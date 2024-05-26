package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

@Entity
@Table (name = "comments")
public class Comment {
    //•	id - Accepts UUID String or Long values
    //•	approved - Accepts boolean values
    //•	created - Accepts Date and Time values
    //o	 The values should not be future dates
    //•	text content - Accepts very long text values
    //•	author - Accepts User Entities as values
    //•	route - Accepts Route Entities as values
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private boolean approved;
    @Column(nullable = false)
    private Instant created;
    @Column(name = "text_content", columnDefinition = "LONGTEXT", nullable = false)
    private String textContent;
    @ManyToOne(optional = false)
    private User author;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Route route;

   private Comment () {}

}
