package com.nonglianwang.buchong.controller;

import com.nonglianwang.buchong.commons.BaseResult;
import com.nonglianwang.buchong.entity.Order;
import com.nonglianwang.buchong.service.OrderManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "订单管理",tags = "订单管理")
@RestController
@RequestMapping(value = "/order")
@CrossOrigin
public class OrderManagementController {

    @Autowired
    private OrderManagementService orderManagementService;

    @ApiOperation(value = "获取该用户所有订单",notes = "获取该用户所有订单")
    @GetMapping(value = "/getAll")  //获取该用户所有的订单项，且state=false
    public BaseResult getAll(){

        return orderManagementService.getAll();
    }

    @ApiOperation(value = "批量删除订单项", notes = "批量删除订单项")
    @PostMapping(value = "/batchdelete")   //批量删除订单项
    public BaseResult batchdelete(@RequestBody Map<String,Order> objects) {
        return orderManagementService.batchdelete(objects);
    }

    @ApiOperation(value = "修改所选项商品重量",notes = "修改所选项商品重量")
    @PostMapping(value = "/updateState")    //修改所选项商品重量
    public BaseResult updateState(@RequestBody Order order){
        System.out.println("order = [" + order + "]");
        return orderManagementService.updateState(order);
    }

    @ApiOperation(value = "提交订单",notes = "提交订单")
    @PostMapping(value = "/submitOrders")   //提交订单
    public BaseResult submitOrders(@RequestBody Order[] orders){
        for (Order order : orders) {
            System.out.println("order = " + order);
        }
        return orderManagementService.submitOrders(orders);
    }

}
