package xyz.itwill06.aop;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Setter;

//JavaMail ����� �����ϱ� ���� spring-context-support ���̺귯���� javax.mail ���̺귯����
//������Ʈ�� ����ǵ��� ó�� - ���̺� ��� : pom.xml  

//���� ���� ���(JavaMail ���)�� �����ϱ� ���� Ŭ���� - ���� ������ SMTP ���񽺸� ����Ͽ� ���� ����
// => ���� ����(Mail Server) : ������ �ۼ����ϴ� ���񽺸� �����ϴ� ��ǻ��
// => STMP ����(Simple Message Transfer Protocol - 25)�� ������ ������ POP3(Post Office Protocol3 - 110) 
//���񽺳� IMAP(Internet Message Access Protocol - 143) ���񽺴� ������ �޾� ����ڿ��� ����
public class EmailSendBean {
	//JavaMailSender ��ü�� �����ϱ� ���� �ʵ� ����
	// => JavaMailSender ��ü : SMTP ���񽺸� �����ϴ� ������ ������ �����ϱ� ���� ��ü
	// => Spring Bean Configuration File���� JavaMailSender ��ü�� �����޾� �ʵ忡 ���� - DI
	@Setter
	private JavaMailSender javaMailSender;
	
	//SMTP ���񽺸� ����Ͽ� ������ �����ϴ� �޼ҵ�
	// => ������ �޴� ����� �̸��� �ּҸ� ��ȯ
	// => ������ �޴� ����� �̸��� �ּ�, ����, ������ �Ű������� ���޹޾� �޼ҵ忡�� ���
	//������ ��ȯ���� void�� ���� �� 
	public String sendEmail(String email, String subject, String content) throws Exception {
		//JavaMailSender.createMimeMessage() : MimeMessage ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//MimeMessage ��ü : ���� ���� ���� ������ �����ϱ� ���� ��ü
		MimeMessage message=javaMailSender.createMimeMessage();
		
		//MimeMessage.setSubject(String subject) : MimeMessage ��ü�� ���� ������ �����ϴ� �޼ҵ�
		message.setSubject(subject);
		
		//MimeMessage.setText(String content) : MimeMessage ��ü�� ���� ���� �����ϴ� �޼ҵ�
		// => ���� ������ �Ϲ� �ؽ�Ʈ ���� ���·� �����Ͽ� ����
		//message.setText(content);
		
		//MimeMessage.setContent(Object o, String type) : MimeMessage ��ü�� ���� ������ �����ϴ� �޼ҵ�
		// => type �Ű������� ���Ϸ� ������ ������ ����(MimeType)�� �����Ͽ� ����
		// => ���� ������ HTML ���� ���·� �����Ͽ� ���� 
		message.setContent(content, "text/html; charset=utf-8");
		
		message.setFrom(new InternetAddress("swiftair@itwill.xyz"));
		
		//MimeMessage.setRecipient(RecipientType type, Address address) : MimeMessage ��ü��
		//������ �޴� ����� �̸��� �ּ� ���� ������ �����ϴ� �޼ҵ�
		// => type : ���� ���� ����ڸ� �����ϱ� ���� ���(RecipientType) ����
		// => address :  �̸��� �ּҰ� ����� Address ��ü ����
		//InternetAddress ��ü : �̸��� �ְ� �����ϱ� ���� ��ü
		//MimeMessage.setRecipients(RecipientType type, Address[] address) : MimeMessage ��ü��
		//������ �޴� ������� �̸��� �ּ� ���� ������ �����ϴ� �޼ҵ� - �ټ��� ����ڿ��� ���� ����
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		
		//JavaMailSender.send(MimeMessage message) : �Ű������� ���޵� MimeMessage ��ü�� ������
		//�̿��� SMTP ���񽺷� ������ �����ϴ� �޼ҵ�
		javaMailSender.send(message);
		
		return email;
	}
}