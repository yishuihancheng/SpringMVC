package edu.scu.cs.tlzhang.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by tlzhang on 16-11-11.
 */
public class SpringContextHelper implements ApplicationContextAware {
    public static ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHelper.applicationContext = applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
}
