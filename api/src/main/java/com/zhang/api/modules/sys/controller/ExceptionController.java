package com.zhang.api.modules.sys.controller;

import javax.servlet.http.HttpServletRequest;
import com.zhang.api.utils.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//统一异常处理器
@RestControllerAdvice
public class ExceptionController {


    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R globalException(HttpServletRequest request, Throwable ex) {
        return new R().error(getStatus(request).value(),ex.toString());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
    	System.out.println("getstatus-------");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}

