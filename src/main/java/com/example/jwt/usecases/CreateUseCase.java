package com.example.jwt.usecases;

import com.example.jwt.collections.Product;
import com.example.jwt.models.ProductDTO;

import com.example.jwt.user.ProductRepository;
import com.example.jwt.utilities.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;



@Service
@Validated
public class CreateUseCase {
    private final ProductRepository productRepository;

    private final MapperUtils mapperUtils;

    public CreateUseCase(MapperUtils mapperUtils, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<Product> apply( ProductDTO newProduct) {
        return productRepository
                .save(mapperUtils.mapperToProduct(null).apply(newProduct));
    }

}
