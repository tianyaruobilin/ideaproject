package com.springbootruleenginee.springbootruleenginee.entity;

import lombok.Data;

@Data
public class AdressCheckResult {

    private boolean postCodeResult=false;   //true：通过校验，false:未通过校验
}
