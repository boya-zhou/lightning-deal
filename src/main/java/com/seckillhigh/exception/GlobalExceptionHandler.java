package com.seckillhigh.exception;

import com.seckillhigh.result.CodeMsg;
import com.seckillhigh.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice(basePackages = "com.seckillhigh")
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> handleException(Exception e) {

        e.printStackTrace();

        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
            return Result.error(exception.getCodeMsg());

        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(errorList.stream().map(ele -> ele.getDefaultMessage()).collect(Collectors.toList())));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }

}
