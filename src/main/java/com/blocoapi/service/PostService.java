package com.blocoapi.service;

import com.blocoapi.dto.AtualizarTituloPost;
import com.blocoapi.dto.FavoritarPost;
import com.blocoapi.model.Post;

public interface PostService {
    public Post buscarPorUUID(String idPost);
    public Post atualizarPost(String idPost, Post post);
    public void deletarPost(String idPost);
    public Post favoritar(String idPost, FavoritarPost favoritarPost);
    public Post atualizarTitulo(String idPost, AtualizarTituloPost atualizarTituloPost);
}
