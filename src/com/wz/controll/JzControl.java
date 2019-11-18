package com.wz.controll;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wz.model.NewsModel;
import com.wz.model.UserModel;

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
	 * 活动剪影首页
	 */
	public void photos() {
		render("page/photos/index.htm");
	}
	
	/**
	 * 服务项目首页
	 */
	public void service() {
		render("page/service/index.htm");
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

}
