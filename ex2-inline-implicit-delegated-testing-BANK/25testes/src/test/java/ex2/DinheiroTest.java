package ex2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DinheiroTest {
    @Test
    public void shouldScaleQuantity() {
        // In-line Setup
        // Fixture Setup
        var dinheiro = new Dinheiro(Moeda.USD, 10, 00);
        // Exercise SUT
        var result = dinheiro.obterQuantiaEmEscala();
        // Result Verification
        assertEquals(1000, result);
        // Fixture Teardown
    }
    @Test
    public void shouldCorrectlyReturnMoeda() {
        // In-line Setup
        // Fixture Setup
        var dinheiro = new Dinheiro(Moeda.USD, 10, 00);
        // Exercise SUT
        var result = dinheiro.obterMoeda();
        // Result Verification
        assertEquals(Moeda.USD, result);
        // Fixture Teardown
    }
    @Test
    public void shouldCorrectlyReturnNegativeDinheiro() {
        // In-line Setup
        // Fixture Setup
        var dinheiro = new Dinheiro(Moeda.USD, 10, 00);
        // Exercise SUT
        var result = dinheiro.negativo().toString();
        // Result Verification
        assertEquals("-10,00 USD", result);
        // Fixture Teardown
    }
    @Test
    public void shouldCorrectlyReturnFormatedDinheiro() {
        // In-line Setup
        // Fixture Setup
        var dinheiro = new Dinheiro(Moeda.USD, 10, 00);
        // Exercise SUT
        var result = dinheiro.formatado();
        // Result Verification
        assertEquals("10,00 USD", result);
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnPositiveDinheiro() {
        // In-line Setup
        // Fixture Setup
        var dinheiro = new Dinheiro(Moeda.USD, -10, 00);
        // Exercise SUT
        var result = dinheiro.positivo().toString();
        // Result Verification
        assertEquals("+10,00 USD", result);
        // Fixture Teardown
    }
}
