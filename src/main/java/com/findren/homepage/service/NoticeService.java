package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface NoticeService {

	public void noticeList(HttpServletRequest request);

	public void noticeWriteResult(MultipartHttpServletRequest request, String path) throws IllegalStateException, IOException;
}
