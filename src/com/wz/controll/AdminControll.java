package com.wz.controll;

import java.util.Date;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wz.Interceptor.AdminInterceptor;
import com.wz.model.LogsModel;
import com.wz.model.NewsModel;
import com.wz.model.RoleModel;
import com.wz.model.ShowactivityModel;
import com.wz.model.UserModel;

@Before(AdminInterceptor.class)
public class AdminControll extends Controller {
	
	
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
		render("user/userEdit.html");
	}
	
	public void openUpdateUserPassword() {
		render("user/uppassword.html");
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
		String phone = getPara("phone");
		String posititoned = getPara("positioned");
		boolean result = UserModel.update(id, username, phone, posititoned);
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
		render("news/newsEdit.html");
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
		boolean result = NewsModel.saveNews(title, userid, massage);
		setAttr("result", result);
		renderJson();
	}
	
	public void updateNews() {
		String id = getPara("id");
		String title = getPara("title");
		String userid = getPara("userid");
		String massage = getPara("massage");
		boolean result = NewsModel.updateNews(id, title, userid, massage);
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
		render("role/roleEdit.html");
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
		render("show/showEdit.html");
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
}
