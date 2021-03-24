package com.codeup.codeup_demo;

import com.codeup.codeup_demo.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class PostController {
//    @GetMapping("/posts")
//    @ResponseBody
//    public String seeAllPosts() {
//
//        return "posts index page";
//    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showOnePost(@PathVariable long id) {

        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPostForm() {

        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }

    @GetMapping("/post")

    public String showPost(Model viewModel){
        Post template = new Post("The Title!", "The Body");

        viewModel.addAttribute("post", template);
        return "posts/show";
    }

    @GetMapping("/posts")
    public String showHome(Model viewModel){
        Post template = new Post("The Title!", "The Body");
        Post templateTwo = new Post("Another Title!", "Another Body");

        List<Post> posts = new ArrayList<>();

        posts.add(template);
        posts.add(templateTwo);

        viewModel.addAttribute("posts", posts);
        return "posts/index";
    }
}
