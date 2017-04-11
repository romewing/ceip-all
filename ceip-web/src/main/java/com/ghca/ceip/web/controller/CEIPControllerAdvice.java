package com.ghca.ceip.web.controller;

/**
 * Created by gh on 2017/4/10.
 */

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@ControllerAdvice
public class CEIPControllerAdvice {


    @ModelAttribute
    public void modelAttribute(Principal principal) {

    }

    @ModelAttribute
    public void modelAttribute(HttpServletRequest httpRequest) {

    }
}
