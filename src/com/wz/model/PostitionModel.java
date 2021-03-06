package com.wz.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.wz.util.StringUtil;

public class PostitionModel extends Model<PostitionModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "position";
	
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
	
	public static PostitionModel dao = new PostitionModel();
	
	public static PostitionModel getById(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ?", id);
	}
	
	public static Page<PostitionModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where rolename like '%"+key+"%'");
		}
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean save(String name) {
		PostitionModel m = new PostitionModel();
		m.setId(StringUtil.getId());
		m.setName(name);
		return m.save();
	}
	
	public static boolean update(String id ,String name) {
		PostitionModel m = PostitionModel.getById(id);
		m.setName(name);
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
	
	public static List<PostitionModel> getListAll() {
		String select_sql = "select * from " + tableName;
		return dao.find(select_sql);
	}
}
