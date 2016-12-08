package com.fisher.service;

import com.fisher.model.User;
import com.fisher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fisbii on 16-12-8.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        userRepository.saveAndFlush(user);
    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findOne(id);
    }

    public void updateUser(User user){
        userRepository.saveAndFlush(user);
    }

    public void deleteUserById(Long id){
        userRepository.delete(id);
        userRepository.flush();
    }
}
