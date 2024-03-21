package xyz.itwill07.dao;

import lombok.Builder;
import lombok.Data;

/*
�̸�       ��?       ����            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE    
*/

//STUDENT ���̺��� ��(�л�����)�� �����Ͽ� �����ϱ� ���� Ŭ���� - DTO Ŭ����
@Data
@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}