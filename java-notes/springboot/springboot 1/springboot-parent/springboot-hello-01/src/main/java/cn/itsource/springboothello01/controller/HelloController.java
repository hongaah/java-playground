package cn.itsource.springboothello01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller 应用于 Thymeleaf
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("msg", "hello,Springboot");
        return "index";
    }
}
