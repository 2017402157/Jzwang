package com.wz.controll;

import java.io.File;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.wz.util.StringUtil;

public class UploadsConteroll extends Controller {
	
//	public void uploadNewsImg() {
//		UploadFile upFile = getFile();//单个上传文件一句搞定  默认路径是 upload
//		File file = upFile.getFile();
//        String extName = StringUtil.getFileExt(file.getName());
//        String filePath = upFile.getUploadPath();
//        String fileName = System.currentTimeMillis() + extName;
//        file.renameTo(new File(filePath+"\\"+fileName));
//        
//        JSONObject json = new JSONObject();
//        json.put("src", "\\upload\\"+fileName);
//        json.put("title", fileName);
//        
//        setAttr("msg", "上传成功");
//		setAttr("code", 0);
//		setAttr("data", json);
//		renderJson();
//	} 
//	
	public void uploadImg() {
		UploadFile upFile = getFile();//单个上传文件一句搞定  默认路径是 upload
		File file = upFile.getFile();
        String extName = StringUtil.getFileExt(file.getName());
        String filePath = upFile.getUploadPath();
        String fileName = System.currentTimeMillis() + extName;
        file.renameTo(new File(filePath+"\\"+fileName));
        
        JSONObject json = new JSONObject();
        json.put("src", "\\upload\\"+fileName);
        json.put("title", fileName);
        
        setAttr("msg", "上传成功");
		setAttr("code", 0);
		setAttr("data", json);
		renderJson();
	}
	

}
