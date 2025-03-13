package cn.itsource.springbootdemo.projects.configProperties;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiConfig")
public class MultiConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiConfigController.class);

    @Resource
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("/getUrl")
    public String testConfig() {
        LOGGER.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        LOGGER.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        LOGGER.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());

        return "success";
    }
}
