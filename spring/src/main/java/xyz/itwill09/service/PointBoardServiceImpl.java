package xyz.itwill09.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.PointBoardDAO;
import xyz.itwill09.dao.PointUserDAO;
import xyz.itwill09.dto.PointBoard;
import xyz.itwill09.dto.PointUser;

@Service
@RequiredArgsConstructor()
public class PointBoardServiceImpl implements PointBoardService {
	private final PointUserDAO pointUserDAO;
	private final PointBoardDAO pointBoardDAO;
	
	//�Ű������� �Խñ��� ���޹޾� POINT_BOARD ���̺� ������ �����ϰ� �Խñ� �ۼ��ڿ� ����
	// ȸ�������� POINT_USER ���̺��� �˻��Ͽ� PointUserDTO ��ü�� ��ȯ�ϴ� �޼ҵ�
	// => POINT_USER ���̺��� �Խñ� �ۼ��ڿ� ���� ���� POINT �÷����� �����ǵ��� ���� ó��
	// @Transactional : TransactionManager ��ü�� ���� Ʈ������ ó�� ����� �����ޱ� ���� ������̼�
	// rollbackFor �Ӽ� : ����Ŭ����(Class ��ü)�� �Ӽ������� ���� - ���ܰ� �߻��Ǹ� �ѹ� ó��
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PointUser addPointBoard(PointBoard board) {
		pointBoardDAO.insertPointBoard(board);
		
		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���� ��� ������ ���� �߻�
		// => ���ܰ� �߻��� ��� ���� �߻� ��� �Ʒ��� �ۼ��� ����� ������� �ʰ� �޼ҵ� ���� ����
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new RuntimeException("�Խñ� �ۼ��ڰ� �������� �ʽ��ϴ�.");
		}
		pointUserDAO.updatePlusPointUser(board.getWriter());
		
		return pointUserDAO.selectPointUser(board.getWriter());
	}

	//�Ű������� �۹�ȣ�� ���޹޾� POINT_BOARD ���̺� ����� ������ �����ϰ� �Խñ� �ۼ��ڿ� ����
	//ȸ�������� POINT_USER ���̺��� �˻��Ͽ� PointUserDTO ��ü�� ��ȯ�ϴ� �޼ҵ�
	// => POINT_USER ���̺��� �Խñ� �ۼ��ڿ� ���� ���� POINT �÷����� ���ҵǵ��� ���� ó��
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PointUser removePointBoard(int idx) {
		PointBoard board = pointBoardDAO.selectPointBoard(idx);
		
		
		if(board == null) {
			throw new RuntimeException("�Խñ��� �������� �ʽ��ϴ�.");
		}
		
		pointBoardDAO.deletePointBoard(idx);

		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���� ��� ������ ���� �߻�
		// => ���ܰ� �߻��� ��� ���� �߻� ��� �Ʒ��� �ۼ��� ����� ������� �ʰ� �޼ҵ� ���� ����
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new RuntimeException("�Խñ� �ۼ��ڰ� �������� �ʽ��ϴ�.");
		}	
		pointUserDAO.updateMinusPointUser(null);
		
		return pointUserDAO.selectPointUser(board.getWriter());
	}
	
	//POINT_BOARD ���̺� ����� ��� ���� �˻��Ͽ� List ��ü�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}

}
