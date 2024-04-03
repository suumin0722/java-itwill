package xyz.itwill09.util;

import lombok.Data;

//����¡ ó�� ���� ���� �����ϱ� ���� Ŭ����
@Data
public class Pager {
	//������ �Ű������� �ʱⰪ�� ���޹޾� �ʵ忡 ����
	private int pageNum;//��û ������ ��ȣ
	private int totalSize;//��ü �Խñ��� ����
	private int pageSize;//�ϳ��� �������� ��µ� �Խñ��� ����
	private int blockSize;//�ϳ��� ���� ��µ� ������ ��ȣ�� ����
	
	//������ �Ű������� �ʱ�ȭ ó���� �ʵ尪�� ����� ���� ������� �ʵ忡 ����
	private int totalPage;//��ü �������� ����
	private int startRow;//��û �������� ��µ� �Խñ��� ���� ���ȣ
	private int endRow;//��û �������� ��µ� �Խñ��� ���� ���ȣ
	private int startPage;//���� ���� ��µ� ���� ������ ��ȣ
	private int endPage;//���� ���� ��µ� ���� ������ ��ȣ
	private int prevPage;//���� ���� ��µ� ���� ������ ��ȣ
	private int nextPage;//���� ���� ��µ� ���� ������ ��ȣ
	
	public Pager(int pageNum, int totalSize, int pageSize, int blockSize) {
		this.pageNum = pageNum;
		this.totalSize = totalSize;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		calcPaging();
	}
	
	private void calcPaging() {
		totalPage=(int)Math.ceil((double)totalSize/pageSize);
		if(pageNum <= 0 || pageNum > totalPage) {
			pageNum=1;
		}
		
		startRow=(pageNum-1)*pageSize+1;
		endRow=pageNum*pageSize;
		if(endRow > totalSize) {
			endRow=totalSize;
		}
		
		startPage=(pageNum-1)/blockSize*blockSize+1;
		endPage=startPage+blockSize-1;
		if(endPage > totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-blockSize;
		nextPage=startPage+blockSize;
	}
}

