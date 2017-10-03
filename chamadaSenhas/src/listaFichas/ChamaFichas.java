package listaFichas;

import java.util.List;

import modelo.Ficha;

public class ChamaFichas {

	public Ficha novaChamada(ListaFichas lf, List<String> sequencia) {
		// TODO Auto-generated method stub
		Ficha f = null;
		String reintroduzir;

		if (lf.getFichasNRE().isEmpty() && lf.getFichasNFE().isEmpty() && lf.getFichasPFE().isEmpty()
				&& lf.getFichasPRE().isEmpty()) {
			return null;
		} else {
			if (sequencia.get(0) == "PRE") {
				if (!lf.getFichasPRE().isEmpty()) {
					f = lf.getFichasPRE().remove(0);
					reintroduzir = sequencia.remove(0);
					sequencia.add(reintroduzir);
					return f;
				} else {
					reintroduzir = sequencia.remove(0);
					sequencia.add(reintroduzir);
					return novaChamada(lf, sequencia);
				}
			} else {
				if (sequencia.get(0) == "PFE") {
					if (!lf.getFichasPFE().isEmpty()) {
						f = lf.getFichasPFE().remove(0);
						reintroduzir = sequencia.remove(0);
						sequencia.add(reintroduzir);
						return f;
					} else {
						reintroduzir = sequencia.remove(0);
						sequencia.add(reintroduzir);
						return novaChamada(lf, sequencia);
					}
				} else {
					if (sequencia.get(0) == "NRE") {
						if (!lf.getFichasNRE().isEmpty()) {
							f = lf.getFichasNRE().remove(0);
							reintroduzir = sequencia.remove(0);
							sequencia.add(reintroduzir);
							return f;
						} else {
							reintroduzir = sequencia.remove(0);
							sequencia.add(reintroduzir);
							return novaChamada(lf, sequencia);
						}
					} else {
						if (!lf.getFichasNFE().isEmpty()) {
							f = lf.getFichasNFE().remove(0);
							reintroduzir = sequencia.remove(0);
							sequencia.add(reintroduzir);
							return f;
						} else {
							reintroduzir = sequencia.remove(0);
							sequencia.add(reintroduzir);
							return novaChamada(lf, sequencia);
						}
					}
				}
			}
		}
	}

}
