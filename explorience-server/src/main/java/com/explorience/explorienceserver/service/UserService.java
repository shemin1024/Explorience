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

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
