package com.wz.model;

import com.jfinal.plugin.activerecord.Model;

public class NewsModel extends Model<NewsModel> {
	public String getId() {
		return get("id");
	}
	public void setId(String id) {
		set("id", id);
	}
}
