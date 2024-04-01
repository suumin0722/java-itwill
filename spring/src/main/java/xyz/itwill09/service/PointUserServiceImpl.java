package xyz.itwill09.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.PointUserDAO;
import xyz.itwill09.dto.PointUser;

@Service
@RequiredArgsConstructor
public class PointUserServiceImpl implements PointUserService {
	private final PointUserDAO pointUserDAO;
	
	//�Ű������� ȸ�������� ���޹޾� POINT_USER ���̺� ������ �����ϰ� ���Ե� ��(ȸ������)��
	//�˻��Ͽ� DTO ��ü�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public PointUser addPointUser(PointUser user) {
		//�Ű������� ���޹��� ȸ�������� ���̵� �ߺ��� ��� ������ ���� �߻�
		if(pointUserDAO.selectPointUser(user.getId()) != null) {
			throw new RuntimeException("�̹� ������� ���̵��Դϴ�.");
		}
		
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}

}









