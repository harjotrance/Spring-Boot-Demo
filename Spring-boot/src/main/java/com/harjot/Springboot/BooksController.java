package com.harjot.Springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController {
    @GetMapping("/books")
    public List<Books> getAllBook()

    {
        return Arrays.asList(new Books(34,"Dawn of midknight","Galardo gabreal"));
    }


}
