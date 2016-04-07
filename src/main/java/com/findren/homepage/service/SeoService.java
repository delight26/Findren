package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface SeoService {

	//리스트
	public void seoList(HttpServletRequest request);

	//글쓰기결과
	public void seoWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void seoContent(HttpServletRequest request);
	
	//다음글
	public void seoNext(HttpServletRequest request);
	
	//이전글
	public void seoPre(HttpServletRequest request);
	
	//삭제
	public void seoDelete(HttpServletRequest request);
	
	//업데이트
	public void seoUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void seoUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
