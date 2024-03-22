package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

//��(Model) ����� �����ϱ� ���� Ŭ���� - ��û ó�� Ŭ���� : Controller Ŭ����
//@Controller : ��û ó�� Ŭ����(Controller Ŭ����)�� Spring Bean���� ����ϱ� ���� ������̼�
// => Ŭ������ �̸��� Spring Bean�� �����ϱ� ���� �ĺ���(beanName)�� ��� - Ŭ���� �̸��� ù���ڴ� �ҹ��ڷ� ��ȯ
// => value �Ӽ��� ����Ͽ� Spring Bean�� �ĺ��� ���� ����
//@Controller ������̼��� ����ϸ� Controller �������̽��� ��ӹ��� �ʾƵ� Controller Ŭ������ ���
// => �޼ҵ忡 @RequestMapping ������̼��� ����Ͽ� ��û ó�� �޼ҵ�� ó���ǵ��� �ۼ�
// => @RequestMapping ������̼��� ����� ��û ó�� �޼ҵ带 ������ �ۼ� ����
@Controller
@Slf4j
public class HelloController {
	//@RequestMapping : Controller Ŭ������ �޼ҵ带 Ŭ���̾�Ʈ�� ��û�� ó�� �ϱ� ���� ��û
	//ó�� �޼ҵ�� �����ϱ� ���� ������̼�
	// => Ŭ���̾�Ʈ�� ��� ��û���(Method - GET, POST, PUT, PATCH, DELETE ��)�� ����
	//��û�� ��� ȣ��Ǵ� ��û ó�� �޼ҵ带 �ۼ��� �� ���
	// => Ŭ���̾�Ʈ�� ��û����� �����Ͽ� ��û ó�� �޼ҵ带 ȣ���ؾߵ� ��� @GetMapping,
	//@PostMapping, @PutMapping, @PatchMapping, @DeleteMapping ���� ������̼��� ����Ͽ� ����
	//value �Ӽ� : Ŭ���̾�Ʈ�� ��û����(Command - URL �ּ�)�� �Ӽ������� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	// => ��û ó�� �޼ҵ��� value �Ӽ����� �ߺ��� ��� WAS ���α׷� ����� ���� �߻�
	@RequestMapping(value = "/hello")
	public void hello() {//��û ó�� �޼ҵ�
		//��û ó�� ��� �ۼ�
		log.info("[/hello] ������ ��û : HelloController Ŭ������ hello() �޼ҵ� ȣ��");
	}
	
	@RequestMapping(value="/helloViewName")
	public String helloViewName() {
		log.info("[/helloViewName] ������ ��û : HelloController Ŭ������ helloViewName() �޼ҵ� ȣ��");
		return "hello";
	}
}




