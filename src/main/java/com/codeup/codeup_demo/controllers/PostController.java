package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.models.User;
import com.codeup.codeup_demo.repo.PostRepository;
import com.codeup.codeup_demo.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }
//    List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public String seeAllPosts(Model viewModel){
        List<Post> postsFromDB = postDao.searchByBodyLike("post");

        viewModel.addAttribute("posts", postsFromDB);
        return "posts/index";
    }


    @GetMapping("/posts/${id}")
    public String showPost(@PathVariable long id , Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(Model viewModel){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            Model viewModel,
            @RequestParam("post_title") String title,
            @RequestParam("post_body") String body){
        User user = userDao.getOne(1);

        Post postToSave = new Post(title, body, user);

        postDao.save(postToSave);

        return "posts/index";
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

    @PostMapping("/posts/${id}/delete")
    @ResponseBody
    public String deletePost(@PathVariable Long id){
        postDao.deleteById(id);

        return "Post deleted!";
    }
}
