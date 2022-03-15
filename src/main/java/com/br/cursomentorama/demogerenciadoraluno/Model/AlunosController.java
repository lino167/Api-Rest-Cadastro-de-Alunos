package com.br.cursomentorama.demogerenciadoraluno.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

import com.br.cursomentorama.demogerenciadoraluno.Aluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Alunos")
public class AlunosController {

 private final List<Aluno> alunos;
 public AlunosController(){
     this.alunos = new ArrayList<>();
 }
@GetMapping
public List<Aluno> findAll(@RequestParam(required = false) String nome, @RequestParam(required = false) Integer idade){
        if(nome != null && idade !=null){
            return alunos.stream()
                    .filter(aluno -> aluno.getNome().contains(nome) && aluno.getIdade().equals(idade))
                    .collect(Collectors.toList());
        } else if (nome!=null){
            return alunos.stream()
                    .filter(aluno -> aluno.getNome().contains(nome))
                    .collect(Collectors.toList());
        } else if (idade!=null){
            return alunos.stream()
                    .filter(aluno -> aluno.getIdade().equals(idade))
                    .collect(Collectors.toList());
        }
        return alunos;
    }
 
    

  
    
}
