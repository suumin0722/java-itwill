package xyz.itwill09.dto;

import lombok.Data;

//create table payment(imp_uid vartchar2(100), mercharnt_uid varchar2(100),
//	, amount number, pay_date date, userid varchar2(50), status varchar2(20)); 

@Data
public class Payment {
	private String impUid;//결제 관련 OpenApi에서 제공되는 고유값
	private String mercharntUid;//결제번호
	private long amount;//결제금액
	private String payDate;//결제일
	private String userid;//결제 아이디
	private String status;//결제 상태
}