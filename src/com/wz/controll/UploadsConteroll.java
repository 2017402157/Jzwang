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
		UploadFile upFile = getFile();//单个上传文件一句搞定  默认路径是 upload
		File file = upFile.getFile();
        String extName = StringUtil.getFileExt(file.getName());
        String filePath = upFile.getUploadPath();
        String fileName = System.currentTimeMillis() + extName;
        file.renameTo(new File(filePath+"\\"+fileName));
        setAttr("msg", "上传成功");
		setAttr("code", 0);
		setAttr("data", file);
		renderJson();
	} 
	
	

}
