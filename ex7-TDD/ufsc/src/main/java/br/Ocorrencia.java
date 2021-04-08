package br;

public class Ocorrencia {

    private boolean aberto;
    private String resumo;
    private ETIPO_TAREFA tipo_tarefa;
    private EPRIORIDADE_TAREFA tipo_prioridade;
    public Ocorrencia(String string, ETIPO_TAREFA bug, EPRIORIDADE_TAREFA prioridade) {
        this.resumo = string;
        this.tipo_tarefa = bug;
        this.tipo_prioridade = prioridade;
        aberto = true;
    }

    public String getResumo() {
        return this.resumo;
    }

	public Object getTipoTarefa() {
		return this.tipo_tarefa;
	}

    public Object getPrioridade() {
        return this.tipo_prioridade;
    }

    public void setPrioridade(EPRIORIDADE_TAREFA p) {
        if (aberto)
        this.tipo_prioridade = p;
    }

    public void setTarefa(ETIPO_TAREFA t) {
        if (aberto)
        this.tipo_tarefa = t;
    }

    public void setFechado(boolean b) {
        aberto = false;
    }

    public boolean isFechado() {
        return aberto;
    }

}
