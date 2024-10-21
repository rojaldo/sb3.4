package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloWorldController {

    @GetMapping("/greeting")
    public String helloWorld(
            @RequestParam(name="msg", required=false, defaultValue="Hola Mundo!") String message,
            @RequestParam(name="num", required=false, defaultValue="3.0") float num,
            Model view) {
        view.addAttribute("my_msg", message);
        return "hello";
    }

    
}
