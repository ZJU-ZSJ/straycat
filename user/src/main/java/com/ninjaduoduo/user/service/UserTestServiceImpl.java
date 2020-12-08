package com.ninjaduoduo.user.service;

import com.ninjaduoduo.common.response.Response;
import com.ninjaduoduo.user.api.UserTestService;
import org.springframework.stereotype.Component;

@Component
public class UserTestServiceImpl implements UserTestService {

    public Response<String> hello() {
        return Response.buildSuccessResponse("user hello");
    }

}
