package com.mvc.di;

import com.mvc.di.annotation.Controller;
import com.mvc.di.annotation.Inject;

@Controller
public class UserController {

    private UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

}
