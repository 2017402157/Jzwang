package com.wz.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class CandidateModel extends Model<CandidateModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "candidate";
	
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
	public int getSex() {
		return get("sex");
	}
	public void setSex(int sex) {
		set("sex", sex);
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
	public String getWeixin() {
		return get("weixin");
	}
	public void setWeixin(String weixin) {
		set("weixin", weixin);
	}
	public String getQQ() {
		return get("qq");
	}
	public void setQQ(String qq) {
		set("qq", qq);
	}
	public String getType() {
		return get("type");
	}
	public void setType(String type) {
		set("type", type);
	}
	public int getAge() {
		return get("age");
	}
	public void setAge(int age) {
		set("age", age);
	}
	
	public static CandidateModel dao = new CandidateModel();
	
	public static CandidateModel getById(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ?", id);
	}
	
	public static Page<CandidateModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where rolename like '%"+key+"%'");
		}
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean save(String name, int sex, String phone, String addr, int age, String qq, String weixin, String type) {
		CandidateModel m = new CandidateModel();
		m.setId(StringUtil.getId());
		m.setName(name);
		m.setSex(sex);
		m.setPhone(phone);
		m.setAddr(addr);
		m.setAge(age);
		m.setQQ(qq);
		m.setWeixin(weixin);
		m.setType(type);
		return m.save();
	}
	
	public static boolean update(String id, String name, int sex, String phone, String addr, int age, String qq, String weixin, String type) {
		CandidateModel m = CandidateModel.getById(id);
		m.setName(name);
		m.setSex(sex);
		m.setPhone(phone);
		m.setAddr(addr);
		m.setAge(age);
		m.setQQ(qq);
		m.setWeixin(weixin);
		m.setType(type);
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
