package com.blocoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blocoapi.model.Post;
import com.blocoapi.service.PostService;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/{idPost}")
    @ResponseStatus(HttpStatus.OK)
    public Post buscarPost(@PathVariable String idPost) {
        return postService.buscarPorUUID(idPost);
    }

}
