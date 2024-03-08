package br.cryslefundes.clientespring.repository;

import br.cryslefundes.clientespring.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
