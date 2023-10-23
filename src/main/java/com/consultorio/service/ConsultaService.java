package com.consultorio.service;

import com.consultorio.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;
}
