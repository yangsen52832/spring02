package com.yangsen;

import static org.junit.Assert.assertTrue;

import com.yangsen.spring.xml.ApplicationContext;
import com.yangsen.spring.xml.support.ClassPathApplicationContext;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test(){

        ApplicationContext ac = new ClassPathApplicationContext("spring.xml");
        User user = (User)ac.getBean("user");
        System.out.println(user);
    }
}
