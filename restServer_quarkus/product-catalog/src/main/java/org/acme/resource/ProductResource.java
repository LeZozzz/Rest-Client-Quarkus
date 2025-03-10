package org.acme.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import org.acme.model.Product;

@Path("/api/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private static List<Product> products = new ArrayList<>();

    @GET
    public List<Product> getAllProducts() {
        return products;
    }

    @POST
    public Response createProduct(Product product) {
        products.add(product);
        return Response.status(201).entity(product).build();
    }
}