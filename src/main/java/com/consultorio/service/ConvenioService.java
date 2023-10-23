package com.consultorio.service;

import com.consultorio.models.Convenio;
import com.consultorio.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConvenioService {

    @Autowired
    ConvenioRepository convenioRepository;

    public Page<Convenio> listarConvenios (Pageable pageable) {
        return convenioRepository.findAll(pageable);
    }

    public Convenio cadastrarConvenio (Convenio convenio){
        return convenioRepository.save(convenio);
    }
}
