package com.nonglianwang.buchong.service;

import com.nonglianwang.buchong.commons.BaseResult;
import com.nonglianwang.buchong.dao.OrderManageDao;
import com.nonglianwang.buchong.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class OrderManagementService{

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private OrderManageDao orderManageDao;


    public BaseResult getAll(){
    //需要先从redis中获取uno,然后获取该用户订单
    Object user = redisTemplate.opsForValue().get("user");
        String[] split = ((String) user).split(",");
        String s = split[0];
        String[] split1 = s.split(new String("\\["));
        String[] split2 = split1[1].split("=");
        String s1 = split2[1];
        if (s1==null||"".equals(s1.trim())) {
            //未登陆
            return BaseResult.FAILED("未登陆");
        }else {
            Example example = new Example(Order.class);
            example.createCriteria().andEqualTo("buyerno", s1).andEqualTo("state","未下单");
            List<Order> orders = orderManageDao.selectByExample(example);
            return BaseResult.SUCCESS(orders);
        }
    }

    public BaseResult batchdelete(Map<String, Order> needBatchObject) {
        Iterator<Map.Entry<String, Order>> iterator = needBatchObject.entrySet().iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }
        return BaseResult.SUCCESS();
    }

    public BaseResult updateState(Order order) {
        Order order1=new Order();
        order1.setGoodsweight(order.getGoodsweight());
        Example example=new Example(Order.class);
        example.createCriteria().andEqualTo("ono", order.getOno());
        orderManageDao.updateByExampleSelective(order1, example);
        return BaseResult.SUCCESS();
    }

    public BaseResult submitOrders(Order[] orders) {
        Order temp;
        for (Order order : orders) {
            temp=new Order();
            temp.setOno(order.getOno());
            temp.setState("已提交");
            orderManageDao.updateByPrimaryKeySelective(temp);
        }
        return BaseResult.SUCCESS();
    }
}
