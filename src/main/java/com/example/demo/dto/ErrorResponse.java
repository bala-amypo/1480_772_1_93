// package com.example.demo.dto;

// public class ErrorResponse {
//     private String message;

//     public ErrorResponse() {}
//     public ErrorResponse(String message) { this.message = message; }

//     public String getMessage() { return message; }
//     public void setMessage(String message) { this.message = message; }
// }




package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}