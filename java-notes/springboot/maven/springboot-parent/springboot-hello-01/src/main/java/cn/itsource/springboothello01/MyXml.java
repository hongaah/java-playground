package cn.itsource.springboothello01;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyXml {
    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    @Autowired
    private Environment env;

    public String getMsg() {
        return msg1 + " " + msg2;
    }

    public String getEnvVar() {
        return env.getProperty("person.name");
    }
}
