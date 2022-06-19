package com.factapi.factapi.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // excluding paths
        List<String> paths = new ArrayList<String>();
        paths.add("/fact/dog");
        paths.add("/fact/cat");
        registry.addInterceptor(new MyHandlerInterceptor())
                               .excludePathPatterns(paths)
                               .pathMatcher(new AntPathMatcher());

        // including path to protect api with key
        registry.addInterceptor(new MyHandlerInterceptor())

                               .addPathPatterns("/info")
                               .pathMatcher(new AntPathMatcher()); 
         
                                                           
    }
}
