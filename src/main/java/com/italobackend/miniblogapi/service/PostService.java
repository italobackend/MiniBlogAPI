package com.italobackend.miniblogapi.service;

import com.italobackend.miniblogapi.dto.request.PostRequestDTO;
import com.italobackend.miniblogapi.entity.Post;
import com.italobackend.miniblogapi.exceptions.PostNaoEncontradoException;
import com.italobackend.miniblogapi.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post create(PostRequestDTO postDto) {

        Post post = new Post();

        post.setAutor(postDto.titulo());
        post.setConteudo(postDto.conteudo());
        post.setTitulo(postDto.titulo());

        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, PostRequestDTO postDto) {
        Post postUpdated = postRepository.findById(id)
                .orElseThrow(() -> new PostNaoEncontradoException("Post com o ID: " + id + " não encontrado para atualizar!"));

        postUpdated.setTitulo(postDto.titulo());
        postUpdated.setConteudo(postDto.conteudo());
        postUpdated.setAutor(postDto.autor());

        return postRepository.save(postUpdated);
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNaoEncontradoException("Post com o ID: " + id + "não encontrado!"));
    }
}
