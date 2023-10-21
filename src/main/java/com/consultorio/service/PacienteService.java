package com.consultorio.service;

import com.consultorio.models.Paciente;
import com.consultorio.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

//    public List<Paciente> listarTodosPacientes() {
//        return pacienteRepository.findAll();
//    }

    public Page<Paciente> listarTodosPacientes(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    public Paciente obterPacientePorNome(String nome) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findByNome(nome);
        return pacienteOptional.orElse(null);
    }

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(String nome, Paciente paciente) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findByNome(nome);
        if (pacienteOptional.isPresent()) {
            paciente.setNome(nome);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public boolean excluirPaciente(String nome) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findByNome(nome);
        if (pacienteOptional.isPresent()) {
            pacienteRepository.deleteById(nome);
            return true;
        }
        return false;
    }
}
