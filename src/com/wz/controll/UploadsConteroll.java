package com.wz.controll;

import java.io.File;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.wz.util.StringUtil;

public class UploadsConteroll extends Controller {
	
//	public void uploadNewsImg() {
//		UploadFile upFile = getFile();//�����ϴ��ļ�һ��㶨  Ĭ��·���� upload
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
//        setAttr("msg", "�ϴ��ɹ�");
//		setAttr("code", 0);
//		setAttr("data", json);
//		renderJson();
//	} 
//	
	public void uploadImg() {
		UploadFile upFile = getFile();//�����ϴ��ļ�һ��㶨  Ĭ��·���� upload
		File file = upFile.getFile();
        String extName = StringUtil.getFileExt(file.getName());
        String filePath = upFile.getUploadPath();
        String fileName = System.currentTimeMillis() + extName;
        file.renameTo(new File(filePath+"\\"+fileName));
        
        JSONObject json = new JSONObject();
        json.put("src", "\\upload\\"+fileName);
        json.put("title", fileName);
        
        setAttr("msg", "�ϴ��ɹ�");
		setAttr("code", 0);
		setAttr("data", json);
		renderJson();
	}
	

}
