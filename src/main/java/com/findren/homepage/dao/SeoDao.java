package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.SeoBoard;

public interface SeoDao {

	//게시판 글 수 
	public Integer getSeoBoardCount();
	
	//리스트 페이징
	public List<SeoBoard> getSeoBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertSeoBoard(SeoBoard seo);
	
	//조회수
	public void seoWatchUpdate(int watch, int no);
	
	//글내용
	public SeoBoard seoContent(int no);
	
	//다음 글 번호
	public Integer seoNextNo(int no);
	
	//이전글 번호
	public Integer seoPreNo(int no);
	
	//삭제
	public void seoDelete(int no);
	
	//업데이트
	public void updateSeoBoard(SeoBoard seo);
	
	//게시글 최대 수
	public Integer maxNum();
}
