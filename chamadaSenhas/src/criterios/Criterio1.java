package criterios;

import java.util.ArrayList;
import java.util.List;

import listaFichas.ChamaFichas;
import listaFichas.ListaFichas;
import modelo.Ficha;

public class Criterio1 implements Criterio {

	private List<String> sequencia = new ArrayList<>();

	public Criterio1() {
		super();
		this.sequencia.add("NRE");
		this.sequencia.add("NFE");
		this.sequencia.add("NRE");
		this.sequencia.add("NFE");
		this.sequencia.add("PRE");
		this.sequencia.add("PFE");
	}

	@Override
	public Ficha puxaFicha(ListaFichas lf) {

		ChamaFichas n = new ChamaFichas();

		return n.novaChamada(lf, sequencia);
	}

	public String imprimeSeq() {
		String texto = "";
		for (String string : sequencia) {
			texto += string + "\n";
		}
		return texto;
	}

	public List<String> getSequencia() {
		return sequencia;
	}

}
