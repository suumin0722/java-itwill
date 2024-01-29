<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//게시글 검색 기능에 필요한 전달값(검색대상과 검색단어)을 반환받아 저장
	String search=request.getParameter("search");//검색대상
	if(search==null) {//전달값이 없는 경우 - 게시글 검색 기능을 사용하지 않은 경우
		search="";
	}
	
	String keyword=request.getParameter("keyword");//검색단어
	if(keyword==null) {//전달값이 없는 경우
		keyword="";
	}

	//페이징 처리에 필요한 전달값(페이지번호과 게시글갯수)을 반환받아 저장
	int pageNum=1;//페이지번호- 전달값이 없는 경우 저장된 초기값 설정
	if(request.getParameter("pageNum")!=null) {//전달값이 있는 경우
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
	}
	
	int pageSize=10;//게시글갯수- 전달값이 없는 경우 저장된 초기값 설정
	if(request.getParameter("pageSize")!=null) {//전달값이 있는 경우
		pageSize=Integer.parseInt(request.getParameter("pageSize"));
	}
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰</title>
    <link rel="stylesheet" href="/shop/templete/myproject/style_review_list.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
        <div class="sortBtn">
        <button type="button" id="sortByDate">최신순</button>
        <button type="button" id="sortByRating">별점순</button>
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
                    <div class="review_images">
                        <img src="/shop/templete/tennisracket.jpg" 
                            alt="리뷰 이미지" class="review_image" style="width: 120px; height: 90px;">
                    </div>
                    <div class="review_content">
                        <p>리뷰내용입니다. 너무 좋아요~!</p>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div><hr></div>
    
    <%-- 페이지번호 출력 및 링크 제공 - 블럭화 처리 --%>
	<%
		//하나의 페이지블럭에 출력될 페이지번호의 갯수 설정
		int blockSize=5;
	
		//페이지블럭에 출력될 시작 페이지번호를 계산하여 저장
		//ex)1Block : 1, 2Block : 6, 3Block : 11, 4Block : 16,...
		int startPage=(pageNum-1)/blockSize*blockSize+1;
		        
		//페이지블럭에 출력될 종료 페이지번호를 계산하여 저장
		//ex)1Block : 5, 2Block : 10, 3Block : 15, 4Block : 20,...
		int endPage=startPage+blockSize-1;
		
		//종료 페이지번호가 페이지 총갯수보다 큰 경우 종료 페이지번호 변경 
		//if(endPage>totalPage) {
		//	endPage=totalPage;
		//}
	%>
    <div class="paging_block"></div>
<script>
$(document).ready(function() {
    // 이미지 클릭 시 동작할 함수
    function enlargeImage(image) {
        // 이미지 크기 변경
        image.animate({
            width: '30%',
            height: '30%'
        }, 300);
    }

    // 이미지에 클릭 이벤트 추가
    $('.review_image').click(function() {
        enlargeImage($(this));
    });
});
</script>
</body>
</html>
