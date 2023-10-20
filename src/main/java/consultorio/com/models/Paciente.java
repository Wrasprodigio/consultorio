package consultorio.com.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

//@Entity
//public class Paciente {
//
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long codigo;
//
//    @NotBlank
//    @Id
//    private String nome;
//
//    @OneToMany
//    private List<Consulta> consultas;
//
//    @OneToMany
//    private List<Prontuario> prontuarios;
//
//    @ManyToOne //Muitos pacientes para um convenio, ou seja, Many=paciente to One=convenio.
//    private Convenio convenios;
//
//    @Size(min=0, max=40, message="Este campo só pode conter no máximo 40 caracteres.")
//    @NotBlank
//    private String endereco;
//
//    @NotBlank
//    private String telefone;
//    @Size(min=0, max=20, message="Este campo só pode conter no máximo 20 caracteres.")
//    @NotBlank
//    private String email;
//
//    @NotBlank
//    @DateTimeFormat(pattern="dd-mm-yyyy")
//    private String dataNascimento;
//
//    @Size(min=0, max=30, message="Este campo deve conter no máximo 30 caracteres.")
//    @NotBlank
//    private String observacao;
//
//    public long getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(long codigo) {
//        this.codigo = codigo;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getDataNascimento() {
//        return dataNascimento;
//    }
//
//    public void setDataNascimento(String dataNascimento) {
//        this.dataNascimento = dataNascimento;
//    }
//
//    public String getObservacao() {
//        return observacao;
//    }
//
//    public void setObservacao(String observacao) {
//        this.observacao = observacao;
//    }
//}


import java.io.Serializable;
import java.util.List;

@Entity
public class Paciente implements Serializable{

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy= GenerationType.AUTO)
    private long codigo;

    @Id//o id tera que ser a chave estrangeira da outra coluna, por isso é importante definir certo!
    private String nome;

    @OneToMany
    private List<Consulta> consultas;

    @DateTimeFormat(pattern="dd-mm-yyyy")
    private String nascimento;

    private String sexo;

    @ManyToOne //Muitos pacientes para um convenio, ou seja, Many=paciente to One=convenio.
    private Convenio convenio;

    @OneToMany
    private List<Prontuario> prontuarios;

    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private long cep;
    private String estado;
    private long telefone;
    private String email;
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
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public long getCep() {
        return cep;
    }
    public void setCep(long cep) {
        this.cep = cep;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public String getNascimento() {
        return nascimento;
    }
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }


}

