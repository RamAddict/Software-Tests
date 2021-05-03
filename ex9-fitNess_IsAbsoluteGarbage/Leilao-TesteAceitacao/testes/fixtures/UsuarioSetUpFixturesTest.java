package fixtures;

import fitlibrary.SetUpFixture;
import interfaces.IMercadoLeilao;
import modelo.MercadoLeilao;

public class UsuarioSetUpFixturesTest  extends SetUpFixture {
    private static IMercadoLeilao mercado;

    public void nomeEnderecoEmailCpf(String nome, String endereco, String email, String cpf) {
        mercado = new MercadoLeilao();
        try {
            mercado.cadastrarUsuario(nome, endereco, email, cpf);
        } catch (Exception e) {
        }
    }

    public static IMercadoLeilao retornoMercado() {
        return mercado;
    }
}
