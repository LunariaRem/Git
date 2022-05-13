package com.example.goodsprovider.controller;

import com.example.goodscommons.pojo.Book;
import com.example.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderContorller {

    @Resource
    private GoodsProviderService goodsProviderService;
    /*
    测试goodsui调用是否成功
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("成功进入provider");
        return "调用成功";
    }

    /*
    返回所有图书
     */
    @RequestMapping("/list")
    public List<Book> getBookList(){
        List<Book> bookList = goodsProviderService.getBookList();
        return bookList;
    }

    /*
    根据id查询
     */
    @RequestMapping("/detail/{id}")
    public Book detail(@PathVariable("id")Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return goodsProviderService.getBookDetail(id);

    }

    /*
    添加图书
     */
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        goodsProviderService.addBook(book);
        return "success";
    }


    /*

     */
    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),//服务错误率

    })
    @RequestMapping("/test_hystrix")
    public String testHytrix(@RequestParam("num")Integer num){
        int n = (int)Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回结果：n = "+n+"/"+num+"="+result;
    }
    public String fallback(@RequestParam("num")Integer num){
        return "服务降级响应：num为0";
    }
}
