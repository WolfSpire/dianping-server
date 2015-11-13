package com.hyx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;
import com.hyx.dao.GoodsDao;
import com.hyx.dao.impl.GoodsDaoImpl;
import com.hyx.enity.Goods;
import com.hyx.enity.ResponseObject;

public class GoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		GoodsDao dao=new GoodsDaoImpl();
		String cityId=request.getParameter("cityId");
		String catId=request.getParameter("catId");
		int page= Integer.parseInt(request.getParameter("page"));
		int size=Integer.parseInt(request.getParameter("size"));
		List<Goods> list= dao.getList(cityId, catId, page, size);
		//��Ʒ��Ϣ������
		double count=dao.getCount(cityId, catId);
		//������תΪjson�ַ���
		ResponseObject result=null;
		if (list!=null && list.size()>0) {
			result=new ResponseObject(1,list);
			result.setPage(page);
			result.setCount((int)Math.ceil(count/size));
			result.setSize(size);
		}else{
			result=new ResponseObject(0,"��ȡ����ʧ��,����ϵGeekyx����");
		}
		out.println(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();


	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}

}
