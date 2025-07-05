package cn.itsource.springbootdemo.projects.exception;


import cn.itsource.springbootdemo.projects.exception.JsonResult;
import cn.itsource.springbootdemo.projects.exception.BusinessErrorException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 * @ResponseBody 注解是为了异常处理完之后给调用方输出一个 json 格式的封装数据。
 * @ControllerAdvice 注解包含了 @Component 注解，说明在 Spring Boot 启动时，也会把该类作为组件交给 Spring 来管理。
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 缺少请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        logger.error("缺少请求参数，{}", ex.getMessage());
        return new JsonResult("400", "缺少必要的请求参数");
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleTypeMismatchException(NullPointerException ex) {
        logger.error("空指针异常，{}", ex.getMessage());
        return JsonResult.error("空指针异常了");
    }

    /**
     * 拦截业务异常，返回业务异常信息
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleBusinessError(BusinessErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }

    /**
     * 处理其他异常
     *
     * 数据库还有一些查询或者操作异常等等。由于 Exception 异常是父类，所有异常都会继承该异常，所以我们可以直接拦截 Exception 异常，一劳永逸
     * @ExceptionHandler 注解用来指定处理哪种异常，这里是处理 Exception 类型的异常。最后将结果通过统一的 json 结构体返回给调用者。
     */
    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        logger.error("系统异常: " + requestURI, e);
        // return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return JsonResult.error("系统发生异常，请联系管理员");
    }
}
