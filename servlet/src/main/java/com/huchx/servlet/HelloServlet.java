package com.huchx.servlet;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @HttpServletRequet 域对象
 * @ServletContext 域对象
 * @HttpSession 域对象
 * @PageContext 域对象
 */
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String forwardParams = (String) request.getAttribute("name");
       response.setCharacterEncoding("utf-8");//防止中文乱码
        response.setContentType("text/html;charset=utf-8");//输出内容
        if (forwardParams!=null&forwardParams.length()>0) {
            response.getWriter().write("Huchx Servlet 转发数据为：" +forwardParams);
        }else{
            response.getWriter().write("Huchx Servlet 测试程序。测试时间：" + new Date());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    public void destroy() {
    }
}