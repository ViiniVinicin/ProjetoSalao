// Localização: src/main/java/com/salaobeleza/model/Profissional.java
package com.salaobeleza.model;

import java.util.List;
import java.util.ArrayList; // Para inicializar a lista

public class Profissional {

    private Long id;
    private String nome;
    private String telefone; // Opcional
    private String email;    // Opcional
    private List<Servico> especializacoes; // Lista dos serviços que o profissional é especializado
    private String jornadaTrabalhoDescricao; // Ex: "Seg-Sex 9h-18h, Sab 8h-12h" (pode evoluir)

    // Construtor padrão
    public Profissional() {
        this.especializacoes = new ArrayList<>();
    }

    // Construtor com campos
    public Profissional(String nome, String telefone, String email, String jornadaTrabalhoDescricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.jornadaTrabalhoDescricao = jornadaTrabalhoDescricao;
        this.especializacoes = new ArrayList<>();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Servico> getEspecializacoes() {
        return especializacoes;
    }

    public void setEspecializacoes(List<Servico> especializacoes) {
        this.especializacoes = especializacoes;
    }

    public String getJornadaTrabalhoDescricao() {
        return jornadaTrabalhoDescricao;
    }

    public void setJornadaTrabalhoDescricao(String jornadaTrabalhoDescricao) {
        this.jornadaTrabalhoDescricao = jornadaTrabalhoDescricao;
    }

    // É uma boa prática adicionar toString(), equals() e hashCode()
    @Override
    public String toString() {
        return "Profissional{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}