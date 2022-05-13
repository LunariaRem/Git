package com.example.customerui.controller;

import com.example.customerui.feign.CustomerUIFeign;
import com.example.goodscommons.Vo.ResultVo;
import com.example.goodscommons.pojo.Customer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerUIController {

    @Resource
    private CustomerUIFeign customerUIFeign;


    @RequestMapping("/list")
    public List<Customer> list(){
        return customerUIFeign.getCustomerList();
    }


    @RequestMapping("/detail/{id}")
    public ResultVo detail(@PathVariable("id")Integer id){
        return customerUIFeign.getCustomerDetail(id);
    }
}
