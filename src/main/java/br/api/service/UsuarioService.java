package br.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.dto.CadastroDto;
import br.api.dto.UsuarioDto;
import br.api.model.Usuario;
import br.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<CadastroDto> listarCadastros(){
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            List<CadastroDto> usuariosDto = usuarios.stream().map(CadastroDto::new).collect(Collectors.toList());
            return usuariosDto;
        } catch (Exception e) {
            System.out.println("Erro ao listar cadastros" + e.getMessage());
            return null;
        }
    }

    public CadastroDto cadastroById(Long id){
        try {
            Usuario cadastro = usuarioRepository.findById(id).orElse(null);

            if (cadastro == null) {
                return null;
            }

            return new CadastroDto(cadastro);          
        } catch (Exception e) {
            System.out.println("Erro ao buscar cadastro: " + e.getMessage());
            return null;
        }
    }

    public void insertUsuario(UsuarioDto usuarioDto){
        try {
            Usuario usuario = new Usuario(usuarioDto);   
            usuarioRepository.save(usuario);    
        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro: " + e.getMessage());
        }
    }

    public void updateUsuario(UsuarioDto usuarioDto){
        try {
            Usuario usuario = usuarioRepository.findById(usuarioDto.getId()).orElse(null);
            
            if (usuario == null) {
                System.out.println("Cadastro não encontrado!");
                return;
            }

            if(usuarioDto.getNome() != null){
                usuario.setNome(usuarioDto.getNome());
            }
            if(usuarioDto.getEmail() != null){
                usuario.setEmail(usuarioDto.getEmail());
            }
            if(usuarioDto.getCpf() != null){
                usuario.setCpf(usuarioDto.getCpf());
            }
            if(usuarioDto.getDataNascimento() != null){
                usuario.setDataNascimento(usuarioDto.getDataNascimento());
            }
            if(usuarioDto.getTelefone() != null){
                usuario.setTelefone(usuarioDto.getTelefone());
            }

            usuarioRepository.save(usuario);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cadastro: " + e.getMessage());
        }
    }

    public void deleteUsuario(Long id){
        try {
            Usuario cadastro = usuarioRepository.findById(id).orElse(null);

            if (cadastro == null) {
                System.out.println("Cadastro não encontrado!");
                return;
            }

            usuarioRepository.delete(cadastro);
        } catch (Exception e) {
            System.out.println("Erro ao deletar cadastro: " + e.getMessage());
        }
    }
}
