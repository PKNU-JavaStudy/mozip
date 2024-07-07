package com.mozip.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadFolder = env.getProperty("file.path");

        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler("/upload/**") // Thymeleaf 페이지에서 "/upload/**" 이 패턴이 나오면
                .addResourceLocations("file:///"+uploadFolder)// 실행
                .setCachePeriod(60*10*6) // 1시간동안 캐싱
                .resourceChain(true) //true 로 설정.
                .addResolver(new PathResourceResolver());
    }
}
