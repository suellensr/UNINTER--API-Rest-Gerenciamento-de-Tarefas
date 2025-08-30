package com.example.resttarefas.service;

import com.example.resttarefas.model.Tarefa;
import com.example.resttarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    public Optional<Tarefa> findById(long id) {
        return repository.findById(id);
    }

    public Tarefa create(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Optional<Tarefa> update(long id, Tarefa tarefa) {
        return repository.findById(id).map(record -> {
            record.setNome(tarefa.getNome());
            record.setDataEntrega(tarefa.getDataEntrega());
            record.setResponsavel(tarefa.getResponsavel());
            return repository.save(record);
        });
    }

    public boolean delete(long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}