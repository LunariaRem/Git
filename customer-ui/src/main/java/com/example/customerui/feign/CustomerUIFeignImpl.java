package com.example.customerui.feign;

import com.example.goodscommons.Vo.ResultVo;
import com.example.goodscommons.pojo.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUIFeignImpl implements CustomerUIFeign{
    @Override
    public List<Customer> getCustomerList() {
        return null;
    }

    @Override
    public ResultVo getCustomerDetail(Integer id) {
        return ResultVo.error("feign服务降级返回的响应内容");
    }
}
