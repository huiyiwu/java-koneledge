package com.huchx.session.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        boolean isFlag = isFlag(req);
        if (!isFlag){
            resp.getWriter().write("已经提交过，请勿重复提交");
            System.out.println("已经提交过，请勿重复提交");
            return;
        }
        String userName = req.getParameter("userName");
        try {
            Thread.sleep(3000);
            System.out.println("往数据库中插入数据："+userName);
            resp.getWriter().write("success");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isFlag(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionToken = (String) session.getAttribute("token");
        String token = req.getParameter("token");
        if (!sessionToken.equals(token)){
            return false;
        }
        session.removeAttribute("sessionToken");
        return true;
    }
}
