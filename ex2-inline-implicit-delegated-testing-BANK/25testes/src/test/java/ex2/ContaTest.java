package ex2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTest {

    private Conta conta;
    private Agencia agencia;

    @BeforeEach
    public void setUp() {
        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("JPMorgan", Moeda.USD);
        agencia = bank.criarAgencia("A1");
        this.conta = agencia.criarConta("José");
    }

    @Test
    public void shouldCorrectlyReturnIdentifier() {
        // Implicit Setup
        // Fixture Setup
        // Exercise SUT
        var identifier = this.conta.obterIdentificador();
        // Result Verification
        assertEquals("0001-4", identifier);
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnTitular() {
        // Implicit Setup
        // Fixture Setup
        // Exercise SUT
        var titular = this.conta.obterTitular();
        // Result Verification
        assertEquals("José", titular);
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnAgencia() {
        // Implicit Setup
        // Fixture Setup
        // Exercise SUT
        var returned_agencia = this.conta.obterAgencia();
        // Result Verification
        assertEquals(this.agencia, returned_agencia);
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyCalculateSaldo() {
        // Implicit Setup
        // Fixture Setup
        // Exercise SUT
        var saldo = this.conta.calcularSaldo();
        // Result Verification
        assertEquals(saldo.obterQuantia().obterQuantiaEmEscala(), 0);
        // Fixture Teardown
    }
    
    @Test
    public void shouldNOTThrowWhenAddingTransition() {
        // Implicit Setup
        // Fixture Setup
        var transaction = new Entrada(this.conta, new Dinheiro(Moeda.USD, 10, 00));
        // Exercise SUT
        assertDoesNotThrow(()->{
            conta.adicionarTransacao(transaction);
        });
        // Result Verification
        // Fixture Teardown
    }


}
