package com.nonglianwang.buchong.advice;

import com.nonglianwang.buchong.commons.BaseResult;
import com.nonglianwang.buchong.commons.Errors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class BindExceptionHandler {

    //当使用 -- BeanValidate -- 时，出现该异常,仅限于 BeanValidate,否则用 MethodValidate
    /**
     * 验证失败时，自动跳转回路径
     * @param be
     * @return
     */
    @ExceptionHandler({BindException.class})
    public BaseResult handleBindException(BindException be){
        //获取验证失败的属性对象
        List<ObjectError> allErrors = be.getAllErrors();
        // 新建一个可变字符串，用于存储错误（也可以建map）
        List<Errors> errors=new LinkedList<>();
        for (ObjectError objectError : allErrors) {
            FieldError fieldError1= (FieldError) objectError;
            Errors errors1=new Errors();
            errors1.setField(fieldError1.getField());
            errors1.setMessage(fieldError1.getDefaultMessage());
            errors.add(errors1);
        }
        System.out.println(errors);
        return BaseResult.FALIED(errors);
    }


    //当验证单个数据时，需要改异常处理器为 MethodValidate ,(1.controller上加 @Validated,2.加上对应的 Validate注解)
    @ExceptionHandler(value = { ConstraintViolationException.class })
    public BaseResult handleResourceNotFoundException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        List<Errors> errors=new LinkedList<>();
        for (ConstraintViolation<?> violation : violations ) {
            Errors error=new Errors();
            error.setField(violation.getInvalidValue().toString());
            error.setMessage(violation.getMessage());
            errors.add(error);
        }
        return BaseResult.FAILED(errors , "数据校验失败");
    }

    //方法参数验证失败  //当使用 MethodValidate 方法参数验证时,会抛出该异常
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public BaseResult
    handleMethodArgumentNotValidException(MethodArgumentNotValidException manve){
        BindingResult bindingResult = manve.getBindingResult();
        List<Errors> errors=new LinkedList<>();
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                Errors error=new Errors();
                error.setField(fieldError.getField());
                error.setMessage(fieldError.getDefaultMessage());
                errors.add(error);
            }
        }
        return BaseResult.FAILED(errors, "参数校验失败");
    }
}
