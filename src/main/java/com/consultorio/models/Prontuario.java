package com.consultorio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "prontuario")
@Entity
public class Prontuario {
    @Id
    @DateTimeFormat(pattern = "dd-mm-yyyy 00:00:00.000")
    private String data;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;

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

    @Size(max=70, message="Este campo só pode conter no máximo 70 caracteres")
    @NotBlank
    private String anamnese;

    @Size(max=70, message="Este campo só pode conter no máximo 70 caracteres")
    @NotBlank
    private String diagnostico;

    @Size(max=70, message="Este campo só pode conter no máximo 70 caracteres")
    @NotBlank
    private String procedimentoRealizado;

    @Size(max=70, message="Este campo só pode conter no máximo 70 caracteres")
    @NotBlank
    private String prescricaoRemedios;

    @Size(max=70, message="Este campo só pode conter no máximo 70 caracteres")
    @NotBlank
    private String prescricaoExames;

    @Size(max=70, message="Este campo só pode conter no máximo 70 caracteres")
    @NotBlank
    private String resultados;

    @Size(max=70, message="Este campo só pode conter no máximo 70 caracteres")
    @NotBlank
    private String observacao;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getProcedimentoRealizado() {
        return procedimentoRealizado;
    }

    public void setProcedimentoRealizado(String procedimentoRealizado) {
        this.procedimentoRealizado = procedimentoRealizado;
    }

    public String getPrescricaoRemedios() {
        return prescricaoRemedios;
    }

    public void setPrescricaoRemedios(String prescricaoRemedios) {
        this.prescricaoRemedios = prescricaoRemedios;
    }

    public String getPrescricaoExames() {
        return prescricaoExames;
    }

    public void setPrescricaoExames(String prescricaoExames) {
        this.prescricaoExames = prescricaoExames;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
