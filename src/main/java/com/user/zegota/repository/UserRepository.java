package com.user.zegota.repository;

import com.user.zegota.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User , Integer> {
    List<User> id(int id);

    List<User> id(int id);
}
