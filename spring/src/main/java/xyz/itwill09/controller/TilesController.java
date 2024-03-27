package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TilesView 클래스 : 요청 처리 메소드의 반환값(ViewName)을 제공받아 다수의 JSP 문서가 결합된
//뷰


@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
}
