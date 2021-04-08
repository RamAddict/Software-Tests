package br;

import java.util.ArrayList;

public class Projeto {

    private ArrayList<Ocorrencia> listaOcorrencias;

    public Projeto() {
        this.listaOcorrencias = new ArrayList<>();
    }

    public Integer getSizeListaOcorrencias() {
        return this.listaOcorrencias.size();
    }

    public void addOcorrencia(Ocorrencia ocorrencia) {
        this.listaOcorrencias.add(ocorrencia);
    }

}
