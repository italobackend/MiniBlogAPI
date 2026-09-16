package com.italobackend.miniblogapi.dto.response;

import com.italobackend.miniblogapi.entity.Post;

public record PostResponseDTO(
        String titulo,
        String conteudo,
        String autor


) {
    public static PostResponseDTO entity(Post post) {
        return new PostResponseDTO(
                post.getTitulo(),
                post.getConteudo(),
                post.getAutor()
        );
    }
}
