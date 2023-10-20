package consultorio.com.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nomeConvenio;

    @OneToMany // Um convenio para muitos pacientes, ou seja, One=convenio  Many=pacientes.
    private List<Paciente> pacientes;

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }
}
