package cn.edu.ctbu.crm.interceptor;

import cn.edu.ctbu.crm.exception.LoginException;
import cn.edu.ctbu.crm.settings.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.indexOf("/login") > 0){
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null){
            return true;
        }else{
            response.sendRedirect( "/CRM/static/login.jsp");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("---------------------------->执行postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("---------------------------->执行afterCompletion");
    }
}
