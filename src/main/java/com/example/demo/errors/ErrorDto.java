package com.example.demo.errors;

import com.example.demo.library.books.IBookResponse;
import com.example.demo.library.lends.ILendResponse;
import com.example.demo.library.users.IUsersResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto implements IBookResponse, IUsersResponse, ILendResponse {
        
        private String message;
        private String stackTrace;
        private int status;
    
}
