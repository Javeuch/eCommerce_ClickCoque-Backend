package fr.insy2s.commerce.models;

        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import com.sun.istack.NotNull;
        import lombok.*;
        import org.springframework.format.annotation.DateTimeFormat;

        import javax.persistence.*;
        import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment")
    @SequenceGenerator(name = "seq_payment", allocationSize = 1, initialValue = 1)
    @Column(name = "id_payment", nullable = false)
    private Long id;

    @Column(name = "card_number", nullable = false, length = 16)
    private Integer cardNumber;
    @Column(nullable = false, length = 3)
    private Integer ccv;
    @Column(name = "expiration_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM")
    private LocalDate expirationDate;



    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "payment", allowSetters = true)
    private Account user;
}