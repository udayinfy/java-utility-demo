package com.jquery;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-21
 * Time: 20:11:27
 * To change this template use File | Settings | File Templates.
 */
public class EncodeServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        String old = request.getParameter("name");
        System.out.println("old--->" + old);
        String name = URLDecoder.decode(old,"utf-8");
        System.out.println("name--->" + name);

        if(name==null || "".equals(name)){

            out.println("the name shoud not be null!!");

        }else if(name.equals("admin")){

            out.println("the name [" + name + "] already exist");

        }else{

            out.println("the name [" + name + "] can be registed");
        }
          

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
