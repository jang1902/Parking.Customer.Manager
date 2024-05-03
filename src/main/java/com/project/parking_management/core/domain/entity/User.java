package com.project.parking_management.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    @NotNull
    private String fullName;

    @Column(unique = true)
    private String phoneNumber;

    @Column
    private String address;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String identity;

}
