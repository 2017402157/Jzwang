package com.wz.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class UserModel extends Model<UserModel> {
	public static final long serialVersionUID = 1L;
	public static final String tableName = "user";
	
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
	public String getPassword() {
		return get("password");
	}
	public void setPassword(String password) {
		set("password", password);
	}
	public String getRoleId() {
		return get("roleid");
	}
	public void setRoleId(String roleid) {
		set("roleid", roleid);
	}
	public String getPhone() {
		return get("phone");
	}
	public void setPhone(String phone) {
		set("phone", phone);
	}
	public String getPosititoned() {
		return get("posititoned");
	}
	public void setPosititoned(String posititoned) {
		set("posititoned", posititoned);
	}
	
	public static UserModel dao = new UserModel();
	
	public static UserModel getById(String id) {
		String data = "select * from " + tableName + " where id = ?";
		return dao.findFirst(data, id);
	}
	
	public static UserModel getByName(String username) {
		String data = "select * from " + tableName + " where username = ?";
		return dao.findFirst(data, username);
	}
	
	
	public static Page<UserModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select a.*,b.rolename as roleid,c.name as posititoned ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName).append(" a left join ");
		from_sql.append(RoleModel.tableName).append(" b on a.roleid=b.id ");
		from_sql.append("left join ").append(PostitionModel.tableName).append(" c ");
		from_sql.append("on c.id=a.posititoned ");
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where username like '%"+key+"%'");
		}
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean saveUser(String username, String password, String roleid, String phone, String posititoned) {
		UserModel m = new UserModel();
		m.setId(StringUtil.getId());
		m.setUsername(username);
		m.setPassword(password);
		m.setPhone(phone);
		m.setRoleId(roleid);
		m.setPosititoned(posititoned);
		return m.save();
	}
	
	public static boolean updatePassword(String id,String password){
		UserModel m=getById(id);
		m.setPassword(password);
		return m.update();
	}
	
	public static boolean update(String id, String username,String roleid, String phone, String posititoned) {
		UserModel model = UserModel.getById(id);
		if (model == null) {
			return false;
		}
		model.setId(id);
		model.setUsername(username);
		model.setRoleId(roleid);
		model.setPosititoned(posititoned);
		model.setPhone(phone);
		try {
			model.update();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean delUserById(String id) {
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
	
	public static List<UserModel> getListAll() {
		StringBuffer sql=new StringBuffer();
		sql.append("select *  from ").append(tableName);
		return dao.find(sql.toString());
	}
}
