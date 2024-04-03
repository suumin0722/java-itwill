package xyz.itwill09.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.FileBoardDAO;
import xyz.itwill09.dto.FileBoard;
import xyz.itwill09.util.Pager;

@Service
@RequiredArgsConstructor
public class FileBoardServiceImpl implements FileBoardService {
	private final FileBoardDAO fileBoardDAO;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addFileBoard(FileBoard fileBoard) {
		fileBoardDAO.insertFileBoard(fileBoard);
	}

	@Transactional
	@Override
	public void removeFileBoard(int idx) {
		if(fileBoardDAO.selectFileBoard(idx) == null) {
			throw new RuntimeException("�Խñ��� ã�� �� �����ϴ�.");
		}
		
		fileBoardDAO.deleteFileBoard(idx);
	}

	@Override
	public FileBoard getFileBoard(int idx) {
		FileBoard fileBoard=fileBoardDAO.selectFileBoard(idx);
		if(fileBoard == null) {
			throw new RuntimeException("�Խñ��� ã�� �� �����ϴ�.");
		}
		return fileBoard;
	}

	//�޼ҵ��� �Ű������� ��û ������ ��ȣ�� ���޹޾� �Խñ� ����� �˻��Ͽ� �Խñ� ��ϰ�
	//����¡ ó�� ���� ������ Map ��ü�� ��Ʈ���� �߰��Ͽ� ��ȯ�ϴ� �޼ҵ� 
	@Override
	public Map<String, Object> getFileBoardList(int pageNum) {
		//FILE_BOARD ���̺� ����� ��� ��(�Խñ�)�� ������ ��ȯ�޾� ����
		int totalSize=fileBoardDAO.selectFileBoardCount();
		int pageSize=5;//�ϳ��� �������� ��µ� �Խñ��� ������ ����
		int blockSize=5;//�ϳ��� ���� ��µ� ������ ��ȣ�� ������ ����

		Pager pager=new Pager(pageNum, totalSize, pageSize, blockSize);

		//FileBoardDAO Ŭ������ selectFileBoardList() �޼ҵ带 ȣ���ϱ� ���� �Ű������� ���޵� Map ��ü ����
		Map<String, Object> pageMap=new HashMap<String, Object>();
		pageMap.put("startRow", pager.getStartRow());
		pageMap.put("endRow", pager.getEndRow());
		List<FileBoard> fileBoardList=fileBoardDAO.selectFileBoardList(pageMap);
		
		//��û ó�� �޼ҵ忡�� ��ȯ�� ó������� ����� Map ��ü ����
		// => ��û ó�� �޼ҵ�� ��ȯ���� Map ��ü�� �信�� �����Ͽ� ��� ó��
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("pager", pager);
		resultMap.put("fileBoardList", fileBoardList);
		
		return resultMap;
	}
}