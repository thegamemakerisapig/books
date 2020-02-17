package work.books.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello1(){
        return "markdown";
    }

    @PostMapping("/hello")
    public String hello2(){
        return "hello";
    }
}