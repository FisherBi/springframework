package com.fisher.config.aop;

import com.fisher.common.aop.LogAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by fisbii on 16-12-8.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.fisher.service")
public class AopConfig {
    @Bean
    public LogAop logAop(){
        return new LogAop();
    }
}
