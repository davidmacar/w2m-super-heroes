package com.world2meet.superHeroesApi.domain.utils;

import java.util.logging.Logger;
import org.apache.coyote.BadRequestException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        Logger.getLogger("GlobalExceptionHandler").info("GlobalExceptionHandler: " + e.getMessage());
        return new ResponseEntity<>("RuntimeException in SuperHeroesApi: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        Logger.getLogger("GlobalExceptionHandler").info("GlobalExceptionHandler: " + e.getMessage());
        return new ResponseEntity<>("Resource not found in SuperHeroesApi", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException e) {
        Logger.getLogger("GlobalExceptionHandler").info("GlobalExceptionHandler: " + e.getMessage());
        return new ResponseEntity<>("Incorrect entry parameters in SuperHeroesApi", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SuperHeroServiceException.class)
    public ResponseEntity<String> handleSuperHeroServiceException(SuperHeroServiceException e) {
        Logger.getLogger("GlobalExceptionHandler").info("GlobalExceptionHandler: " + e.getMessage());
        return new ResponseEntity<>("Error found in service of SuperHeroesApi", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}