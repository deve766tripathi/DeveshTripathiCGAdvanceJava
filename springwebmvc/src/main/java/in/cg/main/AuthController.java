package in.cg.main;

import in.cg.model.User;
import in.cg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // show register page
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // process register
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "login";
    }

    // show login page
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // process login
    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        boolean valid = userService.validateUser(user);

        if (valid) {
            model.addAttribute("username", user.getUsername());
            return "success";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}