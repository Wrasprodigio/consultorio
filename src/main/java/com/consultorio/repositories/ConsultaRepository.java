package com.consultorio.repositories;

import com.consultorio.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, String> {
    Iterable<Consulta> findByData(String data);
    Consulta findByCodigo(long codigo);
}
