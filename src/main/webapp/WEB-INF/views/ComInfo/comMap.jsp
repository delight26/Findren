<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container bodymargin">

	<!-- 페이지 헤드라인 -->
	<div class="row">
		<div class="col-lg-12">
			<ol class="breadcrumb">
				<li><a href="/Findren/comInfo">회사소개</a></li>
				<li class="active">오시는길</li>
			</ol>
		</div>
	</div>

	<!-- 컨텐츠 -->
	<div class="row">
		<!-- 사이드 리스트 -->
		<div class="col-md-3">
			<div class="list-group">
				<a href="/Findren/comInfo" class="list-group-item">회사소개</a>
				<a href="/Findren/comMainCustomer" class="list-group-item">주요고객군</a>
				<a href="/Findren/comMap" class="list-group-item active">오시는길</a>
				<a href="/Findren/noticeList" class="list-group-item">공지사항</a>
				<a href="/Findren/newsList" class="list-group-item">보도자료</a>
			</div>
		</div>
		<!-- 회사정보 내용 -->
		<div class="col-md-9">
			<h2><img src="resources/images/map01.png" class="comInfo_name"></h2>
			<div class="map">
				<div class="map_img">
					<img src="resources/images/map02.png" style="width:100%;">
				</div>
				<br><br>
				<div class="map_table">
					<table class="table">
						<tr>
							<th>(주)중국인찾기</th>
							<td>주소<br>
							대표전화<br>
							대표팩스<br>
							e-mail</td>
							<td>서울특별시 관악구 봉천로 335-3F, 301<br>
							070-7706-8861<br>
							02-877-8868<br>
							findren@findren.kr / findren@naver.com</td>
						</tr>
						<tr>
							<th>교통안내</th>
							<td>지하철<br>
								&nbsp;<br><br>
								버스<br>
								&nbsp;
							</td>
							<td>
								2호선 신림역 8번 출구 도보 13분<br>
								2호선 봉천역 4번 출구 도보 10분<br><br>
								<table class="table">
									<tr>
										<td>봉일시장</td>
										<td>
											간선<br>
											지선<br>
											마을<br>
										</td>
										<td>
											500<br>
											6516<br>
											관악11
										</td>
									</tr>
									<tr>
										<td>	KT&G관악</td>
										<td>
											일반<br>
											간선<br>
											지선<br>
										</td>
										<td>
											1, 9<br>
											N15, N61, 500, 61, 506, 461<br>
											6515, 5413, 5530
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>