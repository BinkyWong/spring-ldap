package com.alldaypa.security2.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Authentication object : {}", authentication.toString());
        log.info("Request principal : {}", authentication.getPrincipal());
        log.info("Authenticated? {} ", authentication.isAuthenticated());
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
//    public String loginAfterLogOut(@PathVariable String logout, Model model){
//        if (logout != null) {
//            model.addAttribute("message", "You have been logged out.");
//        }
//        return "login";
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.toString());
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/login?logout";
    }

}
