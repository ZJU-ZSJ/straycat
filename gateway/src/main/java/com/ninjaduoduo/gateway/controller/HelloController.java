package com.ninjaduoduo.gateway.controller;


import com.ninjaduoduo.common.response.Response;
import com.ninjaduoduo.user.api.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserTestService userTestService;

    @RequestMapping(method = RequestMethod.GET)
    public Response<String> test() {
        return userTestService.hello();
    }
}
