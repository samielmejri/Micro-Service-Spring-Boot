package tn.lastdance.cours.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cours")
public class Cours  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "rating")
    private int rating;
    public Cours() {

    }

    public Cours(String title, String description,String image, int rating) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.rating = rating;

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



}