package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface JobofferService {

	//리스트
	public void jobofferList(HttpServletRequest request);

	//글쓰기결과
	public void jobofferWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void jobofferContent(HttpServletRequest request);
	
	//다음글
	public void jobofferNext(HttpServletRequest request);
	
	//이전글
	public void jobofferPre(HttpServletRequest request);
	
	//삭제
	public void jobofferDelete(HttpServletRequest request);
	
	//업데이트
	public void jobofferUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void jobofferUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
