package com.unicesumar.restful.service;

import com.unicesumar.restful.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CursoService {

    private final CursoRepository repo;
    public CursoService(CursoRepository repo){
        this.repo = repo;
    }

    public Curso create(Curso curso){
        return repo.save(curso);
    }

    public List<Curso> findALL(){
        return repo.findAll();
    }

    public Optional<Curso> findById(Long id){
        return repo.findById(id);
    }

    public Curso update (Long id, Curso updated){
        return repo.findById(id).map(c -> {

            c.setNome(updated.getNome());
            c.setCargaHoraria(updated.getCargaHoraria());
            return repo.save(c);
    }).orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + id));

    }
    public void delete (Long id){
        repo.deleteById(id);
    }
}
