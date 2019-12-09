package com.wz.controll;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wz.model.ContactModel;
import com.wz.model.InviteModel;
import com.wz.model.MessageModel;
import com.wz.model.NewsModel;
import com.wz.model.ShowactivityModel;

/**
 * 2019年11月15日21:00:07
 *	 前端官网控制器
 * @author xiao
 *
 */
public class JzControl extends Controller{
	/**
	 * 首页
	 */
	public void index() {
		render("index.html");
	}
	
	/**
	 * 招聘首页
	 */
	public void recruit() {
		render("page/recruit/index.htm");
	}
	/**
	 * 获取招聘数据
	 */
	public void getRecruit() {
//		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<InviteModel> user = InviteModel.getList(page,limit, "");
		setAttr("m", user.getList());
		renderJson(); 
	}
	//分页
			public void getRecruitTotal() {
//				
				setAttr("total", InviteModel.getCount());
				renderJson(); 
			}
	/**
	 * 获取首页招聘数据
	 */
	public void getRecruitListTop() {
		Page<InviteModel> user = InviteModel.getListTop(1, 4);
		setAttr("m", user.getList());
		renderJson(); 
	}
	/**
	 * 打开招聘详情页面
	 */
	public void openRecruitInfo() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("page/recruit/recruitinfo.htm");
	}
	/**
	 * 获取招聘详情
	 */
	public void getRecruitInfo() {
		String id = getPara("id");
		InviteModel recruitinfo = InviteModel.getById(id);
		setAttr("m", recruitinfo);
		renderJson();
		
	}
	
	
	
	
	
	
	/**
	 * 活动剪影首页
	 */
	public void photos() {
		render("page/photos/index.htm");
	}
	/**
	 * 获取剪影数据
	 */
	public void getPhotos() {
//		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<ShowactivityModel> user = ShowactivityModel.getList(page,limit, "");
		setAttr("m", user.getList());
		renderJson(); 
	}
	//分页
		public void getPhotosTotal() {
//			
			setAttr("total", ShowactivityModel.getCount());
			renderJson(); 
		}
	/**
	 * 打开剪影详情页面
	 */
	public void openPhotosInfo() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("page/photos/photosinfo.htm");
	}
	/**
	 * 获取剪影详情
	 */
	public void getPhotosInfo() {
		String id = getPara("id");
		ShowactivityModel photosinfo = ShowactivityModel.getById(id);
		setAttr("m", photosinfo);
		renderJson();
		
	}
	
	
	
	/**
	
	/**
	 * 新闻首页
	 */
	public void news() {
		render("page/news/index.htm");
	}
	
	/**
	 * 获取新闻数据
	 */
	public void getNews() {
//		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<NewsModel> user = NewsModel.getList(page,limit, 0);
		setAttr("m", user.getList());
		renderJson(); 
	}
	//分页
	public void getNewsTotal() {		
		setAttr("total", NewsModel.getNewsTotal());
		renderJson(); 
	}
	public void getPhotoTotal() {		
		setAttr("total", ShowactivityModel.getTotal());
		renderJson(); 
	}
	public void getInvTotal() {		
		setAttr("total", InviteModel.getTotal());
		renderJson(); 
	}
	
	/**
	 * 获取新闻数据
	 */
	public void getNewsListTop() {
		Page<NewsModel> user = NewsModel.getListTop(1, 4);
		setAttr("m", user.getList());
		renderJson(); 
	}
	/**
	 * 打开新闻详情页面
	 */
	public void openNewsInfo() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("page/news/newsinfo.html");
	}
	/**
	 * 获取新闻详情
	 */
	public void getNewsInfo() {
		String id = getPara("id");
		NewsModel newsinfo = NewsModel.getNewsId(id);
		setAttr("m", newsinfo);
		renderJson();
		
	}
	public void test() {
		render("page/news/test.html");
	}
	
	
	/**
	 * 关于我们首页
	 */
	public void contact() {
		render("page/contact/index.htm");
	}
	/**
	 * 获取关于我们数据
	 */
	public void getContact() {
//		String key = getPara("key");
//		int limit = getParaToInt("limit");
//		int page = getParaToInt("page");
		Page<ContactModel> user = ContactModel.getList(1, 1, "");
		setAttr("m", user.getList());
		renderJson(); 
	}
	
	public void addContact() {
		String title = getPara("title");
		String username = getPara("username");
		String phone = getPara("phone");
		String massage = getPara("massage");
		String email = getPara("email");
		boolean result = MessageModel.save(title, username, massage, phone, email);
		setAttr("result", result);
		renderJson();
	}

}
