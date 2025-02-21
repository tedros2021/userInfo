package com.TedrosGhebru.repo;

import com.TedrosGhebru.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
