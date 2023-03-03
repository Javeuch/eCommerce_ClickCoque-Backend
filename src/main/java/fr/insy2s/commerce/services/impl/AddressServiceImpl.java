package fr.insy2s.commerce.services.impl;


import fr.insy2s.commerce.dtos.AddressDto;
import fr.insy2s.commerce.models.Address;
import fr.insy2s.commerce.repositories.IAddressRepository;
import fr.insy2s.commerce.services.IAddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final IAddressRepository addressRepository;

    private final ModelMapper modelMapper;

    @Override
    public AddressDto findById(Long id) {
        Address address = addressRepository.findById(id).orElse(null);
        return modelMapper.map(address, AddressDto.class);
    }

    /* Get All account (with archives)*/
    @Override
    public List<AddressDto> getAll(){
        return addressRepository.findAll()
                .stream()
                .map(address -> modelMapper.map(address,AddressDto.class))
                .collect(Collectors.toList());
    }
    /* Get All account (without archives)*/
    @Override
    public List<AddressDto> getAllAddress(){
        return addressRepository.findAllWithoutArchive()
                .stream()
                .map(address -> modelMapper.map(address,AddressDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<AddressDto> getAllArchive(){
        return addressRepository.findArchive()
                .stream()
                .map(address -> modelMapper.map(address,AddressDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addAddress(AddressDto address) {addressRepository.save(modelMapper.map(address, Address.class));}

    @Override
    public void deleteAddress(Long id){addressRepository.deleteById(id);}


}
