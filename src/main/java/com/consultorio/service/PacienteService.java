package com.consultorio.service;

import com.consultorio.models.Convenio;
import com.consultorio.models.Paciente;
import com.consultorio.repositories.ConvenioRepository;
import com.consultorio.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ConvenioRepository convenioRepository;


    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente obterPacientePorNome(String nome) {
        return pacienteRepository.findById(nome).orElse(null);
    }

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(String nome, Paciente paciente) {
        List<Paciente> pacienteEncontrado = pacienteRepository.findByNome(nome);
        if (pacienteEncontrado.isEmpty()) {
            return null;
        }
        paciente.setNome(nome);
        return pacienteRepository.save(paciente);
    }

    public boolean excluirPaciente(String nome) {
        List<Paciente> pacienteExcluido = pacienteRepository.findByNome(nome);
        if (pacienteExcluido.isEmpty()) {
            return false;
        }
        pacienteRepository.deleteById(nome);
        return true;
    }
}
