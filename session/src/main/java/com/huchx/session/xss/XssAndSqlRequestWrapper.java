package com.huchx.session.xss;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssAndSqlRequestWrapper  extends HttpServletRequestWrapper {
    HttpServletRequest request;
    public XssAndSqlRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String value = request.getParameter(name);
        System.out.println("参数："+name+",值为："+value);
        if (!StringUtils.isEmpty(value)){
            value = StringEscapeUtils.escapeHtml4(value);
        }
        return value;
    }
}
