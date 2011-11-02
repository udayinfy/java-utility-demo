package com.jquery;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStockInfo extends HttpServlet {
	
	//保存股票对象的Map
	private HashMap<String,Stock> stocks;

	/**
	 * Constructor of the object.
	 */
	public GetStockInfo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 返回两只股票的当前价格
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		// 计算随机数
		double sz = Math.random() * 20;
		double pf = Math.random() * 0.5;
		
		// 通过随机数是奇数还是偶数判断股票是上涨还是下跌
		boolean flagSz  = ((int)(Math.random() * 10)) % 2 == 0;
		boolean flagPf  = ((int)(Math.random() * 10)) % 2 == 0;
		
		// 将随机数和股票的当前价格进行加或减的操作，得到当前新的价格
		Stock szzs = stocks.get("300001");
		Stock pufy = stocks.get("000001");
		double temp;
		
		if (flagSz) {
			temp = szzs.getNow() + sz;
		} else {
			temp = szzs.getNow() - sz;
		}
		// 对当前价格进行截取，只保留小数点后两位
		temp = (int) (temp * 100) / 100.0; 
		szzs.setNow(temp);
		
		if (flagPf) {
			temp = pufy.getNow() + pf;
		} else {
			temp = pufy.getNow() - pf;
		}
		// 对当前价格进行截取，只保留小数点后两位
		temp = (int) (temp * 100) / 100.0; 
		pufy.setNow(temp);
		
		// 返回两只股票的昨天收盘，今天开盘和当前价格
		
		//out.println(szzs + "<br/>" + pufy);
		// 使用json数据格式返回股票信息（有jsonlib的工具，struts2里有工具类，完成把java格式化为json格式）
		
		// 采用数组的方式回传两个对象
		// [{name:'123',id:'123',yes:123.0,tod:123.0,now:123.0},{name:'123',id:'123',yes:123.0,tod:123.0,now:123.0}]
		StringBuilder builder = new StringBuilder();
		//builder.append( "[{name:'" + szzs.getName() + "',id:'" + szzs.getId() + "',yes:"	+ szzs.getYesterday() + ",tod:" + szzs.getToday() + ",now:" + szzs.getNow() +"}," 
		//		+ "{name:'"  + pufy.getName() + "',id:'" + pufy.getId() + "',yes:"	+ pufy.getYesterday() + ",tod:" + pufy.getToday() + ",now:" + pufy.getNow()	+ "}]" );
		
		// 采用对象的方式回传两个对象
		// 如果回传对象表示的json，需要在最外层加上一个括号，否则页面解析会出错
		// 如果不加括号，把out.println()语句改为out.print(),让其不要想客户端输出\r\n,也可以修正这一点
		builder.append("({" 
				+ "'" + szzs.getId() + "':{name:'" + szzs.getName() + "',yes:" + szzs.getYesterday() + ",tod:" + szzs.getToday() + ",now:" + szzs.getNow() + "}"
				+"," + "'" + pufy.getId() + "':{name:'" + pufy.getName() + "',yes:" + pufy.getYesterday() + ",tod:" + pufy.getToday() + ",now:" + pufy.getNow() + "}"
				+ "})");
		System.out.println(builder.toString());
		System.out.println("request.getParameter(\"count\")--->" + request.getParameter("count"));
		out.println(builder.toString());
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
		stocks = new HashMap<String,Stock>();
		
		//创建股票对象
		Stock szzs = new Stock(3000.0,2990.1,"上证指数","300001");
		Stock pufy = new Stock(23.22,23.50,"浦发银行","000001");
		
		//将股票对象保存在stocks的Map中
		stocks.put("300001", szzs);
		stocks.put("000001", pufy);
		
		System.out.println("stocks--->" + stocks);
		
	}

	
	

}
