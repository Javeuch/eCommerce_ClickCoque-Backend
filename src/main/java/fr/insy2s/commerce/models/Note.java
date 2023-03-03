package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Note {

    @Id
    @Column(name = "id_note", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_note")
    @SequenceGenerator(name = "seq_note", allocationSize = 1, initialValue = 50)
    private Long id;
    private int notation;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties("notes")
    private Account user;

    @ManyToOne
    @JoinColumn(name = "id_product")
    @JsonIgnoreProperties("notes")
    private Product product;
}
