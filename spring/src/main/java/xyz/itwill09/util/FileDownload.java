package xyz.itwill09.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//���� �ٿ�ε� ����� �����ϱ� ���� Ŭ����
// => BeanNameViewResolver ��ü�� ���� ����Ǵ� Ŭ����
// => Spring Bean Configuration File(servlet-context.xml)�� Spring Bean���� ���
//BeanNameViewResolver ��ü�� ���� ����Ǵ� Ŭ������ �ݵ�� AbstractView Ŭ������ ��ӹ޾� �ۼ�
// => renderMergedOutputModel() �޼ҵ带 �������̵� �����Ͽ� ���� ó���� �ʿ��� ��� �ۼ�
public class FileDownload extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//��û ó�� �޼ҵ忡�� ������ �Ӽ���(�ٿ�ε� ���� ����)�� ��ü�� ��ȯ�޾� ����
		String uploadDirectory=(String)model.get("uploadDirectory");
		String uploadFilename=(String)model.get("uploadFilename");
		
		//���� ���丮�� ����� ���ε� ���Ͽ� ���� File ��ü ����
		File file=new File(uploadDirectory, uploadFilename);
		
		//���Ϸ� ���� ó���ǵ��� Ŭ���̾�Ʈ���� ������ ��������(MimeType)�� ����
		response.setContentType("application/download; utf-8");
		
		//Ŭ���̾�Ʈ���� ������ ����ũ�⸦ ����
		response.setContentLengthLong(file.length());
		
		//Ŭ���̾�Ʈ�� ����� ���ϸ� ����
		// => ������ �̸��� �ѱ��� ������ ��� ��ȣȭ ó���Ͽ� ���� ó��
		String originalFilename=URLEncoder.encode(uploadFilename.substring(37), "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=\""
				+originalFilename+"\";");
		
		//������ Ŭ���̾�Ʈ���� �����ϱ� ���� ��½�Ʈ���� ��ȯ�޾� ����
		OutputStream out=response.getOutputStream();
		
		//���� ���丮�� ����� ���ε� ������ ������ �б� ���� �Է½�Ʈ���� �����Ͽ� ����
		InputStream in=new FileInputStream(file);
		
		//FileCopyUtils.copy(InputStream in, OutputStream out) : �Է½�Ʈ������ ���õ����͸� �о�
		//��½�Ʈ������ �����ϴ� �޼ҵ� - ����
		FileCopyUtils.copy(in, out);
		
		in.close();
	}

}
