package xyz.itwill09.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill09.dto.RestMember;

//REST(Representational State Transfer) : �ڿ�(Resource)�� ǥ��(Representational)�� ����
//����(State)�� ����(Transfer)�ϴ� ���� �ǹ�
// => ������ ��û�� ���� ���� ����� Ŭ���̾�Ʈ���� XML �Ǵ� JSON ������ �ؽ�Ʈ �����ͷ� ���� ó��
//Restful API : REST ����� ����Ͽ� �� ��ǻ���� �ý����� �����ϰ� ���� �ְ� �ޱ� ���� ���α׷�
// => ����Ʈ����� ���α׷�(��) ���࿡ �ʿ��� ������ ���޹޾� ����ϰų� �������� �����޾� ����ϱ� ���� ���

@Controller
@RequestMapping("/rest")
public class RestfulController {
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
		return "rest/input";
	}
	
	/*
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	*/
	
	//@ResponseBody : ��û ó�� �޼ҵ��� ��ȯ��(���ڿ�)�� �������� �޼��� ��ü�ο� �����Ͽ�
	//���ڰ�(�ؽ�Ʈ ������)�� Ŭ���̾�Ʈ���� �����Ͽ� �����ϴ� ������̼�
	// => ��ȯ���� ViewResolver ��ü�� ����Ͽ� ��� ��ȯ�Ͽ� ���� ó������ �ʰ� ��û ó�� �޼ҵ���
	//��ȯ������ ���� ó��
	// => @ResponseBody ��� ResponseEntity Ŭ������ ��û ó�� �޼ҵ��� ��ȯ������ �ۼ��Ͽ� ���� ó��
	//@RequestBody : ������Ʈ �޼��� ��ü�ο� ����� ��� ���ް��� ���ڿ��� �����ޱ� ���� ������̼�
	// => POST, PUT, PATCH, DELETE ���� ��û������� �������� ��û�� ��� ������Ʈ �޼��� ��ü�ο�
	//����� ���ް��� ���ڿ��� �����޾� �Ű������� ����
	// => GET ������� �������� ��û�� ��� ������Ʈ �޼��� ��ü�ΰ� ��� �����Ƿ� @RequestBody ��� �Ұ���
	// => �񵿱�� ������� ������ ��û�� JSON ������ �׽�Ʈ �����ͷ� ���޵� ���� �Ű������� �����ϱ� ���� ���
	// => @RequestBody ������̼� ��� RequestEntity Ŭ������ ����Ͽ� ���ް� ���� ����
	@RequestMapping(value="/join", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestBody String input) {
		return input;
	}
	
	/*
	//@ResponseBody ������̼��� ����Ͽ� ��û ó�� �޼ҵ��� ��ȯ��(RestMember ��ü)�� ��������
	// �޼��� ��ü�ο� ���ڿ��� �����Ͽ� Ŭ���̾�Ʈ���� ���� ó��
	// ������)�������� �޼��� ��ü�ο��� Java ��ü�� �����Ͽ� ���� ó�� �Ұ��� - 406 �����ڵ� �߻�
	// �ذ��)��û ó�� �޼ҵ忡 ���� ��ȯ�Ǵ� Java ��ü�� ���ڿ�(XML �Ǵ� JSON)�� ��ȯ�Ͽ�
	// �������� �޼��� ��ü�ο� �����Ͽ� ����  ó��
	// => ������Ʈ�� jackson-databind ���̺귯���� ���� ó���ϸ� ��û ó�� �޼ҵ忡 ���� ��ȯ�Ǵ�
	// Java ��ü�� JSON ������ ���ڿ��� �����Ͽ� �������� �޼��� ��ü�ο� �����Ͽ� ���� ó�� 
	@RequestMapping("/member")
	@ResponseBody
	public RestMember restMember() {
		return RestMember.builder().id("abc123").name("ȫ�浿").email("abc@itwill.xyz").build();
	}
	*/
	
	//@ResponseBody ������̼� ��� ��û ó�� �޼ҵ��� ��ȯ���� ResponseEntity Ŭ������ ������
	//ResponseEntity ��ü�� ��ȯ�ص� ���ڿ��� ���� ó�� ����
	// => ResponseEntity Ŭ������ ���׸����� ���� ó���� Java ��ü�� �ڷ����� ����
	@RequestMapping("/member")
	public ResponseEntity<RestMember> restMember() {
		try {
			//Java ��ü�� Javascript�� Object ��ü �������� ��ȯ�Ͽ� ���� ó��
			RestMember member=RestMember.builder().id("abc123").name("ȫ�浿").email("abc@itwill.xyz").build();
			//Ŭ���̾�Ʈ���� �����ڵ� 200�� �������� �ؽ�Ʈ �����ͷ� ���� ó��
			return new ResponseEntity<RestMember>(member, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RestMember>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/member_list")
	@ResponseBody
	public List<RestMember> restMemberList() {
		List<RestMember> restMemberList=new ArrayList<RestMember>();
		restMemberList.add(RestMember.builder().id("abc123").name("ȫ�浿").email("abc@itwill.xyz").build());
		restMemberList.add(RestMember.builder().id("opq456").name("�Ӳ���").email("opq@itwill.xyz").build());
		restMemberList.add(RestMember.builder().id("xyz789").name("����ġ").email("xyz@itwill.xyz").build());
		//List ��ü�� Javascript�� Array ��ü �������� ��ȯ�Ͽ� ���� ó��
		return restMemberList;
	}
	
	@RequestMapping("/member_map")
	@ResponseBody
	public Map<String, Object> restMemberMap() {
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("id", "abc123");
		map.put("name", "ȫ�浿");
		map.put("email", "abc@itwill.xyz");
		
		//Map ��ü�� Javascript�� Object ��ü �������� ��ȯ�Ͽ� ���� ó��
		return map;
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET) 
	public String restBoard() {
		return "rest/board";
	}
	
}
