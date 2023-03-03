package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Status {
    @Id
    @Column(name = "id_status", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status")
    @SequenceGenerator(name = "seq_status", allocationSize = 1, initialValue = 4)
    private Long id;

    private String label;

    @OneToMany(mappedBy = "status")
    @JsonIgnoreProperties("status")
    private List<Command> commands;
}
