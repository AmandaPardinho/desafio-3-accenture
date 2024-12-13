package br.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.api.dto.CadastroDto;
import br.api.dto.UsuarioDto;
import br.api.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<CadastroDto> getCadastros() {
        return usuarioService.listarCadastros();
    }

    @GetMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CadastroDto getCadastroById(Long id) {
        return usuarioService.cadastroById(id);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public String insertUsuario(@RequestBody UsuarioDto usuarioDto) {       
        usuarioService.insertUsuario(usuarioDto);
        return "Usuario inserido com sucesso!";
    }

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateUsuario(@RequestBody UsuarioDto usuarioDto) {
        usuarioService.updateUsuario(usuarioDto);
        return "Usuario atualizado com sucesso!";
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUsuario(Long id) {
        usuarioService.deleteUsuario(id);
        return "Usuario deletado com sucesso!";
    }


}
