package com.wz.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;

public class MessageModel extends Model<MessageModel> {
	private static final long serialVersionUID = 1L;
	public static final String tableName = "message";
	
	public String getId() {
		return get("id");
	}
	public void setId(String id) {
		set("id", id);
	}
	public String getTitle() {
		return get("Title");
	}
	public void setTitle(String title) {
		set("title", title);
	}
	public String getMassage() {
		return get("massage");
	}
	public void setMassage(String massage) {
		set("massage", massage);
	}
	public String getUsername() {
		return get("username");
	}
	public void setUsername(String username) {
		set("username", username);
	}
	public Date getTime() {
		return get("time");
	}
	public void setTime(Date time) {
		set("time", time);
	}
	public String getPhone() {
		return get("phone");
	}
	public void setPhone(Date phone) {
		set("phone", phone);
	}
	public String getEmail() {
		return get("email");
	}
	public void setEmail(Date email) {
		set("email", email);
	}
	
	public static MessageModel dao = new MessageModel();
	
	

}
