package com.ING.Job.controllers;

import com.ING.Job.entities.UserEntity;
import com.ING.Job.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(path = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(path = "/login/getusers")
    public String getLoginPage(Model model) {
        List<UserEntity> usersList = userService.userL();
        model.addAttribute("usersL", usersList);
        return "/index";
    }

    @GetMapping(path = "/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register/add")
    public String getRegisterPage(@ModelAttribute UserEntity newUser) {
        userService.addCustomer(newUser);
        return "redirect:/login";
    }

}
