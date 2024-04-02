package xyz.itwill09.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import xyz.itwill09.exception.BadRequestException;
import xyz.itwill09.exception.ExistsUserinfoException;
import xyz.itwill09.exception.LoginAuthFailException;
import xyz.itwill09.exception.UserinfoNotFoundException;

//@ControllerAdvice : ���� ó�� �޼ҵ常 �ۼ��� Controller Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => ��� Controller Ŭ������ ��û ó�� �޼ҵ忡�� �߻��� ���ܿ� ���� ����ó�� ���� - Spring AOP ��� ���
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = BadRequestException.class)
	public String badRequestExceptionHandler() {
		return "userinfo/user_error";
	}
	
	@ExceptionHandler(ExistsUserinfoException.class)
	public String existsUserinfoExceptionHandler(ExistsUserinfoException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		return "userinfo/user_write";	
	}
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String loginAuthFailExceptionHandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		return "userinfo/user_login";	
	}
	
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String userinfoNotFoundExceptionHandler() {
		return "userinfo/user_error";	
	}
	
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "userinfo/user_error";	
	}
	*/
}