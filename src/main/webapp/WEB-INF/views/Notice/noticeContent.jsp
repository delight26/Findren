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
			<h1 class="page-header">
				&nbsp;
			</h1>
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
			<table class="table">
		<tr>
			<th>제목</th>
			<td>${ nb.wr_subject }</td>
			<th>작성일</th>
			<td>${ fn:substring(nb.wr_datetime, 0, 16) }</td>
		</tr>
			<tr>
			<th>글쓴이</th>
			<td>${ nb.wr_name }</td>
			<th>조회수</th>
			<td>${ nb.wr_hit }</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="http://${ nb.wr_link1 }" target=_blank>${ nb.wr_link1 }</a>조회수 : ${ nb.wr_link1_hit }<br/>
				<a href="http://${ nb.wr_link2 }" target=_blank>${ nb.wr_link2 }</a>조회수 : ${ nb.wr_link1_hit }
				${ nb.wr_content }
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: left;"><a href="noticepre?no=${nb.wr_id }&pageNum=${pageNum }">이전글</a></td>
			<td colspan="2" style="text-align: right;"><a href="noticenext?no=${nb.wr_id }&pageNum=${pageNum }">다음글</a></td>
		</tr>
	</table>
	
			<div style="text-align: center;">
				<input type="button" class="btn btn-default" value="수정" onclick="location.href='noticeUpdate?no=${ nb.wr_id }'"/>
				<input type="button" class="btn btn-default" id="noticeDelete" value="삭제" onclick="location.href='noticeOneDelete?no=${nb.wr_id}'"/>
				<input type="button" class="btn btn-default" value="복사"/>
				<input type="button" class="btn btn-default" value="이동"/>
				
				<input type="button" class="btn btn-default" value="목록" onclick="location.href='noticeList?pageNum=${pageNum }'"/>
				<input type="button" class="btn btn-default" value="답변"/>
				<input type="button" class="btn btn-default"value="글쓰기" onclick="location.href='noticeWrite'"/>
			</div>
		</div>
	</div>
</div>

