package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

public abstract class Quarto {
	private int num;
	private float preco;
	private List<Reservado> diasReservados = new ArrayList<>();	
	
	public Quarto(int num, float preco) {
		super();
		this.num = num;
		this.preco = preco;
	}
	
	public float precoQuarto(DateTime entrada, DateTime saida) {
		int resultado = Days.daysBetween(saida, entrada).getDays();	
		return resultado * preco;
	}
	
	public boolean reservarDia(DateTime inicioHospedagem, DateTime fimHospedagem){		
			if(this.disponivel(inicioHospedagem, fimHospedagem)) {
				diasReservados.add(new Reservado(inicioHospedagem,fimHospedagem));
				return true;
			}
							return false;
	}
	
	public boolean disponivel(DateTime inicio, DateTime fim) {		
			if (diasReservados.isEmpty())
				return true;
			int verificar = 1;
			for (Reservado r : diasReservados) {
		
				if ((inicio == r.getDiaEntrada() || fim == r.getDiaSaida()))
					verificar = 0;
				else if (inicio.isBefore(r.getDiaEntrada())  && fim.isAfter(r.getDiaSaida()))
					verificar = 0;
					else if (inicio.isBefore(r.getDiaSaida()) && fim.isAfter(r.getDiaSaida()))
						verificar = 0;
					else if (inicio.isBefore(r.getDiaEntrada()) && fim.isBefore(r.getDiaSaida()))
						verificar = 0;				
	
//				if ((inicio == r.getDiaEntrada() || fim == r.getDiaSaida()))
//						verificar = 0;
//					else if (inicio < r.getDiaEntrada() && fim > r.getDiaSaida())
//						verificar = 0;
//						else if (inicio < r.getDiaSaida() && fim > r.getDiaSaida())
//							verificar = 0;
//						else if (inicio > r.getDiaEntrada() && fim < r.getDiaSaida())
//							verificar = 0;				
		
		}
			if(verificar == 1)
				return true;
			else
				return false;
		
	}

	@Override
	public String toString() {
		return "Quarto [num=" + num + ", preco=" + preco + "]";
	}
		
}
