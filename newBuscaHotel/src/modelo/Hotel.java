package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Hotel {
	private float simples;
	private float duplo ;
	private float triplo;
	private float presidencial;
	private float avaliação;
	private String nome;
	private String cidade;
	private float distanciaCentro;
	private List<Reserva> reservas = new ArrayList<>();
	private List<Quarto> quartos = new ArrayList<Quarto>();				
	
	public Hotel(String nome, String cidade, float distanciaCentro, float precoSimples, float precoDuplo, float precoTriplo, float precoPresidencial) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.distanciaCentro = distanciaCentro;
		this.simples = precoSimples;
		this.duplo = precoDuplo;
		this.triplo = precoTriplo;
		this.presidencial = precoPresidencial;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public float getAvaliação() {
		return avaliação;
	}

	public String getCidade() {
		return cidade;
	}

	public float getDistanciaCentro() {
		return distanciaCentro;
	}
	
	public int proximoNumeroQuarto() {
		if(quartos.isEmpty())
			return 1;
		return quartos.size()+1;
	}	

	public void setDuplo(float duplo) {
		this.duplo = duplo;
	}

	public void setSimples(float simples) {
		this.simples = simples;
	}

	public void setTriplo(float triplo) {
		this.triplo = triplo;
	}

	public void setPresidencial(float presidencial) {
		this.presidencial = presidencial;
	}

	public void adicionarQuarto(String tipo) {		
		switch (tipo) {
		case "Simples":
			quartos.add(new Simples(this.proximoNumeroQuarto(), this.simples));
			break;
		case "Duplo":
			quartos.add(new Duplo(this.proximoNumeroQuarto(), this.duplo));
			break;
		case "Triplo":
			quartos.add(new Triplo(this.proximoNumeroQuarto(), this.triplo));
			break;
		case "Presidencial":
			quartos.add(new Presidencial(this.proximoNumeroQuarto(), this.presidencial));
			break;

		default:
			break;
		}
		
	}

	public boolean buscaQuartos(String tipoQuarto, DateTime inicioHospedagem, DateTime fimHospedagem) {		
		for(Quarto q: quartos) {
			if(q.getClass().getSimpleName().equals(tipoQuarto) && q.disponivel(inicioHospedagem, fimHospedagem))
				return true;
		}
		return false;
	}
	
	public float precohospedagem(String tipoQuarto, DateTime inicioHospedagem, DateTime fimHospedagem) {		
		float resultado = 0;
		if(tipoQuarto.equals("Simples"))
			resultado = simples * (Days.daysBetween(inicioHospedagem, fimHospedagem).getDays());
		else if (tipoQuarto.equals("Duplo"))
			resultado = duplo * (Days.daysBetween(inicioHospedagem, fimHospedagem).getDays());
		else if (tipoQuarto.equals("Triplo"))
			resultado = triplo * (Days.daysBetween(inicioHospedagem, fimHospedagem).getDays());
		else if (tipoQuarto.equals("Presidencial"))
			resultado = presidencial * (Days.daysBetween(inicioHospedagem, fimHospedagem).getDays());
		return resultado;
	}
	
	
//	Corrigir inserção de reservas!!
	public boolean reservarQuarto(String tipoQuarto, DateTime inicioHospedagem, DateTime fimHospedagem, String tipoPagamento) {
		for(Quarto q :  quartos) {
			if(q.getClass().getSimpleName().equals(tipoQuarto) && q.reservarDia(inicioHospedagem, fimHospedagem)){
				reservas.add(new Reserva(inicioHospedagem, fimHospedagem, q.precoQuarto(inicioHospedagem, fimHospedagem), tipoQuarto, tipoPagamento));
				return true;
			}
		}
		return false;
	}	
		
	public String reservas() {
		String texto = "";
		for(Reserva r : reservas) {
			texto += r.toString();
		}
		return texto;
	}
		
}
