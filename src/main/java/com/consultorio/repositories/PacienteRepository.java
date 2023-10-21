package com.consultorio.repositories;

import com.consultorio.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    Optional<Paciente> findByNome(String nome);

}
