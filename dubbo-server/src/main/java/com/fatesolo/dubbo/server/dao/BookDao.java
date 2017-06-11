package com.fatesolo.dubbo.server.dao;

import com.fatesolo.dubbo.api.bean.Book;

import java.util.List;

public interface BookDao {

    Book findById(int id);

    List<Book> findAll();

    void save(Book book);

}
