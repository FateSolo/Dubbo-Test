package com.fatesolo.dubbo.client.controller;

import com.fatesolo.dubbo.api.bean.Book;
import com.fatesolo.dubbo.api.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(HttpServletRequest request) {
        Object sessionInfo = request.getSession().getAttribute("info");

        if (sessionInfo == null) {
            request.getSession().setAttribute("info", "Session : " + request.getLocalAddr());
            return "No Session<br/>" + request.getLocalAddr();
        }

        return sessionInfo + "<br/>" + request.getLocalAddr();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/xml")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addBook(Book book) {
        return bookService.addBook(book) ? book.toString() : "Failure";
    }

}
