<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
회원가입 시 등록하신 이메일 주소를 입력해 주세요.
해당 이메일로 아이디와 비밀번호 정보를 보내드립니다.
	<input type="email" name="fhm_email"/>
	<div id="recaptcha">
	<div class="g-recaptcha" data-sitekey="6LdkmxwTAAAAAPALNWYHlctTEGXmdADPEhdUfDRZ"></div>
	</div>
	<input type = "text" id = "rechaptcha" readonly/>
	<input id="recaptchaCheck" type="button" value="Check">