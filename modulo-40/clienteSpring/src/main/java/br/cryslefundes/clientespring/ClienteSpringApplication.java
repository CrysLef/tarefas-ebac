package br.cryslefundes.clientespring;

import br.cryslefundes.clientespring.domain.Cliente;
import br.cryslefundes.clientespring.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteSpringApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ClienteSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = Cliente.builder()
                .name("Crystian")
                .email("funcionario@admin.com")
                .password("admin")
                .build();
        repository.save(cliente);
    }
}
