package com.explorience.explorienceserver.service;

import com.explorience.explorienceserver.entity.User;
import com.explorience.explorienceserver.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shemin
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void updateById(User user1) {
        userRepository.save(user1);
    }
}
