package com.spiderBookStall.RestService;

import com.spiderBookStall.CustomerDto.Book;

import java.util.List;

public interface BookRestApiService
{
    /** taking all the rest book json data from the server side  and Converting into object form using restTemplate
     * in client side
     * @return all the rest book data as object
     */
    public List<Book> getALLBookRestData();

    /**
     * @return book object
     */
    public  Book getBookById(String bookId);
}
