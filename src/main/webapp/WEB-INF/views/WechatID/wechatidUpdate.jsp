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
				<li>위챗서비스</li>
				<li class="active">공중계정</li>
			</ol>
		</div>
	</div>

	<!-- 컨텐츠 -->
	<div class="row">
		<!-- 사이드 리스트 -->
		<div class="col-md-3">
			<div class="list-group">
				<a href="/Findren/wechatidListt" class="list-group-item active">공중계정</a>
				<a href="/Findren/wechatpayList" class="list-group-item">위챗페이</a>
			</div>
		</div>
		<!-- 공중계정 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/wofficial_01.png" class="table_name"></h2>
		</div>
		
		<div class="findrenWechatID col-md-9">
		<form id="frm" action="wechatidUpdateResult" method="post" enctype="multipart/form-data">
			<table class="table inputForm">
				<tr>
					<td>옵션</td>
					<td>
						<input type="checkbox" value="wechatid" name="type"/>공지
						<input type="hidden" value="${ wechatid.wr_id }"  name="no"/>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${ wechatid.wr_subject }"/></td>
				</tr>
			   	<tr>
			   		<td>내용</td>
			   		<td id="input"><textarea name="content" id="ir1" rows="10" cols="100">${ wechatid.wr_content }</textarea></td>
				<tr>
					<td>링크 1</td>
					<td><input type="text" name="link1" value="${ wechatid.wr_link1 }"/></td>
				</tr>
				<tr>
					<td>링크 2</td>
					<td><input type="text" name="link2"/>${ wechatid.wr_link2 }</td>
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
				<input type="button" class="btn btn-default" id="savebutton" value="작성완료" />
				<input type="button" class="btn btn-default" id="cancel" value="취소" />
		</form>
			
			
		</div>
	</div>
</div>