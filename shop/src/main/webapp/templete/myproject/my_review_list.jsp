<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
ul {
  list-style-type: none; /* 목록 아이콘을 없앰 */
  padding: 0; /* 목록의 패딩을 없앰 */
  margin: 0; /* 목록의 마진을 없앰 */
}

li {
  /* 여기에 필요한 다른 스타일을 추가할 수 있습니다 */
}

.review_title_block {
	display: flex;
	flex-direction: row;
	align-items: center; /* 세로 중앙 정렬을 위한 속성 추가 */
}

.review_count, .star_rating {
	margin-right: 5px; /* 간격 조절을 위한 속성 추가 */
}

.star_rating {
	margin-top: 10px;
	margin-right: 3px;
}

.star_rating .star {
	width: 25px;
	height: 25px;
	display: inline-block;
	background: url('/shop/templete/empty_star.png') no-repeat;
	background-size: 100%;
	box-sizing: border-box;
}

.star_rating .star.on {
	width: 25px;
	height: 25px;
	display: inline-block;
	background: url('/shop/templete/black_star.png') no-repeat;
	background-size: 100%;
	box-sizing: border-box;
}

#review_title_line {
	border: 2px solid #000; /* 2px 굵기의 실선을 사용하며, 색상은 검정(#000)입니다. */
	margin-top: 1px; /* 간격 조절을 위한 margin-top 추가 */
}

.writer_info_1 {
	display: flex;
    -webkit-box-align: center;
    align-items: center;
    margin-bottom: 15px;
    font-size: 15px;
    font-weight: 300;
    line-height: 15px;
    color: rgb(0, 0, 0);
}
}

#userId {
	margin-left: 5px;
}

#regDate {
	display: flex;
    -webkit-box-flex: 1;
    flex-grow: 1;
    -webkit-box-pack: end;
    justify-content: flex-end;
}



</style>
</head>
<body>

	<div class="review_title_block">
		<div class="review_count">
			<h2>
				리뷰<span>(108)</span>
			</h2>
		</div>
		<div class="star_rating">
			<span class="star on" data-value="1"></span>
			<span class="star" data-value="2"></span>
			<span class="star" data-value="3"> </span>
			<span class="star" data-value="4"></span>
			<span class="star" data-value="5"> </span>
		</div>
	</div>
	<hr id="review_title_line">
	<div class="review_content_all">
		<ul class="review_list_all">
			<li class="review_list">
				<div class="writer_info_all">
					<div class="writer_info_1">
						<div class="star_rating">
							<span class="star on" data-value="1"></span>
							<span class="star" data-value="2"></span>
							<span class="star" data-value="3"> </span>
							<span class="star" data-value="4"></span>
							<span class="star" data-value="5"> </span>
						</div>
						<span id="userId">son*****</span>
						<span id="regDate">2024.01.28</span>
					</div>
				</div>
				<div class="writer_info_2">
					<div class="review_image">
						<img src="https://img.29cm.co.kr/next-product/2024/01/28/1f327ff3d7214489a3223cb2aabd0e7a_20240128005355.jpeg?width=120" 
								loading="lazy" alt="리뷰 이미지" class="css-18bdumj e1pl60v515">
					</div>
					<div class="review_content">
						<p>리뷰내용입니다. 너무 좋아요~!</p>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<div><hr></div>



				<div class="paging_block">
				</div>
</body>

<script>
$(document).ready(function() {
    // 이미지 클릭 시 동작할 함수
    function enlargeImage(image) {
        // 이미지 크기 변경
        image.animate({
            width: '20%',
            height: '20%'
        }, 300);
    }

    // 이미지에 클릭 이벤트 추가
    $('.review_image img').click(function() {
        enlargeImage($(this));
    });
});
</script>
</html>
