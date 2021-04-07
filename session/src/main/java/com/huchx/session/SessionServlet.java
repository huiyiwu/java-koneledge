package com.huchx.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

/**
 * 会话数据保存在服务器端。（内存中）
 * 
 */
@WebServlet(name = "sessionServlet", value = "/session")
public class SessionServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String sessionId = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie:cookies){
            String name = cookie.getName();
            if (name.equals("HSESSIONID")){
                sessionId = cookie.getValue();
                break;
            }
        }
        if (sessionId == null) {
            sessionId = String.valueOf(UUID.randomUUID());
            User user = new User(sessionId,"huchx");
            session.setAttribute(sessionId,user);
            resp.getWriter().write("首次登陆创建得对象为:"+user.toString());
        }else {
            User user = (User) session.getAttribute(sessionId);
            System.out.println("Session获取到的对象为："+user.toString());
            resp.getWriter().write("Session中获取得 对象为:"+user.toString());
        }
        Cookie cookie  = new Cookie("HSESSIONID",sessionId);
        resp.addCookie(cookie);
    }
}
