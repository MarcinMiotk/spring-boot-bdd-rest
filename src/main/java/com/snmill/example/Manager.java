package com.snmill.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class Manager {

    @Value("${name}")
    private String name;

    @RequestMapping("/manager/name")
    @ResponseBody
    String name() {
        return "Hello World " + name;
    }
}
