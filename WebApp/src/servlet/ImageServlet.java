package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import util.FileUtil;

public class ImageServlet extends HttpServlet{

	private Logger logger = Logger.getLogger(ImageServlet.class);
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String imagePath = "D:\\zTEMP\\image.png";
		byte[] buf = FileUtil.readImage(imagePath);

		java.util.Date startDate = new java.util.Date();
		
		response.setContentType("image/png");
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(buf);
		outputStream.close();
		
		java.util.Date endDate = new java.util.Date();
		long eclipsedTime = endDate.getTime() - startDate.getTime();
		logger.info("eclipsed time: " + eclipsedTime);
		
	}

	
	
}
