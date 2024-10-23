package com.example.demo.library.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserErrorDto implements IUsersResponse {
    private String message;
    private String details;
    private int status;
    
}
