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
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tag")
    @SequenceGenerator(name = "seq_tag", allocationSize = 1, initialValue = 11)
    @Column(name = "id_tag")
    private Long id;
    private String label;


    @ManyToMany
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "id_tag"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    @JsonIgnoreProperties("tags")
    private List<Product> products;


}
