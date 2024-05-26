package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import org.hibernate.sql.results.internal.StandardEntityGraphTraversalStateImpl;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "users")
public class User {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Integer age;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(unique = true)
    private String email;
    @ManyToMany
    private Set<Role> roles;
    @Enumerated (EnumType.STRING)
    private Level level;
    public User () {
        this.roles = new HashSet<> ();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
