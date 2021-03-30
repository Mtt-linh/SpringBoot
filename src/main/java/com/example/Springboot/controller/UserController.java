package com.example.Springboot.controller;

import com.example.Springboot.entity.User;
import com.example.Springboot.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class UserController {
    @Autowired
    UserRespository userRespository;
    @RequestMapping("/")
    public  String index(Model model){
        List<User> users = (List<User>) userRespository.findAll();
        model.addAttribute("users",users);
        return "index";
    }
    @RequestMapping(value = "add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return  "addUser";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user){
        userRespository.save(user);
        return "redirect:/";

    }
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public  String editUser(@RequestParam("id" ) Long userId , Model model){
        Optional<User> userEdit = userRespository.findById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user",user));
        return "editUser";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public  String deleteUser(@RequestParam("id") Long userId,Model model){
        userRespository.deleteById(userId);
        return "redirect:/";
    }
}
