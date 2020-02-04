package com.techshard.graphql.service;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.techshard.graphql.dao.entity.Status;

@Converter
public class VehicleConverter  implements AttributeConverter<Status, String> {
	 
	   @Override
	   public String convertToDatabaseColumn(Status priority) {
	       if (priority == null) {
	           return null;
	       }
	       return priority.toString();
	   }
	 
	   @Override
	   public Status convertToEntityAttribute(String string) {
	       if (string == null) {
	           return null;
	       }
	       try {
	           return Status.valueOf(string);
	       } catch (IllegalArgumentException e) {
	           return null;
	       }
	   }
}
	


