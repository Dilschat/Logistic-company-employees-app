package com.company.Employee.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
class MvcConfig implements WebMvcConfigurer {
    @Value("${spring.view.prefix}")
    private String prefix;

    @Value("${spring.view.suffix}")
    private String suffix;

    @Value("${spring.view.view-names}")
    private String viewNames;
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("thymeleaf/home");
        registry.addViewController("/hello").setViewName("thymeleaf/hello");
        registry.addViewController("/login").setViewName("thymeleaf/login");
        registry.addViewController("/graph").setViewName("jsp/chart");

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(prefix);
        viewResolver.setSuffix(suffix);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setViewNames(viewNames);
        registry.viewResolver(viewResolver);
    }


}
