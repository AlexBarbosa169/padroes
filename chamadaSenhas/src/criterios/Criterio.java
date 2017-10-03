package criterios;

import java.util.List;

import listaFichas.ListaFichas;
import modelo.Ficha;

public interface Criterio {

	public Ficha puxaFicha(ListaFichas lf);

	public List<String> getSequencia();

}
