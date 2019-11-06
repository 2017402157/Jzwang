package com.wz.controll;

import com.jfinal.core.Controller;

public class AdminControll extends Controller {
	public void index() {
		render("index.html");
	}
	
	public void main() {
		render("main.html");
	}
}
