package com.consultorio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Table(name = "consulta")
@Entity
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @JsonIgnore
    @ManyToOne //Muitas consultas para um paciente, ou seja, Many=consulta  One=paciente.
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;

    @NotBlank
    private boolean status;

    @NotBlank
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String data;

    @NotBlank
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String horarioInicio;

    @NotBlank
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String horarioTermino;

    @NotBlank
    @Size(max = 100, message = "Este campo só pode conter até 100 caracteres")
    private String observacao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
