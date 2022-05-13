package com.example.customerprovider.Dao;


import com.example.goodscommons.Vo.ResultVo;
import com.example.goodscommons.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CustomerDao {
    List<Customer> getCustomerList();

    void add(Customer customer);

    void deleteBatch(@Param("ids") Integer[] ids);

    Customer getCustomerDetail(Integer id);

    Customer getCustomerById(Integer id);
}
