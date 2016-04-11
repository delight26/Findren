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
				<li>중국인채용</li>
				<li class="active">구인/구직</li>
			</ol>
		</div>
	</div>

	<!-- 컨텐츠 -->
	<div class="row">
		<!-- 사이드 리스트 -->
		<div class="col-md-3">
			<div class="list-group">
				<a href="/Findren/jobofferList" class="list-group-item active">구인/구직</a>
				<a href="/Findren/headhuntingList" class="list-group-item">헤드헌팅</a>
				<a href="/Findren/peopleList" class="list-group-item">인력파견</a>
			</div>
		</div>
		<!-- 온라인마케팅 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/joboffer_01.png" class="table_name"></h2>
		</div>
		
		<div class="findrenOnline col-md-9">
			<table class="table">
		<tr>
			<th>제목</th>
			<td>${ joboffer.wr_subject }</td>
			<th>작성일</th>
			<td>${ fn:substring(joboffer.wr_datetime, 0, 16) }</td>
		</tr>
			<tr>
			<th>글쓴이</th>
			<td>${ joboffer.wr_name }</td>
			<th>조회수</th>
			<td>${ joboffer.wr_hit }</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="http://${ joboffer.wr_link1 }" target=_blank>${ joboffer.wr_link1 }</a>조회수 : ${ joboffer.wr_link1_hit }<br/>
				<a href="http://${ joboffer.wr_link2 }" target=_blank>${ joboffer.wr_link2 }</a>조회수 : ${ joboffer.wr_link1_hit }
				${ joboffer.wr_content }
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: left;"><a href="jobofferpre?no=${joboffer.wr_id }&pageNum=${pageNum }">이전글</a></td>
			<td colspan="2" style="text-align: right;"><a href="joboffernext?no=${joboffer.wr_id }&pageNum=${pageNum }">다음글</a></td>
		</tr>
	</table>
	
			<div style="text-align: center;">
				<input type="button" class="btn btn-default" value="수정" onclick="location.href='jobofferUpdate?no=${ joboffer.wr_id }'"/>
				<input type="button" class="btn btn-default" id="jobofferDelete" value="삭제" onclick="location.href='jobofferOneDelete?no=${joboffer.wr_id}'"/>
				<input type="button" class="btn btn-default" value="목록" onclick="location.href='jobofferList?pageNum=${pageNum }'"/>
				<input type="button" class="btn btn-default"value="글쓰기" onclick="location.href='jobofferWrite'"/>
			</div>
		</div>
	</div>
</div>

