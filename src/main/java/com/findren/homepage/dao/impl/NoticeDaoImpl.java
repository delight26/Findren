package com.findren.homepage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.findren.homepage.dao.NoticeDao;
import com.findren.homepage.domain.NoticeBoard;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private DaoMapper dm = new DaoMapper();

	@Override
	public Integer getNoticeBoardCount() {
		SqlParameterSource boardparam = new MapSqlParameterSource("board_notice", "board_notice");
		String sql = "select count(*) from board_notice";
		return namedParameterJdbcTemplate.queryForObject(sql, boardparam, Integer.class);
	}

	@Override
	public List<NoticeBoard> getNoticeBoardList(int startRow, int PAGE_SIZE) {
		SqlParameterSource noticeparam = new MapSqlParameterSource("startRow", startRow).addValue("PAGE_SIZE",
				PAGE_SIZE);
		String sql = "select * from board_notice limit :startRow, :PAGE_SIZE";
		return namedParameterJdbcTemplate.query(sql, noticeparam, dm.getNoticeBoardRMRSE());
	}

	@Override
	public void insertNoticeBoard(NoticeBoard nb) {
		SqlParameterSource noticeparam = new BeanPropertySqlParameterSource(nb);
		String sql = "insert into board_notice values(0, :notice_Title, :notice_Writer, :notice_Content, :notice_File1, :notice_File2, :notice_Link1,"
				+ ":notice_Link2, 0, :notice_WriteDate, :notice_Type)";
		namedParameterJdbcTemplate.update(sql, noticeparam);
	}
}
