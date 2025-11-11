package com.unicesumar.restful.service;

import com.unicesumar.restful.model.Curso;
import com.unicesumar.restful.repository.AlunoRepository;
import com.unicesumar.restful.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AlunoService {
    private final AlunoRepository alunoRepo;
    private final CursoRepository cursoRepo;
    public AlunoService(AlunoRepository alunoRepo, CursoRepository cursoRepo){
        this.alunoRepo = alunoRepo;
        this.cursoRepo = cursoRepo;
    }
    public Aluno create(Aluno aluno){
        if (aluno.getMatricula() != null && alunoRepo.existsByMatricula(aluno.getMatricula())){
            throw new RuntimeException("Matricula já existe: " + aluno.getMatricula());
        }
        if (aluno.getCurso() != null && aluno.getCurso().getId() != null){
            Curso curso = cursoRepo.findAllById(aluno.getCurso().getId())
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado: " + aluno.getCurso().getId()));
            aluno.setCurso(curso);
        }
    }
}
