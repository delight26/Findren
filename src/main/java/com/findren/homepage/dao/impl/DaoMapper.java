package com.findren.homepage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

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
			nb.setNotice_No(rs.getInt("notice_no"));
			nb.setNotice_Title(rs.getString("notice_title"));
			nb.setNotice_Writer(rs.getString("notice_writer"));
			nb.setNotice_Content(rs.getString("notice_content"));
			nb.setNotice_WriteDate(rs.getTimestamp("notice_writedate"));
			nb.setNotice_Watch(rs.getInt("notice_Watch"));
			nb.setNotice_Type(rs.getString("notice_Type"));
			nb.setNotice_File1(rs.getString("notice_File1"));
			nb.setNotice_File2(rs.getString("notice_File2"));
			nb.setNotice_Link1(rs.getString("notice_Link1"));
			nb.setNotice_Link2(rs.getString("notice_Link2"));
			return nb;
		}
		
		@Override
		public NoticeBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			NoticeBoard nb = new NoticeBoard();
			nb.setNotice_No(rs.getInt("notice_no"));
			nb.setNotice_Title(rs.getString("notice_title"));
			nb.setNotice_Writer(rs.getString("notice_writer"));
			nb.setNotice_Content(rs.getString("notice_content"));
			nb.setNotice_WriteDate(rs.getTimestamp("notice_writedate"));
			nb.setNotice_Watch(rs.getInt("notice_Watch"));
			nb.setNotice_Type(rs.getString("notice_Type"));
			nb.setNotice_File1(rs.getString("notice_File1"));
			nb.setNotice_File2(rs.getString("notice_File2"));
			nb.setNotice_Link1(rs.getString("notice_Link1"));
			nb.setNotice_Link2(rs.getString("notice_Link2"));
			return nb;
			}
			return null;
		}
	}
}
