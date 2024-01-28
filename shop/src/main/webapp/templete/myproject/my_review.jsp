<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 쓰기</title>
<link rel="stylesheet" href="/shop/templete/myproject/style_review.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class=review_all>
		<h2>리뷰 쓰기</h2>
		<div class="product_info">상품 이미지, 상품 카테고리, 상품명</div>
		
		<p>상품은 만족하셨나요?</p>
		<div class="star_rating">
			<span class="star on" value="1"></span>
			<span class="star" value="2"></span>
			<span class="star" value="3"> </span>
			<span class="star" value="4"></span>
			<span class="star" value="5"> </span>
		</div>
		<p id="star_select">선택하세요.</p>
		
		<textarea class="review_box" placeholder="리뷰 내용을 작성해주세요."></textarea>
		
		<div class="photo">
		<input type="submit" class="attach_photo" value="사진 첨부하기" />
		</div>
		
		<div class="buttons">
			<input type="submit" class="btn01" value="취소" />
			<input type="submit" class="btn02" value="등록" />
		</div>
	</div>
</body>
<script type="text/javascript">
	//드래그 상태를 나타내는 변수
	let dragging = false;

	//마우스 다운 이벤트 처리
	$('.star_rating .star').mousedown(function() {
		dragging = true;
		$(this).addClass('on').prevAll('span').addClass('on');
	});

	//마우스 업 이벤트 처리
	$(document).mouseup(function() {
		dragging = false;
	});

	//마우스 이동 이벤트 처리
	$('.star_rating .star').mousemove(function() {
		if (dragging) {
			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
		}
	});
</script>
</html>