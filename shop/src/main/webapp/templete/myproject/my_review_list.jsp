<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
  list-style-type: none; /* 목록 아이콘을 없앰 */
  padding: 0; /* 목록의 패딩을 없앰 */
  margin: 0; /* 목록의 마진을 없앰 */
}

li {
  /* 여기에 필요한 다른 스타일을 추가할 수 있습니다 */
}

.review_title_box {
	display: flex;
	flex-direction: row;
	align-items: center; /* 세로 중앙 정렬을 위한 속성 추가 */
}

.review_title, .star_rating {
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

#title_line {
	border: 2px solid #000; /* 2px 굵기의 실선을 사용하며, 색상은 검정(#000)입니다. */
	margin-top: 1px; /* 간격 조절을 위한 margin-top 추가 */
}
</style>
</head>
<body>

	<div class="review_title_box">

		<div class="review_title">
			<h2>
				리뷰<span>(108)</span>
			</h2>
		</div>

		<div class="star_rating">
			<span class="star" value="1"></span> <span class="star" value="2"></span>
			<span class="star" value="3"> </span> <span class="star" value="4"></span>
			<span class="star" value="5"> </span>
		</div>
	</div>
	<hr id="title_line">
	<div class="css-0 e1fqypsc0">
		<ul class="css-0 e1fqypsc1">
			<li class="css-0 e1fqypsc2">
			<div class="css-100fusk e1pl60v52">
					<div class="css-4g6ai3 e1pl60v53">
						<div class="css-69znzl e1pl60v54"><%-- 별모양+id --%>
							<div class="star_rating"><%-- 별모양 5개--%>
								<span class="star on" value="1"></span>
								<span class="star" value="2"></span>
								<span class="star" value="3"> </span>
								<span class="star" value="4"></span>
								<span class="star" value="5"> </span>
							</div>

							<%-- 아이디 --%>
							<span class="css-5030pi e1pl60v55">son*****</span>
							<%-- 날짜 오른쪽 정렬 --%>
							<span class="css-1riowxi e1pl60v56">2024.01.28</span>
						</div>
					</div>
				</div>		
			</li>
		</ul>

							<%-- 옵션.., 리뷰 내용, 사진 --%>
						<div class="css-16tn2ye e1pl60v57">
								<%-- 옵션 체형 사이즈 내용 --%>
							<div class="css-31l7gp e1pl60v51">
									<%-- 옵션 체형 사이즈 --%>
								<div class="css-4oetsc e1pl60v59">
										<%--옵션 --%>
									<div class="css-nn803e e1rsz3cb0">
										<span class="css-rlwyr0 e1rsz3cb1">옵션 : </span> <span
											class="css-wle0cx e1rsz3cb2">[사이즈]95</span>
									</div>
										<%-- 사이즈 --%>
									<div class="css-nn803e e1rsz3cb0">
										<span class="css-rlwyr0 e1rsz3cb1">사이즈 : </span><span
											class="css-wle0cx e1rsz3cb2">잘 맞아요</span>
									</div>
								</div>
								<p class="css-1gk1nxz e1pl60v58">살까 말까 고민하다가 사이즈 입고 되고 쿠폰
									먹여서 샀는데 완전만족! 생각보다 엄청 가벼워오</p><%-- 리뷰내용 --%>
							</div>


							<div class="css-1jjxju6 e1pl60v50"><%--사진 --%>
								<ul>
									<li><img
										src="https://img.29cm.co.kr/next-product/2024/01/28/1f327ff3d7214489a3223cb2aabd0e7a_20240128005355.jpeg?width=120"
										loading="lazy" alt="리뷰 이미지" class="css-18bdumj e1pl60v515">
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div></div>
				<%-- 리뷰당 구분선 --%>



				<div class="e1fqypsc4 css-1oq0g9s e1mylnp80">
					<%--페이징 버튼 블럭 --%>
					
					<%-- 이전페이지 버튼 --%>
					<button type="button" class="css-129gw94 e1mylnp83">
						<svg class="e1mylnp85 css-11r31mh e1q3599k0"
							xmlns="http://www.w3.org/2000/svg" viewBox="0 0 42 80"></svg>
						<span class="css-17mseqq e1mylnp87">이전 페이지</span>
					</button>
					
					<ul class="css-16vmvyd e1mylnp81">
						<%-- 숫자버튼만 --%>
						<li aria-current="true" class="css-12l5i6f e1mylnp82"><button
								type="button" class="css-1xzw0uc e1mylnp84">1</button></li>
						<li aria-current="false" class="css-12l5i6f e1mylnp82"><button
								type="button" class="css-opb0qt e1mylnp84">2</button></li>
						<li aria-current="false" class="css-12l5i6f e1mylnp82"><button
								type="button" class="css-opb0qt e1mylnp84">3</button></li>
						<li aria-current="false" class="css-12l5i6f e1mylnp82"><button
								type="button" class="css-opb0qt e1mylnp84">4</button></li>
						<li aria-current="false" class="css-12l5i6f e1mylnp82"><button
								type="button" class="css-opb0qt e1mylnp84">5</button></li>
						<li aria-current="false" class="css-12l5i6f e1mylnp82"><button
								type="button" class="css-opb0qt e1mylnp84">6</button></li>
					</ul>
					<button type="button" aria-disabled="false" class="css-129gw94 e1mylnp83">
						
						<%-- 다음 페이지 버튼 --%>
						<svg class="e1mylnp86 css-ar1b2l emw5wod0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 42 80"></svg>
						<span class="css-17mseqq e1mylnp87">다음 페이지</span>
					</button>
				</div>
	</div>
</body>
</html>