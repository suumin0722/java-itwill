<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%-- 비로그인 상태의 사용자가 JSP 문서를 요청한 경우 에러페이지로 이동되도록 응답 처리 --%>

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
			<span class="star" data-value="1"></span>
			<span class="star" data-value="2"></span>
			<span class="star" data-value="3"> </span>
			<span class="star" data-value="4"></span>
			<span class="star" data-value="5"> </span>
		</div>
		<p id="star_select">선택하세요.</p>
			<div class="reviewContent">
			<textarea id="reviewContent" placeholder="리뷰 내용을 작성해주세요."></textarea>
			</div>
			<div class="review_text">
			<p id="textCount">0자</p>
    		<p id="textTotal">/500자</p>
			</div>
			
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
	
	//리뷰박스 키업 이벤트 처리
	$('#review_box').keyup(function (e) {
		let content = $(this).val();
	    
	    // 글자수 세기
	    if (content.length == 0 || content == '') {
	    	$('#textCount').text('0자');
	    } else {
	    	$('#textCount').text(content.length + '자');
	    }
	    
	    // 글자수 제한
	    if (content.length > 500) {
	    	// 500자 부터는 타이핑 되지 않도록
	        $(this).val($(this).val().substring(0, 500));
	        // 500자 넘으면 알림창 뜨도록
	        alert('글자수는 500자까지 입력 가능합니다.');
	    };
	});
	
	//
	$("#reviewForm").submit(function() {
	    if ($(".star").data("value") === undefined || $(".star").data("value") === "") {
	        $("#star_select").text("별점을 선택해 주세요.").css("color":"red");
	        return false;
	    }
		
		if($("#reviewContent").val()=="") {
			 $("#reviewContent").attr("placeholder", "내용을 입력해 주세요.").css("color", "red");
			return false;
		}
	});
</script>
</html>