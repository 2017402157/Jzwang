package com.wz.controll;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alibaba.druid.support.json.JSONParser;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wz.Interceptor.AdminInterceptor;
import com.wz.bean.TDvoBean;
import com.wz.model.CandidateModel;
import com.wz.model.CompanyModel;
import com.wz.model.ContactModel;
import com.wz.model.InviteModel;
import com.wz.model.LogsModel;
import com.wz.model.MessageModel;
import com.wz.model.NewsModel;
import com.wz.model.PostitionModel;
import com.wz.model.RoleModel;
import com.wz.model.ShowactivityModel;
import com.wz.model.TypeModel;
import com.wz.model.UserModel;

@Before(AdminInterceptor.class)
public class AdminControll extends Controller {
	public void find() {
		render("404.html");
	}
	
	public void index() {
		setAttr("user", getSessionAttr("user"));
		renderFreeMarker("index.html");
	}
	
	public void main() {
		render("main.html");
	}
	
	@Clear(AdminInterceptor.class)
	public void Login() {
		String username = getPara("username");
		String password = getPara("password");
		UserModel m = UserModel.getByName(username);
		int status = 1;
		String name  = "";
//		String check = m.getRoleId();
//		RoleModel check1 = RoleModel.getById(check);
		if(m != null) {
			if(m.getPassword().equals(password)) {
				setAttr("result", 0);//可以登录
				setCookie("checkname", m.getUsername(), 36000);
				setSessionAttr("user", m);
				status = 0;
				name = m.getUsername();
			} 
			else {
				setAttr("result", 1);//密码错误
			}
		}
		else {
			setAttr("result", 2);//用户名不存在
		}
		LogsModel.save(username, status);
		renderJson();
	}
	
	@Before(AdminInterceptor.class)
	public void outLogin() {
		removeCookie("username");
		removeSessionAttr("user");
		redirect("/admin");
	}
	
	
	/**
	 * 用户表
	 */
	public void openUser() {
		render("user/userinfo.html");
	}
	
	public void openAddUser() {
		render("user/userAdd.html");
	}
	
