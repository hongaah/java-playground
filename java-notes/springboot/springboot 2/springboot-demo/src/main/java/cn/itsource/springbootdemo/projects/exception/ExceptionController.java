package cn.itsource.springbootdemo.projects.exception;

import cn.itsource.springbootdemo.projects.exception.JsonResult;
import cn.itsource.springbootdemo.projects.exception.BusinessErrorException;
import cn.itsource.springbootdemo.projects.exception.BusinessMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    // 测试请求参数异常
    @PostMapping("/testReq")
    public JsonResult testReq(@RequestParam("name") String name,
                           @RequestParam("pass") String pass) {
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return JsonResult.success();
    }

    // 测试空指针异常
    @PostMapping("/testNull")
    public JsonResult testNull() {
        String str = null;
        str.length();
        return JsonResult.success();
    }

    // 测试其他异常
    @PostMapping("/testOther")
    public JsonResult testOther() {
        int i = 1 / 0;
        return JsonResult.success();
    }

    // 测试自定义异常
    @GetMapping("/testBusinessError")
    public JsonResult testBusinessError() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.SERVICE_TIME_OUT);
        }
        return new JsonResult();
    }

}
