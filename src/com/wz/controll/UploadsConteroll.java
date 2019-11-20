package com.wz.controll;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.render.JsonRender;
import com.jfinal.upload.UploadFile;
import com.wz.util.StringUtil;

public class UploadsConteroll extends Controller {
	
	public void uploadImg() {
		UploadFile upFile = getFile();//�����ϴ��ļ�һ��㶨  Ĭ��·���� upload
		File file = upFile.getFile();
        String extName = StringUtil.getFileExt(file.getName());
        String filePath = upFile.getUploadPath();
        String fileName = System.currentTimeMillis() + extName;
        file.renameTo(new File(filePath+"\\"+fileName));
        setAttr("msg", "�ϴ��ɹ�");
		setAttr("code", 0);
		setAttr("data", file);
		renderJson();
	} 
	
	

}
