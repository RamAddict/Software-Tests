package ex2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class AgenciaTest {

    @Test
    public void shouldNotThrowWhenCreatingConta() {
        // In-line Setup
        // Fixture Setup
        SistemaBancario sistemaBancario = new SistemaBancario();
        Banco bank = sistemaBancario.criarBanco("JPMorgan", Moeda.USD);
        var agencia = bank.criarAgencia("A1");
        // Exercise SUT
        assertDoesNotThrow(() -> {
            agencia.criarConta("José");
        });
        // Result Verification
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnIdentifier() {
        // Delegated Setup
        // Fixture Setup
        Agencia agencia = TestHelper.makeAgencia();
        // Exercise SUT
        var result = agencia.obterIdentificador();
        // Result Verification
        assertEquals(result, "001");
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnTheName() {
        // Delegated Setup
        // Fixture Setup
        Agencia agencia = TestHelper.makeAgencia();
        // Exercise SUT
        var name = agencia.obterNome();
        // Result Verification
        assertEquals("A1", name);
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnTheBank() {
        // In-line Setup
        // Fixture Setup
        SistemaBancario sistemaBancario = new SistemaBancario();
        Banco bank = sistemaBancario.criarBanco("JPMorgan", Moeda.USD);
        var agencia = bank.criarAgencia("A1");
        // Exercise SUT
        var returned_bank = agencia.obterBanco();
        // Result Verification
        assertEquals(bank, returned_bank);
        // Fixture Teardown
    }
}

class TestHelper {
    public static Agencia makeAgencia() {
        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("JPMorgan", Moeda.USD);
        return bank.criarAgencia("A1");
    }

    public static ValorMonetario makeValorMonetario() {

        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("JPMorgan", Moeda.USD);
        var agencia = bank.criarAgencia("A1");
        var conta = agencia.criarConta("Joao");
        var transaction = new Entrada(conta, new Dinheiro(Moeda.BRL, 20, 00));
        return transaction.obterValorMonetario();
    }

}