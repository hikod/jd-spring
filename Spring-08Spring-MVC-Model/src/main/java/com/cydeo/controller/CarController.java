package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car") //class level mapping
public class CarController {

    @RequestMapping("/info")
    public String showCarInfo(@RequestParam String make, Model model){

        model.addAttribute("make", make);

        return "/car/car-info";
    }
}
