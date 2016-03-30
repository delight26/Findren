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
			nb.setNotice_No(rs.getInt("No"));
			nb.setNotice_Title(rs.getString("Title"));
			nb.setNotice_Writer(rs.getString("Writer"));
			nb.setNotice_Content(rs.getString("Content"));
			nb.setNotice_Watch(rs.getInt("Watch"));
			nb.setNotice_IP(rs.getString("IP"));
			return nb;
		}
		
		@Override
		public NoticeBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			NoticeBoard nb = new NoticeBoard();
			nb.setNotice_No(rs.getInt("No"));
			nb.setNotice_Title(rs.getString("Title"));
			nb.setNotice_Writer(rs.getString("Writer"));
			nb.setNotice_Content(rs.getString("Content"));
			nb.setNotice_Watch(rs.getInt("Watch"));
			nb.setNotice_IP(rs.getString("IP"));
			return nb;
			}
			return null;
		}
	}
}
