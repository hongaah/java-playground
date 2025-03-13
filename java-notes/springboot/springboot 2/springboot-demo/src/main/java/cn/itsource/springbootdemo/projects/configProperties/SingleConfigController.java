package cn.itsource.springbootdemo.projects.configProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 单个配置文件属性值注入
// 通过 @Value 注解获取配置文件中的属性值
@RestController
@RequestMapping("/singleConfig")
public class SingleConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleConfigController.class);

    @Value("${url.orderUrl}")
    private String orderUrl;

    @RequestMapping("/getUrl")
    public String testConfig() {
        LOGGER.info("=====获取的订单服务地址为：{}", orderUrl);
        return "success";
    }
}