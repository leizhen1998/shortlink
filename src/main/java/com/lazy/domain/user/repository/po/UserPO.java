package com.lazy.domain.user.repository.po;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 255)
    private String username;
}
