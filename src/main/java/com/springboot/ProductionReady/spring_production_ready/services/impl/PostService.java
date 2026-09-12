package com.springboot.ProductionReady.spring_production_ready.services.impl;

import com.springboot.ProductionReady.spring_production_ready.dto.PostDTO;
import com.springboot.ProductionReady.spring_production_ready.entities.PostEntity;
import com.springboot.ProductionReady.spring_production_ready.repositories.PostRepository;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPost();
    PostDTO getPostById(Long id);
    PostDTO createPost(PostDTO postDTO);
    PostDTO updatePost(Long id, PostDTO postDTO);
    void deletePostById(Long id);
}
