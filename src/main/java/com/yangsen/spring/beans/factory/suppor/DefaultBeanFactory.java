package com.yangsen.spring.beans.factory.suppor;

import com.yangsen.spring.beans.factory.BeanDefinition;
import com.yangsen.spring.beans.factory.BeanFactory;
import com.yangsen.spring.config.BeanDefinitionReader;
import com.yangsen.spring.utils.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements BeanFactory, BeanDefinitionReader {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = beanDefinitionMap.get(beanId);
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        String classNmae = bd.getBeanClassName();
        try {
            Class<?> clazz = classLoader.loadClass(classNmae);
            return clazz.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {

        return beanDefinitionMap.get("beanId");
    }

    @Override
    public void beanDefinitionRegist(String beanId,BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanId,beanDefinition);
    }
}
