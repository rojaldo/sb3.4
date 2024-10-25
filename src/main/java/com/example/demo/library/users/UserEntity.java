package com.example.demo.library.users;

import org.hibernate.validator.constraints.Length;

import com.example.demo.library.lends.LendEntity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private long id;

    @Length(min = 3, max = 50)
    private String name;

    @Column(unique = true, nullable = false, length = 50, updatable = true, insertable = true, name = "e-mail")
    private String email;

    private int age;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<LendEntity> lends;
}
