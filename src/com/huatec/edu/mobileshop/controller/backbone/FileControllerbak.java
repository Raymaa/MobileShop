package com.huatec.edu.mobileshop.controller.backbone;

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
/**
 * 文件上传的备份文件
 * @author ZhangRuiYuan
 *
 */
@Controller
@RequestMapping("/file")
public class FileControllerbak {
	
	@RequestMapping(value="/uploadbak",method=RequestMethod.POST)
	@ResponseBody
//	@ApiOperation(value="富文本上传文件")
	public Result kindEditorUpload(HttpServletRequest request, HttpServletResponse response){
		System.out.println("/upload/ke");
		Result result=new Result();
		//文件保存目录路径
		String savePath = request.getSession().getServletContext().
				getRealPath("/") + "upload/kindeditor/";
		/*File file1 = new File(savePath);
        if (!file1.exists()) {
             file1.mkdir();// 创建文件根目录
         }*/

        //文件保存目录URL
        String saveUrl  = request.getContextPath() + "/upload/kindeditor/";
        /*File file2 = new File(saveUrl);
        if (!file2.exists()) {
             file2.mkdir();// 创建文件根目录
         }*/
        
        String dirName = request.getParameter("dir");  
        if (dirName == null) {  
            dirName = "image";  
        }
        
		//定义允许上传的文件扩展名
		HashMap extMap = new HashMap();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		System.out.println("/upload/ke1...");
		if(!extMap.containsKey(dirName)){  
			result.setStatus(1);
            result.setMsg("目录名不正确");
            return result;  
        }
		System.out.println("/upload/ke2...");
        //创建文件夹  
        savePath += dirName + "/";  
        saveUrl += dirName + "/";  
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {  
            saveDirFile.mkdirs();  
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
        String ymd = sdf.format(new Date());  
        savePath += ymd + "/";  
        saveUrl += ymd + "/";  
        File dirFile = new File(savePath);  
        if (!dirFile.exists()) {  
            dirFile.mkdirs();  
        }
        System.out.println("/upload/ke3...");
		//最大文件大小
		long maxSize = 10000000;
		response.setContentType("text/html; charset=UTF-8");
		//判断是否选择文件
		if(!ServletFileUpload.isMultipartContent(request)){
            result.setStatus(1);
            result.setMsg("请选择文件");
            return result;
        }
		System.out.println("/upload/ke4...");
//		UploadFile uploadFile = new UploadFile(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<?> items = null;
		try {
			items = upload.parseRequest(request);
			System.out.println("/upload/ke5...");
		} catch (FileUploadException e) {
			e.printStackTrace();
			System.out.println("接收文件异常"+e);
		}
		Iterator<?> itr = items.iterator();
		System.out.println("/upload/ke5.5...");
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			System.out.println("/upload/ke6..."+fileName);
			if (!item.isFormField()) {
				//检查文件大小  
                if(item.getSize() > maxSize){
                	result.setStatus(1);
                	result.setMsg("上传文件大小超过限制");
                	return result;
                }
                System.out.println("/upload/ke7...");
                //检查扩展名  
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                if(!Arrays.<String>asList(((String) extMap.get(dirName)).split(",")).
                		contains(fileExt)){
                	result.setStatus(1);
                	result.setMsg("上传文件扩展名是不允许的扩展名");
                	return result;
                }
                System.out.println("/upload/ke8...");
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
                String newFileName = df.format(new Date()) + "_" + 
                new Random().nextInt(1000) + "." + fileExt;  
                try{
                	System.out.println("/upload/ke10..."+savePath);
                    File uploadedFile = new File(savePath, newFileName);  
                    item.write(uploadedFile);  
                }catch(Exception e){  
                    System.out.println("上传文件失败"+e);  
                }
                result.setStatus(0);
                result.setMsg("上传文件成功");
                result.setData(saveUrl+newFileName);
                return result;
			}
		}
		return null;
	}
	
	
	@RequestMapping(value="/uploadbak2",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject save(HttpServletRequest request,HttpServletResponse response){
		System.out.println("/file2/img/upload");
		//文件保存目录路径
		String savePath = request.getSession().getServletContext().
				getRealPath("/") + "upload/kindeditor/";
		//文件保存目录URL
        String saveUrl  = request.getContextPath() + "/upload/kindeditor/";
        
		HashMap<String,String> extMap=new HashMap<String,String>();
		//支持文件的类型
		extMap.put("image", "jpg,jpeg,png,bmp");
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
        savePath += dirName + "/";  
        saveUrl += dirName + "/";  
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
			System.out.println("item.hasNext()");
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
			System.out.println(fileExt);
			if(!Arrays.asList(extMap.get(dirName).split(",")).contains(fileExt)){
				return getError("上传文件扩展名是不允许的扩展名。\n只允许"+extMap.get(dirName)+"格式");
			}
			//上传到服务器
			/*Map<String,String> params=new HashMap<String,String>();
			params.put("fsd", "sdf");
			Map<String,String> headers=new HashMap<String,String>();
			String s;*/
//			s=HttpUtil.
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
            String newFileName = df.format(new Date()) + "_" + 
            new Random().nextInt(1000) + "." + fileExt;  
            try{
            	System.out.println("/upload/ke10..."+savePath);
                File uploadedFile = new File(savePath, newFileName);
                ByteStreams.copy(file.getInputStream(), new FileOutputStream(uploadedFile));
                fileItem.write(uploadedFile);
            }catch(Exception e){  
                return getError("上传文件失败");  
            }
            JSONObject obj1=new JSONObject();
            obj1.put("error", 0);
    		obj1.put("url", saveUrl+newFileName);
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
