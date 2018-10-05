package com.zzr.springboot2mvc.config;

import com.zzr.springboot2mvc.interceptor.SessonHandlerinterceptor;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class myMvcConfigurer implements WebMvcConfigurer {

    /**
     * 格式化
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //new SimpleDateFormat("");
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 拦截器设置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessonHandlerinterceptor()).addPathPatterns("/admin/**");
    }

    /**
     * 跨域访问配置
     * 增加对Cors支持
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //registry.addMapping("/**");

        registry.addMapping("/api/**")
                .allowedOrigins("localhost")
                .allowedMethods("post");
        //还有更多的Allow
    }

    /**
     * 增加Controller映射配置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }


}
