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
				<a href="/Findren/comInfo" class="list-group-item">회사소개</a>
				<a href="/Findren/comMainCustomer" class="list-group-item">주요고객군</a>
				<a href="/Findren/comMap" class="list-group-item">오시는길</a>
				<a href="/Findren/noticeList" class="list-group-item active">공지사항</a>
				<a href="/Findren/newsList" class="list-group-item">보도자료</a>
			</div>
		</div>
		<!-- 공지사항 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/notice_01.png"></h2>
		</div>
		
		<div class="findrenNotice col-md-9">
			<form id="frm" action="noticeWriteResult" method="post" enctype="multipart/form-data">
				<table class="table inputForm">
					<tr>
						<td>옵션</td>
						<td><input type="checkbox" value="notice" name="type">공지</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"/></td>
					</tr>
				   	<tr>
					   	<td>내용</td>
					   	<td id="input" ><textarea name="content" id="ir1" cols="100"></textarea></td>
					<tr>
						<td>링크 1</td>
						<td><input type="text" name="link1"/></td>
					</tr>
					<tr>
						<td>링크 2</td>
						<td><input type="text" name="link2"/></td>
					</tr>
					<tr>
						<td>파일 1</td>
						<td><input type="file" name="file1"/></td>
					</tr>
					<tr>
						<td>파일 2</td>
						<td><input type="file" name="file2"/></td>
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
