package com.findren.homepage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.findren.homepage.domain.NoticeBoard;


public class DaoMapper {

	private NoticeBoardRMRSE noticeBoardRMRSE = new NoticeBoardRMRSE();
	
	public NoticeBoardRMRSE getNoticeBoardRMRSE() {
		return noticeBoardRMRSE;
	}
	private class NoticeBoardRMRSE implements RowMapper<NoticeBoard>, ResultSetExtractor<NoticeBoard>{
		
		@Override
		public NoticeBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			NoticeBoard nb = new NoticeBoard();
			nb.setWr_id(rs.getInt("wr_id"));
			nb.setWr_subject(rs.getString("wr_subject"));
			nb.setWr_content(rs.getString("wr_content"));
			nb.setMb_id(rs.getString("mb_id"));
			nb.setWr_name(rs.getString("wr_name"));
			nb.setWr_link1(rs.getString("wr_link1"));
			nb.setWr_link2(rs.getString("wr_link2"));
			nb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			nb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			nb.setWr_hit(rs.getInt("wr_hit"));
			nb.setWr_datetime(rs.getTimestamp("wr_datetime"));
			nb.setWr_file1(rs.getString("wr_file1"));
			nb.setWr_file2(rs.getString("wr_file2"));
			nb.setWr_ip(rs.getString("wr_ip"));
			nb.setWr_option(rs.getString("wr_option"));
			
			return nb;
		}
		
		@Override
		public NoticeBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			NoticeBoard nb = new NoticeBoard();
			nb.setWr_id(rs.getInt("wr_id"));
			nb.setWr_subject(rs.getString("wr_subject"));
			nb.setWr_content(rs.getString("wr_content"));
			nb.setMb_id(rs.getString("mb_id"));
			nb.setWr_name(rs.getString("wr_name"));
			nb.setWr_link1(rs.getString("wr_link1"));
			nb.setWr_link2(rs.getString("wr_link2"));
			nb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			nb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			nb.setWr_hit(rs.getInt("wr_hit"));
			nb.setWr_datetime(rs.getTimestamp("wr_datetime"));
			nb.setWr_file1(rs.getString("wr_file1"));
			nb.setWr_file2(rs.getString("wr_file2"));
			nb.setWr_ip(rs.getString("wr_ip"));
			nb.setWr_option(rs.getString("wr_option"));
			return nb;
			}
			return null;
		}
	}
}
