package com.testrestdoc.testrestdoc.controller;

import com.testrestdoc.testrestdoc.entity.Book;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * 用户创建某本图书 post /books/
 * 用户修改某本图书 put /books/:id/
 * 用户删除某本图书 delete /books/:id/
 * 用户获取所有图书 get /books
 * 用户获取某一图书 get /books/:id
 * Create by lirunmin on 2018/12/10
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    Map<Integer, Book> books;

    {
        books = Collections.synchronizedMap(new HashMap<Integer, Book>());
    }

    @ApiOperation(value = "获取图书列表",notes = "获取图书列表")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Book> getBook(){
        List<Book> book=new ArrayList<>(books.values());
        return book;
    }


    /**
     * @api {post} /books/
     * @apiDescription 这只是一个测试接口的描述
     * @apiName 添加书籍
     * @apiParam {Integer} id
     * @apiParam {String} name
     * @apiParamExample {json} Request-Example:
     * ?id=1&name=ttt
     * @apiGroup:books
     * @apiError CannotCreatException  <code>555</code>
     * @apiSampleRequest /books/
     */
    @ApiOperation(value = "创建图书",notes = "创建图书")
    @ApiImplicitParam(name = "book",value = "图书详细实体",required = true,dataType = "Book")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postBook(@RequestBody Book book){
        books.put(book.getId(), book);
        return "success";
    }

    @ApiOperation(value = "删除图书",notes = "根据url的id来删除图书")
    @ApiImplicitParam(name = "id",value = "图书ID",required = true,dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Integer id){
        books.remove(id);
        return "success";
    }

    @ApiOperation(value = "获取图书",notes = "根据url的id来获取图书")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiImplicitParam(name = "id",value = "图书ID",required = true,dataType = "Integer",paramType = "path")
    public Book getBook(@PathVariable Integer id){
        return books.get(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "图书ID",required = true,dataType = "Integer",paramType = "path"),
        @ApiImplicitParam(name = "book",value = "图书实体Book",required = true,dataType = "Book")
    })
    @ApiOperation(value = "更新图书",notes = "根据url中的id来更新图书")
    public String updateBook(@PathVariable Integer id,@RequestBody Book book){
        Book book1=books.get(id);
        book1.setName(book.getName());
        books.put(id, book1);
        return "success";
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String jsonTest(){
        return "hi , you";
    }
}
