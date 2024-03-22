package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@AllArgsConstructor : ��� �ʵ忡 ���� �ʱ�ȭ �۾��� �ϱ� ���� �Ű������� �ۼ��� �����ڸ�
//�����ϴ� ������̼�
//@RequiredArgsConstructor : final �����ڸ� ����� �ۼ��� �ʵ忡 �ʱ�ȭ �۾��� �ϱ� ����
//�Ű������� �ۼ��� �����ڸ� �����ϴ� ������̼�
@RequiredArgsConstructor
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	//�ʵ忡 @Autowired ������̼��� ����Ͽ� ������ �����̳ʿ��� Spring Bean�� �����޾� 
	//�ʵ忡 ����ǵ��� ������ ���� - �ʵ� ������ ������ ����
	// => �ʵ忡 ���� Setter �޼ҵ尡 ��� Setter Injection�� ����Ͽ� ������ ����
	// => ���� �������� ������ ���� ��������� ��ȯ ������ ������ �߻����� �ʾ� StackOverflow �߻� ����
	//@Autowired
	//private MemberDAO memberDAO;
	
	//@RequiredArgsConstructor ������̼��� ����Ͽ� �����ڷ� �ʱ�ȭ ó���ϱ� ���� �ʵ��
	//final �����ڸ� ����� �ۼ�
	// => final ������ ��� �ʵ忡 @NonNull ������̼� ����Ͽ� �ۼ� ���� 
	//private final MemberDAO memberDAO;
	
	@NonNull 
	private MemberDAO memberDAO;
	
	//�ʵ忡 ���� Setter �޼ҵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - Setter ������ ������ ����
	// => Setter �޼ҵ��� ���� �����ڰ� [public]�� ��� Setter �޼ҵ带 ȣ���Ͽ� �������� ���� ����
	/*
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	*/

	/*
	public MemberServiceImpl() {
		log.info("### MemberServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	*/

	/*
	//�Ű������� �ۼ��� �����ڿ� @Autowired ������̼��� ����Ͽ� ������ ���� - Constructor ������ ������ ����
	// => ��ȯ ���� ������ ���� �����ڸ� �̿��� ������ ���� - ��ȯ ���� �߻��� ���� �߻�
	// => �Ű������� �ۼ��� �����ڰ� �ϳ��� �ִ� ��� @Autowired ������̼��� �����ص� ������ ���� ����
	//@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		log.info("### MemberServiceImpl Ŭ������ �Ű������� �ۼ��� ������ ȣ�� ###");
		this.memberDAO=memberDAO;
	}
	*/
	
	@Override
	public void addMember(Member member) {
		log.info("*** MemberServiceImpl Ŭ������ addMember(Member member) �޼ҵ� ȣ�� ***");
		memberDAO.insertMember(member);
	}

	@Override
	public void modifyMember(Member member) {
		log.info("*** MemberServiceImpl Ŭ������ modifyMember(Member member) �޼ҵ� ȣ�� ***");
		memberDAO.updateMember(member);
	}

	@Override
	public void removeMember(String id) {
		log.info("*** MemberServiceImpl Ŭ������ removeMember(String id) �޼ҵ� ȣ�� ***");
		memberDAO.deleteMember(id);
	}

	@Override
	public Member getMember(String id) {
		log.info("*** MemberServiceImpl Ŭ������ getMember(String id) �޼ҵ� ȣ�� ***");
		return memberDAO.selectMember(id);
	}

	@Override
	public List<Member> getMemberList() {
		log.info("*** MemberServiceImpl Ŭ������ getMemberList() �޼ҵ� ȣ�� ***");
		return memberDAO.selectMemberList();
	}

}