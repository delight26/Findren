package com.findren.homepage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.findren.homepage.dao.OnlineDao;
import com.findren.homepage.domain.OnlineBoard;

@Repository
public class OnlineDaoImpl implements OnlineDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	private SqlParameterSource onlineparam;
	private String sql;
	private DaoMapper dm = new DaoMapper();

	@Override
	public Integer getOnlineBoardCount() 
	{
		onlineparam = new MapSqlParameterSource("findren_write_05_board", "findren_write_05_board");
		sql = "select count(*) from findren_write_05_board";
		return namedParameterJdbcTemplate.queryForObject(sql, onlineparam, Integer.class);
	}

	@Override
	public List<OnlineBoard> getOnlineBoardList(int startRow, int PAGE_SIZE) 
	{
		onlineparam = new MapSqlParameterSource("startRow", startRow).addValue("PAGE_SIZE",
				PAGE_SIZE);
		sql = "select * from findren_write_05_board order by wr_datetime desc limit :startRow, :PAGE_SIZE";
		return namedParameterJdbcTemplate.query(sql, onlineparam, dm.getOnlineRMRSE());
	}

	@Override
	public void insertOnlineBoard(OnlineBoard nb) {
		onlineparam = new BeanPropertySqlParameterSource(nb);
		sql = "insert into findren_write_05_board (wr_id, wr_subject, wr_content, mb_id, wr_name, wr_link1, wr_link2, wr_link1_hit, wr_link2_hit,"
				+ "wr_hit, wr_datetime, wr_file1, wr_file2, wr_ip, wr_option) "
				+ "values(0, :wr_subject, :wr_content, :mb_id, :wr_name, :wr_link1, :wr_link2, 0, 0,"
				+ "0, :wr_datetime, :wr_file1, :wr_file2, :wr_ip, :wr_option)";
		namedParameterJdbcTemplate.update(sql, onlineparam);
	}
	
	@Override
	public void onlineWatchUpdate(int watch, int no) {
		onlineparam = new MapSqlParameterSource("watch", watch).addValue("no", no);
		sql = "update findren_write_05_board set wr_hit = :watch where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, onlineparam);
		
	}
	
	@Override
	public OnlineBoard onlineContent(int no) {
		onlineparam = new MapSqlParameterSource("no", no);
		sql = "select * from findren_write_05_board where wr_id = :no";
		return namedParameterJdbcTemplate.query(sql, onlineparam, dm.getOnlineRMRSE());
	}
	
	@Override
	public Integer onlineNextNo(int no) {
		onlineparam = new MapSqlParameterSource("no", no);
		sql = "SELECT max(wr_id) FROM findren_write_05_board WHERE wr_id < :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, onlineparam, Integer.class);
	}
	
	@Override
	public Integer onlinePreNo(int no) {
		onlineparam = new MapSqlParameterSource("no", no);
		sql = "SELECT min(wr_id) FROM findren_write_05_board WHERE wr_id > :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, onlineparam, Integer.class);
	}
	
	@Override
	public void onlineDelete(int no) {
		onlineparam = new MapSqlParameterSource("no", no);
		sql = "delete from findren_write_05_board where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, onlineparam);
	}
	
	@Override
	public void updateOnlineBoard(OnlineBoard nb) {
		onlineparam = new BeanPropertySqlParameterSource(nb);
		if(!nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_05_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
				+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(!nb.getWr_file1().isEmpty() && nb.getWr_file2().isEmpty()){
			sql = "update findren_write_05_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_05_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		}
		namedParameterJdbcTemplate.update(sql, onlineparam);
	}
	
	@Override
	public Integer maxNum() {
		onlineparam = new MapSqlParameterSource("findren_write_05_board", "findren_write_05_board");
		sql = "select max(wr_num) from findren_write_05_board";
		return namedParameterJdbcTemplate.queryForObject(sql, onlineparam, Integer.class);
	}
}
