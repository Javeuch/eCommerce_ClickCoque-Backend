package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Currency;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class LineOfPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lineOfPayment")
    @SequenceGenerator(name = "seq_lineOfPayment", allocationSize = 1, initialValue = 1)
    @Column(name = "id_payment", nullable = false)
    private Long id;

    private Currency montant;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "lineOfPayments", allowSetters = true)
    private Payment payment;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "lineOfPayment", allowSetters = true)
    private Command command;
}

