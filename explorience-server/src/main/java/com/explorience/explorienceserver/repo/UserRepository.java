package com.explorience.explorienceserver.repo;

import com.explorience.explorienceserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
