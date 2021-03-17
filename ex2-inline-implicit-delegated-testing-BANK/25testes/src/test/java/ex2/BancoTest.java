package ex2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest {    
    
    private Banco bitconnectBank;
    private SistemaBancario sistemaBancario;
    
    @BeforeEach
    public void setUp() {
        this.sistemaBancario = new SistemaBancario();
        this.bitconnectBank = sistemaBancario.criarBanco("Bitconnect", Moeda.USD);
    }

    @Test
    public void shouldCorreclyCreateBanksWithDifferentCurrencies() {
        // Implicit
        // Fixture Setup
        // Exercise SUT
        assertDoesNotThrow(() -> {
            Banco bank1 = sistemaBancario.criarBanco("Bico Doce", Moeda.USD);
            Banco bank2 = sistemaBancario.criarBanco("Abacate", Moeda.BRL);
            Banco bank3 = sistemaBancario.criarBanco("Baguette", Moeda.CHF);
        });
        // Result Verification
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnTheName() {
        // Implicit Setup
        // Fixture Setup
        // Exercise SUT
        var result = this.bitconnectBank.obterNome();
        // Result Verification
        assertEquals(result, "Bitconnect");
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyReturnTheCurrency() {
        // Implicit Setup
        // Fixture Setup
        // Exercise SUT
        var result = this.bitconnectBank.obterMoeda();
        // Result Verification
        assertEquals(result, Moeda.USD);
        // Fixture Teardown
    }

    @Test void shouldNotThrowWhenCreateAgencia() {
        // Implicit Setup
        // Fixture Setup
        // Exercise SUT
        assertDoesNotThrow(() -> {
            this.bitconnectBank.criarAgencia("1988");
        });
        // Result Verification
        // Fixture Teardown
    }
    
}
// Fixture Setup
// Exercise SUT
// Result Verification
// Fixture Teardown