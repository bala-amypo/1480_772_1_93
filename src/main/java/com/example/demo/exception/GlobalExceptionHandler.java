// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.Map;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     @ResponseStatus(HttpStatus.NOT_FOUND)
//     public Map<String, String> handleNotFound(
//             ResourceNotFoundException ex) {

//         Map<String, String> error = new HashMap<>();
//         error.put("message", ex.getMessage());
//         return error;
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public Map<String, String> handleBadRequest(
//             IllegalArgumentException ex) {

//         Map<String, String> error = new HashMap<>();
//         error.put("message", ex.getMessage());
//         return error;
//     }
// }


package com.example.demo.exception;

import com.example.demo.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse err = new ErrorResponse(LocalDateTime.now(), 404, "Not Found", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())); // Fixed: .put instead of .add
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobal(Exception ex, WebRequest request) {
        ErrorResponse err = new ErrorResponse(LocalDateTime.now(), 500, "Internal Error", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}