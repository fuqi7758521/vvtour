package com.usual.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.Constants;
import com.common.utils.ImageUtils;
import com.common.utils.MD5Util;
import com.common.utils.PublicResult;
import com.usual.entity.AlbumInfo;
import com.usual.entity.AlbumPic;
import com.usual.service.AlbumPicService;
import com.usual.service.AlbumService;
import com.usual.utils.MakeHtml;
import com.usual.utils.Page;
import com.vvtour.shop.entity.CategoryInfo;

@Controller
@RequestMapping("/admin")
public class AlbumController extends BaseController{
	
	private final static Logger logger = Logger.getLogger(AlbumController.class);
	
	
	private static final String UPLOAD_URL = "/upload/web_pic/";
	
	public static final int AJAX_PAGE_SIZE = 12;
	
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AlbumPicService albumPicService;
	
	/**
	 * 检验该名词是否已经存在 AJAX
	 * */
	@RequestMapping(value="/checkAlbumName",method = RequestMethod.GET)
	public void checkAlbumName(@RequestParam("album_name") String album_name,PrintWriter printWriter){
		String msg = "null";
		try{
			if(StringUtils.isBlank(album_name)){
				msg = "菜单名称不能为空";
			}
			album_name = URLDecoder.decode(album_name, "UTF-8");
			PublicResult<AlbumInfo> result = albumService.queryAlbumInfoByAlbumName(album_name);
			if(result.isSuccess()){
				if(result.getModel()==null){
					msg = Constants.AJAX_RESULT_SUCCESS+"可以添加";
				}else{
					msg = Constants.AJAX_RESULT_FAIL+"该名称已经存在";
				}
			}else{
				msg = Constants.AJAX_RESULT_ERROR+"系统错误，检查失败";
			}
			printWriter.write(msg);
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			printWriter.write(Constants.AJAX_RESULT_ERROR+"系统错误");
		} finally{
			if(printWriter != null){
				printWriter.flush();
				printWriter.close();
			}
		}
		
	}
	
	
	/**
	 * 添加相册名称 AJAX
	 * 
	 * */
	@RequestMapping(value="/addAlbum",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String addAlbum(AlbumInfo info){
		String msg = "null";
		try{
			PublicResult<String> result = albumService.addAlbum(info);
			
			msg = Constants.AJAX_RESULT_SUCCESS+"添加成功";
			
			if(result.isSuccess()){
				if(!StringUtils.isBlank(result.getModel())){
					msg = Constants.AJAX_RESULT_SUCCESS+"添加成功";
				}
			}else{
				msg = Constants.AJAX_RESULT_ERROR+"系统错误，检查失败";
			}
			
			return msg;
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"系统错误";
			return msg;
		} 
	}
	
	
	/**
	 * Ajax 获取相册
	 * */
	@RequestMapping(value="/catchAlbumList",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> catchAlbumList(@RequestParam(value = "album_type", required = false) String album_type){
		try{
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			PublicResult<AlbumInfo> albumResult = albumService.queryAlbumInfoList(0,0,album_type);
			
			if(!albumResult.isSuccess() || albumResult.getModelList() == null){
				//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"获取图片失败,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			
			List<AlbumInfo> albumlist = new ArrayList<AlbumInfo>();
			albumlist = albumResult.getModelList();
			
			modelMap.put("msg", "获取成功");
			modelMap.put("data",albumlist);
			modelMap.put("success","true");
			return modelMap; 
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
			return null;
		} 
	}
	
	
	/**
	 * Ajax 获取图片
	 * */
	@RequestMapping(value="/catchImagesList",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> catchImagesList(Integer pageNo,String album_id){
		try{
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * AJAX_PAGE_SIZE;
			int totalPage = 0;
			if(StringUtils.isNotBlank(album_id)&&album_id.equals("0")){
				album_id=null;
			}
			PublicResult<AlbumPic> result = albumPicService.queryAlbumPicList(album_id, start, AJAX_PAGE_SIZE);
			
			if(!result.isSuccess() || result.getModelList() == null){
				//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"获取图片失败,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			
			List<AlbumPic> piclist = new ArrayList<AlbumPic>();
			piclist = result.getModelList();
			Page page = new Page(AJAX_PAGE_SIZE,result.getCount(),pageNo);
            totalPage = page.getTotalPage();
			
			modelMap.put("msg", "获取成功");
			modelMap.put("data",piclist);
			modelMap.put("totalPage",totalPage);
			modelMap.put("success","true");
			return modelMap; 
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
			return null;
		} 
	}
	
	
	/**
	 * 获取album列表forward
	 * */
	@RequestMapping(value="/album_list")
	public ModelAndView albumList(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "album_type", required = false) String album_type){
		ModelAndView mav = new ModelAndView();
		try{
			pageNo = pageNo==null?1:pageNo;
			int startIndex = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			PublicResult<AlbumInfo> result = albumService.queryAlbumInfoList(startIndex, PAGE_SIZE,album_type);
			if(result!=null){
				mav.addObject("albumList", result.getModelList());
			}
			mav.setViewName("admin/album/albumList");
			
			Page page = new Page(PAGE_SIZE,result.getCount(),pageNo);
            totalPage = page.getTotalPage();
            mav.addObject("currentPage",pageNo);
            mav.addObject("album_type",album_type);
            mav.addObject("pageSize",PAGE_SIZE);
            mav.addObject("totalPage",totalPage);
            mav.addObject("totalCount",result.getCount());
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}

	}
	
	@RequestMapping(value="/picture_list")
	public ModelAndView pictureList(HttpServletRequest request,@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "album_id", required = false) String album_id){
		ModelAndView mav = new ModelAndView();
		try{
			pageNo = pageNo==null?1:pageNo;
			int startIndex = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			PublicResult<AlbumPic> result = albumPicService.queryAlbumPicList(album_id, startIndex, PAGE_SIZE);
			
			if(result!=null){
				mav.addObject("picList", result.getModelList());
				PublicResult<AlbumInfo> albumResult = albumService.queryAlbumInfoByAlbumId(album_id);
				
				if(albumResult.isSuccess()){
					if(albumResult.getModel()==null){
						mav.setViewName("admin/doFail");
						mav.addObject(ERROR_MSG_KEY, "获取相册错误");
						return mav;
					}
					AlbumInfo album = albumResult.getModel();
					
					mav.addObject("album_name", album.getAlbum_name());
				}
			}
			Page page = new Page(PAGE_SIZE,result.getCount(),pageNo);
            totalPage = page.getTotalPage();
            mav.addObject("currentPage",pageNo);
            mav.addObject("pageSize",PAGE_SIZE);
            mav.addObject("totalPage",totalPage);
            mav.addObject("totalCount",result.getCount());
			mav.addObject("album_id", album_id);
			mav.setViewName("admin/album/picList");
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}

	}
	
	@RequestMapping(value="/delAlbumPic")
	public ModelAndView delAlbumPic(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "album_id", required = false) String album_id,
			@RequestParam(value = "pic_id", required = false) String pic_id,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		try{
			PublicResult<AlbumPic> queryResult = albumPicService.queryAlbumPicByPicID(pic_id);
			if(queryResult.isSuccess()){
				
				AlbumPic pic = queryResult.getModel();
				PublicResult<Boolean> result = albumPicService.deletelAlbumPic(pic_id);
				
				if(result.isSuccess()){
					
					String filePath = request.getSession().getServletContext()
		                    .getRealPath(UPLOAD_URL+album_id+SPRIT);
					
					String url = filePath+"/"+pic.getPic_name();
					MakeHtml.deleteFile(url);
					
	                PublicResult<Boolean> albumResult = albumService.updateAlbumPicCount(album_id,Constants.ACTION_ALBUMPIC_DEL);
	                if(!albumResult.isSuccess())logger.error("1`修改相册图片数量失败");  
	                	
				}
			}
			
			mav.setViewName(URL_REDIRECT + "/admin/picture_list.htm?album_id="+album_id);
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_FORWARD + "/admin/picture_list.htm?album_id="+album_id);
			return mav;
		}

	}
	
	@RequestMapping("/upload")
	public String register(){
		return "admin/album/upload";
	}
	
	
	 @RequestMapping(value="/picUpload")  
	    public String picUpload(@RequestParam("album_id") String album_id,
	    		HttpServletRequest request,
	    		HttpServletResponse response) throws IOException{
		 
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		 MultipartFile myfile =null;

		 	//可以在上传文件的同时接收其它参数  
	        //System.out.println("用户要上传到[" + album_id + "]的相册里面去");  
	        //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  
	        //这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建  
	        String uploadPath = request.getSession().getServletContext()
                    .getRealPath(UPLOAD_URL+album_id+SPRIT); 
	        //设置响应给前台内容的数据格式 
	        response.setContentType("text/plain; charset=UTF-8");  
	        //设置响应给前台内容的PrintWriter对象
	        PrintWriter out = response.getWriter();  
	        //上传文件的原名(即上传前的文件名字)
	        String originalFilename = null;
	        //如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解  
	        //如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解  
	        //上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件  
			 for(Map.Entry<String,MultipartFile > set:fileMap.entrySet()){
				 //String filekey = set.getKey();//Filedata
				 myfile = set.getValue();//文件名
			 
	        	if(myfile.isEmpty()){
	                out.print("1`请选择文件后上传");  
	                out.flush();
	                return null;
	            }else{
	            	
	                originalFilename = myfile.getOriginalFilename();
//	                System.out.println("文件原名: " + originalFilename);
//	                System.out.println("文件名称: " + myfile.getName());
//	                System.out.println("文件长度: " + myfile.getSize());
//	                System.out.println("文件类型: " + myfile.getContentType());
//	                System.out.println("========================================"); 
	                String file_ture_name;
	                try {
	                	 //System.out.println(myfile.getOriginalFilename());
	                	 
	                	 File filePath = new File(uploadPath);
	                	 
	                	 if(!filePath.exists()){
	     	 	        	filePath.mkdir();
	     	 	        }
	                	//String pic_time = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

	                	String pic_type = myfile.getContentType();

	                	file_ture_name = MD5Util.encode(System.currentTimeMillis()+"");
	                	//System.out.println("生成文件名："+file_ture_name);
	                	
	                	if(pic_type.equals("image/jpeg")||originalFilename.indexOf(".jpg")>0){
	                		
	                		file_ture_name =   file_ture_name.concat(".jpg");
	                		
	                	} else if (pic_type.equals("image/png")||originalFilename.indexOf(".png")>0){
	                		
	                		file_ture_name = file_ture_name.concat(".png");
	                		
	                	} else if(pic_type.equals("image/bmp")||originalFilename.indexOf(".bmp")>0){
	                		
	                		file_ture_name =  file_ture_name.concat(".bmp");
	                		
	                	} else if(pic_type.equals("image/gif")||originalFilename.indexOf(".gif")>0){
	                		
	                		file_ture_name = file_ture_name.concat(".gif");
	                		
	                	} else file_ture_name = file_ture_name.concat(".jpg");
	                	
	                	
	                	// 上传文件
	        	        ImageUtils.uploadImage(myfile.getInputStream(), new File(uploadPath, file_ture_name));
	        	        
	                    //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉  
	                    //此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传  
	                    //FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, originalFilename));  
	                } catch (Exception e) {
	                    System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");  
	                    e.printStackTrace();  
	                    out.print("1`文件上传失败，请重试！！");  
	                    out.flush();
	                    return null;
	                }
	                
	                addAlbumPic(album_id,file_ture_name,myfile.getOriginalFilename());
	                if(fileMap.entrySet()!=null&&fileMap.entrySet().size()>0){
	                	PublicResult<Boolean> albumResult = albumService.updateAlbumPicCount(album_id,Constants.ACTION_ALBUMPIC_UPLOAD);
	                	if(!albumResult.isSuccess()){
	                		out.print("1`修改相册图片数量失败");  
	                	}
	                }
	                
	                
	            }
	        }
	        //此时在Windows下输出的是[D:\Develop\apache-tomcat-6.0.36\webapps\AjaxFileUpload\\upload\愤怒的小鸟.jpg]  
	        //System.out.println(realPath + "\\" + originalFilename);  
	        //此时在Windows下输出的是[/AjaxFileUpload/upload/愤怒的小鸟.jpg]  
	        //System.out.println(request.getContextPath() + "/upload/" + originalFilename);  
	        //不推荐返回[realPath + "\\" + originalFilename]的值  
	        //因为在Windows下<img src="file:///D:/aa.jpg">能被firefox显示,而<img src="D:/aa.jpg">firefox是不认的  
	        out.print("0`" + uploadPath);  
	        out.flush();
	        return null;
	 }
	 
	 public Boolean addAlbumPic(String album_id,String pic_name,String orginalName){
		 try{
			AlbumPic info = new AlbumPic();
			info.setAlbum_id(album_id);
			info.setPic_name(orginalName);
			info.setPic_url(UPLOAD_URL+album_id+SPRIT+pic_name);
			info.setPic_comment("");
			//添加到pic表里
 	        PublicResult<String> result = albumPicService.addAlbumPic(info);
 	        if(!result.isSuccess()){
 	        	logger.error("保存图片数据失败！");
 	        	return false;
 	        }else{
 	        	info.setPic_id(result.getModel());
 	        	return true;
 	        }
 	        
		 }catch(Exception ex){
			 ex.printStackTrace();
			 return false;
		 }
	 }
}
