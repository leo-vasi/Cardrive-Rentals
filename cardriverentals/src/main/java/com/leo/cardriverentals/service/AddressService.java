package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.Address;
import com.leo.cardriverentals.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddresById (Long id) {
        return addressRepository.findById(id);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress (Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElseThrow(()-> new RuntimeException("Address Not Found"));
        existingAddress.setUser(address.getUser());
        existingAddress.setNum(address.getNum());
        existingAddress.setStreet(address.getStreet());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setCountry(address.getCountry());
        existingAddress.setZipcode(address.getZipcode());
        existingAddress.setAddressType(address.getAddressType());
        return addressRepository.save(existingAddress);
    }

    public void deleteAddress (Long id) {
        addressRepository.deleteById(id);
    }

}
