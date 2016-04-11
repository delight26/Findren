<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form action = "loginresult" method = "post">
	아이디<input type="text" name="fhm_id" required/><br/>
	비밀번호<input type="text" name="fhm_pw" required/>
	<input type="submit" value="로그인"/>
	<a href="joinMember">회원가입</a>
	<a href="searchIdPw">아이디 / 비밀번호 찾기</a>
</form>