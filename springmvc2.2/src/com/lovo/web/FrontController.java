package com.lovo.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.entity.Goods;
import com.lovo.entity.User;

@Controller
public class FrontController implements ServletContextAware{
	/**
	 * 使用接口注入上下文对象
	 */
	private ServletContext context;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("test")
	public String goToLogin(){
		return "login";
	}
	
	/**
	 * 跳转到商品展示页面，并将商品数据传递过去
	 * @return
	 */
	@RequestMapping("showgoods")
	public ModelAndView showGoods(){
		ModelAndView mav = new ModelAndView();
		List<Goods> list = new ArrayList<>();
		Goods g1 = new Goods("泡面", 3.5);
		Goods g2 = new Goods("粉丝", 3.0);
		Goods g3 = new Goods("泡干饭", 5.0);
		list.add(g1);
		list.add(g2);
		list.add(g3);
		
		mav.addObject("goodsList", list);
		mav.setViewName("showGoods");
		
//		req.setAttribute("goodsList", list);
		
		return mav;
	}
	
	/**
	 * 跳转到上传页面
	 * @return
	 */
	@RequestMapping("goToUp")
	public String goToUpload(){
		return "upload";
	}
	
	/**
	 * 执行上传业务
	 * @param files
	 * @return
	 */
	@RequestMapping("upload")
	public String upload(@RequestParam("file") CommonsMultipartFile[] files){
		for(CommonsMultipartFile file : files){
			if(!file.isEmpty()){
				String path = context.getRealPath("/WEB-INF/images");
				//取文件名使用.getOriginalFilename(),而非.getName()
				String filename = file.getOriginalFilename();
				String suffix = "";
				int dot = filename.lastIndexOf(".");
				if(dot >= 0){
					suffix = filename.substring(dot);
				}
				filename = UUID.randomUUID() + suffix;
				try {
					file.transferTo(new File(path + "/" + filename));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "showGoods";
	}
	
	/**
	 * 使用spring执行阿贾克斯
	 * @return
	 */
	@RequestMapping("jackson")
	public @ResponseBody List<Goods> doJack(){
		Goods goods = new Goods("白开水", 100.0);
		List<Goods> list = new ArrayList<>();
		list.add(goods);
		
		return list;
	}
	
	/**
	 * 使用AbstractExcelView生成Excel文件
	 * 为什么返回excelView后就能跳转到UserListViewResolver???
	 * @param map
	 * @return
	 */
	@RequestMapping("getExcel")
	public String getExcel(ModelMap map){
		List<User> list = new ArrayList<>();
		User u1 = new User("jack", "123");
		User u2 = new User("bob", "234");
		User u3 = new User("marry", "567");
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		map.addAttribute("userList", list);
		
		return "excelView";
	}
	
	@RequestMapping("getPdf")
	public String getPdf(ModelMap map){
		List<String> words = new ArrayList<>();
		words.add("shit!");
		words.add("fuck!");
		words.add("foolish!");
		
		map.addAttribute("words", words);
		
		return "pdfView";
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
