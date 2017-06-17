package com.fatesolo.dubbo.server.dao.impl;

import com.fatesolo.dubbo.api.bean.Book;
import com.fatesolo.dubbo.server.dao.BookDao;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BookDaoRedisImpl implements BookDao {

    @Resource
    private RedisTemplate<String, Book> redisTemplate;

    @Override
    public Book findById(int id) {
        return redisTemplate.opsForValue().get("book." + id);
    }

    @Override
    public List<Book> findAll() {
        return redisTemplate.opsForValue().multiGet(redisTemplate.keys("book.*"));
    }

    @Override
    public void save(Book book) {
        int id = redisTemplate.keys("book.*").size() + 1;

        book.setId(id);

        redisTemplate.opsForValue().set("book." + id, book);
    }

}
