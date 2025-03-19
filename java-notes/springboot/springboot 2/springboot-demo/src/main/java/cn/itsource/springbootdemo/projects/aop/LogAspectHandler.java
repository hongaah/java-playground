package cn.itsource.springbootdemo.projects.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 日志切面处理类
 *
 * @Aspect 注解用来描述一个切面类，定义切面类的时候需要打上这个注解
 * @Component 注解让该类交给 Spring 来管理。
 */
@Aspect
@Component
public class LogAspectHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义一个切面，拦截 cn.itsource.springbootdemo 包和子包下的所有方法
     */
    @Pointcut("execution(* cn.itsource.springbootdemo.controller..*.*(..))")
    public void pointCut() {}

    /**
     * 定义一个切面，拦截所有使用 @GetMapping 注解的方法
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotationCut() {}

    /**
     * @Before 注解指定的方法在切面切入目标方法之前执行，可以做一些 log 处理，也可以做一些信息的统计，比如获取用户的请求 url 以及用户的 ip 地址等等
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("==== doBefore 方法进入了 ====");

        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funcName = signature.getName();
        logger.info("即将执行方法为: {}，属于{}包", funcName, declaringTypeName);

        // 也可以用来记录一些信息，比如获取请求的 url和 ip
        // getRequestAttributes 可能会返回 null，尤其是在非 Web 请求的上下文中（例如单元测试或异步任务中），所以需要进行判空处理
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            logger.warn("无法获取请求信息，当前可能不在 Web 请求上下文中");
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        // 获取请求url
        String url = request.getRequestURL().toString();
        // 获取请求ip
        String ip = request.getRemoteAddr();
        logger.info("用户请求的url为：{}，ip地址为：{}", url, ip);
    }

    /**
     * @After 注解和 @Before 注解相对应，指定的方法在切面切入目标方法之后执行，也可以做一些完成某方法之后的 log 处理。
     */
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("====doAfter方法进入了====");

        Signature signature = joinPoint.getSignature();
        String method = signature.getName();

        logger.info("方法{}已经执行完", method);
    }

    /**
     * @AfterReturning 注解用来描述切面方法的返回值，当切面方法执行成功后，该注解的方法会被执行。
     * 在 @AfterReturning注解 中，属性 returning 的值必须要和参数保持一致，否则会检测不到。该方法中的第二个入参就是被切方法的返回值，在 doAfterReturning 方法中可以对返回值进行增强，可以根据业务需要做相应的封装。
     */
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("====doAfterReturning方法进入了====");

        Signature signature = joinPoint.getSignature();
        String method = signature.getName();

        logger.info("方法{}执行完毕，返回值为：{}", method, result);
    }

    /**
     * @AfterThrowing 注解是当被切方法执行时抛出异常时，会进入 @AfterThrowing 注解的方法中执行
     * 在该方法中可以做一些异常的处理逻辑。要注意的是 throwing 属性的值必须要和参数一致，否则会报错。该方法中的第二个入参即为抛出的异常。
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();

        // 处理异常的逻辑
        logger.info("执行方法{}出错，异常为：{}", method, ex);
    }

}

