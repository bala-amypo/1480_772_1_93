// package com.example.demo.exception;

// public class ResourceNotFoundException
//         extends RuntimeException {

//     public ResourceNotFoundException(String message) {
//         super(message);
//     }
// }


package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception representing “not found” conditions (Requirement 5.1)
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}