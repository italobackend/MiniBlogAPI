package com.italobackend.miniblogapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GerenciadorExceptions {

    @ExceptionHandler(PostNaoEncontradoException.class)
    public ResponseEntity<ResponseError> PostNaoEncontrado(PostNaoEncontradoException postNaoEncontradoException) {
        ResponseError erro = new ResponseError(
                HttpStatus.NOT_FOUND.value(),
                "Post não encontrado",
                postNaoEncontradoException.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> erroGenerico(Exception exception) {
        ResponseError erro = new ResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno do servidor",
                "Ocorreu um erro inesperado no sistema."
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
