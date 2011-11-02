package com.jquery;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStockInfo extends HttpServlet {
	
	//�����Ʊ�����Map
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
		// ������ֻ��Ʊ�ĵ�ǰ�۸�
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		// ���������
		double sz = Math.random() * 20;
		double pf = Math.random() * 0.5;
		
		// ͨ�����������������ż���жϹ�Ʊ�����ǻ����µ�
		boolean flagSz  = ((int)(Math.random() * 10)) % 2 == 0;
		boolean flagPf  = ((int)(Math.random() * 10)) % 2 == 0;
		
		// ��������͹�Ʊ�ĵ�ǰ�۸���мӻ���Ĳ������õ���ǰ�µļ۸�
		Stock szzs = stocks.get("300001");
		Stock pufy = stocks.get("000001");
		double temp;
		
		if (flagSz) {
			temp = szzs.getNow() + sz;
		} else {
			temp = szzs.getNow() - sz;
		}
		// �Ե�ǰ�۸���н�ȡ��ֻ����С�������λ
		temp = (int) (temp * 100) / 100.0; 
		szzs.setNow(temp);
		
		if (flagPf) {
			temp = pufy.getNow() + pf;
		} else {
			temp = pufy.getNow() - pf;
		}
		// �Ե�ǰ�۸���н�ȡ��ֻ����С�������λ
		temp = (int) (temp * 100) / 100.0; 
		pufy.setNow(temp);
		
		// ������ֻ��Ʊ���������̣����쿪�̺͵�ǰ�۸�
		
		//out.println(szzs + "<br/>" + pufy);
		// ʹ��json���ݸ�ʽ���ع�Ʊ��Ϣ����jsonlib�Ĺ��ߣ�struts2���й����࣬��ɰ�java��ʽ��Ϊjson��ʽ��
		
		// ��������ķ�ʽ�ش���������
		// [{name:'123',id:'123',yes:123.0,tod:123.0,now:123.0},{name:'123',id:'123',yes:123.0,tod:123.0,now:123.0}]
		StringBuilder builder = new StringBuilder();
		//builder.append( "[{name:'" + szzs.getName() + "',id:'" + szzs.getId() + "',yes:"	+ szzs.getYesterday() + ",tod:" + szzs.getToday() + ",now:" + szzs.getNow() +"}," 
		//		+ "{name:'"  + pufy.getName() + "',id:'" + pufy.getId() + "',yes:"	+ pufy.getYesterday() + ",tod:" + pufy.getToday() + ",now:" + pufy.getNow()	+ "}]" );
		
		// ���ö���ķ�ʽ�ش���������
		// ����ش������ʾ��json����Ҫ����������һ�����ţ�����ҳ����������
		// ����������ţ���out.println()����Ϊout.print(),���䲻Ҫ��ͻ������\r\n,Ҳ����������һ��
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
		
		//������Ʊ����
		Stock szzs = new Stock(3000.0,2990.1,"��ָ֤��","300001");
		Stock pufy = new Stock(23.22,23.50,"�ַ�����","000001");
		
		//����Ʊ���󱣴���stocks��Map��
		stocks.put("300001", szzs);
		stocks.put("000001", pufy);
		
		System.out.println("stocks--->" + stocks);
		
	}

	
	

}
