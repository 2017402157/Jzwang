package com.wz.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class LogsModel extends Model<LogsModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "logs";
	
	public String getId() {
		return get("id");
	}
	public void setId(String id) {
		set("id", id);
	}
	public String getUsername() {
		return get("username");
	}
	public void setUsername(String username) {
		set("username", username);
	}
	public Date getLogintime() {
		return get("logintime");
	}
	public void setLogintime(Date logintime) {
		set("logintime", logintime);
	}
	public int  getStatus() {
		return get("status");
	}
	public void setStatus(int status) {
		set("status", status);
	}
	
	public static LogsModel dao = new LogsModel();
	
	public static LogsModel getById(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ? ", id);
	}
	
	public static Page<LogsModel> getList(int pageNumber, int pageSize, String key) {
		String sele_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName).append(" ORDER BY logintime DESC");
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append(" where  title like '%" + key + "%'");
		}
		return dao.paginate(pageNumber, pageSize, sele_sql, from_sql.toString());
	}
	
	public static boolean save(String username, int status) {
		LogsModel m =  new LogsModel();
		m.setId(StringUtil.getId());
		m.setUsername(username);
		m.setStatus(status);
		m.setLogintime(new Date());
		return m.save();
	}
	
}
