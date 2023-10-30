package com.consultorio.service;

import com.consultorio.models.Convenio;
import com.consultorio.models.Paciente;
import com.consultorio.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioService {

    @Autowired
    ConvenioRepository convenioRepository;

    public List<Convenio> listarConvenios () {
        return convenioRepository.findAll();
    }

    public Convenio obterConvenioPorNome(String nome) {
        return convenioRepository.findById(nome).orElse(null);
    }

    public Convenio cadastrarConvenio (Convenio convenio){
        return convenioRepository.save(convenio);
    }
}
