package com.example.goodsprovider.dao;

import com.example.goodscommons.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public interface GoodsDao {
    List<Book> getBookList();

    Book getBookDetail(Integer id);

    void addBook(Book book);
}
