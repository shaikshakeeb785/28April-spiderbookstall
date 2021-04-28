package com.spiderBookStall.RestController;
import com.spiderBookStall.CustomerDto.Book;
import com.spiderBookStall.RestService.BookRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookRestApiController
{
    @Autowired
    private BookRestApiService bookRestApiService;
    @RequestMapping("/getBookById")
    public String getBookByID(@RequestParam("bookId") String bookId,Model model)
    {

        model.addAttribute("bookObject1",bookRestApiService.getBookById(bookId));
        return "getBookByIdPage";
    }


}
