package xyz.itwill09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
@RequiredArgsConstructor
public class UserinfoController {
	private final UserinfoService userinfoService;
	
	//ȸ�������� �Է¹ޱ� ���� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����� �Ǵ� �����ڰ� �ƴ� �Ϲ�ȸ���� �������� ��û�� ��� ������ ���� �߻� - 500 �����ڵ� �߻�
	// => try~catch ������ ����Ͽ� ���ܰ� �߻��� ��� �����޼����� ����ϴ� ���̸� ��ȯ - 500 �����ڵ� �̹߻�
	/*
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		try {
			//�������� ��û�� ����ڰ� ��α��� ������̰ų� �����ڰ� �ƴ� �Ϲ�ȸ���� ���
			if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
				throw new BadRequestException("���������� ������� �������� ��û �Ͽ����ϴ�.");
			}
		} catch (BadRequestException e) {
			return "userinfo/user_error";
		}
		return "userinfo/user_write";	
	}
	*/
	
	//���� ó�� �޼ҵ�(Exception Handle Method)�� ����Ͽ� ���� ó��
	//���ͼ��͸� ����Ͽ� ���� ���� ó�� ���� - ��û ó�� �޼ҵ忡���� ���� ���� ��� ���ۼ�
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "userinfo/user_write";	
	}
	
	/*
	//ȸ�������� ���޹޾� USERINFO ���̺� �����ϰ� �α��� �������� ��û�� �� �ִ� URL �ּҷ�
	//�����ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			//�Ű������� ���޹��� ȸ�������� ���̵� �ߺ��� ��� ExistsUserinfoException �߻�
			userinfoService.addUserinfo(userinfo);
		} catch (ExistsUserinfoException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("userinfo", e.getUserinfo());
			return "userinfo/user_write";	
		}
		return "redirect:/userinfo/login";	
	}
	*/
	
	//���� ó�� �޼ҵ�(Exception Handle Method)�� ����Ͽ� ���� ó��
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo) {
		userinfoService.addUserinfo(userinfo);
		return "redirect:/userinfo/login";	
	}
	
	//���������� �Է¹ޱ� ���� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";	
	}
	
	/*
	//���������� ���޹޾� USERINFO ���̺� ����� ���� �˻��� ���� ó���ϰ� ȯ���޼����� 
	//����ϴ� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���� ���� �� ���ǿ� ���� ���� ����(ȸ������)�� �Ӽ������� ����
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session, Model model) {
		try {
			//�Ű������� ���޹��� ���������� ���� �������н� LoginAuthFailException �߻�
			Userinfo authUserinfo=userinfoService.loginAuth(userinfo);
			session.setAttribute("loginUserinfo", authUserinfo);	
		} catch (LoginAuthFailException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("userid", e.getUserid());
			return "userinfo/user_login";	
		}
		return "userinfo/user_login";	
	}
	*/
	
	//���� ó�� �޼ҵ�(Exception Handle Method)�� ����Ͽ� ���� ó��
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session) {
		Userinfo authUserinfo=userinfoService.loginAuth(userinfo);
		session.setAttribute("loginUserinfo", authUserinfo);	
		return "userinfo/user_login";	
	}
	
	//�α׾ƿ� ó���ϰ� �α��� �������� ��û�� �� �ִ� URL �ּҷ� �����ϴ� ��û ó�� �޼ҵ�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginUserinfo");
		session.invalidate();
		return "redirect:/userinfo/login";	
	}
	
	//USERINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� �Ӽ������� ������ ȸ������� ����ϴ�
	//���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
	/*
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		//�������� ��û�� ����ڰ� ��α��� ������� ���
		if(loginUserinfo == null) {
			throw new BadRequestException("���������� ������� �������� ��û �Ͽ����ϴ�.");
		}
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	*/
	
	//���ͼ��͸� ����Ͽ� ���� ���� ó�� ���� - ��û ó�� �޼ҵ忡���� ���� ���� ��� ���ۼ�
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}

	/*
	//���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� �Ӽ������� ������ 
	//ȸ�������� ����ϴ� ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ��α��� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model, HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		//�������� ��û�� ����ڰ� ��α��� ������� ���
		if(loginUserinfo == null) {
			throw new BadRequestException("���������� ������� �������� ��û �Ͽ����ϴ�.");
		}
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}
	*/
	
	//���ͼ��͸� ����Ͽ� ���� ���� ó�� ���� - ��û ó�� �޼ҵ忡���� ���� ���� ��� ���ۼ�
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model, HttpSession session) {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}
	
	/*
	//@ExceptionHandler : ���� ó�� ����� �޼ҵ带 �����ϱ� ���� ������̼�
	// => Controller Ŭ������ ��û ó�� �޼ҵ忡�� ���ܰ� �߻��Ǹ� Front Controller�� ����
	//�ڵ� ȣ��Ǿ� ���� ó���ϴ� �޼ҵ� - ���� ó�� �޼ҵ�
	// => ���� ó�� �޼ҵ��� �Ű������� ���� ó���� �ʿ��� ��ü�� ���޹޾� ���ܸ� ó���� ��
	//������ Ŭ���̾�Ʈ���� ������ ���̸� ��ȯ - �����̷�Ʈ �̵�����
	//value �Ӽ� : ���� ó���ϱ� ���� Ŭ����(Class ��ü)�� �Ӽ������� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
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
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "userinfo/user_error";	
	}
	*/
}

