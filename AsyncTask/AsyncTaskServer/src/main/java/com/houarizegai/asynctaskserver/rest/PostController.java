package com.houarizegai.asynctaskserver.rest;

import com.houarizegai.asynctaskserver.dao.PostRepository;
import com.houarizegai.asynctaskserver.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/add")
    public void addPost(@RequestParam String name, @RequestParam String comment) {
        postRepository.save(new Post(name, comment));
    }

    @GetMapping("/comments")
    public List<Post> getAll() {
        return postRepository.findAll();
    }

}
