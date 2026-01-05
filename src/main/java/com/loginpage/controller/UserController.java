package com.loginpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginpage.model.User;
import com.loginpage.repo.UserRepo;
import com.loginpage.vo.LoginRequest;

@Controller
public class UserController {

	@Autowired
	private UserRepo userRepo; 
	
    @GetMapping("/")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "loginPage"; // lowercase, consistent
    }

    @PostMapping("/loginUser")
    public String loginUser(
            @ModelAttribute("loginRequest") LoginRequest loginRequest,
            Model model) {

        User user = userRepo.findByUsernameAndPassword(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );

        if (user != null) {
            model.addAttribute("msg", "Hi " + loginRequest.getUsername());
            return "success";
        }

        model.addAttribute("msg", "Please enter correct username & password");
        return "loginPage";
    }

	
}
