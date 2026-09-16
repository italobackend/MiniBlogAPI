package com.italobackend.miniblogapi.dto.request;

public record PostRequestDTO(
        String titulo,
        String conteudo,
        String autor
) {
}
