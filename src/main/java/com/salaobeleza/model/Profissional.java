// Localização: src/main/java/com/salaobeleza/model/Profissional.java
package com.salaobeleza.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set; // Usar Set para coleções ManyToMany é uma boa prática
import java.util.HashSet;

@Entity
@Table(name = "profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "telefone", length = 20)
    private String telefone; // Opcional

    @Column(name = "email", unique = true, length = 255)
    private String email;    // Opcional, mas único se presente

    @Column(name = "jornada_trabalho_descricao", columnDefinition = "TEXT")
    private String jornadaTrabalhoDescricao;

    // Relacionamento Muitos-para-Muitos com Servico (para especializações)
    // A tabela de junção "profissionais_especializacoes" será usada.
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "profissionais_especializacoes",
            joinColumns = @JoinColumn(name = "profissional_id"), // Coluna nesta entidade (Profissional) na tabela de junção
            inverseJoinColumns = @JoinColumn(name = "servico_id") // Coluna da outra entidade (Servico) na tabela de junção
    )
    private Set<Servico> especializacoes; // Usar Set é uma boa prática para ManyToMany

    // Construtor padrão (JPA requirement)
    public Profissional() {
        this.especializacoes = new HashSet<>();
    }

    public Profissional(String nome, String telefone, String email, String jornadaTrabalhoDescricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.jornadaTrabalhoDescricao = jornadaTrabalhoDescricao;
        this.especializacoes = new HashSet<>();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getJornadaTrabalhoDescricao() { return jornadaTrabalhoDescricao; }
    public void setJornadaTrabalhoDescricao(String jornadaTrabalhoDescricao) { this.jornadaTrabalhoDescricao = jornadaTrabalhoDescricao; }
    public Set<Servico> getEspecializacoes() { return especializacoes; }
    public void setEspecializacoes(Set<Servico> especializacoes) { this.especializacoes = especializacoes; }


    @Override
    public String toString() {
        return "Profissional{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}