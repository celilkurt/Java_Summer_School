package com.tr.obss.JpaApp.service;


import com.tr.obss.JpaApp.dao.AddressRepository;
import com.tr.obss.JpaApp.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity<List<Address>> getAllAddresses(){

        List<Address> addresses = addressRepository.findAll();

        if(addresses.isEmpty()){
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        }

    }

    public ResponseEntity<Address> addAddress(Address address){

        Address address1 = addressRepository.save(address);
        if(address1 == null)
            return new ResponseEntity<Address>(address1,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Address> updateAddress(Address address){

        Address address1 = addressRepository.save(address);
        if(address1 == null)
            return new ResponseEntity<Address>(address1,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Address> updateAddressDetails(String details,Long id){

        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            address.get().setDetails(details);
            Address address1 = addressRepository.save(address.get());
            return new ResponseEntity<>(address1,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteAddress(Long id){

        addressRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
