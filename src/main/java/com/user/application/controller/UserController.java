package com.user.application.controller;
import com.user.application.entity.User;
import com.user.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHome(Model model){

        List<User> user= userService.getUsers();
        model.addAttribute("user",user);

        return "index";
    }

    @GetMapping("/addUser")
    public String registerUser(){
        return "add_user";
    }

    @PostMapping("/register")
    public String userRegister(@ModelAttribute User user, HttpSession session){
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model){
        User user=userService.getUserById(id);
        model.addAttribute("user",user);
        return "edit";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user){
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return"redirect:/";
    }
    @GetMapping("/shop")
    public String goToShop(){
        return "shop";
    }
}
