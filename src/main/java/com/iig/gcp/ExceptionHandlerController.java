package com.iig.gcp;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
            ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
           
        mav.addObject("datetime", new Date());
        mav.addObject("exception", e.getClass().getCanonicalName());
        mav.addObject("url", request.getRequestURL());
        return mav;
    }
}