	public void openEditUser() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("user/userEdit.html");
	}
	
	public void openUpdateUserPassword() {
		String id = getPara("id");
		UserModel m = UserModel.getById(id);
		setAttr("user", m);
		renderFreeMarker("user/uppassword.html");
	}
	
	public void queryUser() {
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<UserModel> user = UserModel.getList(page, limit, key);
		setAttr("infos", user);
		setAttr("code", 0);
		setAttr("msg", "你好！");
		setAttr("count", user.getTotalRow());
		setAttr("data", user.getList());
		renderJson();
	}
	
	public void getUser() {
		String id = getPara("id");
		UserModel m = UserModel.getById(id);
		setAttr("m", m);
		renderJson();
	}
	
	public void getUsers() {
		List<UserModel> m = UserModel.getListAll();
		setAttr("m", m);
		renderJson();
	}
	
	public void saveUserInfo() {
		String username = getPara("username");
		String password = getPara("password");
		String roleid = getPara("roleid");
		String phone = getPara("phone");
		String posititoned = getPara("posititoned");
		boolean result = UserModel.saveUser(username, password, roleid, phone, posititoned);
		setAttr("result", result);
		renderJson();
	}
	
	public void updateUser() {
		String id = getPara("id");
		String username = getPara("username");
		String roleid = getPara("roleid");
		String phone = getPara("phone");
		String posititoned = getPara("posititoned");
		boolean result = UserModel.update(id, username, roleid, phone, posititoned);
		setAttr("result", result);
		renderJson();
	}
	
	public void deleUser() {
		String id = getPara("id");
		boolean result = UserModel.delUserById(id);
		setAttr("result", result);
		renderJson();
	}
	
	public void updateUserPassword() {
		String id = getPara("id");
		String password = getPara("password");
		boolean result = UserModel.updatePassword(id, password);
		setAttr("result", result);
		renderJson();
	}
	
	public void getUsercount() {
		List<UserModel> m = UserModel.getCount();
		setAttr("m", m);
		renderJson();
	}
	
	/**
	 * 新闻表
	 */
	public void openNews() {
		render("news/newsinfo.html");
	}
	public void openAddNews() {
		render("news/newsAdd.html");
	}
	public void openEditNews() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("news/newsEdit.html");
	}
	public void queryNews() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<NewsModel> list = NewsModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	
	public void getNews() {
		String id = getPara("id");
		NewsModel result = NewsModel.getNewsId(id);
		setAttr("result", result);
		renderJson();
	}
	
	public void saveNews() {
		String title = getPara("title");
		String userid = getPara("userid");
		String massage = getPara("massage");
		String type = getPara("type");
		String outline = getPara("outline");
		boolean result = NewsModel.saveNews(title, userid, massage, type, outline);
		setAttr("result", result);
		renderJson();
	}
	
	public void updateNews() {
		String id = getPara("id");
		String title = getPara("title");
		String userid = getPara("userid");
		String massage = getPara("massage");
		String type = getPara("type");
		String outline = getPara("outline");
		boolean result = NewsModel.updateNews(id, title, userid, massage, type, outline);
		setAttr("result", result);
		renderJson();		
	}
	
	public void deleNews() {
		String id = getPara("id");
		boolean result = NewsModel.deleteNews(id);
		setAttr("result", result);
		renderJson();
	}
	
	public void checkNews() {
		String id = getPara("id");
		boolean result = NewsModel.checkNew(id);
		setAttr("result", result);
		renderJson();
	}
	
	//获取新闻数量
		public void getNewscount() {
			List<NewsModel> m = NewsModel.getCount();
			setAttr("m", m);
			renderJson();
		}
	
	/**
	 * 角色表
	 */
	public void openRole() {
		render("role/roleinfo.html");
	}
	public void openAddRole() {
		render("role/roleAdd.html");
	}
	public void openEditRole() {
		String id = getPara("id");
		RoleModel m = RoleModel.getById(id);
		setAttr("id", id);
		renderFreeMarker("role/roleEdit.html");
	}
	public void queryRole() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<RoleModel> list = RoleModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	} 
	public void getRole() {
		String id = getPara("id");
		RoleModel result = RoleModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	
	public void getRoles() {
		List<RoleModel> m = RoleModel.getListAll();
		setAttr("m", m);
		renderJson();
	}
	public void saveRole() {
		String rolename = getPara("rolename");
		String permission = getPara("permission");
		boolean result = RoleModel.save(rolename, permission);
		setAttr("result", result);
		renderJson();
	}
	public void updateRole() {
		String id = getPara("id");
		String rolename = getPara("rolename");
		String permission = getPara("permission");
		boolean result = RoleModel.update(id, rolename, permission);
		setAttr("result", result);
		renderJson();
	}
	public void deleRole() {
		String id = getPara("id");
		boolean result = RoleModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	/**
	 * 勤工俭学剪影表
	 */
	public void openShow() {
		render("show/showinfo.html");
	}
	public void openAddShow() {
		render("show/showAdd.html");
	}
	public void openEditShow() {
		String id = getPara("id");
		ShowactivityModel m = ShowactivityModel.getById(id);
		setAttr("id", id);
		renderFreeMarker("show/showEdit.html");
	}
	public void queryShow() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<ShowactivityModel> list = ShowactivityModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	} 
	public void getShow() {
		String id = getPara("id");
		ShowactivityModel result = ShowactivityModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void saveShow() {
		String title = getPara("title");
		String massage = getPara("massage");
		String photor = getPara("photor");
		boolean result = ShowactivityModel.save(title, massage, photor);
		setAttr("result", result);
		renderJson();
	}
	public void updateShow() {
		String id = getPara("id");
		String title = getPara("title");
		String massage = getPara("massage");
		String photor = getPara("photor");
		boolean result = ShowactivityModel.update(id, title, massage, photor);
		setAttr("result", result);
		renderJson();
	}
	public void deleShow() {
		String id = getPara("id");
		boolean result = ShowactivityModel.delete(id);
		setAttr("result", result);
		renderJson();
	}
	
	public void getShowcount() {
		List<ShowactivityModel> m = ShowactivityModel.getCount();
		setAttr("m", m);
		renderJson();
	}
	
	/**
	 * 留言表
	 */
	public void openMessage() {
		render("mes/messageinfo.html");
	}
	public void openAddMessage() {
		render("mes/messageAdd.html");
	}
	public void openEditMessage() {
		String id = getPara("id");
		MessageModel m = MessageModel.getById(id);
		setAttr("id", id);
		renderFreeMarker("mes/messageEdit.html");
	}
	public void queryMessage() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<MessageModel> list = MessageModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	public void getMessage() {
		String id = getPara("id");
		MessageModel result = MessageModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void saveMessage() {
		String title = getPara("title");
		String massage = getPara("massage");
		String username = getPara("username");
		String phone = getPara("phone");
		String email = getPara("email");
		boolean result = MessageModel.save(title, username, massage, phone, email);
		setAttr("result", result);
		renderJson();
	}
	public void updateMessage() {
		String id = getPara("id");
		String title = getPara("title");
		String massage = getPara("massage");
		String username = getPara("username");
		String phone = getPara("phone");
		String email = getPara("email");
		boolean result = MessageModel.update(id, title, username, massage, phone, email);
		setAttr("result", result);
		renderJson();
	}
	public void deleMessage() {
		String id = getPara("id");
		boolean result = MessageModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	public void getMessagecount() {
		List<MessageModel> m = MessageModel.getCount();
		setAttr("m", m);
		renderJson();
	}
	public void getMessagedata() {
		List<MessageModel> m = MessageModel.getData();
		setAttr("m", m);
		renderJson();
	}
	
	/**
	 * 联系我们表
	 */
	public void openContact() {
		render("cont/contactinfo.html");
	}
	public void openAddContact() {
		render("cont/contactAdd.html");
	}
	public void openEditContact() {
		String id = getPara("id");
		ContactModel m = ContactModel.getById(id);
		setAttr("id", id);
		renderFreeMarker("cont/contactEdit.html");
	}
	public void queryContact() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<ContactModel> list = ContactModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	public void getContact() {
		String id = getPara("id");
		ContactModel result = ContactModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void saveContact() {
		String name = getPara("name");
		String addr = getPara("addr");
		String inteteraddr = getPara("inteteraddr");
		String phone = getPara("phone");
		String postcode = getPara("postcode");
		String email = getPara("email");
		boolean result = ContactModel.save(name, phone, addr, inteteraddr, postcode, email);
		setAttr("result", result);
		renderJson();
	}
	public void updateContact() {
		String id = getPara("id");
		String name = getPara("name");
		String addr = getPara("addr");
		String inteteraddr = getPara("inteteraddr");
		String phone = getPara("phone");
		String postcode = getPara("postcode");
		String email = getPara("email");
		boolean result = ContactModel.update(id, name, phone, addr, inteteraddr, postcode, email);
		setAttr("result", result);
		renderJson();
	}
	public void deleContact() {
		String id = getPara("id");
		boolean result = ContactModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	/**
	 * 新闻类型
	 */
	public void openType() {
		render("typ/typeinfo.html");
	}
	public void openAddType() {
		render("typ/typeAdd.html");
	}
	public void openEditType() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("typ/typeEdit.html");
	}
	public void queryType() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<TypeModel> list = TypeModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	public void getType() {
		String id = getPara("id");
		TypeModel result = TypeModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void getTypes() {
		List<TypeModel> m = TypeModel.getListAll();
		setAttr("m", m);
		renderJson();
	}
	public void saveType() {
		String name = getPara("name");
		boolean result = TypeModel.save(name);
		setAttr("result", result);
		renderJson();
	}
	public void updateType() {
		String id = getPara("id");
		String name = getPara("name");
		boolean result = TypeModel.update(id, name);
		setAttr("result", result);
		renderJson();
	}
	public void deleType() {
		String id = getPara("id");
		boolean result = TypeModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	/**
	 * 职位表
	 */
	public void openPostition() {
		render("pos/postitioninfo.html");
	}
	public void openAddPostition() {
		render("pos/postitionAdd.html");
	}
	public void openEditPostition() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("pos/postitionEdit.html");
	}
	public void queryPostition() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<PostitionModel> list = PostitionModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	public void getPostition() {
		String id = getPara("id");
		PostitionModel result = PostitionModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void getPostitions() {
		List<PostitionModel> m = PostitionModel.getListAll();
		setAttr("m", m);
		renderJson();
	}
	public void savePostition() {
		String name = getPara("name");
		boolean result = PostitionModel.save(name);
		setAttr("result", result);
		renderJson();
	}
	public void updatePostition() {
		String id = getPara("id");
		String name = getPara("name");
		boolean result = PostitionModel.update(id, name);
		setAttr("result", result);
		renderJson();
	}
	public void delePostition() {
		String id = getPara("id");
		boolean result = PostitionModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	/**
	 * 招聘表
	 */
	public void openInvite() {
		render("inv/inviteinfo.html");
	}
	public void openAddInvite() {
		render("inv/inviteAdd.html");
	}
	public void openEditInvite() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("inv/inviteEdit.html");
	}
	public void queryInvite() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<InviteModel> list = InviteModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	public void getInvite() {
		String id = getPara("id");
		InviteModel result = InviteModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void saveInvite() {
		String name = getPara("name");
		String workpro = getPara("workpro");
		String addr = getPara("addr");
		int number = getParaToInt("number");
		String workexp = getPara("workexp");
		String education = getPara("education");
		String worktime = getPara("worktime");
		String reward = getPara("reward");
		String company = getPara("company");
		String type = getPara("type");
//		int label = getParaToInt("label");
		boolean result = InviteModel.save(name, workpro, addr, number, workexp, education, worktime, reward, company, type);
		setAttr("result", result);
		renderJson();
	}
	public void updateInvite() {
		String id = getPara("id");
		String name = getPara("name");
		String workpro = getPara("workpro");
		String addr = getPara("addr");
		int number = getParaToInt("number");
		String workexp = getPara("workexp");
		String education = getPara("education");
		String worktime = getPara("worktime");
		String reward = getPara("reward");
		String company = getPara("company");
		String type = getPara("type");
//		int label = getParaToInt("label");
		boolean result = InviteModel.update(id, name, workpro, addr, number, workexp, education, worktime, reward, company, type);
		setAttr("result", result);
		renderJson();
	}
	public void deleInvite() {
		String id = getPara("id");
		boolean result = InviteModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	/**
	 * 公司表
	 */
	public void openCompany() {
		render("com/companyinfo.html");
	}
	public void openAddCompany() {
		render("com/companyAdd.html");
	}
	public void openEditCompany() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("com/companyEdit.html");
	}
	public void queryCompany() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<CompanyModel> list = CompanyModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	public void getCompany() {
		String id = getPara("id");
		CompanyModel result = CompanyModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void getCompanys() {
		List<CompanyModel> m = CompanyModel.getListAll();
		setAttr("m", m);
		renderJson();
	}
	public void saveCompany() {
		String name = getPara("name");
		String brief = getPara("brief");
		String phone = getPara("phone");
		String email = getPara("email");
		boolean result = CompanyModel.save(name, brief, phone, email);
		setAttr("result", result);
		renderJson();
	}
	public void updateCompany() {
		String id = getPara("id");
		String name = getPara("name");
		String brief = getPara("brief");
		String phone = getPara("phone");
		String email = getPara("email");
		boolean result = CompanyModel.update(id, name, brief, phone, email);
		setAttr("result", result);
		renderJson();
	}
	public void deleCompany() {
		String id = getPara("id");
		boolean result = CompanyModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	/**
	 * 应聘表
	 */
	public void openCondidate() {
		render("cond/condidateinfo.html");
	}
	public void openAddCondidate() {
		render("cond/condidateAdd.html");
	}
	public void openEditCondidate() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("cond/condidateEdit.html");
	}
	public void queryCondidate() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<CandidateModel> list = CandidateModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	public void getCondidate() {
		String id = getPara("id");
		CandidateModel result = CandidateModel.getById(id);
		setAttr("result", result);
		renderJson();
	}
	public void saveCondidate() {
		String name = getPara("name");
		int sex = getParaToInt("sex");
		String phone = getPara("phone");
		String addr = getPara("addr");
		int age = getParaToInt("age");
		String qq = getPara("qq");
		String weixin = getPara("weixin");
		String type = getPara("type");
		boolean result = CandidateModel.save(name, sex, phone, addr, age, qq, weixin, type);
		setAttr("result", result);
		renderJson();
	}
	public void updateCondidate() {
		String id = getPara("id");
		String name = getPara("name");
		int sex = getParaToInt("sex");
		String phone = getPara("phone");
		String addr = getPara("addr");
		int age = getParaToInt("age");
		String qq = getPara("qq");
		String weixin = getPara("weixin");
		String type = getPara("type");
		boolean result = CandidateModel.update(id, name, sex, phone, addr, age, qq, weixin, type);
		setAttr("result", result);
		renderJson();
	}
	public void deleCondidate() {
		String id = getPara("id");
		boolean result = CandidateModel.delById(id);
		setAttr("result", result);
		renderJson();
	}
	
	/**
	 * 日志表
	 */
	public void openLogs() {
		render("log/logsinfo.html");
	}
	public void queryLogs() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<LogsModel> list = LogsModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}
	
	/**
	 * 折线图
	 */
	public void getTubiaoinfo() {
		List<TDvoBean> td = new ArrayList<TDvoBean>();
		for(int i = 1; i<=12; i++) {
			int num=0;
			List<InviteModel> list = InviteModel.getListByYeanMonth(i);
			for(InviteModel m:list) {
				num++;
			}
			TDvoBean a = new TDvoBean();
			a.setName("发布");
			a.setValue(num);
			td.add(a);
		}
		setAttr("td", td);
		renderJson();
	}
	
	/**
	 * 饼图
	 */
	public void getBinTuinfo() {
		List<TDvoBean> tb = new ArrayList<TDvoBean>();
		List<TypeModel> names = TypeModel.getListName();
		for(TypeModel m:names) {
			TDvoBean a = new TDvoBean();
			a.setName(m.toString());
			String id = m.getId();
			List<NewsModel> list = NewsModel.getListName(id);
			int num=0;
			for(NewsModel n: list) {
				num++;
			}
			a.setValue(num);
			tb.add(a);
		}
		setAttr("tb", tb);
		renderJson();
	}
}
