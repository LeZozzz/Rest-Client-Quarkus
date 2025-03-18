package fr.univtln.eberge.samples.resources;

import fr.univtln.eberge.samples.element.Author;
import fr.univtln.eberge.samples.element.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/api/v1/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    private static List<Author> authors = new ArrayList<>();

    @GET
    public List<Author> getAllAuthors() {
        return authors;
    }

    @GET
    @Path("/{id}")
    public Author getAuthorById(Long id) {
        return authors.stream()
                      .filter(author -> author.getId().equals(id))
                      .findFirst()
                      .orElseThrow(() -> new NotFoundException("Author not found"));
    }

    @GET
    @Path("/{name}")
    public Author getAuthorByName(String name) {
        return authors.stream()
                      .filter(author -> author.getName().equals(name))
                      .findFirst()
                      .orElseThrow(() -> new NotFoundException("Author not found"));
    }

    @GET
    @Path("/{id}/books")
    public List<Book> getBooksByAuthorId(Long id) {
        return authors.stream()
                      .filter(author -> author.getId().equals(id))
                      .findFirst()
                      .orElseThrow(() -> new NotFoundException("Author not found"))
                      .getBooks();
    }

    @GET
    @Path("/{name}/books")
    public List<Book> getBooksByAuthorName(String name) {
        return authors.stream()
                      .filter(author -> author.getName().equals(name))
                      .findFirst()
                      .orElseThrow(() -> new NotFoundException("Author not found"))
                      .getBooks();
    }

    @POST
    public Response createAuthor(Author author) {
        authors.add(author);
        return Response.status(201).entity(author).build();
    }

    @DELETE
    public Response deleteAuthor(Long id) {
        Author author = authors.stream()
                               .filter(a -> a.getId().equals(id))
                               .findFirst()
                               .orElseThrow(() -> new NotFoundException("Author not found"));
        authors.remove(author);
        return Response.status(204).build();
    }

//    @PUT
//    public Response updateAuthorName(Long id, String updatedName) {
//        Author author = authors.stream()
//                               .filter(a -> a.getId().equals(id))
//                               .findFirst()
//                               .orElseThrow(() -> new NotFoundException("Author not found"));
//        author.setName(updatedName);
//        return Response.status(200).entity(author).build();
//
//    }

}
