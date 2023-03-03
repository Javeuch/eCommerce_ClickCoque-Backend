package fr.insy2s.commerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.insy2s.commerce.models.Account;
import fr.insy2s.commerce.models.Address;
import fr.insy2s.commerce.models.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommandDto {

    private Date createdAt;

    private Date deliveryDate;

    private Boolean isValidated;

    @JsonIgnoreProperties("commands")
    private StatusDto status;

    private AddressDto address;

    @JsonIgnoreProperties("commands")
    private List<ProductDto> products;
}
