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
				<li>중국마케팅</li>
				<li class="active">온라인마케팅</li>
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
		<!-- 공지사항 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/joboffer_01.png" class="table_name"></h2>
		</div>
		
		<div class="findreJobOffer col-md-9">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
<%--						<c:if test=""> --%>
						<th></th>
<%--						/<c:if> --%>
						<th>제목</th>
						<th>글쓴이</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<c:if test="${ listCount > 0 }">
					<form id="form1">
						<c:forEach var="joboffer" items="${ jobofferList }" varStatus="s">
							<c:if test="${ joboffer.wr_option eq 'joboffer' }">
								<tr>
									<c:if test="${ joboffer.wr_subject.length() > 20 }">
										<td>
											<a href="jobofferContent?no=${ joboffer.wr_id }&pageNum=${ currentPage }&watch=${ joboffer.wr_hit }">
										${ joboffer.wr_subject.substring(0, 21) }... 
											</a>
										</td>
									</c:if>
									<c:if test="${ joboffer.wr_subject.length() <= 20 }">
										<td>
											<a href="jobofferContent?no=${ joboffer.wr_id }&pageNum=${ currentPage }&watch=${ joboffer.wr_hit }">
										${ joboffer.wr_subject } 
											</a>
										</td>
									</c:if>
										<td><b>${ joboffer.wr_name }</b></td>
										<td>${ fn:substring(joboffer.wr_datetime, 0, 10) }</td>
										<td>${ joboffer.wr_hit }</td>
								</tr>
							</c:if>
						</c:forEach>
						
						<c:forEach var="joboffer" items="${ jobofferList }" varStatus="s">
							<tr>
								<td>${(listCount - s.index) - ( (currentPage - 1)  *  PAGE_GROUP ) }</td>
								<%-- 									<c:if test=""> --%>
								<td>
									<input type="checkbox" value="${ joboffer.wr_id }" name="check"/>
								</td>
							<%-- 									</c:if> --%>
							<c:if test="${ joboffer.wr_subject.length() > 20 }">
								<td>
									<a href="jobofferContent?no=${ joboffer.wr_id }&pageNum=${ currentPage }&watch=${ joboffer.wr_hit }">
								${ joboffer.wr_subject.substring(0, 21) }... 
									</a>
								</td>
							</c:if>
							<c:if test="${ joboffer.wr_subject.length() <= 20 }">
								<td>
									<a href="jobofferContent?no=${ joboffer.wr_id }&pageNum=${ currentPage }&watch=${ joboffer.wr_hit }">
								${ joboffer.wr_subject } 
									</a>
								</td>
							</c:if>
								<td><b>${ joboffer.wr_name }</b></td>
								<td>${ fn:substring(joboffer.wr_datetime, 0, 10) }</td>
								<td>${ joboffer.wr_hit }</td>
							</tr>
						</c:forEach>
					</form>
				</c:if>
			</table>
			
			<div style="text-align: center;">
				<c:if test="${ startPage > PAGE_GROUP }">
					<ul>
						<li>
							<a href="jobofferList?pageNum=${ startPage - PAGE_GROUP }"><span class="glyphicon glyphicon-menu-left" aria-hidden="true">[이전]</span></a></li>
					</ul>
				</c:if>
				
				<div>
					<ul class="pagination pagination-sm">
						<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
							<c:if test="${ i == currentPage }">
								<li class="disabled"><a>${ i }</a></li>
							</c:if>
							<c:if test="${ i != currentPage }">
								<li><a href="jobofferList?pageNum=${ i }">${ i }</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
				
				<c:if test="${ endPage < pageCount }">
					<ul>
						<li>
							<a href="jobofferList?pageNum=${ startPage + PAGE_GROUP }">[다음]</a></li>
					</ul>
				</c:if>
				<%-- 				<c:if test=""> --%>
				
				<a href = "#" id = "jobofferDelete"><button class="btn btn-default">선택삭제</button></a>
				<input type="button" class="btn btn-default" value="글쓰기" onclick="location.href='jobofferWrite'">
				<%-- 				</c:if> --%>
			</div>
		</div>
	</div>
</div>

