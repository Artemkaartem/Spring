package ru.gb.Spring_HW_4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello.html";
    }
}