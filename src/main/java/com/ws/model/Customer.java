package com.ws.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "Customer")
public class Customer {

    @BsonId
    public ObjectId id;
    private String name;
    @BsonProperty("last_name")
    private String lastName;
    private Product product;

}
