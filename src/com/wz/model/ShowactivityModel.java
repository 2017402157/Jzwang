package com.wz.model;

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class ShowactivityModel extends Model<ShowactivityModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "showactivity";
	
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
	public String getPhotor() {
		return get("photor");
	}
	public void setPhotor(String photor) {
		set("photor", photor);
	}
	public Date getTime() {
		return get("time");
	}
	public void setTime(Date time) {
		set("time", time);
	}
	public String getMassage() {
		return get("massage");
	}
	public void setMassage(String massage) {
		set("massage", massage);
	}
	
	public static ShowactivityModel dao = new ShowactivityModel();
	
	public static ShowactivityModel getById(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ? ", id);
	}
	
	public static Page<ShowactivityModel> getList(int pageNumber, int pageSize, String key) {
		String sele_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append(" where  title like '%" + key + "%'");
		}
		return dao.paginate(pageNumber, pageSize, sele_sql, from_sql.toString());
	}
	
	public static boolean save(String title, String massage, String photor) {
		ShowactivityModel m = new ShowactivityModel();
		m.setId(StringUtil.getId());
		m.setTitle(title);
		m.setMassage(massage);
		m.setTime(new Date());
		m.setPhotor(photor);
		return m.save();
	}
	
	public static boolean update(String id, String title, String massage, String photor) {
		ShowactivityModel m = ShowactivityModel.getById(id);
		m.setTitle(title);
		m.setMassage(massage);
		m.setTime(new Date());
		m.setPhotor(photor);
		return m.update();
	}
	
	public static boolean delete(String id) {
		try {
			String del = "DELETE FROM "+ tableName +" WHERE id=?";
			int data = Db.delete(del, id);
			if(data > 0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static List<ShowactivityModel> getCount() {
		String count = "select count(*) as data from "+ tableName;
		return dao.find(count);
	}
	public static Object getTotal() {
		List<ShowactivityModel> list=dao.find("select count(*) as total from " + tableName);
		return list;
	}
}
