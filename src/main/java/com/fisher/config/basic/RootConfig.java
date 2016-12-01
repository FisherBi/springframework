package com.fisher.config.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.regex.Pattern;

@Configuration
@ComponentScan(basePackages={"com.fisher.config"},
    excludeFilters={
        @Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
    })
public class RootConfig {
}
