package com.example.supabase_native_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String form(@RequestParam(required = false) String success, Model model) {
        model.addAttribute("success", success);
        return "employee-form";
    }

    @PostMapping("/employees")
    public String submit(
            @RequestParam String name,
            @RequestParam String position,
            @RequestParam int yearsOfExperience
    ) {
        repository.save(new Employee(name, position, yearsOfExperience));
        // Redirect with success query parameter
        return "redirect:/?success=Employee+added+successfully!";
    }
}