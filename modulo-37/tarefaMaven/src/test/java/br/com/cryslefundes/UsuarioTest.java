package br.com.cryslefundes;

import br.com.cryslefundes.core.Usuario;
import br.com.cryslefundes.core.enums.UserRole;
import br.com.cryslefundes.repository.IUsuarioRepository;
import br.com.cryslefundes.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    IUsuarioRepository repository;

    public UsuarioTest() {
        this.repository = new UsuarioRepository();
    }

    @Test
    @DisplayName("Testa se as bibliotecas foram carregadas com sucesso")
    public void validaCadastro() {
        Usuario usuario = new Usuario();
        usuario.setName("Funcionario 1");
        usuario.setEmail("funcionario@admin");
        usuario.setBirthdate(LocalDate.now());
        usuario.setRole(UserRole.ADMIN);

        Usuario usuarioSalvo = repository.cadastrar(usuario);
        Assertions.assertNotNull(usuarioSalvo);
        Assertions.assertEquals(usuario.getName(), usuarioSalvo.getName());
    }
}
