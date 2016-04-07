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
						<c:forEach var="notice" items="${ noticeList }" varStatus="s">
							<c:if test="${ notice.wr_option eq 'notice' }">
								<tr>
									<td>공지</td>
								<%-- 									<c:if test=""> --%>
									<td>
										<input type="checkbox" value="${ notice.wr_id }" name="check"/>
									</td>
								<%-- 									</c:if> --%>
							
								<c:if test="${ notice.wr_subject.length() > 20 }">
									<td>
										<a href="noticeContent?no=${ notice.wr_id }&pageNum=${ currentPage }&watch=${ notice.wr_hit }">
									${ notice.wr_subject.substring(0, 21) }... 
										</a>
									</td>
								</c:if>
								<c:if test="${ notice.wr_subject.length() <= 20 }">
									<td>
										<a href="noticeContent?no=${ notice.wr_id }&pageNum=${ currentPage }&watch=${ notice.wr_hit }">
									${ notice.wr_subject } 
										</a>
									</td>
								</c:if>
									<td><b>${ notice.wr_name }</b></td>
									<td>${ fn:substring(notice.wr_datetime, 0, 10) }</td>
									<td>${ notice.wr_hit }</td>
								</tr>
							</c:if>
						</c:forEach>
						
						<c:forEach var="notice" items="${ noticeList }" varStatus="s">
							<tr>
								<td>${(listCount - s.index) - ( (currentPage - 1)  *  PAGE_GROUP ) }</td>
								<%-- 									<c:if test=""> --%>
								<td>
									<input type="checkbox" value="${ notice.wr_id }" name="check"/>
								</td>
							<%-- 									</c:if> --%>
							<c:if test="${ notice.wr_subject.length() > 20 }">
								<td>
									<a href="noticeContent?no=${ notice.wr_id }&pageNum=${ currentPage }&watch=${ notice.wr_hit }">
								${ notice.wr_subject.substring(0, 21) }... 
									</a>
								</td>
							</c:if>
							<c:if test="${ notice.wr_subject.length() <= 20 }">
								<td>
									<a href="noticeContent?no=${ notice.wr_id }&pageNum=${ currentPage }&watch=${ notice.wr_hit }">
								${ notice.wr_subject } 
									</a>
								</td>
							</c:if>
								<td><b>${ notice.wr_name }</b></td>
								<td>${ fn:substring(notice.wr_datetime, 0, 10) }</td>
								<td>${ notice.wr_hit }</td>
							</tr>
						</c:forEach>
					</form>
				</c:if>
			</table>
			
			<div style="text-align: center;">
				<c:if test="${ startPage > PAGE_GROUP }">
					<ul>
						<li>
							<a href="noticeList?pageNum=${ startPage - PAGE_GROUP }"><span class="glyphicon glyphicon-menu-left" aria-hidden="true">[이전]</span></a></li>
					</ul>
				</c:if>
				
				<div>
					<ul class="pagination pagination-sm">
						<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
							<c:if test="${ i == currentPage }">
								<li class="disabled"><a>${ i }</a></li>
							</c:if>
							<c:if test="${ i != currentPage }">
								<li><a href="noticeList?pageNum=${ i }">${ i }</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
				
				<c:if test="${ endPage < pageCount }">
					<ul>
						<li>
							<a href="noticeList?pageNum=${ startPage + PAGE_GROUP }">[다음]</a></li>
					</ul>
				</c:if>
				<%-- 				<c:if test=""> --%>
				
				<a href = "#" id = "noticeDelete"><button class="btn btn-default">선택삭제</button></a>
				<a href = "#" id = "noticeCopy"><button class="btn btn-default">선택복사</button></a>
				<a href = "#" id = "noticeMove"><button class="btn btn-default">선택이동</button></a>
				<a href = "noticeWrite"><button class="btn btn-default">글쓰기</button></a>
				<%-- 				</c:if> --%>
			</div>
		</div>
	</div>
</div>

