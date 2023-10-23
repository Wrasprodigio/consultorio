package com.consultorio.controllers;

import com.consultorio.models.Convenio;
import com.consultorio.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/convenios")
public class ConveniosController {

    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public ResponseEntity<Page<Convenio>> listarConvenios(@PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(convenioService.listarConvenios(pageable));
    }

    @PostMapping
    public ResponseEntity<Convenio> cadastrarConvenio(@RequestBody Convenio convenio){
        Convenio novoConvenio = convenioService.cadastrarConvenio(convenio);
        return new ResponseEntity<>(novoConvenio, HttpStatus.CREATED);
    }

}
