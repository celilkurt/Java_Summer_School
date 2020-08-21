package com.tr.obss.JpaApp.controller;


import com.tr.obss.JpaApp.entity.Address;
import com.tr.obss.JpaApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }

    @PatchMapping("/id/{id}")
    public ResponseEntity<Address> updateAddressDetails(@RequestParam String details,@PathVariable Long id){
        return addressService.updateAddressDetails(details,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }




}
