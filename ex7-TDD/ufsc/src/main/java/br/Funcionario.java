package br;

public class Funcionario {
    
    private String name;
    private int nOcorrencias;

    public Funcionario(String name) {
        this.name = name;
        nOcorrencias = 0;
    }

    public Integer getNumOcorrencias() {
        return nOcorrencias;
    }

    public String getName() {
        return this.name;
    }

    public void incrementOcorrencia() {
        nOcorrencias++;
    }

}
