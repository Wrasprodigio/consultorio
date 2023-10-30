package com.consultorio.controllers;

import com.consultorio.models.Convenio;
import com.consultorio.models.Paciente;
import com.consultorio.service.ConsultaService;
import com.consultorio.service.ConvenioService;
import com.consultorio.service.PacienteService;
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
@RequestMapping("/api/pacientes")
public class PacientesController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    ConvenioService convenioService;

    @Autowired
    ConsultaService consultaService;

    @PostMapping("/associar-convenio/{nome}/{nomeConvenio}")
    public ResponseEntity<String> associarPacienteAConvenio(
            @PathVariable String nome,
            @PathVariable String nomeConvenio) {

        Paciente paciente = pacienteService.obterPacientePorNome(nome);
        Convenio convenio = convenioService.obterConvenioPorNome(nomeConvenio);

        if (paciente != null && convenio != null) {
            paciente.setConvenio(convenio);
            pacienteService.criarPaciente(paciente);
            return ResponseEntity.ok("Paciente associado ao convênio com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Paciente ou convênio não encontrados.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodosPacientes(@PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) Paciente paciente) {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarTodosPacientes());

    }

    @GetMapping("/{nome}")
    public ResponseEntity<Paciente> obterPacientePorNome(@PathVariable String nome) {
        Paciente paciente = pacienteService.obterPacientePorNome(nome);
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.criarPaciente(paciente);
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }

    @PutMapping("/{nome}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable String nome, @RequestBody Paciente paciente) {
        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(nome, paciente);
        if (paciente != null) {
            return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Paciente> excluirPaciente(@PathVariable String nome) {
        boolean excluido = pacienteService.excluirPaciente(nome);
        if (excluido) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
