package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface WechatpayService {

	//리스트
	public void wechatpayList(HttpServletRequest request);

	//글쓰기결과
	public void wechatpayWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void wechatpayContent(HttpServletRequest request);
	
	//다음글
	public void wechatpayNext(HttpServletRequest request);
	
	//이전글
	public void wechatpayPre(HttpServletRequest request);
	
	//삭제
	public void wechatpayDelete(HttpServletRequest request);
	
	//업데이트
	public void wechatpayUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void wechatpayUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
