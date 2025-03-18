package fr.univtln.eberge.samples.element;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import fr.univtln.eberge.samples.element.Book;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    private List<Book> books;


}
