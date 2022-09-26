package com.mvc.mvc.mvc.controller;

import com.mvc.mvc.mvc.annotation.Controller;
import com.mvc.mvc.mvc.annotation.RequestMapping;
import com.mvc.mvc.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", UserRepository.findAll());
        return "home";
    }

}
