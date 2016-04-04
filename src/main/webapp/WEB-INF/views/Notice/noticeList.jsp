<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(function(){
	$("#noticeDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'noticeDelete', method:'post'}).submit();
		}
	});	
});
</script>
</head>
<body>
	<div>
		<span>
			<b>NOTICE BOARD</b>
		</span>
		<span>
		(주)중국인찾기의 공지사항
		</span>
	</div>
	<div>
		<div>
			<div>
				<table>
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
				<c:if test="${ startPage > PAGE_GROUP }">
					<ul>
						<li>
							<a href="noticeList?pageNum=${ startPage - PAGE_GROUP }">[이전]</a></li>
					</ul>
				</c:if>
				<div>
					<ul>
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
					<a href = "#" id = "noticeDelete">선택삭제</a>
					<a href = "#" id = "noticeCopy">선택복사</a>
					<a href = "#" id = "noticeMove">선택이동</a>
					<a href = "noticeWrite">글쓰기</a>
<%-- 				</c:if> --%>
			</div>
		</div>
	</div>
</body>
</html>