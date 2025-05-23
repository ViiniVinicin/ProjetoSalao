package com.salaobeleza;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void shouldConnectToDatabase() throws SQLException {
        // Verifica se o DataSource foi injetado corretamente
        assertNotNull(dataSource, "DataSource não deve ser nulo");

        // Tenta obter uma conexão
        try (Connection connection = dataSource.getConnection()) {
            // Verifica se a conexão é válida
            assertTrue(connection.isValid(1),
                    "A conexão com o banco de dados deve ser válida");

            // Verifica se não está no modo auto-commit (opcional)
            assertFalse(connection.getAutoCommit(),
                    "O auto-commit deve estar desativado por padrão");
        }
    }
}