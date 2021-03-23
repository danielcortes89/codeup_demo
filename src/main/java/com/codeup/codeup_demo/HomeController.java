package com.codeup.codeup_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String Home(){
        return "This is the landing!";
    }
}
