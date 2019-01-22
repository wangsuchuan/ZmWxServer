package com.zm.controller;

import com.zm.servic.UserExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    @Autowired
    private UserExService userExService;

    @RequestMapping(value = "api/v1", method = RequestMethod.GET)
    public String v1() {
        Long id  = userExService.insertUserExInfo();
        return String.valueOf(id);
    }

}
