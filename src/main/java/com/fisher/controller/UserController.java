package com.fisher.controller;

import com.fisher.model.User;
import com.fisher.repository.UserRepository;
import com.fisher.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    UserService userService;

    @RequestMapping(value = "/addUser")
    public String goLoginPage() {
        return "addUser";
    }

    // 用户管理
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap modelMap){
        logger.info("get all users");
        // 找到user表里面的所有记录
        List<User> userList = userService.getUserList();

        // 将所有的记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userList);

        // 返回pages目录下的userManage.jsp
        return "userManage";
    }
    // 添加用户处理
    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") User userEntity){
        userService.saveUser(userEntity);
        // 返回重定向页面
        return "redirect:/users";
    }

    // 查看用户详细信息
    // @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    // 例如：访问 localhost:8080/showUser/1 ，将匹配 userId = 1
    @RequestMapping(value = "/showUser/{userId}", method = RequestMethod.GET)
    public String showUser( @PathVariable("userId") Long userId, ModelMap modelMap ){
        User user = userService.getUserById(userId);
        modelMap.addAttribute("user", user);
        return "userDetail";
    }

    // 更新用户信息页面
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userId") Long userId, ModelMap modelMap){
        User user = userService.getUserById(userId);
        modelMap.addAttribute("user", user);
        return "updateUser";
    }
    // 处理用户修改请求
    @RequestMapping(value = "/updateUserPost", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("user") User userEntity){
        userService.updateUser(userEntity);
        return "redirect:/users";
    }

    // 删除用户
    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUserById(userId);
        return "redirect:/users";
    }


}
