package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Command {
    @Id
    @Column(name = "id_command", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_command")
    @SequenceGenerator(name = "seq_command", allocationSize = 1, initialValue = 101)
    private Long id;
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdAt;
    @Column(name = "delivery_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;
    @Column(name = "is_validated")
    private Boolean isValidated;
    @Column(name = "soft_delete", nullable = false, columnDefinition = "boolean default false")
    private boolean softDelete;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({"address", "commands"})
    private Account user;

    @ManyToOne
    @JoinColumn(name = "id_status")
    @JsonIgnoreProperties("commands")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_address")
    @JsonIgnoreProperties({"users", "commands"})
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "Products_Commands",
            joinColumns = @JoinColumn(name = "id_command"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    @JsonIgnoreProperties("commands")
    private List<Product> products;
}
