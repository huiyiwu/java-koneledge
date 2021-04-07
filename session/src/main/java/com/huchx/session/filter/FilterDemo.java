package com.huchx.session.filter;

import com.huchx.session.xss.XssAndSqlRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Filter 也称之为过滤器，它是 Servlet 技术中最实用的技术，Web 开发人员通过 Filter 技术，对 web 服务器管理的所有 web 资源：例如 Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。例如实现 URL 级别的权限访问控制、过滤敏感词汇、压缩响应信息等一些高级功能。
 * 它主要用于对用户请求进行预处理，也可以对 HttpServletResponse 进行后处理。使用 Filter 的完整流程：Filter 对用户请求进行预处理，接着将请求交给 Servlet 进行处理并生成响应，最后 Filter 再对服务器响应进行后处理。
 */
public class FilterDemo implements Filter {
    public FilterDemo() {
        System.out.println("进入Filter拦截器");
    }

    @Override
    public void destroy() {
        System.out.println("销毁拦截器");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("对Servlet请求进行拦截");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String resuestUri = request.getRequestURI();
//        System.out.println("请求地址为:"+resuestUri);
//
//        Map<String, String[]> paramterMap = request.getParameterMap();
//        for (String key : paramterMap.keySet()){
//            String[] paramter = paramterMap.get(key);
//            System.out.println(paramter.toString());
//        }
//        filterChain.doFilter(request,response);


//        防止XSS攻击解决方案
        System.out.println("执行过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        XssAndSqlRequestWrapper wrapper = new XssAndSqlRequestWrapper(request);
        filterChain.doFilter(wrapper,servletResponse);
    }

}
