package com.fatesolo.dubbo.server.service.impl;

import com.alibaba.dubbo.container.Main;
import com.fatesolo.dubbo.api.bean.Book;
import com.fatesolo.dubbo.api.service.BookService;
import com.fatesolo.dubbo.api.util.StringUtil;
import com.fatesolo.dubbo.server.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource(name = "bookDaoSimpleImpl")
    private BookDao bookDao;

    @Override
    public Book getBookById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.findAll();
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null || book.getId() != 0 || StringUtil.isBlank(book.getName())) {
            return false;
        }

        bookDao.save(book);
        return book.getId() != 0;
    }

    public static void main(String[] args) {
        Main.main(args);
    }

}
