<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file = "/WEB-INF/views/Main/mainSlide.jsp" %>

<div class="container bodymargin">
	<!-- 사업분야 -->
	<div class="row">
		<div class="col-lg-12">
			<p class="page-header">
				<img src="resources/images/main01.png">
			</p>
		</div>
		
		<!-- 중국마케팅 -->
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4><i class="fa fa-fw fa-check"></i><img src="resources/images/main03.png" ></h4>
				</div>
			<div class="panel-body">
				<p><img src="resources/images/main06.png" style="width:100%; text-align:center;"></p>
				<a href="/Findren/comChinaMkt"><img src="resources/images/more.png" style="width:20%; float: right;"></a>
			</div>
			</div>
		</div>
		
		<!-- 위챗서비스 -->
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4><i class="fa fa-fw fa-gift"></i><img src="resources/images/main04.png" ></h4>
				</div>
				<div class="panel-body">
					<p><img src="resources/images/main07.png" style="width:100%; text-align:center;"></p>
					<a href="/Findren/comOfficialAccount"><img src="resources/images/more.png" style="width:20%; float: right;"></a>
				</div>
			</div>
		</div>
		
		<!-- 중국인채용 -->
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4><i class="fa fa-fw fa-compass"></i><img src="resources/images/main05.png" ></h4>
				</div>
				<div class="panel-body">
					<p><img src="resources/images/main08.png" style="width:100%; text-align:center;"></p>
					<a href="/Findren/comJob"><img src="resources/images/more.png" style="width:20%; float: right;"></a>
				</div>
			</div>
		</div>
	</div>

	<!-- 공식계정 -->
		<div class="col-md-5">
			<div class="col-lg-12">
				<h2 class="page-header"><img src="resources/images/main02.png"></h2>
			</div>
			<div class="comQR" style="text-align:center;">
				<img id="QR1" src="resources/images/QRwechat.png">&nbsp;&nbsp;
				<img id="QR2" src="resources/images/QRweibo.png"><br><br>
				<img id="QR1" src="resources/images/QRyellow.png">&nbsp;&nbsp;
				<img id="QR2" src="resources/images/QRstory.png">
			</div>
		</div>
	 
	<!-- 가맹점홍보 -->
	<div class="col-md-7" style="margin-bottom: 5%;">
		<div class="col-lg-12">
			<h2 class="page-header"><img src="resources/images/main09.png"></h2>
		</div>
		<div class="comProLink">ffs</div>
	</div>
</div>