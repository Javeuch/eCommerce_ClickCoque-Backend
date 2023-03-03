package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_product;
    private String name;
    private String reference;
    private int price;
    private int taxe;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String detailed_description;
    private int stock;
    private float average_notation;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfInsert;
    @Column(name = "soft_delete", nullable = false, columnDefinition = "boolean default false")
    private boolean softDelete;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Command> commands;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("products")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    @JsonIgnoreProperties("products")
    private Brand brand;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Tag> tags;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private List<PhotoProduct> photoProducts;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private List<Note> notes;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Color> colors;

}
