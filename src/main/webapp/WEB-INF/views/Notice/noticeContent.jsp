<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>제목</th>
			<td>${ nb.notice_Title }</td>
			<th>작성일</th>
			<td>${ fn:substring(nb.notice_WriteDate, 0, 16) }</td>
		</tr>
			<tr>
			<th>글쓴이</th>
			<td>${ nb.notice_Writer }</td>
			<th>조회수</th>
			<td>${ nb.notice_Watch }</td>
		</tr>
	</table>
		<a href="http://${ nb.notice_Link1 }" target=_blank>${ nb.notice_Link1 }</a><br/>
		<a href="http://${ nb.notice_Link2 }" target=_blank>${ nb.notice_Link2 }</a>
		${ nb.notice_Content }
	<table>
		<tr>
			<th>이전글</th>
			<td><a href="noticepre?no=${nb.notice_No }&pageNum=${pageNum }">이전글</a></td>
		</tr>
		<tr>
			<th>다음글</th>
			<td><a href="noticenext?no=${nb.notice_No }&pageNum=${pageNum }">다음글</a></td>
		</tr>
	</table>
	<a href = "noticeUpdate?no=${ nb.notice_No }">수정</a>
	<input type="button" value="삭제"/>
	<input type="button" value="복사"/>
	<input type="button" value="이동"/>
	<input type="button" value="목록"/>
	<input type="button" value="답변"/>
	<input type="button" value="글쓰기"/>
</body>
</html>