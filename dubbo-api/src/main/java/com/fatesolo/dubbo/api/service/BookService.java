package com.fatesolo.dubbo.api.service;

import com.fatesolo.dubbo.api.bean.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BookService {

    @GET
    @Path("/{id}")
    Book getBookById(@PathParam("id") int id);

    @GET
    @Path("/")
    List<Book> getBooks();

    @POST
    @Path("/")
    Boolean addBook(Book book);

}
