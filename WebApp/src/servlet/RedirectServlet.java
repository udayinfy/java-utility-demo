package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import util.PropUtil;

public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 4632215500431361142L;

	private static Logger logger = Logger.getLogger(RedirectServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURL().toString();
		String queryStr = req.getQueryString();
		String requestURL = url + "?" + queryStr;
		logger.debug("RequestURL=" + requestURL);
		
		String redirectURL = "";
		Properties prop = PropUtil.getProperties();
		
		Set<Object> keySet = prop.keySet();
		for (Iterator it = keySet.iterator(); it.hasNext();) {
			String key = (String) it.next();
			if(requestURL.contains(key)){
				redirectURL = prop.getProperty(key);
				logger.debug("找到重定向URI: Key=" + key + "; RedirectURI=" + redirectURL);
			}
		}
		
		if(redirectURL.equals("")){
			throw new RuntimeException("没有打到重定向URI，请检查配置。");
		}else{
			redirectURL = redirectURL + "?" + queryStr;
		}
		
		resp.sendRedirect(redirectURL);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
