package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Maxime VERIN
 */

@Data
@Entity
@Table(name = "PhotoProducts")
public class PhotoProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_photo")
    @SequenceGenerator(name = "seq_photo", allocationSize = 1, initialValue = 14)
    @Column(name = "id_photo_product")
    private Long id;

    @NotNull
    @Column(name = "url_photo")
    private String url_photo;

    /**
     * relational mapping
     */

    @ManyToOne
    @JoinColumn(name = "id_product")
    @JsonIgnoreProperties("photoProducts")
    private Product product;

    /**
     *
     * ToString() equals() hashCode() methods
     */

/*    @Override
    public String toString() {
        return "PhotoProduct{" +
                "id=" + id +
                ", url_photo='" + url_photo + '\'' +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoProduct)) return false;

        PhotoProduct that = (PhotoProduct) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url_photo != null ? !url_photo.equals(that.url_photo) : that.url_photo != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url_photo != null ? url_photo.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }*/
}
