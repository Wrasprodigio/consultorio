package com.consultorio.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

@Entity
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @NotBlank
    @Id
    private String nome;

    @OneToMany
    private List<Consulta> consultas;

    @OneToMany
    private List<Prontuario> prontuarios;

    @ManyToOne //Muitos pacientes para um convenio, ou seja, Many=paciente to One=convenio.
    private Convenio convenios;

    @Size(min=0, max=40, message="Este campo só pode conter no máximo 40 caracteres.")
    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;
    @Size(min=0, max=20, message="Este campo só pode conter no máximo 20 caracteres.")
    @NotBlank
    private String email;

    @NotBlank
    @DateTimeFormat(pattern="dd-mm-yyyy")
    private String dataNascimento;

    @Size(min=0, max=30, message="Este campo deve conter no máximo 30 caracteres.")
    @NotBlank
    private String observacao;


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}