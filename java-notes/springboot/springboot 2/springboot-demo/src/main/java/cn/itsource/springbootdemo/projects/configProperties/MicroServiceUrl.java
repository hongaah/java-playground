package cn.itsource.springbootdemo.projects.configProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 加上 @Component 注解，把该类作为组件放到Spring容器中，让 Spring 去管理，我们使用的时候直接注入即可
@Component
@ConfigurationProperties(prefix = "url")
public class MicroServiceUrl {

    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;

    public String getShoppingUrl() {
        return shoppingUrl;
    }

    public void setShoppingUrl(String shoppingUrl) {
        this.shoppingUrl = shoppingUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }
}
