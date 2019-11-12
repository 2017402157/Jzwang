package com.wz.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class ContactModel extends Model<ContactModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "contact";
	
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
	public String getPhone() {
		return get("phone");
	}
	public void setPhone(String phone) {
		set("phone", phone);
	}
	public String getAddr() {
		return get("addr");
	}
	public void setAddr(String addr) {
		set("addr", addr);
	}
	public String getInteterAddr() {
		return get("inteteraddr");
	}
	public void setInteterAddr(String inteteraddr) {
		set("inteteraddr", inteteraddr);
	}
	public String getPostcode() {
		return get("postcode");
	}
	public void setPostcode(String postcode) {
		set("postcode", postcode);
	}
	public String getEmail() {
		return get("email");
	}
	public void setEmail(String email) {
		set("email", email);
	}
	
	public static ContactModel dao = new ContactModel();
	
	public static ContactModel getById(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ?", id);
	}
	
	public static Page<ContactModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where rolename like '%"+key+"%'");
		}
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean save(String name, String phone, String addr, String inteteraddr, String postcode, String email) {
		ContactModel m = new ContactModel();
		m.setId(StringUtil.getId());
		m.setName(name);
		m.setPhone(phone);
		m.setAddr(addr);
		m.setInteterAddr(inteteraddr);
		m.setPostcode(postcode);
		m.setEmail(email);
		return m.save();
	}
	
	public static boolean update(String id ,String name, String phone, String addr, String inteteraddr, String postcode, String email) {
		ContactModel m = ContactModel.getById(id);
		m.setName(name);
		m.setPhone(phone);
		m.setAddr(addr);
		m.setInteterAddr(inteteraddr);
		m.setPostcode(postcode);
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
