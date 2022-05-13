package com.example.goodsprovider.service;

import com.example.goodscommons.pojo.Book;

import java.util.List;

public interface GoodsProviderService {
    List<Book> getBookList();

    Book getBookDetail(Integer id);

    void addBook(Book book);
}
