package com.huchx.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 地址栏不会改变
 * 转发只能转发到当前web应用内的资源
 * 可以在转发过程中，可以把数据保存到request域对象中
 */
public class ForwardServlet extends HelloServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("name","hchux");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hello");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
