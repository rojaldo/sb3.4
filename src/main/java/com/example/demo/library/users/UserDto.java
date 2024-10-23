package com.example.demo.library.users;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto implements IUsersResponse {

    private long id;

    @Size(min = 3, max = 50)
    private String name;

    //check that is a valid email
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Positive
    private int age;

    
}
