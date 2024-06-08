package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Turmas {
    public String nomeSala;
    public String localizacao;
    public List<Alunos> alunos;

    public Turmas(String nomeSala, String localizacao) {
        this.nomeSala = nomeSala;
        this.localizacao = localizacao;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAlunos(Alunos aluno) {
        alunos.add(aluno);
    }



    public void listarAlunos() {
        System.out.println("Alunos da " + nomeSala + " (" + localizacao + "):");
        for (Alunos aluno : alunos) {
            System.out.println(aluno);
        }
    }

    @Override
    public String toString() {
        return "Turma: " + nomeSala + " (Local: " + localizacao + ")";
    }
}
