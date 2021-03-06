<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<style>
table th{
text-align: center;
}


</style>

<div class="container bodymargin">

	<!-- 페이지 헤드라인 -->
	<div class="row">
		<div class="col-lg-12">
			<ol class="breadcrumb">
				<li>회사소개</li>
				<li class="active">공지사항</li>
			</ol>
		</div>
	</div>

	<!-- 컨텐츠 -->
	<div class="row">
		<!-- 사이드 리스트 -->
		<div class="col-md-3">
			<div class="list-group">
				<a href="/Findren/comChinaMkt" class="list-group-item">중국마케팅</a>
				<a href="/Findren/comOfficialAccount" class="list-group-item">위챗공중계정</a>
				<a href="/Findren/comWechatPay" class="list-group-item">위챗페이</a>
				<a href="/Findren/comJob" class="list-group-item">중국인채용</a>
				<a href="/Findren/portfolioList" class="list-group-item active">포트폴리오</a>
				<a href="/Findren/promotionList" class="list-group-item">가맹점홍보</a>
			</div>
		</div>
		<!-- 포트폴리오 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/portfolio_01.png" class="table_name"></h2>
		</div>
		
		<div class="findrenPortfolio col-md-9">
		<form id="frm" action="portfolioUpdateResult" method="post" enctype="multipart/form-data">
			<table class="table inputForm">
				<tr>
					<td>옵션</td>
					<td>
						<input type="checkbox" value="news" name="type"/>공지
						<input type="hidden" value="${ portfolio.wr_id }"  name="no"/>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${ portfolio.wr_subject }"/></td>
				</tr>
			   	<tr>
			   		<td>내용</td>
			   		<td id="input"><textarea name="content" id="ir1" rows="10" cols="100">${ portfolio.wr_content }</textarea></td>
				<tr>
					<td>링크 1</td>
					<td><input type="text" name="link1" value="${ portfolio.wr_link1 }"/></td>
				</tr>
				<tr>
					<td>링크 2</td>
					<td><input type="text" name="link2"/>${ portfolio.wr_link2 }</td>
				</tr>
				<tr>
					<td>포폴사진</td>
					<td><input type="file" name="file1"/>원래사진: ${portfolio.wr_file1 }</td>
				</tr>
			</table>
			
			<div style="text-align: center;">
				<input type="button" class="btn btn-default" id="savebutton" value="작성완료" />
				<input type="button" class="btn btn-default" id="cancel" value="취소" />
			</div>
		</form>
			
			
		</div>
	</div>
</div>