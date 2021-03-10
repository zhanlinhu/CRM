package cn.edu.ctbu.crm.handler;

import cn.edu.ctbu.crm.exception.LoginException;
import cn.edu.ctbu.crm.utils.PrintJson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = LoginException.class)
    public void doLoginException(Exception ex, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg",ex.getMessage());
        PrintJson.printJsonObj(response,map);
    }
}
