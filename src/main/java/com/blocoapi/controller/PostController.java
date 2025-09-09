package com.blocoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blocoapi.dto.FavoritarPost;
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
    
    @PutMapping("/{idPost}")
    @ResponseStatus(HttpStatus.OK)
    public Post autualizarPost(@PathVariable String idPost, @RequestBody Post post) {
        return postService.atualizarPost(idPost, post);
    }
    
    @DeleteMapping("/{idPost}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarPost(@PathVariable String idPost) {
        postService.deletarPost(idPost);
    }
    
    @PatchMapping("/favoritar/{idPost}")
    @ResponseStatus(HttpStatus.OK)
    public Post favoritarPost(@PathVariable String idPost, @RequestBody FavoritarPost favoritarPost) {
        return postService.favoritar(idPost, favoritarPost);
    }

}
