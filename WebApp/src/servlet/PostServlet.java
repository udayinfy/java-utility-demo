package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet {

	private static final long serialVersionUID = 4394132187065250468L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw new UnsupportedOperationException("不支持Get方式");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("ParamA")); // Post取不到a=1&b=2参数
		System.out.println(req.getParameter("ParamB")); // Post取不到a=1&b=2参数
		System.out.println(req.getQueryString());  // Post取不到QueryString
		
		this.debugPostData(req);
		
	}
	
	public void debugPostData(HttpServletRequest req) throws IOException{
		ServletInputStream inputStream = req.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		StringBuffer buffer = new StringBuffer();
		while( (line=reader.readLine() )!= null){
			buffer.append(line + System.getProperty("line.seprator"));
		}
		System.out.println("Post Data:\n" + buffer);
	}

}
