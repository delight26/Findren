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
	</table>
		<a href="http://${ nb.wr_link1 }" target=_blank>${ nb.wr_link1 }</a>조회수 : ${ nb.wr_link1_hit }<br/>
		<a href="http://${ nb.wr_link2 }" target=_blank>${ nb.wr_link2 }</a>조회수 : ${ nb.wr_link1_hit }
		${ nb.wr_content }
	<table>
		<tr>
			<th>이전글</th>
			<td><a href="noticepre?no=${nb.wr_id }&pageNum=${pageNum }">이전글</a></td>
		</tr>
		<tr>
			<th>다음글</th>
			<td><a href="noticenext?no=${nb.wr_id }&pageNum=${pageNum }">다음글</a></td>
		</tr>
	</table>
	<a href = "noticeUpdate?no=${ nb.wr_id }">수정</a>
	<input type="button" value="삭제"/>
	<input type="button" value="복사"/>
	<input type="button" value="이동"/>
	<a href = "noticeList?pageNum=${pageNum }">목록</a>
	<input type="button" value="목록"/>
	<input type="button" value="답변"/>
	<input type="button" value="글쓰기"/>
</body>
</html>