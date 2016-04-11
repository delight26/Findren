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
				<a href="/Findren/comChinaMkt" class="list-group-item">중국마케팅</a>
				<a href="/Findren/comOfficialAccount" class="list-group-item">위챗공중계정</a>
				<a href="/Findren/comWechatPay" class="list-group-item">위챗페이</a>
				<a href="/Findren/comJob" class="list-group-item">중국인채용</a>
				<a href="/Findren/portfolioList" class="list-group-item">포트폴리오</a>
				<a href="/Findren/promotionList" class="list-group-item active">가맹점홍보</a>
			</div>
		</div>
		<!-- 공지사항 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/news_01.png" class="table_name"></h2>
		</div>
		
		<div class="findrenNews col-md-9">
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
			<td colspan="2" style="text-align: left;"><a href="newspre?no=${nb.wr_id }&pageNum=${pageNum }">이전글</a></td>
			<td colspan="2" style="text-align: right;"><a href="newsnext?no=${nb.wr_id }&pageNum=${pageNum }">다음글</a></td>
		</tr>
	</table>
	
			<div style="text-align: center;">
				<input type="button" class="btn btn-default" value="수정" onclick="location.href='newsUpdate?no=${ nb.wr_id }'"/>
				<input type="button" class="btn btn-default" value="삭제" onclick="location.href='newsOneDelete?no=${nb.wr_id}'"/>
				<input type="button" class="btn btn-default" value="목록" onclick="location.href='newsList?pageNum=${pageNum }'"/>
				<input type="button" class="btn btn-default"value="글쓰기" onclick="location.href='newsWrite'"/>
			</div>
		</div>
	</div>
</div>

