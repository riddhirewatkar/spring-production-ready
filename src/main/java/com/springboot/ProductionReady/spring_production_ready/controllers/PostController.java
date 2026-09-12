package com.springboot.ProductionReady.spring_production_ready.controllers;

import com.springboot.ProductionReady.spring_production_ready.dto.PostDTO;
import com.springboot.ProductionReady.spring_production_ready.services.impl.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPost()
    {
        return ResponseEntity.ok(postService.getAllPost());
    }

    @GetMapping(path = "/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long postId)
    {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO)
    {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @PutMapping(path = "/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.updatePost(postId, postDTO));
    }
}
