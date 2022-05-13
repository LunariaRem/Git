package com.example.goodsui.controller;

import com.example.goodscommons.Vo.ResultVo;
import com.example.goodscommons.pojo.Book;
import com.example.goodsui.service.GoodsUIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ui")
public class GoodsUIContorller {

    @Resource
    private GoodsUIService goodsUIService;

    /*
    测试goods-ui调用goods-provider
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        goodsUIService.testGoodsProvider();
        return "success";
    }

    /*
    查询所有图书
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Book> list() {
        return goodsUIService.getBookList();
    }

    /*
    根据id查询图书
     */
    @RequestMapping("/detail/{id}")
    public ResultVo detail(@PathVariable("id") Integer id) {
        return goodsUIService.getBookDetail(id);
    }

    /*
    添加图书
     */
    @PostMapping("/add")
    public String add(@RequestBody Book book) {
        return goodsUIService.addBook(book);
    }
}