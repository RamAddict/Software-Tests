package ex2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ValorMonetarioTest {
    
    @Test
    public void shouldCorrectlySumValorMonetario() {
        // Delegated Setup
        // Fixture Setup
        var valorMonetario = TestHelper.makeValorMonetario();
        ValorMonetario newValorMonetario;
        // Exercise SUT
        newValorMonetario = valorMonetario.somar(new Dinheiro(Moeda.BRL, 5, 25));
        // Result Verification
        assertEquals("25,25 BRL", newValorMonetario.obterQuantia().toString());
        // Fixture Teardown
    }
    
    @Test
    public void shouldCorrectlySubtractValorMonetario() {
        // Delegated Setup
        // Fixture Setup
        var valorMonetario = TestHelper.makeValorMonetario();
        ValorMonetario newValorMonetario;
        // Exercise SUT
        newValorMonetario = valorMonetario.subtrair(new Dinheiro(Moeda.BRL, 5, 25));
        // Result Verification
        assertEquals("14,75 BRL", newValorMonetario.obterQuantia().toString());
        // Fixture Teardown
    }

    @Test
    public void shouldNOTBeZero() {
        // Delegated Setup
        // Fixture Setup
        var valorMonetario = TestHelper.makeValorMonetario();
        // Exercise SUT
        var isZero = valorMonetario.zero();
        // Result Verification
        assertEquals(isZero, false);
        // Fixture Teardown
    }

    @Test
    public void valorShouldBeEquals() {
        // Delegated Setup
        // Fixture Setup
        var valorMonetario = TestHelper.makeValorMonetario();
        // Exercise SUT
        var isEqual = valorMonetario.equals(valorMonetario);
        // Result Verification
        assertEquals(isEqual, true);
        // Fixture Teardown
    }

    @Test
    public void valorShouldNOTBeEquals() {
        // Delegated Setup
        // Fixture Setup
        var valorMonetario1 = TestHelper.makeValorMonetario();
        var valorMonetario2 = TestHelper.makeValorMonetario();
        valorMonetario1 = valorMonetario1.somar(new Dinheiro(Moeda.BRL, 5, 25));
        // Exercise SUT
        var isEqual = valorMonetario1.equals(valorMonetario2);
        // Result Verification
        assertEquals(isEqual, false);
        // Fixture Teardown
    }

    @Test
    public void valorShouldNOTBeNegative() {
        // Delegated Setup
        // Fixture Setup
        var valorMonetario = TestHelper.makeValorMonetario();
        // Exercise SUT
        var isEqual = valorMonetario.negativo();
        // Result Verification
        assertEquals(isEqual, false);
        // Fixture Teardown
    }
}

