// Localização: src/main/java/com/salaobeleza/repository/ClienteRepository.java
package com.salaobeleza.repository;

import com.salaobeleza.model.Cliente; // Importe sua entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository // Boa prática, embora opcional para interfaces que estendem JpaRepository em versões recentes do Spring Boot
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Exemplo de método de consulta customizado: buscar cliente por email
    // O Spring Data JPA implementa isso automaticamente baseado no nome do método.
    Optional<Cliente> findByEmail(String email);

    // Exemplo: buscar clientes por parte do nome (ignorando maiúsculas/minúsculas)
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

}