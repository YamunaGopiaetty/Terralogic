package com.example.Layout.Management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Layout.Management.dto.User;
import com.example.Layout.Management.dto.UserLayout;

public interface UserLayoutRepository extends JpaRepository<UserLayout, Long> {
    Optional<UserLayout> findByUser(User user);

}
