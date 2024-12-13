package br.api.model;

public class Cadastro {

    private Usuario usuarioId;
    private Address addressId;

    public Cadastro() {
    }

    public Cadastro(Usuario usuarioId, Address addressId) {
        this.usuarioId = usuarioId;
        this.addressId = addressId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }
}
