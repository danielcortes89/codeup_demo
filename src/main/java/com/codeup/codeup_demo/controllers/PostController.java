package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.models.User;
import com.codeup.codeup_demo.repo.PostRepository;
import com.codeup.codeup_demo.repo.UserRepository;
import com.codeup.codeup_demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController {
    @Autowired
    private EmailService emailService;

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }
//    List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public String seeAllPosts(Model viewModel){
        List<Post> postsFromDB = postDao.findAll();

        viewModel.addAttribute("posts", postsFromDB);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable String id, Model model){
        Long cleaned = Long.parseLong(id);

        model.addAttribute("post", postDao.getOne(cleaned));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @ModelAttribute Post post
            ){
        User user = userDao.getOne(1L);


        post.setOwner(user);
//        user.getPosts().add(post);

        postDao.save(post);

        emailService.prepareAndSend(post, "New Post!", "Go check our site to see it!");

        return "redirect:posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editAPost(@PathVariable Long id, Model model){
        Post oldPost = postDao.getOne(id);

        model.addAttribute("post", oldPost);

        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(
                            @PathVariable Long id,
                             @RequestParam("post_title") String title,
                             @RequestParam("post_body") String body){
        Post postToSave = new Post(title, body);

        postDao.save(postToSave);

        return "posts/index";
    }

    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String deletePost(@PathVariable Long id){
        postDao.deleteById(id);

        return "Post deleted!";
    }
}
