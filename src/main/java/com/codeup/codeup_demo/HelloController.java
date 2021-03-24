package com.codeup.codeup_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
class HelloController{

    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "Hello from the otherside!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name.toUpperCase());
        return "hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @GetMapping("/join")
    public String renderForm(){
        return "join";
    }

    @PostMapping("/join")
    public String submitForm(@RequestParam(name = "cohort") String cohort, Model viewModel){
        viewModel.addAttribute("welcomeMessage", "Welcome to " + cohort + "!");
        return "join";
    }
}
