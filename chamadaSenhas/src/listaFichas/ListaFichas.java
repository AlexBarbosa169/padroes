package listaFichas;

import java.util.ArrayList;
import java.util.List;

import criterios.Criterio;
import criterios.Criterio1;
import criterios.Criterio2;
import criterios.Criterio3;
import criterios.Criterio4;
import modelo.Ficha;

public class ListaFichas {
	private List<Ficha> fichasNFE;
	private List<Ficha> fichasPFE;
	private List<Ficha> fichasNRE;
	private List<Ficha> fichasPRE;
	Criterio criterio;

	public ListaFichas() {
		super();
		this.fichasNFE = new ArrayList<>();
		this.fichasPFE = new ArrayList<>();
		this.fichasNRE = new ArrayList<>();
		this.fichasPRE = new ArrayList<>();
		this.criterio = new Criterio1();
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(int num) {
		if (num == 1)
			this.criterio = new Criterio1();
		if (num == 2)
			this.criterio = new Criterio2();
		if (num == 3)
			this.criterio = new Criterio3();
		if (num == 4)
			this.criterio = new Criterio4();
	}

	public void adicionarFicha(Ficha f) {
		switch (f.getTipo()) {
		case "NFE":
			this.fichasNFE.add(f);
			break;
		case "PFE":
			this.fichasPFE.add(f);
			break;
		case "NRE":
			this.fichasNRE.add(f);
			break;
		case "PRE":
			this.fichasPRE.add(f);
			break;
		default:
			break;
		}
	}

	public List<Ficha> getFichasNFE() {
		return fichasNFE;
	}

	public List<Ficha> getFichasPFE() {
		return fichasPFE;
	}

	public List<Ficha> getFichasNRE() {
		return fichasNRE;
	}

	public List<Ficha> getFichasPRE() {
		return fichasPRE;
	}

	@Override
	public String toString() {
		String texto = "Listas de fichas\n";

		if (this.fichasNRE.isEmpty() && this.fichasNFE.isEmpty() && this.fichasPFE.isEmpty()
				&& this.fichasPRE.isEmpty()) {
			System.out.println("Sem fichas cadastradas no momento!");
		}
		if (!this.fichasNFE.isEmpty()) {
			texto += "\n----------- Fichas NFE -----------\n";
			for (Ficha ficha : this.fichasNFE) {
				texto += "Ficha numero: " + ficha.getNum() + " Tipo: " + ficha.getTipo() + "\n";
			}
		}
		if (!this.fichasPFE.isEmpty()) {
			texto += "\n----------- Fichas PFE -----------\n";
			for (Ficha ficha : this.fichasPFE) {
				texto += "Ficha numero: " + ficha.getNum() + " Tipo: " + ficha.getTipo() + "\n";
			}
		}
		if (!this.fichasNRE.isEmpty()) {
			texto += "\n----------- Fichas NRE -----------\n";
			for (Ficha ficha : this.fichasNRE) {
				texto += "Ficha numero: " + ficha.getNum() + " Tipo: " + ficha.getTipo() + "\n";
			}
		}
		if (!this.fichasPRE.isEmpty()) {
			texto += "\n----------- Fichas PRE -----------\n";
			for (Ficha ficha : this.fichasPRE) {
				texto += "Ficha numero: " + ficha.getNum() + " Tipo: " + ficha.getTipo() + "\n";
			}
		}
		return texto;
	}

}
