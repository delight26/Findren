package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface PortfolioService {

	//리스트
	public void portfolioList(HttpServletRequest request);

	//글쓰기결과
	public void portfolioWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void portfolioContent(HttpServletRequest request);
	
	//다음글
	public void portfolioNext(HttpServletRequest request);
	
	//이전글
	public void portfolioPre(HttpServletRequest request);
	
	//삭제
	public void portfolioDelete(HttpServletRequest request);
	
	//업데이트
	public void portfolioUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void portfolioUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
