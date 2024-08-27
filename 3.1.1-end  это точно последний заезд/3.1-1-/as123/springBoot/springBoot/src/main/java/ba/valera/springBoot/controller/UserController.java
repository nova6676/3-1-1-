package ba.valera.springBoot.controller;


import ba.valera.springBoot.model.User;
import ba.valera.springBoot.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users";
    }

    @GetMapping("/new")
    public String newUserPage(@ModelAttribute("user") User user) {
        return "/addUser";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getUser(Model model, @RequestParam(value = "id") int id) {
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user.get());
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/del")
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
