<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [html_two.jsp] 문서를 요청해 실행결과를 HTML 태그로 응답받아 태그내용을 
변경하는 변경하여 응답하는 JSP 문서 --%>    
<%-- => HTML 태그로 결과를 응답받아 태그내용을 변경할 경우 일부 웹프로그램에서만 요청하여 사용 가능 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#newsList {
	width: 50%;
	margin: 0 auto;
}

#newsHeader {
	padding: 5px;
	text-align: center;
	font-size: x-large;
	border: 2px solid black;
	cursor: pointer;
}

</style>
</head>
<body>
	<h1>헤드라인 뉴스</h1>
	<hr>
	<div id="newsList">
		<div id="newsHeader">오늘의 뉴스</div>
		<div id="newsContents"></div>
	</div>
	<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
	var newsContentsVisible = false;
	
	document.getElementById("newsHeader").onclick=function() {
		var xhr=new XMLHttpRequest();
		
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("newsContents").innerHTML=xhr.responseText;
					
					if (newsContentsVisible) {
						document.getElementById("newsContents").style ="display : none";
					} else {
						document.getElementById("newsContents").style ="display : block";
					}
						newsContentsVisible = !newsContentsVisible;

					
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		
		xhr.open("get", "html_two.jsp");
		xhr.send(null);
	}
	});
	</script>
</body>
</html>











