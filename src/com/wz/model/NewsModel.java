package com.wz.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
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
	public String getOutline() {
		return get("outline");
	}
	public void setOutline(String outline) {
		set("outline", outline);
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
		String sele_sql = "select a.*,b.username as userid,c.name as type";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName).append(" a left join ");
		from_sql.append(UserModel.tableName).append(" b on a.userid=b.id ");
		from_sql.append("left join ").append(TypeModel.tableName).append(" c on c.id=a.type");
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append(" where  a.title like '%" + key + "%'");
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
	public static boolean saveNews(String title, String userid, String massage, String type, String outline) {
		NewsModel m = new NewsModel();
		m.setId(StringUtil.getId());
		m.setTitle(title);
		m.setMassage(massage);
		m.setCreattime(new Date());
		m.setUserid(userid);
		m.setStatus(-1);
		m.setType(type);
		m.setLabel(0);
		m.setOutline(outline);
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
	public static boolean updateNews(String id, String title, String userid, String massage, String type, String outline) {
		NewsModel m = NewsModel.getNewsId(id);
		m.setTitle(title);
		m.setMassage(massage);
		m.setCreattime(new Date());
		m.setUserid(userid);
		m.setStatus(0);
		m.setType(type);
		m.setLabel(0);
		m.setOutline(outline);
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
		if(m.getStatus()== -1) {
			m.setStatus(0);
		}
		else {
			m.setStatus(-1);
		}
		return m.update();
	}
}
