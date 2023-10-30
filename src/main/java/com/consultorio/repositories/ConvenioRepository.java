package com.consultorio.repositories;

import com.consultorio.models.Convenio;
import com.consultorio.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvenioRepository extends JpaRepository<Convenio, String> {

}
