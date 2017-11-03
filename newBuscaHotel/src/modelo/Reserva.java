package modelo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Reserva {
	private DateTime inicio;
	private DateTime fim;
	private float preco;
	private String tipoQuarto;
	private String tipoPagamento;
	private DateTimeFormatter f = DateTimeFormat.forPattern("dd/MM/yyyy");
	
	public Reserva(DateTime inicio, DateTime fim, float preco, String tipoQuarto, String tipoPagamento) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.preco = preco;
		this.tipoQuarto = tipoQuarto;
		this.tipoPagamento = tipoPagamento;
	}

	@Override
	public String toString() {
		return "Reserva: Entrada dia =" + inicio.toString(f) +
				", Saída dia =" + fim.toString(f) +
				", Preço hospedagem =" + preco + 
				", Tipo de Quarto =" + tipoQuarto+
				", Tipo de pagamento =" + tipoPagamento + "]\n";
	}
	
	
	
	

}
