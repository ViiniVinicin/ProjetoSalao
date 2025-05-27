// Localização: src/main/java/com/salaobeleza/model/Servico.java
package com.salaobeleza.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true, length = 255)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "tempo_medio_execucao", nullable = false) // Em minutos
    private int tempoMedioExecucao;

    @Column(name = "valor_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorBase;

    // Para mapear List<String> para uma coluna text[] no PostgreSQL:
    // O Hibernate (especialmente versões mais recentes com o dialeto PostgreSQL correto)
    // geralmente consegue lidar com isso. A anotação @Column(columnDefinition = "text[]")
    // pode ajudar a ser mais explícito para o DDL gerado pelo Hibernate, se usado.
    // Se encontrar problemas, um AttributeConverter pode ser necessário.
    @ElementCollection(fetch = FetchType.LAZY) // Cria uma tabela separada por padrão.
    @CollectionTable(name = "servico_produtos_associados", joinColumns = @JoinColumn(name = "servico_id")) // Nome da tabela de junção
    @Column(name = "produto_associado") // Nome da coluna na tabela de junção
    private List<String> produtosAssociados;

    // Construtor padrão (JPA requirement)
    public Servico() {
        this.produtosAssociados = new ArrayList<>();
    }

    public Servico(String nome, String descricao, int tempoMedioExecucao, BigDecimal valorBase) {
        this.nome = nome;
        this.descricao = descricao;
        this.tempoMedioExecucao = tempoMedioExecucao;
        this.valorBase = valorBase;
        this.produtosAssociados = new ArrayList<>();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public int getTempoMedioExecucao() { return tempoMedioExecucao; }
    public void setTempoMedioExecucao(int tempoMedioExecucao) { this.tempoMedioExecucao = tempoMedioExecucao; }
    public BigDecimal getValorBase() { return valorBase; }
    public void setValorBase(BigDecimal valorBase) { this.valorBase = valorBase; }
    public List<String> getProdutosAssociados() { return produtosAssociados; }
    public void setProdutosAssociados(List<String> produtosAssociados) { this.produtosAssociados = produtosAssociados; }

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