package com.codeup.codeup_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @GetMapping("/add/{first}/and/{second}")
    @ResponseBody
    public double addNumbers(@PathVariable double first, @PathVariable double second) {

        return first + second;
    }

    @RequestMapping(path = "/subtract/{first}/from/{second}", method = RequestMethod.GET)
    @ResponseBody
    public double subtract(@PathVariable double first, @PathVariable double second) {
        return second - first;
    }

    @GetMapping("/multiply/{first}/and/{second}")
    @ResponseBody
    public double multiplyNumbers(@PathVariable double first, @PathVariable double second) {

        return first * second;
    }

    @GetMapping("/divide/{first}/by/{second}")
    @ResponseBody
    public double divideNumbers(@PathVariable double first, @PathVariable double second) {

        return first / second;
    }

}
