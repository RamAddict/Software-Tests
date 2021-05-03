package fixtures;

import fit.ActionFixture;
import interfaces.IMercadoLeilao;
import modelo.MercadoLeilao;

public class MercadoActionFixtureTest extends ActionFixture {
    IMercadoLeilao mercado = new MercadoLeilao();
    private String nomeUsuario;
    private String enderecoUsuario;
    private String emailUsuario;
    private String cpfUsuario;

    public void nome(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void endereco(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public void email(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void cpf(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public void cadastrarUsuario() {
        try {
            mercado.cadastrarUsuario(nomeUsuario, enderecoUsuario, emailUsuario, cpfUsuario);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Gerou excecao");
        }
    }

    public Boolean possuiUsuario() {
        return mercado.isPossuiUsuario();
    }
}
