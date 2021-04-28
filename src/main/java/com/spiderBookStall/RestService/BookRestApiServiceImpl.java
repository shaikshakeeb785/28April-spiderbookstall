package com.spiderBookStall.RestService;

import com.spiderBookStall.CustomerDto.Book;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookRestApiServiceImpl implements BookRestApiService {
    private RestTemplate restTemplate;
    @Override
    public List<Book> getALLBookRestData() {
        String url= "http://localhost:8081/SpiderBookStore_war_exploded/getAllBooksjson";
        ResponseEntity<Book[]> responseEntity= restTemplate.getForEntity(url,Book[].class);
        if(responseEntity.getBody()!=null)
        {
            return  Arrays.asList(responseEntity.getBody());
        }
        return  Collections.emptyList();
    }

    @Override
    public Book getBookById(String bookId) {
        String url="http://localhost:8081/SpiderBookStore_war_exploded/getByIdjsondata?bookId="+bookId;
       Book book= restTemplate.getForObject(url,Book.class);
        return book;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    @Required
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
