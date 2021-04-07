package com.huchx.session.xss;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * XSS攻击使用Javascript脚本注入进行攻击
 * 例如在表单中注入: <script>location.href='http://www.itmayiedu.com'</script>
 */
@WebServlet("/xss")
public class XSSServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        req.setAttribute("userName",userName);
        req.getRequestDispatcher("showName.jsp").forward(req,resp);
    }
}
