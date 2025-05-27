// Localização: src/main/java/com/salaobeleza/model/Cliente.java
package com.salaobeleza.model;

import jakarta.persistence.*;  // Pacote para anotações JPA (javax.persistence.* em versões mais antigas do Spring Boot)
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity // Marca esta classe como uma entidade JPA (será uma tabela no banco)
@Table(name = "clientes") // Especifica o nome da tabela no banco de dados
public class Cliente {

    @Id // Marca este campo como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do ID (compatível com BIGSERIAL do PostgreSQL)
    private Long id;

    @Column(name = "nome", nullable = false, length = 255) // Mapeia para a coluna 'nome', não nula, com tamanho máximo
    private String nome;

    @Column(name = "telefone", nullable = false, length = 20) // Mapeia para a coluna 'telefone', não nula
    private String telefone;

    @Column(name = "email", unique = true, length = 255) // Mapeia para a coluna 'email', valor único
    private String email; // Opcional na lógica, mas a coluna permite null se não for @Column(nullable=false)

    @Column(name = "data_nascimento") // Mapeia para a coluna 'data_nascimento'
    private LocalDate dataNascimento; // Opcional

    // Relacionamento Um-para-Muitos com Agendamento
    // Um Cliente pode ter Muitos Agendamentos.
    // "mappedBy = cliente" indica que o lado "Muitos" (Agendamento) tem um campo chamado "cliente" que gerencia o relacionamento.
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Agendamento> historicoServicos;

    @Column(name = "observacoes", columnDefinition = "TEXT") // Mapeia para a coluna 'observacoes', tipo TEXT
    private String observacoes; // Opcional

    // Construtor padrão (exigido pelo JPA)
    public Cliente() {
        this.historicoServicos = new ArrayList<>();
    }

    // Construtor com campos principais
    public Cliente(String nome, String telefone, String email, LocalDate dataNascimento, String observacoes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.observacoes = observacoes;
        this.historicoServicos = new ArrayList<>();
    }

    // Getters e Setters (omitidos aqui por brevidade, mas você deve mantê-los)
    // ... Seus getters e setters para todos os campos ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public List<Agendamento> getHistoricoServicos() { return historicoServicos; }
    public void setHistoricoServicos(List<Agendamento> historicoServicos) { this.historicoServicos = historicoServicos; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}