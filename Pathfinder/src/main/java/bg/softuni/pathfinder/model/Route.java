package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "routes")
public class Route {
    //•	id - Accepts UUID String or Long values
    //•	gpx coordinates - Accepts very long text values
    //•	level - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values
    //•	name - Accepts String values
    //•	author - Accepts User Entities as values
    //•	video url – Accepts the ids of youtube videos as values
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "gpx_coordinates", columnDefinition =  "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated (EnumType.STRING)
    private Level level;
    @Column(name = "video_url")
    private String videoUrl;
    @ManyToOne(optional = false)
    private User author;
    @OneToMany(targetEntity = Comment.class, mappedBy = "route")
    private Set<Comment> comments;

    public Route () {
        this.comments = new HashSet<> ();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
