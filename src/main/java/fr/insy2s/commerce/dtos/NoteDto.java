package fr.insy2s.commerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {
    private Long id;
    private int notation;
    @JsonIgnoreProperties("notes")
    private AccountDto user;
    @JsonIgnoreProperties("notes")
    private ProductDto product;
}
