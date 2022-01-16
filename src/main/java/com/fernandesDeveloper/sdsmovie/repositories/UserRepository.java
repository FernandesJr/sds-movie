package com.fernandesDeveloper.sdsmovie.repositories;

import com.fernandesDeveloper.sdsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
