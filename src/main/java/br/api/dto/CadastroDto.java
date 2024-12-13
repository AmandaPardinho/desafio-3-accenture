package br.api.dto;

import java.time.LocalDateTime;

import br.api.model.Address;
import br.api.model.Usuario;

public class CadastroDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDateTime dataNascimento;
    private String telefone;
    private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;	
	private String ddd;
	
	
	//Construtor
	public CadastroDto() {
		
	}

    public CadastroDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.telefone = usuario.getTelefone();
        this.cep = usuario.getAddress().getCep();
        this.logradouro = usuario.getAddress().getLogradouro();
        this.complemento = usuario.getAddress().getComplemento();
        this.bairro = usuario.getAddress().getBairro();
        this.localidade = usuario.getAddress().getLocalidade();
        this.uf = usuario.getAddress().getUf();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
    public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
    @Override
    public String toString() {
        return "CadastroDto{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro=" + bairro +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ddd='" + ddd + '\'' +                
                '}';
    }
}
