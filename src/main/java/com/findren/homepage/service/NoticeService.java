package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface NoticeService {

	//리스트
	public void noticeList(HttpServletRequest request);

	//글쓰기결과
	public void noticeWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void noticeContent(HttpServletRequest request);
	
	//다음글
	public void noticeNext(HttpServletRequest request);
	
	//이전글
	public void noticePre(HttpServletRequest request);
	
	//삭제
	public void noticeDelete(HttpServletRequest request);
	
	//업데이트
	public void noticeUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void noticeUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
