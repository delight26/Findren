package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface WechatidService {

	//리스트
	public void wechatidList(HttpServletRequest request);

	//글쓰기결과
	public void wechatidWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void wechatidContent(HttpServletRequest request);
	
	//다음글
	public void wechatidNext(HttpServletRequest request);
	
	//이전글
	public void wechatidPre(HttpServletRequest request);
	
	//삭제
	public void wechatidDelete(HttpServletRequest request);
	
	//업데이트
	public void wechatidUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void wechatidUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
