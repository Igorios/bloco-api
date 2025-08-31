package com.blocoapi.service;

import com.blocoapi.model.Post;

public interface PostService {
    public Post buscarPorUUID(String idPost);
    public Post atualizarPost(String idPost, Post post);
}
