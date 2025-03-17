package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.Address;
import com.leo.cardriverentals.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAdresses() {
        List<Address> addresses = addressService.getAddresses();
        if (addresses.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(addresses);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.getAddresById(id);
        if (address.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(address.get());
        }
    }

    @PostMapping
    public ResponseEntity<Address> createAddress (@Valid @RequestBody Address address) {
        Address createAddress = addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAddress);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Address> updateAddress (@PathVariable Long id, @RequestBody Address address) {
        Optional<Address> existingAddress = addressService.getAddresById(id);
        if (existingAddress.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Address updateAddress = addressService.updateAddress(id, address);
            return ResponseEntity.ok(updateAddress);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddress (@PathVariable Long id) {
        if (addressService.getAddresById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            addressService.deleteAddress(id);
            return ResponseEntity.noContent().build();
        }
    }
}
