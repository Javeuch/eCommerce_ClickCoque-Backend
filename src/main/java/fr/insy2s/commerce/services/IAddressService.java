package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.AddressDto;
import fr.insy2s.commerce.models.Address;

import java.util.List;

public interface IAddressService {

    AddressDto findById(Long id);

    List<AddressDto> getAllAddress();

    /* Get All account (with archives)*/
    List<AddressDto> getAll();

    List<AddressDto> getAllArchive();

    void addAddress(AddressDto address);

    void deleteAddress(Long id);
}
