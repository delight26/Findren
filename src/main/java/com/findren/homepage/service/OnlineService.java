package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface OnlineService {

	//리스트
	public void onlineList(HttpServletRequest request);

	//글쓰기결과
	public void onlineWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void onlineContent(HttpServletRequest request);
	
	//다음글
	public void onlineNext(HttpServletRequest request);
	
	//이전글
	public void onlinePre(HttpServletRequest request);
	
	//삭제
	public void onlineDelete(HttpServletRequest request);
	
	//업데이트
	public void onlineUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void onlineUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
