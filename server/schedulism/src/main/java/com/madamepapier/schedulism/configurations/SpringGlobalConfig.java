package com.bnta.the_bright_network.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringGlobalConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins("*") //allows for all ports
                .allowedHeaders("*") //allows for all headings
                .allowedMethods("*"); //allow for all types of requests

    }

}
