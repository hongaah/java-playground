package cn.itsource.springbootdemo.projects.listener;

import cn.itsource.springbootdemo.projects.exception.JsonResult;
import cn.itsource.springbootdemo.projects.swagger.User;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/listener")
public class ListenerController {
    @Resource
    private UserService userService;

    /**
     * 获取application域中的用户信息
     * @param request
     * @return JsonResult
     */
    @GetMapping("/user")
    public JsonResult getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        User user = (User) application.getAttribute("user");
        return JsonResult.success(user);
    }

    /**
     * 获取当前在线人数，该方法有bug
     * @param request
     * @return JsonResult
     */
    @GetMapping("/total")
    public JsonResult getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return JsonResult.success("当前在线人数：" + count);
    }

    /**
     * 获取当前在线人数，该方法没有bug
     * @param request
     * @return JsonResult
     */
    @GetMapping("/total2")
    public JsonResult getTotalUser2(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try {
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge( 48*60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return JsonResult.success("当前在线人数：" + count);
    }

    /**
     * 获取request域中的数据
     * @param request
     * @return JsonResult
     */
    @GetMapping("/request")
    public JsonResult getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return JsonResult.success();
    }

    /**
     * 获取自定义监听器中的数据
     * @param request
     * @return JsonResult
     */
    @GetMapping("/publish")
    public JsonResult getEvent(HttpServletRequest request) {
        User user = userService.publishEvent();
        return JsonResult.success(user);
    }

}
