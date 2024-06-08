package org.example.models;

public class Alunos {
    public String nome;
    public int matricula;
    public int idade;

    public Alunos(String nome, int matricula, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Matrícula: " + matricula + ", Idade: " + idade;
    }
}