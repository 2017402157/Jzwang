package com.wz.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.mysql.fabric.xmlrpc.base.Data;
import com.wz.util.StringUtil;

public class NewsModel extends Model<NewsModel> {
	private static final long serialVersionUID = 1L;
	/**
	 * 数据表
	 */
	public static final String tableName = "news";
	/**
	 * 建立News模型
	 * @return
	 */
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
	public String getUserid() {
		return get("userid");
	}
	public void setUserid(String userid) {
		set("userid", userid);
	}
	public Date getCreattime() {
		return get("creattime");
	}
	public void setCreattime(Date creattime) {
		set("creattime", creattime);
	}
	public Date getReleastime() {
		return get("releastime");
	}
	public void setReleastime(Date releastime) {
		set("releastime", releastime);
	}
	public int getStatus() {
		return get("status");
	}
	public void setStatus(int status) {
		set("status", status);
	}
	public String getReleasesuser() {
		return get("releasesuser");
	}
	public void setReleasesuser(String releasesuser) {
		set("releasesuser", releasesuser);
	}
	public int getPageview() {
		return get("pageview");
	}
	public void setPageview(int pageview) {
		set("pageview", pageview);
	}
	public int getLikenum() {
		return get("likenum");
	}
	public void setLikenum(int likenum) {
		set("likenum", likenum);
	}
	public String getType() {
		return get("type");
	}
	public void setType(String type) {
		set("type", type);
	}
	public int getLabel() {
		return get("label");
	}
	public void setLabel(int label) {
		set("label", label);
	}
	
	/**
	 * 后面要用，先放在这里。
	 */
	public static final NewsModel dao = new NewsModel();
	/**
	 * 按照id查找
	 * @param id
	 * @return
	 */
	public static NewsModel getNewsId(String id) {
		return dao.findFirst("select * from " + tableName + " where id = ? ", id);
	}
	/**
	 * 按照标题查询
	 * @param pageNumber
	 * @param pageSize
	 * @param key
	 * @return
	 */
	public static Page<NewsModel> getList(int pageNumber, int pageSize, String key) {
		String sele_sql = "select * ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName);
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append(" where  title like '%" + key + "%'");
		}
		return dao.paginate(pageNumber, pageSize, sele_sql, from_sql.toString());
	}
	/**
	 * 保存
	 * @param title
	 * @param author
	 * @param massage
	 * @return
	 */
	public static boolean saveNews(String title, String userid, String massage) {
		NewsModel m = new NewsModel();
		m.setId(StringUtil.getId());
		m.setTitle(title);
		m.setMassage(massage);
		m.setCreattime(new Date());
		m.setUserid(userid);
		m.setStatus(-1);
		m.setLabel(0);
		return m.save();
	}
	/**
	 * 更新数据
	 * @param id
	 * @param title
	 * @param author
	 * @param massage
	 * @param time
	 * @return
	 */
	public static boolean updateNews(String id, String title, String userid, String massage) {
		NewsModel m = NewsModel.getNewsId(id);
		m.setTitle(title);
		m.setMassage(massage);
		m.setCreattime(new Date());
		m.setUserid(userid);
		m.setStatus(0);
		m.setLabel(0);
		return m.update();
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public static boolean deleteNews(String id) {
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
	
	public static boolean checkNew(String id) {
		NewsModel m = NewsModel.getNewsId(id);
		m.setReleastime(new Date());
		m.setStatus(0);
		return m.update();
	}
}
