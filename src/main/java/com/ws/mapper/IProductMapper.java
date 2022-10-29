package com.ws.mapper;

import com.ws.model.Product;
import com.ws.model.dto.ProductDto;
import com.ws.model.dto.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface IProductMapper {

    Product toEntity(ProductDto productDto);
    Product toEntity(ProductRequest productDto);
    ProductDto toDto(Product product);
}
