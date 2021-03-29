package com.codeup.codeup_demo.repo;

import com.codeup.codeup_demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleEquals(String titleToSearchFor);


    List<Post> searchByBodyLike(String post);
}
