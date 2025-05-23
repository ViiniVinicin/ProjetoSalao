package com.salaobeleza.model;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Servico {
    private int id;
    private String nome;
    private String descricao;
    private int tempoMedioExecucao;
    private float valorBase;
    private List<String> produtosAssociados; // Pode evoluir para List<Produto> no futuro

    // Construtor Padrão
    public Servico() {
        this.produtosAssociados = new ArrayList<>();
    }

    // Construtor com campos
    private Servico(int id, String nome,
                    String descricao, int tempoMedioExecucao,
                    float valorBase){
        this.nome = nome;
        this.descricao = descricao;
        this.tempoMedioExecucao = tempoMedioExecucao;
        this.valorBase = valorBase;
        this.produtosAssociados = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoMedioExecucao() {
        return tempoMedioExecucao;
    }

    public void setTempoMedioExecucao(int tempoMedioExecucao) {
        this.tempoMedioExecucao = tempoMedioExecucao;
    }

    public float getValorBase() {
        return valorBase;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public List<String> getProdutosAssociados() {
        return produtosAssociados;
    }

    public void setProdutosAssociados(List<String> produtosAssociados) {
        this.produtosAssociados = produtosAssociados;
    }

    // É uma boa prática adicionar toString(), equals() e hashCode()
    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tempoMedioExecucao=" + tempoMedioExecucao +
                ", valorBase=" + valorBase +
                '}';
    }
}

