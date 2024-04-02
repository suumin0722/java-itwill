package xyz.itwill09.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.UserinfoDAO;
import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.exception.ExistsUserinfoException;
import xyz.itwill09.exception.LoginAuthFailException;
import xyz.itwill09.exception.UserinfoNotFoundException;

//����ڷκ��� �Է¹޾� ���޵� ���ڿ�(��й�ȣ)�� ��ȣȭ ó���ϴ� ���
//1.jbcrypt ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.BCrypt.hashpw(String password, String salt) �޼ҵ带 ȣ���Ͽ� ���ڿ�(��й�ȣ)�� ��ȣȭ ó��
// => �Ű������� ��ȣȭ ó���� ���ڿ��� ÷������ ���޹޾� ��ȣȭ ó�� - ÷�ڹ��� ���� �����ȣ�� �ٸ��� ��ȣȭ ó��
// => BCrypt.gensalt(int log_bounds) : �Ű������� ÷������ ���̸� �����Ͽ� ÷������ ������ ��ȯ�ϴ� �����޼ҵ�
// - �Ű������� ���� �޼ҵ带 ȣ���ϸ� ÷������ ���̴� �ڵ����� [10]���� ����
//3.BCrypt.checkpw(String plainText, String hashed) �޼ҵ�� ��ȣȭ�� ���ڿ��� �Ϲ� ���ڿ���
//���Ͽ� �ٸ� ��� [false]�� ��ȯ�ϰ� ���� [true]�� ��ȯ�޾� ó��

@Service
@RequiredArgsConstructor
public class UserinfoServiceImpl implements UserinfoService {
	private final UserinfoDAO userinfoDAO;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addUserinfo(Userinfo userinfo) {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) != null) {
			//���ܸ� ��Ȯ�� �����Ͽ� ����ó���� �ʿ��� ���� �����ޱ� ���� ����Ŭ������ �ۼ��Ͽ�
			//������ ���� �߻�
			throw new ExistsUserinfoException("�̹� ������� ���̵� �Է� �Ͽ����ϴ�.", userinfo);
		}
		
		//�Ű������� ���޹��� ȸ�������� ��й�ȣ�� ��ȣȭ ó���Ͽ� �ʵ尪���� ���� ó��
		String hashedPasword=BCrypt.hashpw(userinfo.getPassword(),BCrypt.gensalt());
		userinfo.setPassword(hashedPasword);
		
		userinfoDAO.insertUserinfo(userinfo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void modifyUserinfo(Userinfo userinfo) {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) == null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� ã�� �� �����ϴ�.");
		}
		
		if(userinfo.getPassword() !=null && !userinfo.getPassword().equals("")) {
			String hashedPasword=BCrypt.hashpw(userinfo.getPassword(),BCrypt.gensalt());
			userinfo.setPassword(hashedPasword);
		}
		
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeUserinfo(String userid) {
		if(userinfoDAO.selectUserinfo(userid) == null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� ã�� �� �����ϴ�.");
		}
		
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) {
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		if(userinfo == null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� ã�� �� �����ϴ�.");
		}
		return userinfo;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectUserinfoList();
	}

	@Override
	public Userinfo loginAuth(Userinfo userinfo) {
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());

		if(authUserinfo ==null) {//���̵� ���� ����
			throw new LoginAuthFailException("���̵��� ȸ�������� �������� �ʽ��ϴ�.", userinfo.getUserid());
		}
		
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {//��й�ȣ ���� ����
			throw new LoginAuthFailException("���̵� ���ų� ��й�ȣ�� ���� �ʽ��ϴ�.", userinfo.getUserid());
		}
		
		return authUserinfo;
	}
}