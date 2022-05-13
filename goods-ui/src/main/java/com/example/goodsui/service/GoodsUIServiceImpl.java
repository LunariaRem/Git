package com.example.goodsui.service;

import com.example.goodscommons.Vo.ResultVo;
import com.example.goodscommons.pojo.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsUIServiceImpl implements GoodsUIService{

    @Resource
    private RestTemplate restTemplate;
    @Override
    public void testGoodsProvider() {
        //1.url:调用服务的地址:应用名称和对应的映射url组合
        String object = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goods-provider返回的结果"+object);
    }

    @Override
    public List<Book> getBookList() {
        Book[] bookList = restTemplate.getForObject("http://goods-provider/provider/list",Book[].class);
        assert bookList != null;
        return Arrays.asList(bookList);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackBookDetail",commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    }//降级响应设置的时间
    )
    public ResultVo getBookDetail(Integer id){
        Book book = restTemplate.getForObject("http://goods-provider/provider/detail/" + id, Book.class);
        return ResultVo.ok(book);
    }
    public ResultVo fallBackBookDetail(Integer id){
        return ResultVo.error("服务降级返回的响应内容");
    }



    @Override
    public String addBook(Book book) {
        return restTemplate.postForObject("http://goods-provider/provider/add", book, String.class);
    }
}
