package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LogServlet extends HttpServlet{
	
	private Logger logger = Logger.getLogger(LogServlet.class);

	private int count = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("the the logservlet is invoked." + count++);
		logger.info("RequestURL:" + request.getRequestURL() + "?" + request.getQueryString());
		
	}
	
	

}
