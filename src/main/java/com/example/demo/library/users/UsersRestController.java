package com.example.demo.library.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/library")
public class UsersRestController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<IUsersResponse>> getMethodName() {
        return ResponseEntity.
        status(HttpStatus.OK).
        body(usersService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<IUsersResponse> postMethodName(@RequestBody @Validated UserDto userDto) {
        // check if is UserErrorDto
        IUsersResponse user = usersService.createUser(userDto);
        if (user instanceof UserErrorDto) {
            // add details to UserErrorDto
            UserErrorDto userError = (UserErrorDto) user;
            userError.setDetails("The email provided was: " + userDto.getEmail());
            return ResponseEntity.
            status(HttpStatus.BAD_REQUEST).
            body(user);
        }
        return ResponseEntity.
        status(HttpStatus.CREATED).
        body(user);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<IUsersResponse> putMethodName(@PathVariable long id, @RequestBody @Validated UserDto userDto) {
        // if id<0 return not found
        if (id < 0) {
            return ResponseEntity.
            status(HttpStatus.NOT_FOUND).
            body(UserErrorDto.builder().message("User not found").details( "The id provided was: " + id).build());
        }
        
        //check if is UserErrorDto
        IUsersResponse user = usersService.updateUser(id, userDto);
        if (user instanceof UserErrorDto) {
            // add details to UserErrorDto
            UserErrorDto userError = (UserErrorDto) user;
            userError.setDetails("The email provided was: " + userDto.getEmail());
            return ResponseEntity.
            status(userError.getStatus()).
            body(user);
        }

        return ResponseEntity.
        status(HttpStatus.OK).
        body(user);

    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<IUsersResponse> deleteMethodName(@PathVariable long id) {
        // if id<0 return not found
        if (id < 0) {
            return ResponseEntity.
            status(HttpStatus.NOT_FOUND).
            body(UserErrorDto.builder().message("User not found").details( "The id provided was: " + id).build());
        }
        IUsersResponse user = usersService.deleteUser(id);
        if (user instanceof UserErrorDto) {
            return ResponseEntity.
            status(HttpStatus.NOT_FOUND).
            body(user);
        }
        return ResponseEntity.
        status(HttpStatus.OK).
        body(user);
    }
    
    
    
}
