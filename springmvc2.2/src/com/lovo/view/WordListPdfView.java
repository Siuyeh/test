package com.lovo.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class WordListPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		resp.setHeader("Content-Disposition",
				"inline;filename="+new String("用户列表".getBytes(), "iso-8859-1"));
		
		resp.setContentType("application/pdf");
		
		List<String> words = (List<String>) map.get("words");
		
		BaseFont bfont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
		Font font = new Font(bfont, 14, Font.BOLD, Color.BLUE);
		
		for(int i=0,len=words.size();i<len;++i){
			doc.add(new Paragraph(words.get(i), font));
		}
	}


}
