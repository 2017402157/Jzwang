package com.wz.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class RoleModel extends Model<RoleModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "role";
	
	public String getId() {
		return get("id");
	}
	public void setId(String id) {
		set("id", id);
	}
	public String getRolename() {
		return get("rolename");
	}
	public void setRolename(String rolename) {
		set("rolename", rolename);
	}
	public String getPermission() {
		return get("permission");
	}
	public void setPermission(String permission) {
		set("permission", permission);
	}
	
	public static RoleModel dao = new RoleModel();
	
	public static RoleModel getById(String id) {
		String data = "select * from " + tableName + " where id = ?";
		return dao.findFirst(data, id);
	}
	
	public static Page<RoleModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where rolename like '%"+key+"%'");
		}
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean save(String rolename, String permission) {
		RoleModel m = new RoleModel();
		m.setId(StringUtil.getId());
		m.setRolename(rolename);
		m.setPermission(permission);
		return m.save();
	}
	
	public static boolean update(String id ,String rolename, String permission) {
		RoleModel m = RoleModel.getById(id);
		m.setRolename(rolename);
		m.setPermission(permission);
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
	
	public static List<RoleModel> getListAll() {
		String select_sql = "select * from " + tableName;
		return dao.find(select_sql);
	}
}
