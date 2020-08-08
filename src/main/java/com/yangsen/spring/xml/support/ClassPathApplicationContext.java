package com.yangsen.spring.xml.support;

import com.yangsen.spring.beans.factory.suppor.DefaultBeanFactory;
import com.yangsen.spring.config.XmlBeanDefinitionReader;
import com.yangsen.spring.xml.ApplicationContext;

public class ClassPathApplicationContext implements ApplicationContext {

    private DefaultBeanFactory factory;
    public ClassPathApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(configFile);
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}
