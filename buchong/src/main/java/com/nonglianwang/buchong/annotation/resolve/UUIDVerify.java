package com.nonglianwang.buchong.annotation.resolve;

import com.nonglianwang.buchong.annotation.VerifyUUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UUIDVerify implements ConstraintValidator<VerifyUUID, String> {

   @Override
   public void initialize(VerifyUUID constraintAnnotation) {
   }

   @Override
   public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
      /*//null时不进行校验
      if (s != null && s.contains(" ")) {
        //获取默认提示信息
        String defaultConstraintMessageTemplate = constraintValidatorContext.getDefaultConstraintMessageTemplate();
         System.out.println("default message :" + defaultConstraintMessageTemplate);
         //禁用默认提示信息
         constraintValidatorContext.disableDefaultConstraintViolation();
         //设置提示语
         constraintValidatorContext.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();

         return false;
      }*/
      if (s!=null && !"".equals(s)){
            if (s.matches("\\\\w{8}(-\\\\w{4}){3}-\\\\w{12}?")){
                return true;
            }
          return false;
      }
       return false;
   }
}
