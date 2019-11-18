package com.wz.controll;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wz.model.NewsModel;
import com.wz.model.UserModel;

/**
 * 2019��11��15��21:00:07
 *	 ǰ�˹���������
 * @author xiao
 *
 */
public class JzControl extends Controller{
	/**
	 * ��ҳ
	 */
	public void index() {
		render("index.html");
	}
	
	/**
	 * ��Ƹ��ҳ
	 */
	public void recruit() {
		render("page/recruit/index.htm");
	}
	
	/**
	 * ���Ӱ��ҳ
	 */
	public void photos() {
		render("page/photos/index.htm");
	}
	
	/**
	 * ������Ŀ��ҳ
	 */
	public void service() {
		render("page/service/index.htm");
	}
	
	/**
	
	/**
	 * ������ҳ
	 */
	public void news() {
		render("page/news/index.htm");
	}
	
	/**
	 * ��ȡ��������
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
	 * ����������ҳ��
	 */
	public void openNewsInfo() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("page/news/newsinfo.html");
	}
	/**
	 * ��ȡ��������
	 */
	public void getNewsInfo() {
		String id = getPara("id");
		renderJson();
		
	}
	public void test() {
		render("page/news/test.html");
	}
	/**
	 * ����������ҳ
	 */
	public void contact() {
		render("page/contact/index.htm");
	}

}
