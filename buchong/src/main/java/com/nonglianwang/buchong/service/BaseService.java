package com.nonglianwang.buchong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 基本的业务抽象类
 *
 * @param <T> 这是对Dao层的抽象泛型
 * @param <D> 这是对要操作的实体类的抽象泛型
 */


@Slf4j
public abstract class BaseService<T extends Mapper, D extends Object> {

    @Value(value = "${pagehelper.navigatePage}")
    Integer navigatePage;

    @Autowired
    T t;

    /**
     * 查询所有
     * @return
     */
    public List<D> selectAll() {
        return t.selectAll();
    }

    /**
     * 增加
     * @param d
     * @return
     */
    public D add(D d) {
        t.insert(d);
        return d;
    }

    /**
     * 当主键为任意类型时，执行删除操作
     * @return 被删除的对象
     */
    public D delete(Object id) {
        t.delete(id);
        return (D) t.selectByPrimaryKey(id);
    }

    /**
     * 修改
     * @param d
     * @return
     */
    public D update(D d) throws IllegalAccessException {
        t.updateByPrimaryKey(d);
        return d;
    }

    /**
     * 查询(根据对象中所有不为空的属性查值)
     * @param d
     * @return
     */
    public List<D> select(D d) throws NoSuchFieldException, IllegalAccessException {
        Example example = new Example(d.getClass());
        Field[] fields = d.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            if (field.get(d)!=null&&!"".equals(field.get(d))){
                example.createCriteria().andEqualTo(field.getName(), field.get(d));
            }
        }
        return t.selectByExample(example);
    }
    /**
     * 查询(根据对象中所有不为空的属性查值)
     * @param d
     * @return
     */
//    public PageInfo<D> selectAndPage(D d, Integer pageNum, Integer pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        List<D> ds = select(d);
//        PageInfo<D> pageInfo = new PageInfo<>(ds,navigatePage);
//        return pageInfo;
//    }


    /**
     * 查询所有并分页
     */
    public PageInfo<D> selectAllAndPage(){
        PageHelper.startPage(1, 5);
        List<D> ds = selectAll();
        PageInfo<D> pageInfo = new PageInfo<>(ds, navigatePage);
        return pageInfo;
    }
}
