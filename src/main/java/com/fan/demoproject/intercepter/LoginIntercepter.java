package com.fan.demoproject.intercepter;

import com.fan.demoproject.domain.User;
import com.fan.demoproject.service.impl.UserServiceImpl;
import com.fan.demoproject.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginIntercepter implements HandlerInterceptor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("login preHandle");

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }
        if (!StringUtils.isEmpty(token)){
            //判断token是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null){
                return true;
            }else {
                JsonData jsonData = JsonData.buildError("登录失败, token 无效", -2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(response, jsonStr);
                return false;
            }
        }else {
            JsonData jsonData = JsonData.buildError("未登录", -3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(response, jsonStr);
            return false;
        }
    }

    private void renderJson(HttpServletResponse response, String json){

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()){

            writer.print(json);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("login postHandle");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("login afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
