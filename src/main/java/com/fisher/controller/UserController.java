package com.fisher.controller;

import com.fisher.model.User;
import com.fisher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fisbii on 16-11-28.
 */
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user")
    public ModelAndView all() {
        ModelAndView model = new ModelAndView("user-list");

        model.addObject( "users", userRepository.findAll() );
        model.addObject( "user-instance", new User() );
        return model;
    }

    @RequestMapping("/user/insert" )
    public String insert( User user ) {

        this.userRepository.save( user );

        return "user-list";
    }

}
