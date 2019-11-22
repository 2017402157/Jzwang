package com.wz.controll;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wz.model.ContactModel;
import com.wz.model.InviteModel;
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
//		int limit = getParaToInt("limit");
//		int page = getParaToInt("page");
		Page<InviteModel> user = InviteModel.getList(1, 10, "");
		setAttr("m", user.getList());
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
//		int limit = getParaToInt("limit");
//		int page = getParaToInt("page");
		Page<ShowactivityModel> user = ShowactivityModel.getList(1, 10, "");
		setAttr("m", user.getList());
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
//		int limit = getParaToInt("limit");
//		int page = getParaToInt("page");
		Page<NewsModel> user = NewsModel.getList(1, 10, "");
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
		Page<ContactModel> user = ContactModel.getList(1, 10, "");
		setAttr("m", user.getList());
		renderJson(); 
	}

}
