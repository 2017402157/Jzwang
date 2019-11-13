package com.wz.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class CompanyModel extends Model<CompanyModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "company";
	
	public String getId() {
		return get("id");
	}
	public void setId(String id) {
		set("id", id);
	}
	public String getName() {
		return get("name");
	}
	public void setName(String name) {
		set("name", name);
	}
	public String getBrief() {
		return get("brief");
	}
	public void setBrief(String brief) {
		set("brief", brief);
	}
	public String getPhone() {
		return get("phone");
	}
	public void setPhone(String phone) {
		set("phone", phone);
	}
	public String getEmail() {
		return get("phone");
	}
	public void setEmail(String email) {
		set("email", email);
	}
	
	public static CompanyModel dao = new CompanyModel();
	
	public static CompanyModel getById(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ?", id);
	}
	
	public static Page<CompanyModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where rolename like '%"+key+"%'");
		}
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean save(String name, String brief, String phone, String email) {
		CompanyModel m = new CompanyModel();
		m.setId(StringUtil.getId());
		m.setName(name);
		m.setBrief(brief);
		m.setPhone(phone);
		m.setEmail(email);
		return m.save();
	}
	
	public static boolean update(String id, String name, String brief, String phone, String email) {
		CompanyModel m = CompanyModel.getById(id);
		m.setName(name);
		m.setBrief(brief);
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
}
