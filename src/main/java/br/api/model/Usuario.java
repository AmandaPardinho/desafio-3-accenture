package br.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.api.dto.UsuarioDto;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDateTime dataNascimento;
    private String telefone;   
    
    @ManyToOne
    @JoinColumn(name = "cep")
    private Address address;
    
    //Construtor
    public Usuario() {
            
    }

    public Usuario(UsuarioDto usuarioDto){

    }

    //gets e sets
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public LocalDateTime getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    @Override
    public String toString() {
        return "Cadastro{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + formatCpf(cpf) + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + formatTelefone(telefone) + '\'' +
                '}';
    }

    private String formatTelefone(String telefone) {
        if (telefone != null && telefone.length() == 9) {
            return telefone.substring(0, 5) + "-" + telefone.substring(5);
        }
        return telefone;
    }

    private String formatCpf(String cpf) {
        if (cpf != null && cpf.length() == 11) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
        }
        return cpf;
    }
}
