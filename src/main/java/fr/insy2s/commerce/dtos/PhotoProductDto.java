package fr.insy2s.commerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.insy2s.commerce.models.Product;
import lombok.Data;

@Data
public class PhotoProductDto {

    private String url_photo;

    @JsonIgnoreProperties("photoProducts")
    private Product product;
}
