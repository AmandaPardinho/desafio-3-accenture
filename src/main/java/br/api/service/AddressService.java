package br.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.model.Address;
import br.api.repository.CepRepository;

@Service
public class AddressService {

    @Autowired
    private CepService cepService;

    @Autowired
    private CepRepository cepRepository;

    public AddressService(CepService cepService, CepRepository cepRepository) {
        this.cepService = cepService;
        this.cepRepository = cepRepository;
    }

    public Address findAddressByCep(String cep) {
        return cepService.findAdressByCep(cep);
    }

    public Address updateAddress(String cep, Address addressDetails) {
        Optional<Address> optionalAddress = cepRepository.findById(cep);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            address.setLogradouro(addressDetails.getLogradouro());
            address.setLocalidade(addressDetails.getLocalidade());
            address.setUf(addressDetails.getUf());
            address.setCep(addressDetails.getCep());
            return cepRepository.save(address);
        } else {
            throw new RuntimeException("Endereço não encontrado para o CEP: " + cep);
        }    
    }

    public void deleteAddress(String cep) {
        Optional<Address> optionalAddress = cepRepository.findById(cep);
        if (optionalAddress.isPresent()) {
            cepRepository.delete(optionalAddress.get());
        } else {
            throw new RuntimeException("Endereço não encontrado para o CEP: " + cep);
        }
    }
}
