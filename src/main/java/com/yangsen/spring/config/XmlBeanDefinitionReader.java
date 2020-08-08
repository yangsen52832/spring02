package com.yangsen.spring.config;

import com.yangsen.spring.beans.factory.BeanDefinition;
import com.yangsen.spring.beans.factory.suppor.DefaultBeanFactory;
import com.yangsen.spring.beans.factory.suppor.GenericBeanDefiniton;
import com.yangsen.spring.utils.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader{

    private BeanDefinitionReader factory;
    public XmlBeanDefinitionReader(BeanDefinitionReader factory) {
        this.factory = factory;
    }

    /**
     * 注册bean信息
     */
    public void loadBeanDefinition(String configFile) {
        InputStream in = null;
        try{
            ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
            in = classLoader.getResourceAsStream(configFile);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(in);
            Element element = document.getRootElement();
            Iterator<Element> iterator = element.elementIterator();
            while (iterator.hasNext()){
                Element el = iterator.next();
                String id = el.attributeValue("id");
                String className = el.attributeValue("class");
                BeanDefinition bd = new GenericBeanDefiniton(id,className);
                factory.beanDefinitionRegist(id,bd);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
