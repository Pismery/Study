package com.pismery.study.gof23.pattern.util;

import org.omg.CORBA.SystemException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/application.yml");

    public ApplicationContextUtil(ApplicationContext context) {
        this.context = context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    @Configuration
    public static class AppContextConfig implements ApplicationContextAware {

        private ApplicationContext appContext;

        @Bean
        public ApplicationContextUtil applicationContext() {
            return new ApplicationContextUtil(appContext);
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws SystemException {
            this.appContext = applicationContext;
        }
    }

}
