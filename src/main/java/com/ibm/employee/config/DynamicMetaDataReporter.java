package com.ibm.employee.config;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.ApplicationInfoManager;

@Component
public class DynamicMetaDataReporter {
 
   @Autowired
   private ApplicationInfoManager aim;
 
   @PostConstruct
   public void init() {
      Map<String, String> map = aim.getInfo().getMetadata();
      map.put("dynamic-s1", "value_2");
      map.forEach((k,v)->
      {
    	  System.out.println("key is::"+k+" value is ::"+v);
      });
   }
}