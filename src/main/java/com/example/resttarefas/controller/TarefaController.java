package com.example.resttarefas.controller;

import com.example.resttarefas.model.Tarefa;
import com.example.resttarefas.repository.TarefaRepository;
import com.example.resttarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({ "/tarefas" })
public class TarefaController {

    private final TarefaService service;

    TarefaController(TarefaService tarefaService) {
        this.service = tarefaService;
    }

    @GetMapping("/listar")
    public List<Tarefa> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "exibir/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/salvar")
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return service.create(tarefa);
    }
    @PutMapping(value = "editar/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa) {
        return service.update(id, tarefa).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping(path = "deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

