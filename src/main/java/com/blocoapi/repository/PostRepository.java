package com.blocoapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blocoapi.model.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {
    
}
