package fr.univtln.eberge.samples.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import fr.univtln.eberge.samples.element.Book;

@Path("/api/v1/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    private static List<Book> books = new ArrayList<>();

    @GET
    public List<Book> searchBooks(
            @QueryParam("minPrice")BigDecimal minPrice,
            @QueryParam("maxPrice")BigDecimal maxPrice,
            @QueryParam("title")String title) {
        return books.stream()
                    .filter(p -> minPrice == null || p.getPrice().compareTo(minPrice) >= 0)
                    .filter(p -> maxPrice == null || p.getPrice().compareTo(maxPrice) <= 0)
                    .filter(p -> title == null || p.getTitle().contains(title))
                    .toList();

    }

    @GET
    @Path("/{isbn}")
    public Book getBookBySKU(@PathParam("isbn") String isbn) {
        return books.stream()
                    .filter(book -> book.getIsbn().equals(isbn))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @POST
    public Response createBook(Book book) {
        books.add(book);
        return Response.status(201).entity(book).build();
    }

    @PUT
    public Response updateTitleBook(@QueryParam("isbn") String isbn,String updatedTitle) {
        Book book = books.stream()
                         .filter(b -> b.getIsbn().equals(isbn))
                         .findFirst()
                         .orElseThrow(()-> new NotFoundException("Book not found"));
        if (book != null) {
            book.setTitle(updatedTitle);
            return Response.status(200).entity(book).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    public Response deleteBook(@QueryParam("isbn") String isbn) {
        Book book = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
        if (book != null) {
            books.remove(book);
            return Response.status(204).build();
        } else {
            return Response.status(404).build();
        }
    }


}