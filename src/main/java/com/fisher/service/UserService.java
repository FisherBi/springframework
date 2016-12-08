package com.fisher.service;

import com.fisher.model.User;
import com.fisher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
