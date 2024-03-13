package com.example.ecomerce.controller;

import com.example.ecomerce.service.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {



    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        model.addAttribute("username", "" );
        List<String> roles = SecurityUtils.getRolesOfUser();
        if (!CollectionUtils.isEmpty(roles) &&  roles.contains("manager")) {
            return "redirect:/manager/viewBooking";
        } else if(!CollectionUtils.isEmpty(roles) &&  roles.contains("admin")) {
            return "redirect:/admin/viewAccount";
        }
        return "home-user";
    }

    @RequestMapping("/login")
    public String loginPage(Model model, @RequestParam(value = "error", required = false) boolean error) {
        if (error) {
            model.addAttribute("message", "Login Fail!!!");
        }
        return "login";
    }


    @RequestMapping("/error")
    public String accessDenied(Model model) {
        return "error";
    }


}
