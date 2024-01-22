package com.world2meet.superHerosApi.domain.exception;

import org.apache.coyote.BadRequestException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase GlobalExceptionHandler que se encarga de manejar las excepciones a nivel global en la aplicación.
 * Utiliza la anotación @ControllerAdvice para manejar las excepciones de manera centralizada.
 *
 * @author davidmacar
 * @version 1.0
 * @since 2023.3.2
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones de tipo RuntimeException.
     * Devuelve un ResponseEntity con el mensaje de la excepción y un estado HTTP de error interno del servidor.
     *
     * @param e la excepción de tipo RuntimeException
     * @return ResponseEntity con el mensaje de la excepción y un estado HTTP de error interno del servidor
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Maneja las excepciones de tipo NotFoundException.
     * Devuelve un ResponseEntity con el mensaje "Recurso no encontrado" y un estado HTTP de no encontrado.
     *
     * @param e la excepción de tipo NotFoundException
     * @return ResponseEntity con el mensaje "Recurso no encontrado" y un estado HTTP de no encontrado
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>("Recurso no encontrado", HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja las excepciones de tipo BadRequestException.
     * Devuelve un ResponseEntity con el mensaje "Solicitud incorrecta" y un estado HTTP de solicitud incorrecta.
     *
     * @param e la excepción de tipo BadRequestException
     * @return ResponseEntity con el mensaje "Solicitud incorrecta" y un estado HTTP de solicitud incorrecta
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>("Solicitud incorrecta", HttpStatus.BAD_REQUEST);
    }

}