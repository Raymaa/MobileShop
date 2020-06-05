package com.huatec.edu.mobileshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.common.io.ByteStreams;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/file")
public class FileController {
	//上传图片
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	//@RequestParam:请求参数的数据匹配
	@ApiOperation(value="上传文件")
	public Result upload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request){
		Result result=new Result();
		String url="http://"+request.getServerName()+":"+request.getLocalPort()
		+request.getContextPath()+"/upload";
		System.out.println("url:"+url);
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
		System.out.println("路径"+savePath);
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
	
	@RequestMapping(value="/upload/ke",method=RequestMethod.POST)
	@ResponseBody
//	@ApiOperation(value="富文本上传文件")
	public JSONObject save(HttpServletRequest request,HttpServletResponse response){
//		System.out.println("/file/upload/ke");
		//文件保存目录路径
		String savePath=request.getSession().getServletContext().
				getRealPath("/") + "upload/kindeditor/";
		//文件保存目录URL
        String saveUrl=request.getContextPath() + "/upload/kindeditor/";
//		String saveUrl  = "http://"+request.getServerName()+":"+request.getLocalPort()
//		+request.getContextPath() + "/upload/kindeditor/";
		HashMap<String,String> extMap=new HashMap<String,String>();
		//支持文件的类型
		extMap.put("image", "jpg,jpeg,png,bmp,gif");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		//最大文件大小
		long maxSize=32505856;
		//是否选择文件
		if(!ServletFileUpload.isMultipartContent(request)){
			return getError("请选择文件");
		}
		//获取文件类型
		String dirName=request.getParameter("dir");
		if(dirName==null){
			dirName="image";
		}
		
		//创建文件夹  
        savePath+=dirName + "/";  
        saveUrl+=dirName + "/";  
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();  
        }
        
		if(!ServletFileUpload.isMultipartContent(request)){
			return getError("请选择文件");
		}
		
		MultipartHttpServletRequest mrequest=(MultipartHttpServletRequest) request;
		Map map=mrequest.getFileMap();
		Collection<MultipartFile> c=map.values();
		Iterator item=c.iterator();
		
		//遍历选择的图片
		JSONObject obj=null;
		while(item.hasNext()){
//			System.out.println("item.hasNext()");
			CommonsMultipartFile file=(CommonsMultipartFile) item.next();
			FileItem fileItem=file.getFileItem();
			long fileSize=file.getSize();
			//检查文件大小
			if(file.getSize()>maxSize){
				return getError("上传文件大小超过限制");
			}
			//检查扩展名
			String fileExt=file.getOriginalFilename().substring
					(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();
//			System.out.println(fileExt);
			if(!Arrays.asList(extMap.get(dirName).split(",")).contains(fileExt)){
				return getError("上传文件扩展名是不允许的扩展名。\n只允许"+extMap.get(dirName)+"格式");
			}
			//重命名图片
			String picTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String picMd5=MSUtil.md5(picTime);
			String newFileName=picMd5+"." + fileExt;
			/*SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
            String newFileName = df.format(new Date()) + "_" + 
            new Random().nextInt(1000) + "." + fileExt;*/
            try{
            	System.out.println("/upload/ke10..."+savePath);
                File uploadedFile = new File(savePath, newFileName);
                ByteStreams.copy(file.getInputStream(), new FileOutputStream(uploadedFile));
                fileItem.write(uploadedFile);
            }catch(Exception e){  
                return getError("上传文件失败");  
            }
//            String saveUrl1="http://"+request.getServerName()+":"+request.getLocalPort()+saveUrl;
            String fileUrl=saveUrl+newFileName;
//            System.out.println("saveUrl:"+saveUrl);
//            System.out.println("fileUrl:"+fileUrl);
            JSONObject obj1=new JSONObject();
            obj1.put("error", 0);
    		obj1.put("url", fileUrl);
    		return obj1;
		}
		return null;
	}
	
	private static JSONObject getError(String message){
		JSONObject obj=new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj;
	}
	
}
