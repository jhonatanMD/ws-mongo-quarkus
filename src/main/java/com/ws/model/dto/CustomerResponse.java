package com.ws.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Data
public class CustomerResponse {

    private ObjectId id;
    private String name;
    private String lastName;
    private String product;
    private BigDecimal price;
}
