package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface NewsService {

	//리스트
	public void newsList(HttpServletRequest request);

	//글쓰기결과
	public void newsWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void newsContent(HttpServletRequest request);
	
	//다음글
	public void newsNext(HttpServletRequest request);
	
	//이전글
	public void newsPre(HttpServletRequest request);
	
	//삭제
	public void newsDelete(HttpServletRequest request);
	
	//업데이트
	public void newsUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void newsUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
