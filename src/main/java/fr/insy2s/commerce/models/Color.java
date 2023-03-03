package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tag")
    @SequenceGenerator(name = "seq_tag", initialValue = 11, allocationSize = 1)
    @Column(name = "id_color")
    private Long id;
    private String color;


    @ManyToMany
    @JoinTable(
            name = "product_color",
            joinColumns = @JoinColumn(name = "id_color"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    @JsonIgnoreProperties("colors")
    private List<Product> products;
}
