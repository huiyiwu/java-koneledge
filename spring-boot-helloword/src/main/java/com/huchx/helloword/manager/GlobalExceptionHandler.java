package com.huchx.helloword.manager;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handler(HttpServletRequest request,Exception e){
        e.printStackTrace();
    Map<String,Object> errMap = new HashMap<>();
    errMap.put("code","-1");
    errMap.put("msg",e.getMessage());
    return errMap;
    }
}
