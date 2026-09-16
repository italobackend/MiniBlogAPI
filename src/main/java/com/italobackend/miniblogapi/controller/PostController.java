package com.italobackend.miniblogapi.controller;

import com.italobackend.miniblogapi.dto.request.PostRequestDTO;
import com.italobackend.miniblogapi.dto.response.PostResponseDTO;
import com.italobackend.miniblogapi.entity.Post;
import com.italobackend.miniblogapi.repository.PostRepository;
import com.italobackend.miniblogapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO requestDTO) {
        Post postCreated = postService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(PostResponseDTO.entity(postCreated));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(@PathVariable Long id, @RequestBody PostRequestDTO requestDTO) {
        Post postUpdated = postService.updatePost(id, requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(PostResponseDTO.entity(postUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
