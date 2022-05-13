package com.example.customerprovider.controller;

import com.example.customerprovider.Dao.CustomerDao;
import com.example.goodscommons.Vo.ResultVo;
import com.example.goodscommons.pojo.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerproviderConreoller {

    @Resource
    private CustomerDao customerDao;

    @RequestMapping("/list")
    public List<Customer> list(){
            return customerDao.getCustomerList();
    }

//    @RequestMapping("/detail")
//    public Customer detail(@RequestParam("id")Integer id){
//
//        return customerDao.getCustomerById(id);
//    }

    @RequestMapping("/detail")
    public ResultVo detail(@RequestParam("id")Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Customer customer = customerDao.getCustomerById(id);
        return ResultVo.ok(customer);
    }
}
