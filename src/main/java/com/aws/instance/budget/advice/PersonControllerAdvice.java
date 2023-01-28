package com.aws.instance.budget.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aws.instance.budget.exception.NoPersonException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class PersonControllerAdvice {

    @ExceptionHandler(value = NoPersonException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleNoPersonException(NoPersonException npe) {
        log.info("Handling No Person Exception In Advice", npe);
        return new ResponseEntity<>("Wrong Person Id", HttpStatus.BAD_REQUEST);
    }
}
