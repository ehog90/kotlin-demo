package com.bence.ujj.kotlindemo.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @RequestMapping("/com.bence.ujj.kotlindemo.showcase.echo")
    public String echoParam(@RequestParam(value = "name", defaultValue = "test") String name) {
        return name;
    }
}
