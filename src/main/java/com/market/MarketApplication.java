package com.market;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan //对servlet组件的支持
@SpringBootApplication
public class MarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }


    /**
     * 解决Tomcat版本和SpringBoot内置版本不一致
     * @return
     */
    @Bean
    public static BeanFactoryPostProcessor removeTomcatWebServerCustomizer() {
        return (beanFactory) ->
                ((DefaultListableBeanFactory)beanFactory).removeBeanDefinition("tomcatWebServerFactoryCustomizer");
    }

}
