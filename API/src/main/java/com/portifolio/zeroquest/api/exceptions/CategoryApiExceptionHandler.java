package com.portifolio.zeroquest.api.exceptions;

import com.portifolio.zeroquest.domain.exceptions.EntityResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CategoryApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityResourceNotFoundException.class)
    public ResponseEntity<StandardErro> entityNotFoundException(EntityResourceNotFoundException e, HttpServletRequest request ){

        StandardErro err = new StandardErro();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        String requestURI = request.getRequestURI();
        String[] pathParts = requestURI.split("/");
        String id = pathParts[pathParts.length - 1];
        err.setError("API não encontrou o Recurso de id " + id);
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }



}
