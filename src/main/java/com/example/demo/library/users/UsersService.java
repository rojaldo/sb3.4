package com.example.demo.library.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private LibraryUsersRepository libraryUsersRepository;
    
    List<IUsersResponse> getUsers() {
        List<UserEntity> userEntities = libraryUsersRepository.findAll();
        return userEntitiesToDtos(userEntities);
    }

    IUsersResponse createUser(UserDto userDto) {
        //check if email already exists
        Optional<UserEntity> userEntityByEmail = libraryUsersRepository.findByEmail(userDto.getEmail());
        if (userEntityByEmail.isPresent()) {
            return UserErrorDto.builder()
                    .message("Email already exists")
                    .status(400)
                    .build();
        }
        UserEntity userEntity = userDtoEntity(userDto);
        UserEntity savedUserEntity = libraryUsersRepository.save(userEntity);
        return userEntityDto(savedUserEntity);
    }

    IUsersResponse updateUser(long id, UserDto userDto) {
        Optional<UserEntity> userEntityById = libraryUsersRepository.findById(id);
        if (!userEntityById.isPresent()) {
            return UserErrorDto.builder()
                    .message("User not found")
                    .status(404)
                    .build();
        }
        // check if email already exists
        Optional<UserEntity> userEntityByEmail = libraryUsersRepository.findByEmail(userDto.getEmail());
        if (userEntityByEmail.isPresent() && userEntityByEmail.get().getId() != id) {
            return UserErrorDto.builder()
                    .message("Email already exists")
                    .status(400)
                    .build();
        }
        UserEntity userEntity = userDtoEntity(userDto);
        userEntity.setId(id);
        UserEntity savedUserEntity = libraryUsersRepository.save(userEntity);
        return userEntityDto(savedUserEntity);
    }

    IUsersResponse deleteUser(long id) {
        Optional<UserEntity> userEntityById = libraryUsersRepository.findById(id);
        if (!userEntityById.isPresent()) {
            return UserErrorDto.builder()
                    .message("User not found")
                    .status(404)
                    .build();
        }
        libraryUsersRepository.deleteById(id);
        return this.userEntityDto(userEntityById.get());
    }

    List<IUsersResponse> userEntitiesToDtos (List<UserEntity> userEntities) {
        return userEntities.stream().map(userEntity -> UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .age(userEntity.getAge())
                .build()).collect(Collectors.toList());

    }

    List<UserEntity> dtosToUserEntities(List<UserDto> userDtos) {
        return userDtos.stream().map(userDto -> UserEntity.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .build()).collect(Collectors.toList());
    }

    UserDto userEntityDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .age(userEntity.getAge())
                .build();
    }

    UserEntity userDtoEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .build();
    }
}
