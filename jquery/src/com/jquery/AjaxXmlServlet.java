package com.jquery;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-28
 * Time: 23:06:00
 * To change this template use File | Settings | File Templates.
 */
public class AjaxXmlServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/xml;charset=GBK");

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        System.out.println(name);

        StringBuilder builder = new StringBuilder();
        builder.append("<message>");
        if(name==null || "".equals(name)){

             builder.append("the name shoud not be null!!").append("</message>");

        }else if(name.equals("admin")){

             builder.append("the name already exist").append("</message>");
            
        }else{

             builder.append("the name can be registed").append("</message>");
        }
        
        System.out.println(builder.toString());
        out.println(builder.toString());
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
