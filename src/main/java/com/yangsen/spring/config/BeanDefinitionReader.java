package com.yangsen.spring.config;

import com.yangsen.spring.beans.factory.BeanDefinition;

public interface BeanDefinitionReader {
    BeanDefinition getBeanDefinition(String beanId);
    void beanDefinitionRegist(String beanId,BeanDefinition beanDefinition);
}
