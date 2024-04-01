package xyz.itwill.spring;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill09.dto.PointBoard;
import xyz.itwill09.dto.PointUser;
import xyz.itwill09.service.PointBoardService;

//Spring �����ӿ�ũ���� TranscationManager ��ü�� ����Ͽ� Ʈ������ ó���ϴ� ���
//1.spring-tx ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
// => spring-jdbc ���̺귯���� ���� ó���ϸ� ���̺귯�� ���� ���迡 ���� �ڵ����� ���� ó��
//2.Spring Bean Configuration File(root-context.xml)�� TranscationManager ���� Ŭ������ Spring Bean���� ���
//3.Spring Bean Configuration File(servlet-context.xml)�� Ʈ������ ó���� ���� AOP ����
// => Ʈ������ ó���� ���� AOP ���� ��� @Transactional ������̼��� ����Ͽ� Ʈ������ ó�� ����

//Ʈ������ ó�� ����� �����ޱ� ���� �޼ҵ忡 @Transactional ������̼��� ����ϸ� �޼ҵ���
//��� ����� ���ܰ� �߻��� ��� TranscationManager ��ü�� ���� �ѹ� ó�� ����
// => @Transactional ������̼��� ����ϱ� ���ؼ��� Spring Bean Configuration File(root-context.xml)��
//tx ���ӽ����̽��� �߰��Ͽ� spring-tx.xsd ������ annotation-driven ������Ʈ�� �����޾� ����
// => Service Ŭ������ �޼ҵ忡 @Transactional ������̼��� ����ϸ� ���� �߻��� �ѹ� ó��
// => Test Ŭ������ �׽�Ʈ �޼ҵ忡 @Transactional ������̼��� ����ϸ� �׽�Ʈ ���� �� �ѹ� ó��

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class PointBoardServiceTest {
	@Autowired
	private PointBoardService pointBoardService;

	@Transactional
	@Test
	public void test1() {
		//PointBoard board=PointBoard.builder().writer("abc123").content("�׽�Ʈ").build();
		PointBoard board=PointBoard.builder().writer("xyz789").content("�׽�Ʈ").build();
	
		//PointBoardService ��ü�� addPointBoard() �޼ҵ带 ȣ���Ͽ� POINT_BOARD ���̺� �� ���� ó��
		// => POINT_USER ���̺��� �࿡�� �Խñ� �ۼ��ڿ� ���� POINT �÷����� �����ǵ��� ���� ó��
		// => POINT_USER ���̺��� �Խñ� �ۼ��ڿ� ���� ���� �˻��Ͽ� PointUserDTO ��ü�� ��ȯ
		// => �Ű������� ���޹��� �Խñۿ��� �Խñ� �ۼ��ڰ� POINT_USER ���̺� ����� ȸ���� �ƴ� ��� ���� �߻�
		//������)���� �߻����� ����� �Խñ� ���Կ� ���� SQL ����� �̹� DBMS ������ ���޵Ǿ�
		//����� �����̹Ƿ� POINT_BOARD ���̺��� ���������� �� ���� ó��
		// => POINT_BOARD ���̺� �Խñ� �ۼ��ڰ� ���� �Խñ� ���� - �Խñ��� �˻��Ͽ� ����� ��� ���������� ��� �߻�
		//�ذ��)���ܰ� �߻��Ǳ� ���� ����� SQL ���(INSERT, UPDATE, DELETE)�� ���� ��� �ѹ� ó���ǵ��� ����
		// => Spring �����ӿ�ũ������ Ʈ������ ���� ����� ����Ͽ� Ʈ������ ó��
		// => TranscationManager ��ü�� ����Ͽ� �ϰ��� �ִ� Ʈ������ ���� ��� ����
		PointUser user=pointBoardService.addPointBoard(board);
		
		log.info(user.toString());
		
		log.info(pointBoardService.getPointBoardList().toString());
	}
	
	/*
	@Transactional
	@Test
	public void test2() {
		//PointBoardService ��ü�� removePointBoard() �޼ҵ带 ȣ���Ͽ� POINT_BOARD ���̺� �� ���� ó��
		// => POINT_USER ���̺��� �࿡�� �Խñ� �ۼ��ڿ� ���� POINT �÷����� ���ҵǵ��� ���� ó��
		// => POINT_USER ���̺��� �Խñ� �ۼ��ڿ� ���� ���� �˻��Ͽ� PointUserDTO ��ü�� ��ȯ
		PointUser user=pointBoardService.removePointBoard(1);
		
		log.info(user.toString());
		
		log.info(pointBoardService.getPointBoardList().toString());
	}
	*/
}