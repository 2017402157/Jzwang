package com.wz.controll;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wz.model.CandidateModel;
import com.wz.model.CompanyModel;
import com.wz.model.ContactModel;
import com.wz.model.InviteModel;
import com.wz.model.MessageModel;
import com.wz.model.NewsModel;
import com.wz.model.ShowactivityModel;

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
	 * ��ȡ��Ƹ����
	 */
	public void getRecruit() {
//		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<InviteModel> user = InviteModel.getListes(page,limit, "");
		setAttr("m", user.getList());
		renderJson(); 
	}
	//��ҳ
			public void getRecruitTotal() {
//				
				setAttr("total", InviteModel.getCount());
				renderJson(); 
			}
	/**
	 * ��ȡ��ҳ��Ƹ����
	 */
	public void getRecruitListTop() {
		Page<InviteModel> user = InviteModel.getListTop(1, 4);
		setAttr("m", user.getList());
		renderJson(); 
	}
	/**
	 * ����Ƹ����ҳ��
	 */
	public void openRecruitInfo() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("page/recruit/recruitinfo.htm");
	}
	/**
	 * ��ȡ��Ƹ����
	 */
	public void getRecruitInfo() {
		String id = getPara("id");
		InviteModel recruitinfo = InviteModel.getByIds(id);
		setAttr("m", recruitinfo);
		renderJson();
		
	}
	
	
	
	
	
	
	/**
	 * ���Ӱ��ҳ
	 */
	public void photos() {
		render("page/photos/index.htm");
	}
	/**
	 * ��ȡ��Ӱ����
	 */
	public void getPhotos() {
//		String key = getPara("key");
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<ShowactivityModel> user = ShowactivityModel.getList(page,limit, "");
		setAttr("m", user.getList());
		renderJson(); 
	}
	//��ҳ
		public void getPhotosTotal() {
//			
			setAttr("total", ShowactivityModel.getCount());
			renderJson(); 
		}
	/**
	 * �򿪼�Ӱ����ҳ��
	 */
	public void openPhotosInfo() {
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("page/photos/photosinfo.htm");
	}
	/**
	 * ��ȡ��Ӱ����
	 */
	public void getPhotosInfo() {
		String id = getPara("id");
		ShowactivityModel photosinfo = ShowactivityModel.getById(id);
		setAttr("m", photosinfo);
		renderJson();
		
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
		int limit = getParaToInt("limit");
		int page = getParaToInt("page");
		Page<NewsModel> user = NewsModel.getList(page,limit, 0);
		setAttr("m", user.getList());
		renderJson(); 
	}
	//��ҳ
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
	 * ��ȡ��������
	 */
	public void getNewsListTop() {
		Page<NewsModel> user = NewsModel.getListTop(1, 4);
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
		NewsModel newsinfo = NewsModel.getNewsId(id);
		setAttr("m", newsinfo);
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
	/**
	 * ��ȡ������������
	 */
	public void getContact() {
//		String key = getPara("key");
//		int limit = getParaToInt("limit");
//		int page = getParaToInt("page");
		Page<ContactModel> user = ContactModel.getList(1, 1, "");
		setAttr("m", user.getList());
		renderJson(); 
	}
	/**
	 * ������ϵ��������
	 */
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
	/**
	 *��ְ&��Ƹ
	 **/
	public void job() {
		render("page/job/index.htm");
	}
	/**
	 * ������ְ����
	 */
	public void addjob() {
		String name = getPara("name");
		int sex = getParaToInt("sex");
		String phone = getPara("phone");
		String addr = getPara("addr");
		int age = getParaToInt("age");
		String qq = getPara("qq");
		String weixin = getPara("weixin");
		String jobmessage = getPara("jobmessage");
		String type = getPara("type");
		boolean result = CandidateModel.save(name, sex, phone, addr, age, qq, weixin, type, jobmessage);
		setAttr("result", result);
		renderJson();
	}
	/**
	 * ������Ƹ����
	 */
	public void addrecruitment() {
		String name = getPara("name");
		String workpro = getPara("workpro");
		String addr = getPara("addr");
		int number = getParaToInt("number");
		String workexp = getPara("workexp");
		String education = getPara("education");
		String worktime = getPara("worktime");
		String reward = getPara("reward");
		String datum = getPara("datum");
		String linkman = getPara("linkman");
		String qq = getPara("qq");
		String weixin = getPara("weixin");
		String position = getPara("position");
		String company = getPara("company");
		String type = getPara("type");
		String brief = getPara("brief");
		String phone = getPara("phone");
		String email = getPara("email");
		String settle = getPara("settle");
		boolean res = CompanyModel.save(company, brief, phone, email, datum, linkman, qq, weixin, position);
		CompanyModel me = CompanyModel.getByName(company);
		String companys = me.getId();
		boolean result = InviteModel.saves(name, workpro, addr, number, workexp, education, worktime, reward, companys, type, settle);
		setAttr("res", res);
		setAttr("result", result);
		renderJson();
	}
	

}
