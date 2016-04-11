<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="container bodymargin">

	<!-- 페이지 헤드라인 -->
	<div class="row">
		<div class="col-lg-12">
			<ol class="breadcrumb">
				<li>회원가입</li>
				<li class="active">회원가입</li>
			</ol>
		</div>
	</div>

	<!-- 컨텐츠 -->
	<div class="row">
		<!-- 사이드 리스트 -->
		<div class="col-md-3">
			<div class="list-group">
				<a herf="/Findren/joinMember" class="list-group-item active">회원가입</a>
				<a href="/Findren/perMember1" class="list-group-item">개인회원</a>
				<a href="/Findren/comMember1" class="list-group-item">법인회원</a>
			</div>
		</div>
		<div class="col-md-9">
			<h2>&nbsp;</h2>
			<div class="findrenMember col-md-9" >
				<a href="/Findren/perMember1"><img src="resources/images/personaljoin.png" ></a>
				&nbsp;&nbsp;&nbsp;
				<a href="/Findren/comMember1"><img src="resources/images/comjoin.png" ></a>
			</div>
		</div>
	</div>
</div>

				
