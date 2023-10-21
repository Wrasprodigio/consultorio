package com.consultorio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Prontuario {
    @Id
    @DateTimeFormat(pattern = "dd-mm-yyyy 00:00:00.000")
    private String data;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Procedimento procedimento;

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
