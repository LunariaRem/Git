package com.example.goodsui.service;

import com.example.goodscommons.Vo.ResultVo;
import com.example.goodscommons.pojo.Book;

import java.util.List;

public interface GoodsUIService {
    void testGoodsProvider();

    List<Book> getBookList();

    ResultVo getBookDetail(Integer id);

    String addBook(Book book);
}
