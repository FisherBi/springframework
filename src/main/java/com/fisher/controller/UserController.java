package com.fisher.controller;

import com.fisher.model.User;
import com.fisher.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by fisbii on 16-11-28.
 */
@Controller
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/addUser.html")
    public String goLoginPage() {
        return "addUser";
    }

    // 用户管理
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap modelMap){
        logger.info("get all users");
        // 找到user表里面的所有记录
        List<User> userList = userRepository.findAll();

        // 将所有的记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userList);

        // 返回pages目录下的userManage.jsp
        return "userManage";
    }
    // 添加用户处理
    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") User userEntity){
        // 向数据库添加一个用户
        //userRepository.save(userEntity);

        // 向数据库添加一个用户，并将内存中缓存区的数据刷新，立即写入数据库，之后才可以进行访问读取
        userRepository.saveAndFlush(userEntity);

        // 返回重定向页面
        return "redirect:/users";
    }


}
