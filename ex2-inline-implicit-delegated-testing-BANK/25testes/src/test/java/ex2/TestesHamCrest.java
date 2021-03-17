package ex2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class TestesHamCrest {
    
    @Test
    public void shouldCorrectlyCreateBank() {
        SistemaBancario sistemaBancario = new SistemaBancario();

        // SUT
        var bank = sistemaBancario.criarBanco("Banco Do Brasil", Moeda.BRL);
        
        
        // check name and currency type.
        assertThat(bank.obterNome(), equalTo("Banco Do Brasil"));
        
        assertThat(bank.obterMoeda(), equalTo(Moeda.BRL));
    }

    @Test
    public void souldCorrectlyCreateAgency() {
        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("Banco Do Brasil", Moeda.BRL);    

        // SUT
        var agencia = bank.criarAgencia("Centro");
        // check id, name and Bank.
        assertThat(agencia.obterNome(), equalToIgnoringWhiteSpace("Centro"));
        assertThat(agencia.obterIdentificador(), equalToIgnoringCase("001"));
        assertThat(agencia.obterBanco().obterNome(), equalTo("Banco Do Brasil"));
    }

    @Test
    public void souldCorrectlyCreateAccount() {
        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("Banco Do Brasil", Moeda.BRL);    
        var agencia = bank.criarAgencia("Centro");
        // SUT
        var account = agencia.criarConta("Maria");
        // check accountId, accountName, balance and agency.
        assertThat(Arrays.asList("Maria", "Centro"), hasItems(account.obterTitular(), account.obterAgencia().obterNome()));
        assertThat(account.calcularSaldo().obterQuantia().obterQuantiaEmEscala(), lessThanOrEqualTo(0));
        assertThat(account.obterIdentificador(), anyOf(startsWith("0001"), endsWith("5")));
    }
        
    @Test
    public void shouldDepositMoneyCorrectly() {
        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("Banco Do Brasil", Moeda.BRL);    
        var agencia = bank.criarAgencia("Centro");
        var account = agencia.criarConta("Maria");
        // SUT
        sistemaBancario.depositar(account, new Dinheiro(Moeda.BRL, 10, 00));
        // check Succesful operation and balance is updated.
        assertThat(account.calcularSaldo().obterQuantia().obterQuantiaEmEscala(), lessThanOrEqualTo(1000));
    }

    @Test
    public void shouldRemoveMoneyCorrectly() {
        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("Banco Do Brasil", Moeda.BRL);    
        var agencia = bank.criarAgencia("Centro");
        var account = agencia.criarConta("Maria");
        sistemaBancario.depositar(account, new Dinheiro(Moeda.BRL, 10, 00));
        // SUT
        var operation = sistemaBancario.sacar(account, new Dinheiro(Moeda.BRL, 6, 00));
        // check Succesful operation and balance is updated.
        assertThat(operation.obterEstado(), equalTo(EstadosDeOperacao.SUCESSO));
        assertThat(account.calcularSaldo().obterQuantia().obterQuantiaEmEscala(), lessThanOrEqualTo(400));
    }

    
    @Test
    public void shouldNOTRemoveMoneyCorrectly() {
        SistemaBancario sistemaBancario = new SistemaBancario();
        var bank = sistemaBancario.criarBanco("Banco Do Brasil", Moeda.BRL);    
        var agencia = bank.criarAgencia("Centro");
        var account = agencia.criarConta("Maria");
        sistemaBancario.depositar(account, new Dinheiro(Moeda.BRL, 10, 00));
        sistemaBancario.sacar(account, new Dinheiro(Moeda.BRL, 6, 00));
        // SUT
        var operation = sistemaBancario.sacar(account, new Dinheiro(Moeda.BRL, 6, 00));
        // check Unsuccesful operation and balance is not updated.
        assertThat(operation.obterEstado(), equalTo(EstadosDeOperacao.SALDO_INSUFICIENTE));
        assertThat(account.calcularSaldo().obterQuantia().obterQuantiaEmEscala(), lessThanOrEqualTo(400));
    }
}
