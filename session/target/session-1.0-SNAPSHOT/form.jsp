<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Form表单</title>
    <script type="text/javascript">
        var isFlag = false;

        function submitFlag() {
            //第一种方式
            // if (isFlag == false) {
            //     isFlag = true;
            //     return true;
            // } else {
            //     return false;
            // }

            //第二种方式
            //获取表单提交按钮
            var btnSubmit = document.getElementById("submit");
            //将表单提交按钮设置为不可用，这样就可以避免用户再次点击提交按钮
            btnSubmit.disabled = "disabled";
            //返回true让表单可以正常提交
            return true;
        }
    </script>
</head>

<body>
<%--<form action="${pageContext.request.contextPath}/form" method="post" onsubmit="return submitFlag()">--%>
    <form action="${pageContext.request.contextPath}/form" method="post">
        <input type="hidden" name="token" value="${token}">
    用户名：<input type="text" name="userName">
    <input type="submit" value="提交" id="submit">
</form>
</body>
</html>