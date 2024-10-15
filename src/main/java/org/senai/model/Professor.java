package org.senai.model;

public class Professor {
    private int pessoaId;
    private String departamento;

    public Professor(int pessoaId, String departamento) {
        this.pessoaId = pessoaId;
        this.departamento = departamento;
    }

    // Getters e Setters
    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}