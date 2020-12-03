<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>네이버 예약</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<div id="container">
        <jsp:include page="header.jsp"/>
		<hr>
		<div class="event">
			<div class="section_visual">
				<div class="group_visual">
					<div class="container_visual">
						<div class="prev_e" style="display: none;">
							<div class="prev_inn">
								<a href="#" class="btn_pre_e" title="이전">
								    <i class="spr_book_event spr_event_pre">이전</i>
								</a>
							</div>
						</div>
						<div class="nxt_e" style="display: none;">
							<div class="nxt_inn">
								<a href="#" class="btn_nxt_e" title="다음">
								    <i class="spr_book_event spr_event_nxt">다음</i>
								</a>
							</div>
						</div>
						<div>
							<div class="container_visual">
								<ul class="visual_img">
								</ul>
							</div>
							<span class="nxt_fix" style="display: none;"></span>
						</div>
					</div>
				</div>
			</div>

			<div class="section_event_tab">
				<ul class="event_tab_lst tab_lst_min">
					<li class="item" data-category="0">
					   <a class="anchor active">
							<span>전체리스트</span>
					   </a>
                    </li>
				</ul>
			</div>

			<div class="section_event_lst">
				<p class="event_lst_txt">
					바로 예매 가능한 행사가 <span class="pink" data-count="0">0개</span> 있습니다
				</p>
				<div class="wrap_event_box">
					<!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
					<ul class="lst_event_box">
					</ul>
					<ul class="lst_event_box">
					</ul>
					<!-- 더보기 -->
					<div class="more">
			            <button class="btn">
			                <span>더보기</span>
			            </button>
					</div>
				</div>
			</div>
		</div>
	</div>

    <jsp:include page="footer.jsp"/>

	<script type="rv-template" id="categoryTabLi">
        <li class="item" data-category="{id}">
            <a class="anchor">
                <span>{name}</span>
            </a>
        </li>
    </script>

	<script type="rv-template" id="promotionItem">
        <li class="item" style="background-image: url(./api/file?fileName={saveFileName}">
            <a href="#">
            <span class="img_btm_border"></span>
            <span class="img_right_border"></span>
            <span class="img_bg_gra"></span>
               <div class="event_txt">
                    <h4 class="event_txt_tit">{description}</h4>
                    <p class="event_txt_adr">{placeName}</p>
                    <p class="event_txt_dsc">{content}</p>
                </div>
            </a>
        </li>
    </script>

	<script type="rv-template" id="itemList">
        <li class="item">
            <a href="detail?id={detailId}&display={displayInfoId}" class="item_book">
                <div class="item_preview">
                    <img alt="{description}" class="img_thumb" src="./api/file?fileName={saveFileName}">
                    <span class="img_border"></span>
                </div>
                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>{descriptionText}</span> <small class="sm">{placeName}</small> </h4>
                    <p class="event_txt_dsc">{content}</p>
                </div>
            </a>
        </li>
    </script>

    <script src="./js/module/error.js"></script>
    <script src="./js/mainpage.js"></script>
</body>
</html>