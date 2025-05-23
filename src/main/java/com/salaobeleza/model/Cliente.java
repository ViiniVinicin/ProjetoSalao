// Localização: src/main/java/com/salaobeleza/model/Cliente.java
package com.salaobeleza.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList; // Para inicializar a lista

// Supondo que a classe Agendamento.java já existe no mesmo pacote ou foi importada
// import com.salaobeleza.model.Agendamento; // Não é necessário se estiver no mesmo pacote

public class Cliente {

    private Long id; // Identificador único
    private String nome;
    private String telefone;
    private String email; // Opcional
    private LocalDate dataNascimento; // Opcional
    private List<Agendamento> historicoServicos; // Histórico de serviços/agendamentos do cliente
    private String observacoes; // Alergias, preferências, etc. (Opcional)

    // Construtor padrão
    public Cliente() {
        this.historicoServicos = new ArrayList<>();
    }

    // Construtor com campos principais (id é geralmente gerado pelo banco, histórico começa vazio)
    public Cliente(String nome, String telefone, String email, LocalDate dataNascimento, String observacoes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.observacoes = observacoes;
        this.historicoServicos = new ArrayList<>();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Agendamento> getHistoricoServicos() {
        return historicoServicos;
    }

    public void setHistoricoServicos(List<Agendamento> historicoServicos) {
        this.historicoServicos = historicoServicos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // É uma boa prática adicionar toString(), equals() e hashCode()
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