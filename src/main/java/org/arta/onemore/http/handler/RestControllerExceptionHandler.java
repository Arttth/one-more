package org.arta.onemore.http.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "org.arta.onemore.http")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
