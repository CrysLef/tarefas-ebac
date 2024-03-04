package br.com.cryslefundes.core;

import br.com.cryslefundes.core.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column(length = 100, unique = true, nullable = false)
    private String email;
}