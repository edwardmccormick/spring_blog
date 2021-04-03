package com.codeup.springboot_blog.controllers;

import com.codeup.springboot_blog.daos.UserRepository;
import com.codeup.springboot_blog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile/{username}/edit")
    public String profileEditRender(@PathVariable String username, Model model) {
        User loggedin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.findByUsername(loggedin.getUsername()));
        return "users/edit";
    }

    @PostMapping("profile/{username}/edit")
    public String profileEditSave(@ModelAttribute User user, @PathVariable String username, Model model) {
        userDao.save(user);
        return "redirect:/user/" + user.getUsername();
    }
}