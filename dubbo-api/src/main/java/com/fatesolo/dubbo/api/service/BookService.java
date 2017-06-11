package com.fatesolo.dubbo.api.service;

import com.fatesolo.dubbo.api.bean.Book;

import java.util.List;

public interface BookService {

    Book getBookById(int id);

    List<Book> getBooks();

    boolean addBook(Book book);

}
