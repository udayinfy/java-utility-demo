package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DebugServlet extends HttpServlet{

    /**
     * 输出请求头信息
     * @param request
     */
    private void debugRequestHeaders(HttpServletRequest request) {
        Date date = new Date();
        System.out.println(date + "================request headers debug================");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerKey = (String) headerNames.nextElement();
            String headerValue = request.getHeader(headerKey);
            System.out.println(headerKey + ":" + headerValue);
        }

    }

    /**
     * 输出响应信息
     * @param response
     */
    private void debugResponseMsg(HttpServletResponse response) {
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		debugRequestHeaders(request);
		
		System.out.println("---------------------->"+request.getHeader("user-agent"));
	
	}
    
    
	
	
}
