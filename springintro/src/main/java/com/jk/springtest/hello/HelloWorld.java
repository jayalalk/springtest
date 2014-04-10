package com.jk.springtest.hello;

import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class HelloWorld {

    private String message;
    private List<Holiday> holidays;
    
    @Value("#{systemProperties}")
    private  Properties systemProperties; 
    
    @Value ("#{ T(System).currentTimeMillis() }")
    private long currentMilli;
    
    @Required
    public void setMessage(String message) {
        this.message = message;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public void hello() {
        System.out.println("Hello! " + message);
    }
    
    public void printHolidays(){
    	
    	System.out.println("currentMilli=" + currentMilli);
    	
    	for(Holiday holiday:holidays){
    				
    		System.out.println("Holidays " + holiday.getGreeting());
    		//System.out.printf("Holidays =  %1  %2  % 3 " , holiday.getGreeting() ,holiday.getMonth() , holiday.getDay() );

    	}
    }
    
    
    public void printSysProp(){
    	
    	Enumeration e = systemProperties.propertyNames();
    	while(e.hasMoreElements()){
    		String skey = (String)e.nextElement();
    		System.out.println(skey + "=" + systemProperties.getProperty(skey));
    	}
    	    	
    	}
}
