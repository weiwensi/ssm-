package com.soecode.lyf.bookuserservice.controller;

import com.soecode.lyf.bookuserservice.pojo.Book;
import com.soecode.lyf.bookuserservice.service.BookService;
import com.soecode.lyf.exception.ParamInvalidException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(value = "swagger测试测试")
@RequestMapping("/book")
public class BookController {


    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(notes = "获取所有的书", value = "获取所有的书", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Book> list() throws ParamInvalidException {
      /* if(1==1){
           throw new ParamInvalidException("异常处理成功");
       }*/
      /*String  str=null;
      str.toString();*/
        List<Book> list = bookService.getList();
        return list;
    }

    @GetMapping(value = "/detail/{bookId}/{userName}")
    @ApiOperation(value = "根据书的id获取书的详情", notes = "根据书的id获取书的详情", produces = MediaType.APPLICATION_JSON_VALUE)
    private Book detail(@PathVariable("bookId") Long bookId,@PathVariable("userName") String  userName ){
        Book book = bookService.getById(bookId, userName);
        return book;
    }

    public static String buildSuccessResultStr(Object result) {
        if (null == result) {
            return "{\"msg\": \"success\",\"code\": " + 200 + ",\"result\":  " + result + "}";
        }
        return "{\"msg\": \"success\",\"code\": " + 200 + ",\"result\": \"" + result.toString().replaceAll("\"","\\\"") + "\"}";
    }




    @GetMapping(value = "/test")
    @ApiOperation(value = "ceshi", notes = "测试", produces = MediaType.APPLICATION_JSON_VALUE)
    public  String test( ){

        String ss = "\"sadas\"";
        String  str="fdgdgdr";
        String s = buildSuccessResultStr(str.replaceAll("\"", "\\\\\""));
        System.out.println(s);
        return   s;
    }

}
