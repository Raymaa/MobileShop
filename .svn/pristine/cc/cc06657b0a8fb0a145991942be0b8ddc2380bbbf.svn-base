package com.huatec.edu.mobileshop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huatec.edu.mobileshop.service.GoodsImgService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/file")
public class FileController {
	//上传图片
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	//@RequestParam:请求参数的数据匹配
	public Result upload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request){
		Result result=new Result();
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
//		String fileName = file.getOriginalFilename();
		//重命名图片
		String picTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String picType=file.getContentType();
		String fileName=MSUtil.md5(picTime);
		if("image/jpeg".equals(picType)){
			fileName=fileName.concat(".jpg");
		}else if("image/png".equals(picType)){
			fileName=fileName.concat(".png");
		}else if("image/gif".equals(picType)){
			fileName=fileName.concat(".gif");
		}else{
			fileName=fileName.concat(".jpg");
		}
		//存放图片的地址
		String savePath = request.getServletContext().getRealPath("/upload");
		File saveFile = new File(savePath);
		if (!saveFile.exists() && !saveFile.isDirectory()) {
			System.out.println(savePath+"目录不存在，需要创建");
			saveFile.mkdirs();
		}
		File targetFile = new File(savePath, fileName);
		if(!targetFile.exists()){  
			targetFile.mkdirs(); 
		}
		try {
			//复制文件
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			System.out.println("上传文件失败"+e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("上传文件失败"+e);
		}
		String filePath=savePath+File.separator+fileName;
		System.out.println("filePath:"+filePath);
		result.setStatus(0);
		result.setMsg("上传文件成功");
		result.setData(filePath);
		return result;
	}
}
