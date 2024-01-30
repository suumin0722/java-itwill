<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:///code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
</style>
<meta charset="utf-8">
<title>문의 작성</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="col-lg-6">

		<div class="csAll">
			<div class="csAll">
				<h4>문의 작성</h4>
				<%--<form action="<%=request.getContextPath() %>/index.jsp?group=review&worker=review_list" method="post"> --%>
				<%-- select 태그를 사용하여 검색대상을 선택해 전달 - 전달값은 반드시 컬럼명으로 설정 --%>
				<select name="search">
					<option value="name">&nbsp;문의유형&nbsp;</option>
					<option value="review_subject">&nbsp;회원정보 문의&nbsp;</option>
					<option value="review_content">&nbsp;주문/결제 관련 문의&nbsp;</option>
					<option value="review_content">&nbsp;취소/환불 관련 문의&nbsp;</option>
					<option value="review_content">&nbsp;배송 관련 문의&nbsp;</option>
					<option value="review_content">&nbsp;주문 전 상품 정보 문의&nbsp;</option>
					<option value="review_content">&nbsp;서비스 개선 제안&nbsp;</option>
					<option value="review_content">&nbsp;시스템 오류 제보&nbsp;</option>
					<option value="review_content">&nbsp;불편 신고&nbsp;</option>
					<option value="review_content">&nbsp;기타문의&nbsp;</option>
				</select>
				<%--</form> --%>
				<form class="row contact_form" action="contact_process.php"
					method="post" novalidate="novalidate">
					<div class="col-md-12">
						<div class="userId">
							<input type="text" class="form-control" name="name"
								placeholder="작성자" />
						</div>
					</div>

					<div class="col-md-12">
						<div class="csSubject">
							<input type="text" class="form-control" name="number"
								placeholder="문의 제목" />
						</div>
					</div>
					<div class="col-md-12">
						<div class="csContent">
							<textarea class="form-control" name="message" rows="1"
								placeholder="문의 내용을 입력하세요."></textarea>
						</div>
					</div>
					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn_3">제출하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>