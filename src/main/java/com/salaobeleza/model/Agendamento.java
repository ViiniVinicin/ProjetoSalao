// Localização: src/main/java/com/salaobeleza/model/Agendamento.java
package com.salaobeleza.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Agendamento {

    private Long id;
    private Cliente cliente;
    private Servico servico;
    private Profissional profissional;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private BigDecimal valorCobrado; // Pode ser o valor base do serviço ou um valor customizado
    private String observacoesAdicionais; // Notas específicas para este agendamento
    private StatusAgendamento status;

    // Construtor padrão
    public Agendamento() {
    }

    // Construtor com campos essenciais (dataHoraFim pode ser calculada)
    public Agendamento(Cliente cliente, Servico servico, Profissional profissional,
                       LocalDateTime dataHoraInicio, BigDecimal valorCobrado, StatusAgendamento status) {
        this.cliente = cliente;
        this.servico = servico;
        this.profissional = profissional;
        this.dataHoraInicio = dataHoraInicio;
        this.valorCobrado = valorCobrado; // Inicialmente pode ser o servico.getValorBase()
        this.status = status;
        // Calcular dataHoraFim baseado no tempoMedioExecucao do serviço
        if (servico != null && dataHoraInicio != null) {
            this.dataHoraFim = dataHoraInicio.plusMinutes(servico.getTempoMedioExecucao());
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
        // Recalcular dataHoraFim se o serviço ou dataHoraInicio mudarem e ambos estiverem definidos
        if (this.dataHoraInicio != null && this.servico != null) {
            this.dataHoraFim = this.dataHoraInicio.plusMinutes(this.servico.getTempoMedioExecucao());
        }
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
        // Recalcular dataHoraFim se o serviço ou dataHoraInicio mudarem e ambos estiverem definidos
        if (this.dataHoraInicio != null && this.servico != null) {
            this.dataHoraFim = this.dataHoraInicio.plusMinutes(this.servico.getTempoMedioExecucao());
        }
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        // Geralmente é calculado, mas pode permitir setar manualmente em casos especiais
        this.dataHoraFim = dataHoraFim;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public String getObservacoesAdicionais() {
        return observacoesAdicionais;
    }

    public void setObservacoesAdicionais(String observacoesAdicionais) {
        this.observacoesAdicionais = observacoesAdicionais;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    // É uma boa prática adicionar toString(), equals() e hashCode()
    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", cliente=" + (cliente != null ? cliente.getNome() : "null") +
                ", servico=" + (servico != null ? servico.getNome() : "null") +
                ", profissional=" + (profissional != null ? profissional.getNome() : "null") +
                ", dataHoraInicio=" + dataHoraInicio +
                ", status=" + status +
                '}';
    }
}