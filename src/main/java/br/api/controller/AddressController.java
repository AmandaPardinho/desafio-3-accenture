package br.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.api.dto.CadastroDto;
import br.api.dto.UsuarioDto;
import br.api.model.Address;
import br.api.repository.CepRepository;
import br.api.service.AddressService;
import br.api.service.CepService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

    @GetMapping("/{cep}")
    public ResponseEntity<Address> getAddressByCep(@PathVariable String cep) {
        Address address = addressService.findAddressByCep(cep);
        return ResponseEntity.ok().body(address);
    }

    @PutMapping("/update/{cep}")
    public ResponseEntity<Address> updateAddress(@PathVariable String cep, @RequestBody Address addressDetails) {
        Address updatedAddress = addressService.updateAddress(cep, addressDetails);
        return ResponseEntity.ok().body(updatedAddress);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String cep) {
        addressService.deleteAddress(cep);
        return ResponseEntity.noContent().build();
    }

}
