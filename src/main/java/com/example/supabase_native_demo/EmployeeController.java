package com.example.supabase_native_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String form() {
        return "employee-form";
    }

    @PostMapping("/employees")
    public String submit(
            @RequestParam String name,
            @RequestParam String position,
            @RequestParam int yearsOfExperience
    ) {
        repository.save(
            new Employee(name, position, yearsOfExperience)
        );
        return "redirect:/";
    }
}
