package cn.itsource.springbootdemo.projects.json;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


/**
 * 自定义 FastJson 配置
 *
 * 作用：解决返回json数据时，null值转换为""字符串，而不是null
 * 测试：hash 集写死的 null 不会转换为 ""
 */
@Configuration
public class fastJsonConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue, // 保留map空的字段
                SerializerFeature.WriteNullStringAsEmpty, // 将String类型的null转成""
                SerializerFeature.WriteNullNumberAsZero, // 将Number类型的null转成0
                SerializerFeature.WriteNullListAsEmpty, // 将List类型的null转成[]
                SerializerFeature.WriteNullBooleanAsFalse, // 将Boolean类型的null转成false
                SerializerFeature.DisableCircularReferenceDetect // 避免循环引用
        );

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);

        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(MediaType.APPLICATION_JSON); // 解决中文乱码问题
        converter.setSupportedMediaTypes(mediaTypeList);

        // 确保 FastJson 转换器是唯一的 JSON 转换器
        converters.removeIf(c -> c instanceof MappingJackson2HttpMessageConverter);
        converters.add(converter);
    }
}