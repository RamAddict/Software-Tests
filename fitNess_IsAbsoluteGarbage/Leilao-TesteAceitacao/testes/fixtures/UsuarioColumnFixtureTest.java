package fixtures;

import fit.ColumnFixture;
import interfaces.IMercadoLeilao;
import modelo.MercadoLeilao;

public class UsuarioColumnFixtureTest extends ColumnFixture {
    private IMercadoLeilao mercado;
    private String nome, endereco, email, cpf;

    public boolean cadastrarUsuario() {
        mercado = new MercadoLeilao();
        try {
            mercado.cadastrarUsuario(nome, endereco, email, cpf);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean verificarUsuarioExiste() {
        try {
            mercado.getUsuarioPor(cpf);
        } catch (Exception e) {
            return false;
        }
        return true; 
    }
}
