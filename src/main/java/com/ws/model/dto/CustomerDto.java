package com.ws.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CustomerDto {

    private ObjectId id;
    private String name;
    private String lastName;
    private ProductDto product;
}
