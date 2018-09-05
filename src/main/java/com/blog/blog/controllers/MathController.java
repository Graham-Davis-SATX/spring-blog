package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNums(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " plus " + num2 + " equals " + (num1 + num2);
    }

    @RequestMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subNums(@PathVariable int num1, @PathVariable int num2) {
        return num2 + " minus " + num1 + " equals " + (num2 - num1);
    }

    @RequestMapping("/multiply/{num1}/by/{num2}")
    @ResponseBody
    public String multNums(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " times " + num2 + " equals " + (num1 * num2);
    }

    @RequestMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divNums(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " divided " + num2 + " equals " + (num1 / num2);
    }
}