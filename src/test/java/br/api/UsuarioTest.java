package br.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.api.model.Usuario;
import br.api.dto.UsuarioDto;

public class UsuarioTest {

    private Usuario usuario;
    private UsuarioDto usuarioDto;


    @BeforeEach
    public void setUp() {

        usuarioDto = new UsuarioDto();
        usuarioDto.setNome("John Doe");
        usuarioDto.setEmail("john.doe@example.com");
        usuarioDto.setCpf("12345678901");
        usuarioDto.setDataNascimento(LocalDateTime.of(1990, 1, 1, 0, 0));
        usuarioDto.setTelefone("123456789");
        //usuarioDto.setAddress(address);

        usuario = new Usuario(usuarioDto);
    }

    @Test
    public void testUsuarioNotNull() {
        assertNotNull(usuario);
    }

    @Test
    public void testGetNome() {
        assertEquals("John Doe", usuario.getNome());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", usuario.getEmail());
    }

    @Test
    public void testGetCpf() {
        assertEquals("12345678901", usuario.getCpf());
    }

    @Test
    public void testGetDataNascimento() {
        assertEquals(LocalDateTime.of(1990, 1, 1, 0, 0), usuario.getDataNascimento());
    }

    @Test
    public void testGetTelefone() {
        assertEquals("123456789", usuario.getTelefone());
    }

    @Test
    public void testToString() {
        String expected = "Cadastro{nome='John Doe', email='john.doe@example.com', cpf='123.456.789-01', dataNascimento=1990-01-01T00:00, telefone='12345-6789'}";
        assertEquals(expected, usuario.toString());
    }
}
