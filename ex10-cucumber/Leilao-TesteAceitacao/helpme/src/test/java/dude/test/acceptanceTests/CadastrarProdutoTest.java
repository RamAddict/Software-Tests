package dude.test.acceptanceTests;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import dude.modelo.MercadoLeilao;

public class CadastrarProdutoTest {
    MercadoLeilao fachada = new MercadoLeilao();
    public String nome = "";
    public String descricao = "";
    public Double lance = (double) 0;
    public String cpf = "";
    public Date data;


    @Given("O cadastro do usuario Ernani Cesar foi realizado")
    public void o_cadastro_do_usuario_ernani_cesar_foi_realizado() throws Exception {
        this.fachada.cadastrarUsuario("Ernani Cesar", "Campus Universitario", "ernani.santos@posgrad.ufsc.br", "055.761.919-00");
    }

    @Given("O nome de Produto {string}")
    public void o_nome_de_produto(String string) {
        this.nome = string;
        
    }
    @Given("a descricao {string}")
    public void a_descricao(String string) {
        this.descricao = string;
        
    }
    @Given("o lance minimo de {double}")
    public void o_lance_minimo_de(Double double1) {
        this.lance = double1;
        
    }
    @Given("o cpf do leiloador é o do Ernani Cesar {string}")
    public void o_cpf_do_leiloador_é_o_do_ernani_cesar(String string) {
        this.cpf = string;
        
    }
    @Given("a data limite é {int}")
    public void a_data_limite_é(Integer int1) {
        this.data = Calendar.getInstance().getTime();
    }
    @When("O produto é cadastrado")
    public void o_produto_eh_cadastrado() {
        boolean cadastro = false;
        try {
            this.fachada.cadastrarProduto(this.nome, this.descricao, this.lance, this.cpf, this.data);
            cadastro = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(true, cadastro);
    }

    @Then("o sistema avisa que o cadastro teve sucesso")
    public void o_sistema_deve_avisar_que_houve_exito_no_cadastro() {
        boolean expectedResult = false;
        try{
            if(this.fachada.getProdutosVencidosENaoVendidos().get(0).getNome().equals(this.nome)) 
            {
                // System.out.println("Usuário encontrado");
                expectedResult= true;
            } else 
            {
                // System.out.println("Usuário não encontrado");
                expectedResult= false;
            }
        } catch(Exception e)
        {
            // TODO Auto-generated catch block
            expectedResult= false;
            e.printStackTrace();
        }
        assertEquals(true, expectedResult);
        System.out.println("Produto cadastrado com sucesso");
    }

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Given("O produto é cadastrado pela primeira vez")
    public void o_produto_é_cadastrado_pela_primeira_vez() {
        boolean cadastro = false;
        try {
            this.fachada.cadastrarProduto(this.nome, this.descricao, this.lance, this.cpf, this.data);
            cadastro = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(true, cadastro);
    }
    @When("O produto é cadastrado pela segunda vez")
    public void o_produto_é_cadastrado_pela_segunda_vez()  throws Exception {
        boolean cadastro = false;
        try {
            this.fachada.cadastrarProduto(this.nome, this.descricao, this.lance, this.cpf, this.data);
            cadastro = true;
        }
        catch (Exception e) {
        }
        assertEquals(false, cadastro);
    }
    @Then("o sistema avisa que o cadastro falhou {string}")
    public void o_sistema_avisa_que_o_cadastro_falhou(String string) {
        boolean expectedResult = false;
        try{
            if(this.fachada.getProdutosVencidosENaoVendidos().get(1).getNome().equals(this.nome)) 
            {
                // System.out.println("Usuário encontrado");
                expectedResult= true;
            } else 
            {
                // System.out.println("Usuário não encontrado");
                expectedResult= false;
            }
        } catch(Exception e)
        {
            expectedResult= false;
            System.out.println(string);
        }
        assertEquals(expectedResult, false);
    }

}