package com.student.student.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.student.Model.AdminModel;
import com.student.student.Service.AdminService;
import com.student.student.Service.StudService;




@Controller
public class AdminController {
   
    @Autowired
    private AdminService adminService;

    @Autowired
    private StudService studservice;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/Admin_Portal")
    public String homepage(){
        
        return "AdminPort";
    }


    @GetMapping("/Admin/register")
    public String getRegisterPage(Model model){
        model.addAttribute("AdminregisterRequest",new AdminModel());
        return "admin_register_page";
    }

    @GetMapping("/Admin/login")
    public String getLoginPage(Model model){
        model.addAttribute("AdminloginRequest",new AdminModel()); 
        return "admin_login_page";
    }

    @PostMapping("/Admin/register")
    public  String register(@ModelAttribute AdminModel adminModel,Model model){
        System.out.println("register request: "+ adminModel);
        AdminModel registeredUser=adminService.registerAdmin(adminModel.getName(), adminModel.getEmail(), adminModel.getPassword());
         return registeredUser==null ? "admin_error_page" : "redirect:/Admin/login";
    }




    @PostMapping("/Admin/login")
    public  String login(@ModelAttribute AdminModel adminModel,Model model){
        System.out.println("login request: "+adminModel);
        AdminModel authenticated=adminService.authenticate(adminModel.getName(),adminModel.getPassword());
        if(authenticated !=null){
            model.addAttribute("userLogin",authenticated.getName());
            model.addAttribute("name",authenticated.getName());
            model.addAttribute("contact",authenticated.getEmail());
            model.addAttribute("ListOfStudent",studservice.getAllStudent());
            return "admin_Dash_page";

        }else {
            return "admin_error_page";
        }
    }


}