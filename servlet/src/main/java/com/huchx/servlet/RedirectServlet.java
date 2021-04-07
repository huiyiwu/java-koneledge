package com.huchx.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 地址栏会改变，变成重定向到地址。
 * 重定向可以跳转到当前web应用，或其他web应用，甚至是外部域名网站。
 * 不能再重定向的过程，把数据保存到request中。
 */
public class RedirectServlet extends HelloServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setStatus(302);
//        response.setHeader("Location","/servlet/hello");
        response.sendRedirect("/servlet/security?redirectName=huchx");
    }
}
