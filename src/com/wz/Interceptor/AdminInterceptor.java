package com.wz.Interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class AdminInterceptor implements Interceptor {
	@Override
	public void intercept(Invocation inv) {
		Controller c = inv.getController();
		String cookiname = c.getCookie("checkname");
		Object session = c.getSessionAttr("user");
		if(cookiname != null && session != null) {
			inv.invoke();
		}
		else {
			c.removeCookie("checkname");
			c.removeSessionAttr("user");
			c.render("login/login.html");
		}
	}
}
