package com.example.supabase_native_demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("employees")
public class Employee {

    @Id
    private Long id;

    @Column("name")
    private final String name;

    @Column("position")
    private final String position;

    @Column("years_of_experience")
    private final int yearsOfExperience;

    public Employee(String name, String position, int yearsOfExperience) {
        this.name = name;
        this.position = position;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Long getId() {
        return id;
    }
}
