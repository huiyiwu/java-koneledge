package com.huchx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  servlet对象在tomcat服务器是单实例多线程的。
 *  因为servlet是多线程的，所以当多个servlet的线程同时访问了servlet的共享数据，如成员变量，可能会引发线程安全问题。
 *
 * 	解决办法：
 * 		1）把使用到共享数据的代码块进行同步（使用synchronized关键字进行同步）
 * 		2）建议在servlet类中尽量不要使用成员变量。如果确实要使用成员，必须同步。而且尽量缩小同步代码块的范围。（哪里使用到了成员变量，就同步哪里！！），以避免因为同步而导致并发效率降低。
 */
public class SecurityServlet extends HttpServlet {
    private int i =1;

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet 开始初始化.....");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet 已经销毁.....");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirectParams = (String) req.getParameter("redirectName");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
         if (redirectParams!=null&redirectParams.length()>0) {
            resp.getWriter().write("Huchx Servlet 重定向数据为：" +redirectParams);
        }else {
             synchronized (this) {
                 System.out.println("这是第" + i + "次访问");
                 resp.getWriter().write("这是第" + i + "次访问");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 i++;
             }
         }
    }
}
