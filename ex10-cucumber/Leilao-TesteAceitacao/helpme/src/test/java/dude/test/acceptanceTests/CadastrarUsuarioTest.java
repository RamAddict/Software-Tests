package dude.test.acceptanceTests;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

import dude.modelo.MercadoLeilao;

public class CadastrarUsuarioTest {

    public String nome = "";
    public String endereco = "";
    public String cpf = "";
    public String email = "";
    public Boolean expectedResult = true;

    MercadoLeilao fachada = new MercadoLeilao();

    @Дано("O nome de usuario {string}")
    public void o_nome_de_usuario(String string) {
        this.nome = string;
    }

    @Дано("o enderco {string}")
    public void o_enderco(String string) {
        this.endereco = string;
    }

    @Дано("e o CPF {string}")
    public void e_o_cpf(String string) {
        this.cpf = string;
    }

    @Дано("e o e-mail {string}")
    public void e_o_e_mail(String string) {
        this.email = string;
    }

    @Когда("O usuario é cadastrado")
    public void o_usuario_eh_cadastrado() {
        boolean cadastro = false;
        try {
            this.fachada.cadastrarUsuario(this.nome, this.endereco, this.email, this.cpf);
            cadastro = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(true, cadastro);
    }

    @Тогда("o sistema avisa que o cadastro do usuario teve sucesso")
    public void o_sistema_avisa_que_o_cadastro_ocorreu_com_sucesso() {
        try{
            if(this.fachada.getUsuarioPor(this.cpf).getCpf().equals(this.cpf)) 
            {
                // System.out.println("Usuário encontrado");
                this.expectedResult= true;
            } else 
            {
                // System.out.println("Usuário não encontrado");
                this.expectedResult= false;
            }
        } catch(Exception e) 
        {
            // TODO Auto-generated catch block
            this.expectedResult= false;
            e.printStackTrace();
        }
        assertEquals(expectedResult, true);
        System.out.println("Usuario cadastrado com sucesso");
    }

}
