package com.maveric.bankapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
  MALE("MALE"),
  FEMALE("FEMALE");

  private String value;

  Gender(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return value;
  }

  @JsonCreator
  public static Gender fromText(String text) {
    for(Gender gender : Gender.values()){
      if(gender.value.equals(text)){
        return gender;
      }
    }
    return null;
  }
}
