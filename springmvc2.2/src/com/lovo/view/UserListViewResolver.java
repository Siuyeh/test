package com.lovo.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.lovo.entity.User;

/**
 * 使用静态类AbstractExcelView生成excel文件
 * @author tian
 */
public class UserListViewResolver extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		resp.setContentType("application/vnd.ms-excel");
		
		//由于Tomcat内部编码被改成了utf-8 因此需要将告诉浏览器的中文文件名再转回成iso-8859-1
		// 浏览器才能够识别出该中文文件名
		resp.setHeader("Content-Disposition",
				"inline;filename="+new String("用户列表".getBytes(), "iso-8859-1"));
		
		HSSFSheet sheet = book.createSheet("用户列表");
		
		HSSFCell tempCell;
		tempCell = getCell(sheet, 0, 0);
		setText(tempCell, "用户名");
		tempCell = getCell(sheet, 0, 1);
		setText(tempCell, "密码");
		
		List<User> list = (List<User>) map.get("userList");
		
		for(int i=0;i<list.size();++i){
			tempCell = getCell(sheet, i+1, 0);
			setText(tempCell, list.get(i).getUsername());
			tempCell = getCell(sheet, i+1, 1);
			setText(tempCell, list.get(i).getPassword());
		}
	}

}
