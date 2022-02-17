package com.krishna.wuapplication.controllers;
import com.krishna.wuapplication.models.User;
import com.krishna.wuapplication.services.AdminServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminServices adminServices;

    @GetMapping("/allUsers")
    public String showAllUsers(Model model){
        List<User> users=adminServices.getAllUsers();
        model.addAttribute("users",users);
        logger.info("Got list of all users...!");
        return "allUsers";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model){
        User users=adminServices.getUserById(id);
        model.addAttribute("users",users);
        return "Useredit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user){
        adminServices.addStudent(user);
        logger.info("User edit page...!");
        return "redirect:/admin/allUsers";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        adminServices.deleteById(id);
        logger.warn("User deleted successfully...!");
        return "redirect:/admin/allUsers";
    }


}
