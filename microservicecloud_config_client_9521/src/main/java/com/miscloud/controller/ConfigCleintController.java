package com.miscloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigCleintController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping
    public String getConfigByGit(){
        return "applicationName = "+applicationName;
    }
}
