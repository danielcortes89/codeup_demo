package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
    List<Post> posts = new ArrayList<>();

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
    public String seeAllPosts(Model viewModel){
//        Post template = new Post("The Title!", "The Body");
//        Post templateTwo = new Post("Another Title!", "Another Body");
//
//        posts.add(template);
//        posts.add(templateTwo);
        List<Post> postsFromDB = postDao.findAll();

        viewModel.addAttribute("posts", postsFromDB);
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String createAPost(Model viewModel){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            Model viewModel,
            @RequestParam("post_title") String title,
            @RequestParam("post_body") String body){
        Post postToSave = new Post(title, body);

        postDao.save(postToSave);

        return "posts/index";
    }

//    @GetMapping("/posts/create")
//    public String createAPost(Model viewModel){
//        return "posts/create";
//    }

    @GetMapping("/posts/{id}/edit")
    public String editAPost(@PathVariable Long id, Model model){
        Post oldPost = postDao.getOne(id);

        model.addAttribute("oldPost", oldPost);

        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(
                            @PathVariable Long id,
                            Model viewModel,
                             @RequestParam("post_title") String title,
                             @RequestParam("post_body") String body){
        Post postToSave = new Post(title, body);

        postDao.save(postToSave);

        return "posts/index";
    }
}
