package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface SnsService {

	//리스트
	public void snsList(HttpServletRequest request);

	//글쓰기결과
	public void snsWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void snsContent(HttpServletRequest request);
	
	//다음글
	public void snsNext(HttpServletRequest request);
	
	//이전글
	public void snsPre(HttpServletRequest request);
	
	//삭제
	public void snsDelete(HttpServletRequest request);
	
	//업데이트
	public void snsUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void snsUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
