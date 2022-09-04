package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){
        model.addAttribute("firstName", "John");
        model.addAttribute("lastName", "Doe");

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(10);
        list.add(1);
        model.addAttribute("numbers", list);

        Student student = new Student(1, "Jane", "Doe");
        model.addAttribute("student",student);

        return "student/welcome";
    }
}
