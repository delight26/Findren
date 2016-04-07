package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface PromotionService {

	//리스트
	public void promotionList(HttpServletRequest request);

	//글쓰기결과
	public void promotionWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void promotionContent(HttpServletRequest request);
	
	//다음글
	public void promotionNext(HttpServletRequest request);
	
	//이전글
	public void promotionPre(HttpServletRequest request);
	
	//삭제
	public void promotionDelete(HttpServletRequest request);
	
	//업데이트
	public void promotionUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void promotionUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
