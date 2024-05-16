package quarkusric;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
//con panache, Book adquiere la capacidad de ser persistido en la base de datos
public class Book extends PanacheEntity{



    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private int numPage;
    private LocalDate pubDate;

    private String description;

    private String genre;

    @CreationTimestamp
    private LocalDate createDate;

    @UpdateTimestamp
    private LocalDate updateDate;

    //getter y setter de genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    //set y get de description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //metodo hashcode
    @Override
    public int hashCode() {
        return Objects.hash(description, numPage, pubDate, titulo);
    }

    @Override
    //metodo equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Book other = (Book) o;
        return Objects.equals(description, other.description) && numPage == other.numPage && Objects.equals(pubDate, other.pubDate) && Objects.equals(titulo, other.titulo);
    }

    //metodo toString
    @Override
    public String toString() {
        return "Book" +
                "[description=" + description +
                ", numPage=" + numPage +
                ", pubDate=" + pubDate +
                ", titulo=" + titulo +
                "]";
    }

    
}
