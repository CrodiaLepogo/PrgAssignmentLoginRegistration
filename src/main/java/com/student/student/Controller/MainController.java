package com.student.student.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
   
    @GetMapping("")
    public String getRegisterPage(){

       return "index";
    }


}