package com.demo.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {
    @GetMapping("/notAuthorized")
    public String error(){
        return("NotAuthorized");
    }
}
