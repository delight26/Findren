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
				<li>사업분야</li>
				<li class="active">포트폴리오</li>
			</ol>
		</div>
	</div>

	<!-- 컨텐츠 -->
	<div class="row">
		<!-- 사이드 리스트 -->
		<div class="col-md-3">
			<div class="list-group">
			<div class="list-group">
				<a href="/Findren/comChinaMkt" class="list-group-item">중국마케팅</a>
				<a href="/Findren/comOfficialAccount" class="list-group-item">위챗공중계정</a>
				<a href="/Findren/comWechatPay" class="list-group-item">위챗페이</a>
				<a href="/Findren/comJob" class="list-group-item">중국인채용</a>
				<a href="/Findren/PotfolioList" class="list-group-item">포트폴리오</a>
				<a href="/Findren/PotfolioList" class="list-group-item active">가맹점홍보</a>
			</div>
		</div>
		<!-- 공지사항 이름 -->
		<div class="col-md-9">
			<h2><img src="resources/images/portfolio_01.png"></h2>
		</div>
		
		<div class="findrenPortfolio col-md-9">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
<%--						<c:if test=""> --%>
						<th></th>
<%--						/<c:if> --%>
						<th>프로젝트</th>
						<th>글쓴이</th>
					</tr>
				</thead>
				
				<c:if test="${ listCount > 0 }">
					<form id="form1">
						<c:forEach var="portfolio" items="${ portfolioList }" varStatus="s">
							<c:if test="${ portfolio.wr_option eq 'portfolio' }">
								<tr>
									<td>
										<div style="width:10vw;">${portfolio.wr_file1 }</div>
									</td>
									<c:if test="${ portfolio.wr_subject.length() > 20 }">
										<td>
											<a href="portfolioContent?no=${ portfolio.wr_id }&pageNum=${ currentPage }&watch=${ portfolio.wr_hit }">
										${ portfolio.wr_subject.substring(0, 21) }... 
											</a>
										</td>
									</c:if>
									<c:if test="${ portfolio.wr_subject.length() <= 20 }">
										<td>
											<a href="portfolioContent?no=${ portfolio.wr_id }&pageNum=${ currentPage }&watch=${ portfolio.wr_hit }">
										${ portfolio.wr_subject } 
											</a>
										</td>
									</c:if>
										<td><b>${ portfolio.wr_name }</b></td>
								</tr>
							</c:if>
						</c:forEach>
						
						<c:forEach var="portfolio" items="${ portfolioList }" varStatus="s">
							<tr>
								<td>
								<td>
									<div style="width:10vw;">${portfolio.wr_file1 }</div>
								</td>
								<td>${(listCount - s.index) - ( (currentPage - 1)  *  PAGE_GROUP ) }</td>
								<%-- 									<c:if test=""> --%>
								<td>
									<input type="checkbox" value="${ portfolio.wr_id }" name="check"/>
								</td>
							<%-- 									</c:if> --%>
							<c:if test="${ portfolio.wr_subject.length() > 20 }">
								<td>
									<a href="portfolioContent?no=${ portfolio.wr_id }&pageNum=${ currentPage }&watch=${ portfolio.wr_hit }">
								${ portfolio.wr_subject.substring(0, 21) }... 
									</a>
								</td>
							</c:if>
							<c:if test="${ portfolio.wr_subject.length() <= 20 }">
								<td>
									<a href="portfolioContent?no=${ portfolio.wr_id }&pageNum=${ currentPage }&watch=${ portfolio.wr_hit }">
								${ portfolio.wr_subject } 
									</a>
								</td>
							</c:if>
								<td><b>${ portfolio.wr_name }</b></td>
							</tr>
						</c:forEach>
					</form>
				</c:if>
			</table>
			
			<div style="text-align: center;">
				<c:if test="${ startPage > PAGE_GROUP }">
					<ul>
						<li>
							<a href="portfolioList?pageNum=${ startPage - PAGE_GROUP }"><span class="glyphicon glyphicon-menu-left" aria-hidden="true">[이전]</span></a></li>
					</ul>
				</c:if>
				
				<div>
					<ul class="pagination pagination-sm">
						<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
							<c:if test="${ i == currentPage }">
								<li class="disabled"><a>${ i }</a></li>
							</c:if>
							<c:if test="${ i != currentPage }">
								<li><a href="portfolioList?pageNum=${ i }">${ i }</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
				
				<c:if test="${ endPage < pageCount }">
					<ul>
						<li>
							<a href="portfolioList?pageNum=${ startPage + PAGE_GROUP }">[다음]</a></li>
					</ul>
				</c:if>
				<%-- 				<c:if test=""> --%>
				
				<a href = "#" id = "portfolioDelete"><button class="btn btn-default">선택삭제</button></a>
				<a href = "#" id = "portfolioCopy"><button class="btn btn-default">선택복사</button></a>
				<a href = "#" id = "portfolioMove"><button class="btn btn-default">선택이동</button></a>
				<input type="button" class="btn btn-default" value="글쓰기" onclick="location.href='portfolioWrite'">
				<%-- 				</c:if> --%>
			</div>
		</div>
	</div>
</div>
</div>

