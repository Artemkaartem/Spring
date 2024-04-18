package ru.gb.Spring_HW_4.controller;

import ru.gb.Spring_HW_4.services.StudentService;
import ru.gb.Spring_HW_4.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/student")
    public String getStudents(Model model) {
        service.getAllStudents();
        model.addAttribute("students", service.getAllStudents());
        return "student";
    }

    @PostMapping("/student")
    public String addStudent(Student student, Model model) {
        service.addStudent(student);
        model.addAttribute("students", service.getAllStudents());
        return "student";
    }
}