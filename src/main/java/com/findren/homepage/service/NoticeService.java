package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface NoticeService {

	public void noticeList(HttpServletRequest request);

	public void noticeWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	public void noticeContent(HttpServletRequest request);
	
	public void noticeNext(HttpServletRequest request);
	
	public void noticePre(HttpServletRequest request);
	
	public void noticeDelete(HttpServletRequest request);
	
	public void noticeUpdate(HttpServletRequest request);
	
	public void noticeUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
