package fr.insy2s.commerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
public class AddressDto {
    private String number;
    private String street;
    private String zipcode;
    private String city;
    private String country;
}
