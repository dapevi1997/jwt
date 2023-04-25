package com.example.jwt.utilities;


import com.example.jwt.collections.Product;
import com.example.jwt.models.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {
    public Function<ProductDTO, Product> mapperToProduct(String id) {
        return updateProduct -> {
            var product = new Product();
            product.setId(id);
            product.setName(updateProduct.getName());
            product.setInventory(updateProduct.getInventory());
            product.setImageUrl(updateProduct.getImageUrl());
            product.setEnabled(updateProduct.getEnabled());
            product.setMin(updateProduct.getMin());
            product.setMax(updateProduct.getMax());
            return product;
        };
    }

    public Function<Product, ProductDTO> mapEntityToProduct() {
        return entity -> new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getInventory(),
                entity.getImageUrl(),
                entity.getEnabled(),
                entity.getMin(),
                entity.getMax()
        );
    }

/*    public Function<UserDTO, User> mapperToUser(){
        return userDTO -> {
            User bike = new User();
            bike.setEmail(userDTO.getEmail());
            bike.setPassword(userDTO.getPassword());
            bike.setRole(userDTO.getRol());

            return bike;
        };
    }*/
}
