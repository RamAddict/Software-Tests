package ex2;
public interface Transacao {

	public ValorMonetario obterValorMonetario();

	public ValorMonetario contabilizar(ValorMonetario saldo);

}
