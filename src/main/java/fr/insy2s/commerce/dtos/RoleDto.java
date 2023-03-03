package fr.insy2s.commerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Data

public class RoleDto {
    private int id;
    private String label;

    public RoleDto(int id, String label) {
        this.id = id;
        this.label = label;
    }
}
