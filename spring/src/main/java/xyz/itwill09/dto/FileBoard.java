package xyz.itwill09.dto;

import lombok.Data;


//create table file_board(idx number primary key, writer varchar2(20)
//, subject varchar2(100), filename varchar2(200));
//create sequence file_board_seq;    

//DTO Ŭ���� : DAO Ŭ������ �޼ҵ忡�� ����(��)�� ���޹ްų� ��ȯ�ϱ� ���� �ۼ��� Ŭ����
//=> ������ ��û�� ���ް��� Command ��ü�� �����ޱ� ���� ���
@Data
public class FileBoard {
	private int idx;
	private String writer;
	private String subject;
	//���� ���丮�� ����� ���ε� ���ϸ��� �����ϱ� ���� �ʵ� - ���̺� ���� 
	private String filename;
	//����ڷκ��� �ԷµǾ� ���޵� ���������� �����ϱ� ���� �ʵ� - ���ε� ó��
	//private MultipartFile multipartFile;
}
