package com.explorience.explorienceserver.exception;

import com.explorience.explorienceserver.enums.MsgCodeEnum;
import com.explorience.explorienceserver.pojo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.net.BindException;

/**
 * @description: 全局异常捕获
 * @author: shemin
 * @create: 2024-08-22 20:16
 **/
@RestControllerAdvice
@Slf4j
public class GLobalExceptionHandler
{
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData<?> constraintViolationExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return ResponseData.error(MsgCodeEnum.PARA_ERROR, bindingResult.getAllErrors().get(0).getDefaultMessage());
    }
}
