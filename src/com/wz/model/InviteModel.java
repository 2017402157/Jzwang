package com.wz.model;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.wz.util.StringUtil;

public class InviteModel extends Model<InviteModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "invite";
	
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
	public String getWorkpro() {
		return get("workpro");
	}
	public void setWorkpro(String workpro) {
		set("workpro", workpro);
	}
	public String getAddr() {
		return get("addr");
	}
	public void setAddr(String addr) {
		set("addr", addr);
	}
	public int getNumber() {
		return get("number");
	}
	public void setNumber(int number) {
		set("number", number);
	}
	public String getWorkexp() {
		return get("workexp");
	}
	public void setWorkexp(String workexp) {
		set("workexp", workexp);
	}
	public String getEducation() {
		return get("education");
	}
	public void setEducation(String education) {
		set("education", education);
	}
	public String getWorktime() {
		return get("worktime");
	}
	public void setWorktime(String worktime) {
		set("worktime", worktime);
	}
	public String getReward() {
		return get("reward");
	}
	public void setReward(String reward) {
		set("reward", reward);
	}
	public Date getReleasetime() {
		return get("releasetime");
	}
	public void setReleasetime(Date releasetime) {
		set("releasetime", releasetime);
	}
	public int getPageview() {
		return get("pageview");
	}
	public void setPageview(int pageview) {
		set("pageview", pageview);
	}
	public String getCompany() {
		return get("company");
	}
	public void setCompany(String company) {
		set("company", company);
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
	public String getSettle() {
		return get("settle");
	}
	public void setSettle(String settle) {
		set("settle", settle);
	}
	public int getStatus() {
		return get("status");
	}
	public void setStatus(int status) {
		set("status", status);
	}
	public Date getCreattime() {
		return get("creattime");
	}
	public void setCreattime(Date creattime) {
		set("creattime", creattime);
	}
	
	public static InviteModel dao = new InviteModel();
	
	public static InviteModel getById(String id) {
		String select_sql = "select * from " + tableName + "  where id = ?";
		return dao.findFirst(select_sql, id);
	}
	
	public static InviteModel getByIds(String id) {
		String select_sql = "select a.id id,a.name name,a.workpro workpro,a.addr addr,a.number number,a.workexp workexp,a.education education,a.worktime worktime,a.reward reward,a.releasetime releasetime,b.name company,a.type type,a.settle settle,a.creattime creattime,b.brief brief,b.linkman linkman,b.position position,b.phone phone,b.datum datum,b.email email,b.qq qq,b.weixin weixin from " + tableName + " a left join " + CompanyModel.tableName+ " b on a.company=b.id" + "  where a.id = ?";
		return dao.findFirst(select_sql, id);
	}
	//��ҳ
	public static List<InviteModel> getCount() {
		String count = "select count(*) as data from "+ tableName;
		return dao.find(count);
	}
	
	public static Page<InviteModel> getList(int pageNumber , int pageSize, String key) {
		String select_sql = "select a.*,b.name as type,c.name as company ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName).append(" a left join ");
		from_sql.append(TypeModel.tableName).append(" b on a.type=b.id left join ");
		from_sql.append(CompanyModel.tableName).append(" c on c.id=a.company ");
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append("where rolename like '%"+key+"%'");
		}
		from_sql.append(" ORDER BY releasetime DESC");
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static Page<InviteModel> getListes(int pageNumber , int pageSize, String key) {
		String select_sql = "select a.*,b.name as type,c.name as company ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName).append(" a left join ");
		from_sql.append(TypeModel.tableName).append(" b on a.type=b.id left join ");
		from_sql.append(CompanyModel.tableName).append(" c on c.id=a.company ");
		from_sql.append(" where a.status=0");
		if(!StringUtil.isBlankOrEmpty(key)) {
			from_sql.append(" and rolename like '%"+key+"%'");
		}
		from_sql.append(" ORDER BY releasetime DESC");
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	public static Page<InviteModel> getListTop(int pageNumber , int pageSize) {
		String select_sql = "select a.*,b.name as type,c.name as company ";
		StringBuffer from_sql = new StringBuffer();
		from_sql.append("from ").append(tableName).append(" a left join ");
		from_sql.append(TypeModel.tableName).append(" b on a.type=b.id left join ");
		from_sql.append(CompanyModel.tableName).append(" c on c.id=a.company ").append("where  a.status=0");
		from_sql.append(" ORDER BY a.releasetime desc ");
		return dao.paginate(pageNumber, pageSize, select_sql, from_sql.toString());
	}
	
	public static boolean save(String name, String workpro, String addr, int number, String workexp, String education,
							String worktime, String reward, String company, String type, String settle) {
		InviteModel m = new InviteModel();
		m.setId(StringUtil.getId());
		m.setName(name);
		m.setWorkpro(workpro);
		m.setAddr(addr);
		m.setNumber(number);
		m.setWorkexp(workexp);
		m.setEducation(education);
		m.setWorktime(worktime);
		m.setReward(reward);
		m.setCreattime(new Date());
		m.setCompany(company);
		m.setType(type);
		m.setSettle(settle);
		m.setStatus(1);
		return m.save();
	}
	
	public static boolean update(String id ,String name, String workpro, String addr, int number, String workexp, String education,
						String worktime, String reward, String company, String type, String settle) {
		InviteModel m = InviteModel.getById(id);
		m.setName(name);
		m.setWorkpro(workpro);
		m.setAddr(addr);
		m.setNumber(number);
		m.setWorkexp(workexp);
		m.setEducation(education);
		m.setWorktime(worktime);
		m.setReward(reward);
		m.setCompany(company);
		m.setType(type);
		m.setSettle(settle);
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
	public static List<InviteModel> getListByYeanMonth(int month) {
		StringBuffer sql = new StringBuffer();
		Calendar now = Calendar.getInstance();
		int yean = now.get(Calendar.YEAR);
		StringBuffer m = new StringBuffer();
		m.append(yean).append("-");
		if(month<10) {
			m.append("0").append(month);
		}
		else {
			m.append(month);
		}
		sql.append("select *  from ").append(tableName);
		sql.append(" where releasetime like '%" + m + "%'");
		return dao.find(sql.toString());
	}
	public static Object getTotal() {
		List<InviteModel> list=dao.find("select count(*) as total from " + tableName);
		return list;
	}
	public static boolean saves(String name, String workpro, String addr, int number, String workexp, String education,
			String worktime, String reward, String company, String type, String settle) {
		InviteModel m = new InviteModel();
		m.setId(StringUtil.getId());
		m.setName(name);
		m.setWorkpro(workpro);
		m.setAddr(addr);
		m.setNumber(number);
		m.setWorkexp(workexp);
		m.setEducation(education);
		m.setWorktime(worktime);
		m.setReward(reward);
		m.setCompany(company);
		m.setType(type);
		m.setSettle(settle);
		m.setStatus(1);
		m.setCreattime(new Date());
		return m.save();
	}
	
	public static boolean check(String id) {
		InviteModel m = InviteModel.getById(id);
		m.setReleasetime(new Date());
		m.setStatus(0);
		return m.update();
	}
	
	
}
