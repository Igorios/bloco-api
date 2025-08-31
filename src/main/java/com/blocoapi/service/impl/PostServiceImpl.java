package com.blocoapi.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blocoapi.model.Post;
import com.blocoapi.repository.PostRepository;
import com.blocoapi.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post buscarPorUUID(String idPost) {

        UUID uuid = UUID.fromString(idPost);
        Optional<Post> postOptional = postRepository.findById(uuid);

        if (!postOptional.isPresent()) {
            throw new RuntimeException("Não foi possivel encontrar esse post!");
        }

        Post postEncontrada = postOptional.get();
        return postEncontrada;

    }

    @Override
    public Post atualizarPost(String idPost, Post post) {

        UUID uuid = UUID.fromString(idPost);

        Optional<Post> postOptional = postRepository.findById(uuid);

        if (!postOptional.isPresent()) {
            throw new RuntimeException("Não foi possivel encontrar essa categoria");
        }

        Post postExistente = postOptional.get();
        BeanUtils.copyProperties(post, postExistente, "idPost", "categoria");

        return postRepository.save(postExistente);

    }
    
}
