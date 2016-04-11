<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style>
table th, td{
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
			<table class="table">
		<tr>
			<th>제목</th>
			<td>${ wechatid.wr_subject }</td>
			<th>작성일</th>
			<td>${ fn:substring(wechatid.wr_datetime, 0, 16) }</td>
		</tr>
			<tr>
			<th>글쓴이</th>
			<td>${ wechatid.wr_name }</td>
			<th>조회수</th>
			<td>${ wechatid.wr_hit }</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="http://${ wechatid.wr_link1 }" target=_blank>${ wechatid.wr_link1 }</a>조회수 : ${ wechatid.wr_link1_hit }<br/>
				<a href="http://${ wechatid.wr_link2 }" target=_blank>${ wechatid.wr_link2 }</a>조회수 : ${ wechatid.wr_link1_hit }
				${ wechatid.wr_content }
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: left;"><a href="wechatidpre?no=${wechatid.wr_id }&pageNum=${pageNum }">이전글</a></td>
			<td colspan="2" style="text-align: right;"><a href="wechatidnext?no=${wechatid.wr_id }&pageNum=${pageNum }">다음글</a></td>
		</tr>
	</table>
	
			<div style="text-align: center;">
				<input type="button" class="btn btn-default" value="수정" onclick="location.href='wechatidUpdate?no=${ wechatid.wr_id }'"/>
				<input type="button" class="btn btn-default" id="wechatidDelete" value="삭제" onclick="location.href='wechatidOneDelete?no=${wechatid.wr_id}'"/>
				<input type="button" class="btn btn-default" value="목록" onclick="location.href='wechatidList?pageNum=${pageNum }'"/>
				<input type="button" class="btn btn-default"value="글쓰기" onclick="location.href='wechatidWrite'"/>
			</div>
		</div>
	</div>
</div>

