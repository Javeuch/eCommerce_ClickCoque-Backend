package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @Column(name = "id_role", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_role")
    @SequenceGenerator(name = "seq_role", sequenceName = "prod_seq", initialValue = 4, allocationSize = 1)
    private Long id;
    private String label;
    @Column(name = "soft_delete",nullable = false,columnDefinition = "boolean default false")
    private boolean softDelete ;
    @OneToMany(mappedBy = "role")
    @JsonIgnoreProperties("role")
    private List<Account> users;


    public Role(String label) {
        this.label = label;
    }


}
