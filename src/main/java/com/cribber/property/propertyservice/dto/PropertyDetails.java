package com.cribber.property.propertyservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyDetails {

  @JsonProperty(value = "propertyId")
  private String propertyId;

  @JsonProperty(value = "type")
  private String type;

  @JsonProperty(value = "size")
  private String size;

  @JsonProperty(value = "area")
  private String area;

  @JsonProperty(value = "numOfBedrooms")
  private String numOfBedrooms;

  @JsonProperty(value = "price")
  private String price;

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(String propertyId) {
    this.propertyId = propertyId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getNumOfBedrooms() {
    return numOfBedrooms;
  }

  public void setNumOfBedrooms(String numOfBedrooms) {
    this.numOfBedrooms = numOfBedrooms;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
