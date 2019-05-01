package com.nonglianwang.buchong.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 其实在我看来，我的这个表设计得，这一项应该命名为 OrderItem
 */
@Data
@Table(name = "tb_order")
public class Order {
    @Id
    private Integer ono;            //订单项编号
    private Integer goodsno;        //商品编号
    private String buyerno;         //购买者编号
    private String goodsname;       //商品名
    private BigDecimal goodsprice;  //商品价格
    private String goodsdescript;   //商品描述
    private BigDecimal goodsweight; //商品重量
    private Date addtime;           //添加时间
    private String state;           //订单项状态
    @Column(name = "totalPrice")
    private String totalPrice;      //总计金额
}
