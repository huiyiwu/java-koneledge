package com.huchx.session;

import jdk.nashorn.internal.ir.IfNode;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * 会话数据保存在浏览器客户端
 *
 * 1）构造Cookie对象
 * 		@Cookie(java.lang.String name, java.lang.String value)
 * 	2）设置cookie
 * 		@setPath (java.lang.String uri)   ：设置cookie的有效访问路径
 * 		@setMaxAge (int expiry) ： 设置cookie的有效时间
 * 		@setValue (java.lang.String newValue) ：设置cookie的值
 * 	3）发送cookie到浏览器端保存
 * 		@response.addCookie(Cookie cookie)  : 发送cookie
 * 	4）服务器接收cookie
 * 		@Cookie[] request.getCookies()  : 接收cookie
 *
 * @Cookie的局限：
 * 		1）Cookie只能存字符串类型。不能保存对象
 * 		2）只能存非中文。
 * 		3）1个Cookie的容量不超过4KB。
 */
@WebServlet(name = "cookieServlet", value = "/cookie")
public class CookieServlet extends HttpServlet {
    public void init() {
        System.out.println("Servlet 初始化.....");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String lastTime = null;

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            String name = cookie.getName();
            if (name.equals("lastTime")){
                lastTime = cookie.getValue();
             break;
            }
        }
        if (lastTime == null) {
            System.out.println("首次访问");
            response.getWriter().write("首次访问");
        }else {
            System.out.println("上次登录时间为："+lastTime);
            response.getWriter().write("上次登录时间为："+lastTime);
        }
        String currentTime = new SimpleDateFormat("yyyy-yy-yyhh:mm:ss").format(new Date());
        Cookie cookie =  new Cookie("lastTime",currentTime);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
    }


    public void destroy() {
    }
}