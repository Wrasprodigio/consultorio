package com.example.consultorio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Procedimento {
    @Id
    @NotBlank
    private String tipoProcedimento;

    @OneToMany
    private List<Consulta> consultas;

    @OneToMany
    private List<Prontuario> prontuario;

    public String getTipoProcedimento() {
        return tipoProcedimento;
    }

    public void setTipoProcedimento(String tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }
}
