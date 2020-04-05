package com.lsl.study.api.config;

import com.lsl.study.api.utils.ResponseEntity;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.lsl.study.api.controller")
public class RestResponseBody implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (!(o instanceof ResponseEntity)) {
            ResponseEntity entity = new ResponseEntity();
            entity.setCode(ResponseEntity.SUCCESS_CODE);
            entity.setMsg("success");
            entity.setSuccess(true);
            entity.setData(o);
            o = entity;
        }
        return o;
    }
}
