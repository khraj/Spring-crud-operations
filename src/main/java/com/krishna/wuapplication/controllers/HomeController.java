package com.krishna.wuapplication.controllers;

import com.krishna.wuapplication.models.Student;
import com.krishna.wuapplication.models.User;
import com.krishna.wuapplication.services.AdminServices;
import com.krishna.wuapplication.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private StudentServices studentServices;
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/")
    public String home(Model model){
        List<Student> student=studentServices.getAllStudents();
        model.addAttribute("student",student);
        return "index";
    }
    @GetMapping("/addStudent")
    public String addStudent(){
        return "add_student";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Student student){
        studentServices.addStudent(student);
        return "redirect:/";
    }
    @GetMapping("/sign_up")
    public String signUp(){
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute User user){
        String password= user.getPassword();
        String encryptpwd=passwordEncoder.encode(password);
        user.setPassword(encryptpwd);
        adminServices.save(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id,Model model){
        Student student=studentServices.getStudentById(id);
        model.addAttribute("student",student);
        return "edit";
    }
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student){
        studentServices.addStudent(student);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentServices.deleteById(id);
        return "redirect:/";
    }

}
