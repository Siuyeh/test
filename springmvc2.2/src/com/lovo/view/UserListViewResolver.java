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
 * ʹ�þ�̬��AbstractExcelView����excel�ļ�
 * @author tian
 */
public class UserListViewResolver extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		resp.setContentType("application/vnd.ms-excel");
		
		//����Tomcat�ڲ����뱻�ĳ���utf-8 �����Ҫ������������������ļ�����ת�س�iso-8859-1
		// ��������ܹ�ʶ����������ļ���
		resp.setHeader("Content-Disposition",
				"inline;filename="+new String("�û��б�".getBytes(), "iso-8859-1"));
		
		HSSFSheet sheet = book.createSheet("�û��б�");
		
		HSSFCell tempCell;
		tempCell = getCell(sheet, 0, 0);
		setText(tempCell, "�û���");
		tempCell = getCell(sheet, 0, 1);
		setText(tempCell, "����");
		
		List<User> list = (List<User>) map.get("userList");
		
		for(int i=0;i<list.size();++i){
			tempCell = getCell(sheet, i+1, 0);
			setText(tempCell, list.get(i).getUsername());
			tempCell = getCell(sheet, i+1, 1);
			setText(tempCell, list.get(i).getPassword());
		}
	}

}
