package com.wz.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.wz.controll.AdminControll;
import com.wz.model.ContactModel;
import com.wz.model.LogsModel;
import com.wz.model.MessageModel;
import com.wz.model.NewsModel;
import com.wz.model.RoleModel;
import com.wz.model.ShowactivityModel;
import com.wz.model.UserModel;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("config.properties");
		me.setDevMode(getPropertyToBoolean("DevMode", true));
	}

	@Override
	public void configRoute(Routes me) {
		me.setBaseViewPath("WEB-INF");
		me.add("/admin", AdminControll.class, "admin");
		
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configPlugin(Plugins me) {
		DruidPlugin mysql = new DruidPlugin(getProperty("sqlurl"), getProperty("user"), getProperty("password").trim());
		{
			mysql.setTestOnBorrow(true);
			mysql.setTestOnReturn(true);
			mysql.setMaxWait(20000);
		}
		ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql", mysql);
		boolean Showsql = getPropertyToBoolean("showsql", true);
		arpMysql.setShowSql(Showsql);
		{
			arpMysql.addMapping("news", NewsModel.class);
			arpMysql.addMapping("user", UserModel.class);
			arpMysql.addMapping("role", RoleModel.class);
			arpMysql.addMapping("logs", LogsModel.class);
			arpMysql.addMapping("showactivity", ShowactivityModel.class);
			arpMysql.addMapping("message", MessageModel.class);
			arpMysql.addMapping("contact", ContactModel.class);
		}
		me.add(mysql);
		me.add(arpMysql);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

}
