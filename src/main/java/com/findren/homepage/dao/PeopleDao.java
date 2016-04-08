package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.PeopleBoard;

public interface PeopleDao {

	//게시판 글 수 
	public Integer getPeopleBoardCount();
	
	//리스트 페이징
	public List<PeopleBoard> getPeopleBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertPeopleBoard(PeopleBoard nb);
	
	//조회수
	public void peopleWatchUpdate(int watch, int no);
	
	//글내용
	public PeopleBoard peopleContent(int no);
	
	//다음 글 번호
	public Integer peopleNextNo(int no);
	
	//이전글 번호
	public Integer peoplePreNo(int no);
	
	//삭제
	public void peopleDelete(int no);
	
	//업데이트
	public void updatePeopleBoard(PeopleBoard nb);
	
	//게시글 최대 수
	public Integer maxNum();
}
