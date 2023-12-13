package br.com.diego.handlerexception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.CommunicationException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CommunicationException.class)
    public ResponseEntity<String> handleCommunicationException(CommunicationException ex) {
        return ResponseEntity.status(500).body("Erro de comunicação com o servidor");
    }

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<String> handleCepNotFoundException(CepNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }


}
