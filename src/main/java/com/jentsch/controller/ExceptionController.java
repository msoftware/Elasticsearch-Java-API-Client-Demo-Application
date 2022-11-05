package com.jentsch.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ExceptionController extends AbstractErrorController {

    public ExceptionController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        throw new RuntimeException(getErrorMessage(request));
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        throw new RuntimeException(getErrorMessage(request));
    }

    private String getErrorMessage(HttpServletRequest request) {
        Object code = request.getAttribute("javax.servlet.error.status_code");
        Object exceptionType = request.getAttribute("javax.servlet.error.exception_type");
        Object message = request.getAttribute("javax.servlet.error.message");
        Object path = request.getAttribute("javax.servlet.error.request_uri");
        Object exception = request.getAttribute("javax.servlet.error.exception");

        return String.format("code: %s,exceptionType: %s,message: %s,path: %s,exception: %s",
                code, exceptionType, message, path, exception);
    }
}
