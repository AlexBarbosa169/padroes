package modelo;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Reservado {
	
	private DateTime diaEntrada;
	private DateTime diaSaida;	
	
	public Reservado(DateTime diaEntrada, DateTime diaSaida) {
		super();
		this.diaEntrada = diaEntrada;
		this.diaSaida = diaSaida;
	}

	public DateTime getDiaEntrada() {
		return diaEntrada;
	}

	public DateTime getDiaSaida() {
		return diaSaida;
	}	
			
}
