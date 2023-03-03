package fr.insy2s.commerce.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Builder
public class Account {
    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private LocalDate birthDate;


    @Column(name="phone_number",length = 10)
    private String phoneNumber;
    @Column(unique=true)
    private String email;
    private String password;
    @Column(name = "soft_delete",nullable = false,columnDefinition = "boolean default false")
    private boolean softDelete ;
    private Boolean locked =false;
    private Boolean enabled =false;
    @ManyToOne
    @JoinColumn(name="id_role")
    @JsonIgnoreProperties("users")
    private Role role;

    @ManyToOne(
            cascade = {
                    CascadeType.ALL
            }
    )
    @JoinColumn(name="address_id")
    @JsonIgnoreProperties("users")
    private Address address;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Command> commands;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Note> notes;


}