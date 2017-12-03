package br.com.unialfa.ia.core.heuristic;

import br.com.unialfa.ia.core.model.Grafo;
import br.com.unialfa.ia.core.model.Vertice;

public interface IBuscaCega {

	public Grafo processarGrafo(Grafo grafo, Vertice origem);
	
	
}
