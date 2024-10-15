package org.senai.model;

public class Estudante {
    private int pessoaId;
    private String matricula;

    public Estudante(int pessoaId, String matricula) {
        this.pessoaId = pessoaId;
        this.matricula = matricula;
    }

    // Getters e Setters
    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}