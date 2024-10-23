package com.example.demo.library.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryUsersRepository extends JpaRepository<UserEntity, Long> {
    
    UserEntity findByName(String name);
    
    Optional<UserEntity> findByEmail(String email);
    
    UserEntity findByNameOrEmail(String name, String email);
    
    List<UserEntity> findByIdIn(List<Long> userIds);
    
    Boolean existsByName(String name);
    
    Boolean existsByEmail(String email);
    
    List<UserEntity> findAll();
    
    List<UserEntity> findByNameContaining(String subString);
    
    
}
