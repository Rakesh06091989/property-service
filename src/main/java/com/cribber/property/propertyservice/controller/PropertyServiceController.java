package com.cribber.property.propertyservice.controller;

import com.cribber.property.propertyservice.dto.PropertyDetails;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PropertyServiceController {

  @Autowired
  RestTemplate restTemplate;


  private static Map<String, PropertyDetails> propertyDetailsMap = new HashMap<>();

  static {
    PropertyDetails propertyDetails1 = new PropertyDetails();
    propertyDetails1.setArea("vallingBy");
    propertyDetails1.setType("apartment");
    propertyDetails1.setNumOfBedrooms("1");
    propertyDetails1.setPropertyId("1");
    propertyDetails1.setSize("50");
    PropertyDetails propertyDetails2 = new PropertyDetails();
    propertyDetails2.setArea("brommaplan");
    propertyDetails2.setType("apartment");
    propertyDetails2.setNumOfBedrooms("3");
    propertyDetails2.setPropertyId("2");
    propertyDetails2.setSize("72");
    propertyDetailsMap.put("brommaplan", propertyDetails2);
    PropertyDetails propertyDetails3 = new PropertyDetails();
    propertyDetails3.setArea("Kista");
    propertyDetails3.setType("house");
    propertyDetails3.setNumOfBedrooms("5");
    propertyDetails3.setPropertyId("3");
    propertyDetails3.setSize("120");
    propertyDetailsMap.put("Kista", propertyDetails3);
    propertyDetailsMap.put("vallingBy", propertyDetails1);
  }

  @GetMapping(value = "/getPropertyDetails/{areaName}")
  public PropertyDetails getPropertyDetails(@PathVariable String areaName) {
    PropertyDetails propertyDetails = propertyDetailsMap.get(areaName);
    String price = restTemplate.exchange("http://price-service/getPriceDetails/{areaName}", HttpMethod.GET, null,
        new ParameterizedTypeReference<String>() {
        }, areaName).getBody();
    propertyDetails.setPrice(price);
    return propertyDetails;
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
