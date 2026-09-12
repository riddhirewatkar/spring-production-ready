package com.springboot.ProductionReady.spring_production_ready.services;

import com.springboot.ProductionReady.spring_production_ready.dto.PostDTO;
import com.springboot.ProductionReady.spring_production_ready.entities.PostEntity;
import com.springboot.ProductionReady.spring_production_ready.exceptions.PostNotFoundException;
import com.springboot.ProductionReady.spring_production_ready.repositories.PostRepository;
import com.springboot.ProductionReady.spring_production_ready.services.impl.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPost() {
        List<PostEntity> postEntities = postRepository.findAll();
        return postEntities.stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundException("Post not found: " + id)
                );

        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        postEntity = postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundException("Post not found: " + id)
                );

        postDTO.setId(id);
        modelMapper.map(postDTO, postEntity);
        PostEntity savedPost = postRepository.save(postEntity);
        return modelMapper.map(savedPost, PostDTO.class);
    }

    @Override
    public void deletePostById(Long id) {
        isExist(id);
        postRepository.deleteById(id);
    }

    public void isExist(Long id) {
        boolean exists = postRepository.findById(id).isPresent();
        if(!exists){
            throw new PostNotFoundException("Post not found"+id);
        }
    }
}
