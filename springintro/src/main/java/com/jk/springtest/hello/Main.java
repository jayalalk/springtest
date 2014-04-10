package com.jk.springtest.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.hello();
        helloWorld.printHolidays();
       // helloWorld.printSysProp();
        
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
        
        helloWorld2.printHolidays();
    }
}
