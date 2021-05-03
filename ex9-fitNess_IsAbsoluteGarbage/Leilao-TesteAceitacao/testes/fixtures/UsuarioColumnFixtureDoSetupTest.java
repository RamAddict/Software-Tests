package fixtures;

import fit.ColumnFixture;

public class UsuarioColumnFixtureDoSetupTest extends ColumnFixture {
    private String nome, endereco, email, cpf;

    public boolean cadastrarUsuario() {
        try {
            UsuarioSetUpFixturesTest.retornoMercado().cadastrarUsuario(nome, endereco, email, cpf);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
