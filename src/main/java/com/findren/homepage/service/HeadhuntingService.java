package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface HeadhuntingService {

	//리스트
	public void headhuntingList(HttpServletRequest request);

	//글쓰기결과
	public void headhuntingWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void headhuntingContent(HttpServletRequest request);
	
	//다음글
	public void headhuntingNext(HttpServletRequest request);
	
	//이전글
	public void headhuntingPre(HttpServletRequest request);
	
	//삭제
	public void headhuntingDelete(HttpServletRequest request);
	
	//업데이트
	public void headhuntingUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void headhuntingUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
