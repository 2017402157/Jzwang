package com.wz.model;

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class MessageModel extends Model<MessageModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "message";
	
	public String getId() {
		return get("id");
	}
	public void setId(String id) {
		set("id", id);
	}
	public String getTitle() {
		return get("Title");
	}
	public void setTitle(String title) {
		set("title", title);
	}
	public String getMassage() {
		return get("massage");
	}
	public void setMassage(String massage) {
		set("massage", massage);
	}
	public String getUsername() {
		return get("username");
	}
	public void setUsername(String username) {
		set("username", username);
	}
	public Date getTime() {
		return get("time");
	}
	public void setTime(Date time) {
		set("time", time);
	}
	public String getPhone() {
		return get("phone");
	}
	public void setPhone(String phone) {
		set("phone", phone);
	}
	public String getEmail() {
		return get("email");
	}
	public void setEmail(String email) {
		set("email", email);
	}
	
	public static MessageModel dao = new MessageModel();
	
	public static MessageModel getById(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ?", id);
	}
	
	public static Page<MessageModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where rolename like '%"+key+"%'");
		}
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean save(String title, String username, String massage, String phone, String email) {
		MessageModel m = new MessageModel();
		m.setId(StringUtil.getId());
		m.setTitle(title);
		m.setUsername(username);
		m.setMassage(massage);
		m.setTime(new Date());
		m.setPhone(phone);
		m.setEmail(email);
		return m.save();
	}
	
	public static boolean update(String id ,String title, String username, String massage, String phone, String email) {
		MessageModel m = MessageModel.getById(id);
		m.setTitle(title);
		m.setUsername(username);
		m.setMassage(massage);
		m.setTime(new Date());
		m.setPhone(phone);
		m.setEmail(email);
		return m.update();
	}
	
	public static boolean delById(String id) {
		try {
			String delsql = "DELETE FROM " + tableName + " WHERE id=?";
			int iRet = Db.update(delsql, id);
			if (iRet > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static List<MessageModel> getCount() {
		String count = "select count(*) as data from "+ tableName;
		return dao.find(count);
	}
	public static List<MessageModel> getData() {
		String count = "select * from "+ tableName +" ORDER BY time DESC limit 0, 8" ;
		return dao.find(count);
	}
}
