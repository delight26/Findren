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
				<li>회사소개</li>
				<li class="active">보도자료</li>
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
				<a href="/Findren/noticeList" class="list-group-item">공지사항</a>
				<a href="/Findren/newsList" class="list-group-item active">보도자료</a>
			</div>
		</div>
		<!-- 공지사항 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/news_01.png"></h2>
		</div>
		
		<div class="findrenNews col-md-9">
			<table class="table">
		<tr>
			<th>제목</th>
			<td>${ news.wr_subject }</td>
			<th>작성일</th>
			<td>${ fn:substring(news.wr_datetime, 0, 16) }</td>
		</tr>
			<tr>
			<th>글쓴이</th>
			<td>${ news.wr_name }</td>
			<th>조회수</th>
			<td>${ news.wr_hit }</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="http://${ news.wr_link1 }" target=_blank>${ news.wr_link1 }</a>조회수 : ${ news.wr_link1_hit }<br/>
				<a href="http://${ news.wr_link2 }" target=_blank>${ news.wr_link2 }</a>조회수 : ${ news.wr_link1_hit }
				${ news.wr_content }
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: left;"><a href="newspre?no=${news.wr_id }&pageNum=${pageNum }">이전글</a></td>
			<td colspan="2" style="text-align: right;"><a href="newsnext?no=${news.wr_id }&pageNum=${pageNum }">다음글</a></td>
		</tr>
	</table>
	
			<div style="text-align: center;">
				<input type="button" class="btn btn-default" value="수정" onclick="location.href='newsUpdate?no=${ news.wr_id }'"/>
				<input type="button" class="btn btn-default" value="삭제" onclick="location.href='newsOneDelete?no=${news.wr_id}'"/>
				<input type="button" class="btn btn-default" value="목록" onclick="location.href='newsList?pageNum=${pageNum }'"/>
				<input type="button" class="btn btn-default"value="글쓰기" onclick="location.href='newsWrite'"/>
			</div>
		</div>
	</div>
</div>

