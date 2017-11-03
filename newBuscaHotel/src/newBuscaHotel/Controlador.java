package newBuscaHotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import modelo.Hotel;

import java.util.TreeSet;

public class Controlador {
	private List<Hotel> hoteis = new ArrayList<Hotel>();
	private DateTimeFormatter f = DateTimeFormat.forPattern("dd/MM/yyyy");
	
	
	public void adicionarHoteis(Hotel novoHotel) {
		hoteis.add(novoHotel);
	}

	// Teste para throws
	public void adicionarReserva(String nomeHotel, String tipoQuarto, String inicioHospedagem, String fimHospedagem,
			String tipoPagamento) throws Exception {
		boolean reservou = false;
		if (hoteis.isEmpty())
			throw new Exception("Não há hoteis cadastrados!");
		for (Hotel h : hoteis) {
			if (h.getNome().equals(nomeHotel)) {
				if(!h.reservarQuarto(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem), tipoPagamento))
					throw new Exception("Não há quartos disponíveis nessa data!");
				{
					reservou = true;
				}
			}				
		}
		
		if(!reservou)
			throw new Exception("Hotel não encontrado!");
		
		
	}

	public String buscaHoteisNome(String nomeCidade, String tipoQuarto, String inicioHospedagem, String fimHospedagem) {
		Map<String, Hotel> listaHoteisNome = new HashMap<>();
		String texto = "Lista de Hoteis na cidade de " + nomeCidade 
				+ " Tipo: " + tipoQuarto
				+ "\n";
		for (Hotel h : hoteis) {
			if (h.getCidade().equals(nomeCidade) && h.buscaQuartos(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem)))
				listaHoteisNome.put(h.getNome(), h);
		}
		
		for (Entry<String, Hotel> pair : listaHoteisNome.entrySet()) {
			texto += "Nome do Hotel: " + pair.getValue().getNome() 
					+ " Recomendação: " + pair.getValue().getAvaliação()
					+ " Preço da Hospedagem: " + pair.getValue().precohospedagem(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem))
					+ "\n";
		}
		
		return texto;
	}

	public String buscaHoteisPreco(String nomeCidade, String tipoQuarto, String inicioHospedagem, String fimHospedagem) {
		String texto = "Lista de Hoteis na cidade de " + nomeCidade 
				+ "Tipo: " + tipoQuarto
				+ "\n";

		Map<Float, Hotel> listaHoteisNome = new HashMap<>();
		TreeSet<Float> valores = new TreeSet<>();
		for (Hotel h : hoteis) {
			if (h.getCidade().equals(nomeCidade) && h.buscaQuartos(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem))) {
				listaHoteisNome.put(h.precohospedagem(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem)), h);
				valores.add(h.precohospedagem(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem)));				
			}
			
		}

		for (float v : valores) {
			texto += "Nome do Hotel: " + listaHoteisNome.get(v).getNome() + " Recomendação: "
					+ listaHoteisNome.get(v).getAvaliação() + " Preço do quarto: "
					+ listaHoteisNome.get(v).precohospedagem(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem)) + "\n";
		}

		return texto;
	}

	public String buscaHoteisDistancia(String nomeCidade, String tipoQuarto, String inicioHospedagem, String fimHospedagem) {
		String texto = "Lista de Hoteis na cidade de " + nomeCidade 
				+ " Tipo: " + tipoQuarto
				+ "\n";

		Map<Float, Hotel> listaHoteisNome = new HashMap<>();
		TreeSet<Float> valores = new TreeSet<>();
		for (Hotel h : hoteis) {
			if (h.getCidade().equals(nomeCidade) && h.buscaQuartos(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem))) {
				listaHoteisNome.put(h.getDistanciaCentro(), h);
				valores.add(h.getDistanciaCentro());
			}
		}

		for (float v : valores) {
			texto += "Nome do Hotel: " + listaHoteisNome.get(v).getNome() + " Recomendação: "
					+ listaHoteisNome.get(v).getAvaliação() + " Preço do quarto: "
					+ listaHoteisNome.get(v).precohospedagem(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem)) + "\n";
		}
			
		return texto;
	}

	public String buscaHoteisRecomendacao(String nomeCidade, String tipoQuarto, String inicioHospedagem,
			String fimHospedagem) {
		String texto = "Lista de Hoteis na cidade de " + nomeCidade 
				+ " Tipo: " + tipoQuarto
				+ "\n";

		Map<Float, Hotel> listaHoteisNome = new HashMap<>();
		TreeSet<Float> valores = new TreeSet<>();
		for (Hotel h : hoteis) {
			if (h.getCidade().equals(nomeCidade) && h.buscaQuartos(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem))) {
				listaHoteisNome.put(h.getAvaliação(), h);
				valores.add(h.getAvaliação());
			}
		}

		for (float v : valores) {
			texto += "Nome do Hotel: " + listaHoteisNome.get(v).getNome() + " Recomendação: "
					+ listaHoteisNome.get(v).getAvaliação() + " Preço do quarto: "
					+ listaHoteisNome.get(v).precohospedagem(tipoQuarto, f.parseDateTime(inicioHospedagem), f.parseDateTime(fimHospedagem)) + "\n";
		}

		// return listaHoteisNome.toString();
		return texto;
	}	
	
	public String reservasHotel(String nomeHotel) {		
		String texto = "Reservas do Hotel: " + nomeHotel + "\n";
		for(Hotel h: hoteis) {
			if(nomeHotel.equals(h.getNome())) {
				if(h.reservas().isEmpty()) {
					texto += "Não há reservas para esse hotel\n";
				}else {
					texto += h.reservas();
				}
			}
		}
		
		return texto;
	}	

}
