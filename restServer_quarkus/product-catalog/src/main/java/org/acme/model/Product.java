package org.acme.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Product {
    private String sku;

    private String name;
    private BigDecimal price;
    private int stock;
    private List<Product> products;


    @GET
    @Path("/{sku}")
    public Product getProduct(@PathParam("sku") String sku) {
        return products.stream()
                .filter(p -> p.getSku().equals(sku))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @GET
    @Path("/search")
    public List<Product> searchProducts(
            @QueryParam("minPrice") BigDecimal minPrice,
            @QueryParam("maxPrice") BigDecimal maxPrice,
            @QueryParam("name") String name) {
        return products.stream()
                .filter(p -> minPrice == null || p.getPrice().compareTo(minPrice) >= 0)
                .filter(p -> maxPrice == null || p.getPrice().compareTo(maxPrice) <= 0)
                .filter(p -> name == null || p.getName().contains(name))
                .toList();
    }
}