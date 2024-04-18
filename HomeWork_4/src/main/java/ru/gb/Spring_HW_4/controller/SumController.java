package ru.gb.Spring_HW_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumController {

    @GetMapping("/sum/{firstNum}/{secondNum}")
    public String getSum(@PathVariable("firstNum") int first,
                         @PathVariable("secondNum") int second,
                         Model model){
        model.addAttribute("firstNum", first);
        model.addAttribute("secondNum", second);
        model.addAttribute("sum", Integer.sum(first, second));
        return "sum";
    }

    @GetMapping("/sum")
    public String getSum2(@RequestParam("firstNum") Integer first,
                          @RequestParam("secondNum") Integer second,
                          Model model){
        model.addAttribute("firstNum", first);
        model.addAttribute("secondNum", second);
        model.addAttribute("sum", Integer.sum(first, second));
        return "sum";
    }
}
