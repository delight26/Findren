package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface PeopleService {

	//리스트
	public void peopleList(HttpServletRequest request);

	//글쓰기결과
	public void peopleWriteResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
	
	//글내용
	public void peopleContent(HttpServletRequest request);
	
	//다음글
	public void peopleNext(HttpServletRequest request);
	
	//이전글
	public void peoplePre(HttpServletRequest request);
	
	//삭제
	public void peopleDelete(HttpServletRequest request);
	
	//업데이트
	public void peopleUpdate(HttpServletRequest request);
	
	//업데이트 결과
	public void peopleUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session) throws IllegalStateException, IOException;
}
