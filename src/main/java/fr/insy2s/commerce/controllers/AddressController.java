package fr.insy2s.commerce.controllers;


import fr.insy2s.commerce.dtos.AddressDto;
import fr.insy2s.commerce.models.Address;
import fr.insy2s.commerce.services.IAddressService;
import fr.insy2s.commerce.services.impl.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/address")
public class AddressController {

    private final AddressServiceImpl addressService;

    /* Get all with archive */
    @GetMapping("/allAll")
    public List<AddressDto> getAll(){return addressService.getAll();}

    /* Get all without Archive */
    @GetMapping("/all")
    public List<AddressDto> getAllAddress(){return addressService.getAllAddress();}

    /*Get all Archive */
    @GetMapping ("/archive")
    public List<AddressDto> getAllArchive(){return addressService.getAllArchive();}

    @GetMapping("/detail/{id}")
    public AddressDto detail(@PathVariable Long id) {return addressService.findById(id);}

    @PostMapping("/add")
    public void addAddress(@PathVariable @RequestBody AddressDto address) {
        addressService.addAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {addressService.deleteAddress(id);}
}
