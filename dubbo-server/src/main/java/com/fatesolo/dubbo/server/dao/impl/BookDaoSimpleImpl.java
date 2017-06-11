package com.fatesolo.dubbo.server.dao.impl;

import com.fatesolo.dubbo.api.bean.Book;
import com.fatesolo.dubbo.server.dao.BookDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookDaoSimpleImpl implements BookDao {

    private final Map<Integer, Book> map = new ConcurrentHashMap<>();

    @Override
    public Book findById(int id) {
        return map.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(Book book) {
        int id = map.size() + 1;

        book.setId(id);
        map.put(id, book);
    }

}
