package com.william.admin.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.william.admin.interceptor.JwtTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 * @date 2018/2/18 12:14
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 配置静态访问资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/spt/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 修改自定义消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类的配置
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse
        );
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        ValueFilter valueFilter = new ValueFilter() {
            public Object process(Object o, String s, Object o1) {
                if (null == o1) {
                    o1 = "";
                }
                return o1;
            }
        };
        fastJsonConfig.setSerializeFilters(valueFilter);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtTokenInterceptor()).addPathPatterns("/api/**");
    }
}
