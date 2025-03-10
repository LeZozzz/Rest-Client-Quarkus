package fr.univtln.eberge.samples.element;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;

/**
 * A simple class to represent a REST resources.
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Book {
    /**
     * The Stocke Keeping Unit/ISBN of the book.
     */
    @Id
    private String isbn;
    /**
     * The title of the book.
     */
    private String title;
    /**
     * The author of the book.
     */
//    @ManyToOne
//    private Author author;
    /**
     * The price of the book.
     */
    private BigDecimal price;
    private int stock;
}
