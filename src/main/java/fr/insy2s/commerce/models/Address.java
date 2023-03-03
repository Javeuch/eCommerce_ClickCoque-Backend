package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Address {
    @Id
    @Column(name = "id_address", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @SequenceGenerator(name = "seq_address", initialValue = 41, allocationSize = 1)
    private Long id;
    private String number;
    private String street;
    private String zipcode;
    private String city;
    private String country;
    @Column(name = "soft_delete", nullable = false, columnDefinition = "boolean default false")
    private boolean softDelete;

    @OneToMany(mappedBy = "address",
               cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("address")
    private List<Account> users = new ArrayList<>();

    @OneToMany(mappedBy = "address")
    @JsonIgnoreProperties({"user", "address"})
    private List<Command> commands;


}
