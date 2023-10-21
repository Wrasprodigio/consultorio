package com.consultorio.controllers;

import com.consultorio.models.Paciente;
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

@Controller
@RequestMapping("/api/pacientes")
public class PacientesController {

    @Autowired
    PacienteService pacienteService;

    //    public List<Paciente> listarTodosPacientes(){
//        return pacienteService.listarTodosPacientes();
//    }
    @GetMapping
    public ResponseEntity<Page<Paciente>> listarTodosPacientes(@PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarTodosPacientes(pageable));
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
