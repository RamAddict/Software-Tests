package br;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class Empresa {

    public Empresa() {
        this.listaFuncionarios = new ArrayList<>();
        this.listaProjetosSize = new ArrayList<>();
        this.listaOcorrencias = new ArrayList<>();
        this.funcionarioParaOcorrencia = new HashMap<Funcionario, Ocorrencia>();
    };

    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Projeto> listaProjetosSize;
    private ArrayList <Ocorrencia> listaOcorrencias;
    private Map<Funcionario, Ocorrencia> funcionarioParaOcorrencia;


    public Integer getListaFuncionariosSize() {
        return this.listaFuncionarios.size();
    }

    public Integer getListaProjetosSize() {
        return this.listaProjetosSize.size();
    }

    public void addFuncionario(Funcionario funcionario) {
        this.listaFuncionarios.add(funcionario);
    }

	public void addProjeto(Projeto projeto) {
        this.listaProjetosSize.add(projeto);
	}

    public void addOcorrencia(Funcionario funcionario, Ocorrencia ocorrencia, Projeto p) {
        if (funcionario.getNumOcorrencias() == 10)
        {
            return;
        }
        this.funcionarioParaOcorrencia.put(funcionario, ocorrencia);
        this.listaOcorrencias.add(ocorrencia);
        p.addOcorrencia(ocorrencia);
        funcionario.incrementOcorrencia();
    }

    public Object getListaOcorrenciasSize() {
        return this.listaOcorrencias.size();
    }

    public Object getOcorrenciaOfFuncionario(Funcionario f) {
        return this.funcionarioParaOcorrencia.get(f);
    }

    public void closeTarefa(Ocorrencia o) {
        o.setFechado(false);
    }
    
    
}
