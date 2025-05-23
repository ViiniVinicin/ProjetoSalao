package com.salaobeleza;

import java.time.LocalDate;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private List<Agendamento> historicoServicos;
    private String observacoes;

    // Construtor
    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = "";
        this.endereco = "";
        this.historicoServicos = new ArrayList<>();
        this.observacoes = "";
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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




}
