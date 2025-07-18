package cn.itsource.springbootdemo.projects.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志 slf4j + logback
 *
 * logback.xml 配置文件: src/main/resources/logback.xml
 */
@RestController
@RequestMapping("/log")
public class LogTestController {

    private final static Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/test")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======测试：{}", str1, str2);

        return "success";
    }
}
