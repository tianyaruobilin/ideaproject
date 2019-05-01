package com.springjwt.springjwt.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.springjwt.springjwt.annotation.PassToken;
import com.springjwt.springjwt.annotation.UserLoginToken;
import com.springjwt.springjwt.commons.entity.User;
import com.springjwt.springjwt.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Qualifier("tokenServiceImpl")
    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");  //从请求头中取出token
        //如果不是映射到方法直接通过 即-->请求的是静态资源
        if (!(handler instanceof MethodHandle)) {
            return true;
        }
        @SuppressWarnings("ConstantConditions")
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        //检查是否右@PassToken注解
        if(method.isAnnotationPresent(PassToken.class)){
            //判断注解中的require是否为true
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()){
                //如果不需要检查为 true ,则跳过拦截器
                return true;
            }
        }
        //检查有没有需要用户权限的注释
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken annotation = method.getAnnotation(UserLoginToken.class);
            if (annotation.required()){
                //执行认证
                if (token == null) {    //无token
                    throw new RuntimeException("无token,请重新登陆");
                }
                // 有token,获取token中的userid
                String userId;
                try{
                    userId = JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException e){
                    throw new RuntimeException("401");
                }
                User user = tokenService.findUserById(userId);
                if(user==null){
                    //没有id为userId的用户
                    throw new RuntimeException("用户不存在，请重新登陆");
                }
                //验证token
                JWTVerifier verification = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    verification.verify(token);
                }catch (JWTVerificationException jve){
                    throw new RuntimeException("401");
                }
                //否则，如果没有上面的情况，就直接通过该拦截器
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
