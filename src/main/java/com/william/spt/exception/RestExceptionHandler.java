package com.william.spt.exception;

import com.william.spt.core.Result;
import com.william.spt.core.ResultGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author william
 * @date 2018/2/18 12:14
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    /**
     * 默认统一异常处理方法
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result runtimeExceptionHandler(Exception e) {
        return new ResultGenerator().getFailResult(e.getMessage());
    }
}
