package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/mentor")
    public String mentor(Model model){
        Mentor mentor1 = new Mentor(1,"Mike", "Snow", 30,"MALE");
        Mentor mentor2 = new Mentor(1,"Liz", "Tyler", 28,"FEMALE");
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(mentor1);
        mentorList.add(mentor2);
        model.addAttribute("mentors",mentorList);
       return "/mentor/mentor";
    }
}
