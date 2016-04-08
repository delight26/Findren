package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.WechatidBoard;

public interface WechatidDao {

	//게시판 글 수 
	public Integer getWechatidBoardCount();
	
	//리스트 페이징
	public List<WechatidBoard> getWechatidBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertWechatidBoard(WechatidBoard wechatid);
	
	//조회수
	public void wechatidWatchUpdate(int watch, int no);
	
	//글내용
	public WechatidBoard wechatidContent(int no);
	
	//다음 글 번호
	public Integer wechatidNextNo(int no);
	
	//이전글 번호
	public Integer wechatidPreNo(int no);
	
	//삭제
	public void wechatidDelete(int no);
	
	//업데이트
	public void updateWechatidBoard(WechatidBoard wechatid);
	
	//게시글 최대 수
	public Integer maxNum();
}
