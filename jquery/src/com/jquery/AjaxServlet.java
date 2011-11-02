package com.jquery;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=GBK");
        
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        
        if(name==null || "".equals(name)){

            out.println("the name shoud not be null!!");

        }else if(name.equals("admin")){

            out.println("the name already exist");
            
        }else{

            out.println("the name can be registed");
        }

    }
}
