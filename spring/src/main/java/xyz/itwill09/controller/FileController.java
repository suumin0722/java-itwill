package xyz.itwill09.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.FileBoard;
import xyz.itwill09.service.FileBoardService;

//Ŭ���̾�Ʈ�κ��� ������ ���޹޾� ���� ���丮�� ���ε� ó���ϱ� ���� ���
//1.commons-fileupload ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.Spring Bean Configuration File(servlet-context.xml)�� ���� ���ε� ó�� ����� �����ϴ� 
//Ŭ������ Spring Bean���� ���
//3.MultipartHttpServletRequest ��ü�� ����Ͽ� [multipart/form-data] ���·� ���޵� �� �Ǵ� 
//������ �����޾� ó��

@Controller
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
	//WebApplicationContext ��ü(������ �����̳�)�� �����޾� �ʵ忡 ����ǵ��� ������ ����
	private final WebApplicationContext context;
	private final FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload1", method = RequestMethod.GET)
	public String uploadOne() {
		return "file/form_one";
	}
	
	/*
	//��û ó�� �޼ҵ忡 MultipartHttpServletRequest �������̽��� �Ű������� �ۼ��ϸ� Front
	//Controller�κ��� MultipartHttpServletRequest ��ü�� �����޾� ��� 
	// => MultipartHttpServletRequest ��ü : [multipart/form-data] ���·� ���޵� �� �Ǵ� ������
	//�����Ͽ� ó���ϱ� ���� ��ü
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(MultipartHttpServletRequest request) throws IOException {
		//MultipartHttpServletRequest.getParameter(String name) : ���ް��� String ��ü�� ��ȯ�ϴ� �޼ҵ�
		String uploaderName=request.getParameter("uploaderName");
		
		//MultipartHttpServletRequest.getFile(String name) : ���������� MultipartFile ��ü�� ��ȯ�ϴ� �޼ҵ�
		// => MultipartFile ��ü : ����ڷκ��� �Է¹޾� ���޵� ���������� �����ϱ� ���� ��ü
		MultipartFile uploaderFile=request.getFile("uploaderFile");
	
		//�������Ͽ� ���� ���� �۾� ���� ��� �ۼ�
		//MultipartFile.isEmpty() : MultipartFile ��ü�� ���������� ����Ǿ� �ִ� ��� [false]��
		//��ȯ�ϰ� ���������� ����Ǿ� ���� ���� ��� [true]�� ��ȯ�ϴ� �޼ҵ�
		if(uploaderFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//MultipartFile.getContentType() : MultipartFile ��ü�� ����� ���������� ��������
		//(MimeType)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ���� = "+uploaderFile.getContentType());
		//MultipartFile.getBytes() : MultipartFile ��ü�� ����� ���������� ������ byte �迭
		//(���õ���Ÿ)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ũ�� = "+uploaderFile.getBytes().length+"Byte");
		
		//���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirectory=request.getServletContext().getRealPath("/resources/images/upload");
		System.out.println("uploadDirectory = "+uploadDirectory);
		
		//MultipartFile.getOriginalFilename() : MultipartFile ��ü�� ����� ���������� �̸���
		//��ȯ�ϴ� �޼ҵ�
		String uploadFilename=uploaderFile.getOriginalFilename();
		
		//���ε� ó���� ���Ͽ� ���� ������ ����� File ��ü ���� 
		File file=new File(uploadDirectory, uploadFilename);
		
		//MultipartFile.transferTo(File file) : MultipartFile ��ü�� ����� ���������� File
		//��ü�� ����� ������ ���Ϸ� ����ǵ��� ���ε� ó���ϴ� �޼ҵ�
		uploaderFile.transferTo(file);
		
		request.setAttribute("uploaderName", uploaderName);
		request.setAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success_one";
	}
	*/
	
	//��û ó�� �޼ҵ忡 �Ű������� �ۼ��Ͽ� ���ް� �� ���������� �����޾� ���
	// => ���ް� �� ���������� �̸��� ���� �̸����� �Ű����� �ۼ�
	// ������)���������� �̸��� ���� �̸��� ������ ���� ���丮�� �ִ� ��� ���� ������
	// �������Ϸ� ����� ����(OverWrite)
	// �ذ��)���������� ���� ���丮�� �����ϱ� ���� ������ �̸��� �ߺ����� �ʵ��� �����Ͽ�
	// ���ε� ó��
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(@RequestParam String uploaderName, @RequestParam MultipartFile uploaderFile, Model model)
			throws IOException {
		// �������Ͽ� ���� ���� �۾� ���� ��� �ۼ�
		if (uploaderFile.isEmpty()) {
			return "file/upload_fail";
		}

		// ���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirectory = context.getServletContext().getRealPath("/resources/images/upload");

		// UUID.randomUUID() : 36Byte ũ���� ���ڿ��� ����� UUID ��ü�� ��ȯ�ϴ� �޼ҵ�
		// => UUID ��ü : �ĺ��� ������ �����ϱ� ���� ��ü
		// UUID.toString() : UUID ��ü�� ����� �ĺ��ڸ� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		String uploadFilename = UUID.randomUUID().toString() + "_" + uploaderFile.getOriginalFilename();

		// ���ε� ó���� ���Ͽ� ���� ������ ����� File ��ü ����
		File file = new File(uploadDirectory, uploadFilename);

		// MultipartFile.transferTo(File file) : MultipartFile ��ü�� ����� ���������� File
		// ��ü�� ����� ������ ���Ϸ� ����ǵ��� ���ε� ó���ϴ� �޼ҵ�
		uploaderFile.transferTo(file);

		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("uploadFilename", uploadFilename);

		return "file/upload_success_one";
	}
	
	@RequestMapping(value="/upload2", method=RequestMethod.GET)
	public String uploadTwo() {
		return "file/form_two";
	}
	
	//���������� �������� ��� �Ű������� List �������̽��� �ۼ��Ͽ� �������Ͽ� ����
		//MultipartFile ��ü�� ��ҷ� ����� List ��ü�� �����޾� ��� 
		@RequestMapping(value = "/upload2", method = RequestMethod.POST)
		public String uploadTwo(@RequestParam String uploaderName
				, @RequestParam List<MultipartFile> uploaderFileList, Model model) throws IOException {
			//���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
			String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");
			
			//���ε� ó���� ��� ������ �̸��� �����ϱ� ���� List ��ü ����
			List<String> filenameList=new ArrayList<String>();
			
			for(MultipartFile multipartFile : uploaderFileList) {
				if(multipartFile.isEmpty() || !multipartFile.getContentType().equals("image/jpeg") && !multipartFile.getContentType().equals("image/png")) {
					return "file/upload_fail";
				}

				//���������� ���� ���丮�� ����ǵ��� ���ε� ó��
				String uploadFilename=UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
				File file=new File(uploadDirectory, uploadFilename);
				multipartFile.transferTo(file);
				
				//List ��ü�� ���ε� ó���� ���ϸ��� ��Ұ����� �߰��Ͽ� ����
				filenameList.add(uploadFilename);
			}
				
			model.addAttribute("uploaderName", uploaderName);
			model.addAttribute("filenameList", filenameList);
			
			return "file/upload_success_two";
		}
		
		@RequestMapping(value = "/write", method = RequestMethod.GET)
		public String fileBoardWrite() {
			return "file/board_write";
		}
		
		@RequestMapping(value = "/write", method = RequestMethod.POST)
		public String fileBoardWrite(@ModelAttribute FileBoard fileBoard
				, @RequestParam MultipartFile multipartFile) throws IOException {
			if(multipartFile.isEmpty()) {
				return "file/board_write";
			}

			//���������� �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
			// => �ٿ�ε� ���α׷������� ���Ͽ� ���� �����ϵ��� /WEB-INF ������ ���ε� ���� �ۼ�
			String uploadDirectory=context.getServletContext().getRealPath("/WEB-INF/upload");

			//���ε� ó���� ���ϸ��� �����Ͽ� FileBoard ��ü�� �ʵ尪 ����
			fileBoard.setFilename(UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename());

			//���������� ���� ���丮�� ����ǵ��� ���ε� ó��
			multipartFile.transferTo(new File(uploadDirectory, fileBoard.getFilename()));
			
			//���ް��� ���ε� ó���� ���ϸ��� FILE_BOARD ���̺��� ������ ���� ó��
			fileBoardService.addFileBoard(fileBoard);
			
			return "redirect:/file/list";
		}
		
		@RequestMapping("/list")
		public String fileBoardList(@RequestParam(defaultValue = "1") int pageNum, Model model) {
			Map<String, Object> map=fileBoardService.getFileBoardList(pageNum);
			
			model.addAttribute("pager", map.get("pager"));
			model.addAttribute("fileBoardList", map.get("fileBoardList"));
			
			return "file/board_list";
		}
		
		@RequestMapping("/delete")
		public String fileBoardDelete(@RequestParam int idx) {
			//������ �Խñ��� ��ȯ�޾� ���� - ���ϸ��� �����ޱ� ���� ���
			FileBoard fileBoard=fileBoardService.getFileBoard(idx);
			String uploadDirectory=context.getServletContext().getRealPath("/WEB-INF/upload");
			
			//���� ���丮�� ����� �Խñ��� ���� ���� ó��
			new File(uploadDirectory, fileBoard.getFilename()).delete();
			
			fileBoardService.removeFileBoard(idx);
			return "redirect:/file/list";
		}
		
		//�ٿ�ε�(Download) : ���� ���丮�� ����� ������ Ŭ���̾�Ʈ���� �����Ͽ� �����ϴ� ���
		//��û ó�� �޼ҵ忡 ���� ��ȯ�Ǵ� ���ڿ�(ViewName)�� �ٿ�ε� ����� �����ϴ� ��ü(Spring Bean)��
		//�޼ҵ带 ȣ���Ͽ� ���� ���丮�� ����� ������ Ŭ���̾�Ʈ���� ���޵ǵ��� ���� ó��
		// => BeanNameViewResolver ��ü�� ����Ͽ� ��ȯ�Ǵ� ���ڿ�(ViewName)�� ��ü�� �޼ҵ� ȣ��
		// => Spring Bean Configuration File(servlet-context.xml)�� BeanNameViewResolver Ŭ������
		//Spring Bean���� ���
		// => ViewResolver ��ü �� ���� �켱 ������ ������ ����
		@RequestMapping("/download")
		public String fileBoardDownload(@RequestParam int idx, Model model) {
			FileBoard fileBoard=fileBoardService.getFileBoard(idx);
			
			//Model ��ü�� ����Ͽ� BeanNameViewResolver ��ü�� ����� Ŭ�������� ����� �� �ִ�
			//�Ӽ��� �����Ͽ� ���� 
			model.addAttribute("uploadDirectory", context.getServletContext().getRealPath("/WEB-INF/upload"));
			model.addAttribute("uploadFilename", fileBoard.getFilename());
			
			//BeanNameViewResolver ��ü�� ����� Ŭ������ Spring Bean�� �ĺ���(beanName)�� ��ȯ
			// => BeanNameViewResolver ��ü�� ����� Ŭ������ �ۼ��Ͽ� Spring Bean Configuration File(servlet-context.xml)��
			//Spring Bean���� ��� - @Component ������̼� ��� ����
			//cf)Spring Bean ���� ����� �� �� �� �ִ� ������̼� 5�� ����
			return "fileDownload";
		}
		
	
}
