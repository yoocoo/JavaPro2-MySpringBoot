package acheng1314.cn.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// GlobalExceptionHandler 类有两个注解:
//
//  1.RestController, 表明 GlobalExceptionHandler 是一个 RESTful Controller, 即它会以 RESTful 的形式返回回复.
//
//  2.ControllerAdvice, 表示 GlobalExceptionHandler 是一个全局的异常处理器.
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}