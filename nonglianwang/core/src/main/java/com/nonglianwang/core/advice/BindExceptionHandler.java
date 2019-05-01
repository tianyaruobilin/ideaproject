package com.nonglianwang.core.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class BindExceptionHandler {

    /**
     * 验证失败时，自动跳转回路径
     * @param be
     * @param redirectAttributes
     * @return
     */
    @ExceptionHandler(BindException.class)
    public String handleBindException(BindException be, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response){
        //获取验证失败的属性对象
        List<ObjectError> allErrors = be.getAllErrors();
        // 新建一个可变字符串，用于存储错误（也可以建map）
        Map map=new LinkedHashMap();
        for (ObjectError objectError : allErrors) {
            FieldError fieldError1= (FieldError) objectError;
            map.put(fieldError1.getField(), fieldError1.getDefaultMessage());
        }
        //全路径
        String url = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
        //头信息
        String header_referer = request.getHeader("Referer");  //获取引用页面
        System.out.println(header_referer);
        System.out.println(url);
        redirectAttributes.addFlashAttribute("error", map);
        System.out.println(map);
        return "redirect:"+header_referer;
    }
}
