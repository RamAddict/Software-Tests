package br;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmpresaTest {
    
    public Empresa empresa;

    @BeforeEach
    public void setup()
    {
        // empty empresa
        this.empresa  = new Empresa();
    }
    
    @Test
    public void shouldBeCorrectClass() {
        assertEquals(empresa.getClass(), Empresa.class);
    }

    @Test
    public void shouldBeEmptyListFuncionarios() {
        assertEquals(empresa.getListaFuncionariosSize(), 0);
    }

    @Test
    public void shouldBeEmptyListProjetos() {
        assertEquals(empresa.getListaProjetosSize(), 0);
    }

    @Test
    public void shouldCorrectlyAddFuncionario() {
        this.empresa.addFuncionario(new Funcionario("Ana"));
        assertThat(empresa.getListaFuncionariosSize(), equalTo(1));
    }

    @Test
    public void shouldCorrectlyAddProjeto() {
        this.empresa.addProjeto(new Projeto());
        assertThat(this.empresa.getListaProjetosSize(), equalTo(1));
    }

    @Test
    public void shouldGetAddedOcorrencia() {
        var f = new Funcionario("Tom");
        var o = new Ocorrencia("Resumao", ETIPO_TAREFA.BUG, EPRIORIDADE_TAREFA.MEDIA);
        var p = new Projeto();
        this.empresa.addOcorrencia(f, o, p);
        assertThat(this.empresa.getListaOcorrenciasSize(), equalTo(1));
        assertThat(this.empresa.getOcorrenciaOfFuncionario(f), equalTo(o));
        assertThat(p.getSizeListaOcorrencias(), equalTo(1));
    }
    @Test
    public void addMoreThan10OcorrenciasToFuncionario() {
        var f = new Funcionario("Tom");
        for (int i = 0; i != 10; i++) {
            assertThat(f.getNumOcorrencias(), equalTo(i));
            var o = new Ocorrencia("Resumao"+i, ETIPO_TAREFA.BUG, EPRIORIDADE_TAREFA.MEDIA);
            var p = new Projeto();
            this.empresa.addOcorrencia(f, o, p);
        }
        var o = new Ocorrencia("Resumao"+10, ETIPO_TAREFA.BUG, EPRIORIDADE_TAREFA.ALTA);
        var p = new Projeto();
        this.empresa.addOcorrencia(f, o, p);
        assertTrue(f.getNumOcorrencias() != 11);
    }

    public void testChangeEstadoTarefa() {
        var f = new Funcionario("Tom");
        var o = new Ocorrencia("Resumao", ETIPO_TAREFA.BUG, EPRIORIDADE_TAREFA.MEDIA);
        var p = new Projeto();
        this.empresa.addOcorrencia(f, o, p);
        this.empresa.closeTarefa(o);
        assert(o.isFechado() == true);
    }

    public void testCannotChangeAtributesTarefaAfterClosingIt() {
        var f = new Funcionario("Tom");
        var o = new Ocorrencia("Resumao", ETIPO_TAREFA.BUG, EPRIORIDADE_TAREFA.MEDIA);
        var p = new Projeto();
        this.empresa.addOcorrencia(f, o, p);
        this.empresa.closeTarefa(o);
        assert(o.isFechado() == true);
        o.setTarefa(ETIPO_TAREFA.MELHORIA);
        assertEquals(o.getTipoTarefa(), ETIPO_TAREFA.BUG);
    }

}
