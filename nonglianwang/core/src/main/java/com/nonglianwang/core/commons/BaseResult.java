package com.nonglianwang.core.commons;


import lombok.Data;

import java.util.LinkedList;
import java.util.List;
@Data
public class BaseResult{

    private Result result;

    private List datas;

    private Cursor cursor;

    private String success;

    private List<Errors> errors;

    /**
     *
     * @param result
     * @param datas
     * @param cursor
     * @param success
     */
    public BaseResult(Result result,List datas,Cursor cursor,String success){
        this.result=result;
        this.datas=datas;
        this.cursor=cursor;
        this.success=success;
    }

    /**
     *
     * @param object
     * @param cursor
     * @return
     */
    public static BaseResult SUCCESS(Object object,Cursor cursor){
        List<Object> list = new LinkedList<>();
        list.add(object);
        return new BaseResult(Result.ok, list, cursor, "成功操作");
    }

    /**
     *
     * @param result
     * @param datas
     * @param cursor
     * @param success
     * @param errors
     */
    public BaseResult(Result result,List datas,Cursor cursor,String success,List<Errors> errors){
        this.result=result;
        this.datas=datas;
        this.cursor=cursor;
        this.success=success;
        this.errors=errors;
    }

    /**
     *
     * @param object
     * @param cursor
     * @param errors
     * @return
     */
    public static BaseResult SUCCESS(Object object,Cursor cursor,List<Errors> errors){
        List<Object> list = new LinkedList<>();
        list.add(object);
        return new BaseResult(Result.ok, list, cursor, "成功操作", errors);
    }

    /**
     *
     * @param result
     * @param datas
     * @param success
     */
    public BaseResult(Result result, List datas, String success){
        this.result=result;
        this.datas=datas;
        this.success=success;
    }

    /**
     *
     * @param object
     * @return
     */
    public static BaseResult SUCCESS(Object object){
        List<Object> list = new LinkedList<>();
        list.add(object);
        return new BaseResult(Result.ok, list, "操作成功");
    }

    /**
     *
     * @param result
     * @param success
     */
    public BaseResult(Result result,String success){
        this.result=result;
        this.success=success;
    }


    /**
     *
     * @return
     */
    public static BaseResult SUCCESS(){
        return new BaseResult(Result.ok, "操作成功");
    }

    public static BaseResult FALIED(){
        return new BaseResult(Result.not_ok, "操作失败");
    }


    /**
     *
     * @param object
     * @return
     */
    public static BaseResult FALIED( Object object){
        List<Object> list = new LinkedList<>();
        list.add(object);
        return new BaseResult(Result.not_ok, list, "操作操作失败");
    }

}
