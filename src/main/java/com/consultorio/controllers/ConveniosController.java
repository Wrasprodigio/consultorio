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

import java.util.List;

@Controller
@RequestMapping("/api/convenios")
public class ConveniosController {

    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public ResponseEntity<List<Convenio>> listarConvenios() {
        List<Convenio> convenios = convenioService.listarConvenios();
        return ResponseEntity.ok(convenios);

    }

    @GetMapping("/{nome}")
    public ResponseEntity<Convenio> buscarConvenio(@PathVariable String nome) {
        Convenio convenio = convenioService.obterConvenioPorNome(nome);
        if (convenio != null) {
            return new ResponseEntity<>(convenio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Convenio> cadastrarConvenio(@RequestBody Convenio convenio){
        Convenio novoConvenio = convenioService.cadastrarConvenio(convenio);
        return new ResponseEntity<>(novoConvenio, HttpStatus.CREATED);
    }

}
