// Em Agendamento.java
package com.salaobeleza.model;

import jakarta.persistence.*; // ou javax.persistence.* dependendo da sua versão do Spring Boot
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos") // Nome da tabela no banco
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Muitos Agendamentos para Um Cliente
    @JoinColumn(name = "cliente_id", nullable = false) // Chave estrangeira na tabela agendamentos
    private Cliente cliente; // Este é o campo que o "mappedBy = cliente" na classe Cliente se refere

    @ManyToOne // Muitos Agendamentos para Um Servico
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    @ManyToOne // Muitos Agendamentos para Um Profissional
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @Column(name = "data_hora_inicio", nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim", nullable = false)
    private LocalDateTime dataHoraFim;

    @Column(name = "valor_cobrado")
    private BigDecimal valorCobrado;

    @Column(name = "observacoes_adicionais", columnDefinition = "TEXT")
    private String observacoesAdicionais;

    @Enumerated(EnumType.STRING) // Grava o Enum como String no banco
    @Column(name = "status", nullable = false)
    private StatusAgendamento status; // Seu Enum StatusAgendamento

    // Construtores, Getters e Setters (essenciais para JPA)
    // ...
}