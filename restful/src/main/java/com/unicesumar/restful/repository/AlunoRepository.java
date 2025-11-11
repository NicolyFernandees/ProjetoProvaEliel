package com.unicesumar.restful.repository;

import com.unicesumar.restful.model.Aluno;
import org.springframework.cglib.core.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {
    boolean existsByMatricula(String matricula);
}
