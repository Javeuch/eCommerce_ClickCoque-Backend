package fr.insy2s.commerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductDto {
    private Long id_product;

    private String name;

    private String reference;

    private int price;

    private int taxe;

    private String description;

    private String detailed_description;

    private int stock;

    private float average_notation;

    private Date dateOfInsert;

    @JsonIgnoreProperties("products")
    private List<CommandDto> commands;

    @JsonIgnoreProperties("products")
    private CategoryDto category;

    @JsonIgnoreProperties("brands")
    private BrandDto brand;

    @JsonIgnoreProperties("products")
    private List<TagDto> tags;

    @JsonIgnoreProperties("product")
    private List<PhotoProductDto> photoProducts;

    @JsonIgnoreProperties("product")
    private List<NoteDto> notes;

    @JsonIgnoreProperties("products")
    private List<ColorDto> colors;
}
