<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container bodymargin">

	<!-- 페이지 헤드라인 -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				&nbsp;
			</h1>
			<ol class="breadcrumb">
				<li><a href="/Findren/comInfo">회사소개</a></li>
				<li class="active">회사소개</li>
			</ol>
		</div>
	</div>

	<!-- 컨텐츠 -->
	<div class="row">
		<!-- 사이드 리스트 -->
		<div class="col-md-3">
			<div class="list-group">
				<a href="/Findren/comInfo" class="list-group-item active">회사소개</a>
				<a href="/Findren/comMainCustomer" class="list-group-item">주요고객군</a>
				<a href="/Findren/comMap" class="list-group-item">오시는길</a>
				<a href="/Findren/noticeList" class="list-group-item">공지사항</a>
				<a href="#" class="list-group-item">보도자료</a>
			</div>
		</div>
		<!-- 회사정보 내용 -->
		<div class="col-md-9">
			<h2><img src="resources/images/cominfo_00.png"></h2>
			<div class="comInfo">
				<div class="comInfo_img_01_03">
					<img src="resources/images/cominfo_01.png">&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="resources/images/cominfo_02.png">&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="resources/images/cominfo_03.png">
				</div><br><br>
				<div class="comInfo_img_04"><img src="resources/images/cominfo_04.png"></div>
			</div>
		</div>
	</div>
</div>