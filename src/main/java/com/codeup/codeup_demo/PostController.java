package com.codeup.codeup_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {

        return "Strings index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsIndex(@PathVariable long id) {

        return "Display page for post id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPosts() {

        return "Create Posts";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return "THis will handle the post";
    }
}
