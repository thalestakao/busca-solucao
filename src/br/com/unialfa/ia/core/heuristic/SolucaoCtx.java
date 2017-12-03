package br.com.unialfa.ia.core.heuristic;
import br.com.unialfa.ia.core.model.Grafo;
import br.com.unialfa.ia.core.model.Vertice;

public class SolucaoCtx {

	private static boolean processado;

	public static IBuscaCega buscaCega;

	public static Grafo processarGrafo(Grafo grafo, Vertice origem) {
		processado = true;
		return buscaCega.processarGrafo(grafo, origem);
	}

	public static void processarSolucao(Grafo grafo, Vertice destino) {
		if (processado == true) {
			for (Vertice vertice : grafo.getVertices()) {
				if (vertice.getNomeVertice().equals(destino.getNomeVertice())) {
					System.out.println("###SOLUÇÃO###");
					for (Vertice verticeSolucao : vertice.getMenorCaminho()) {
						System.out.println(verticeSolucao.getNomeVertice());
					}
				}
			}
			System.out.println(destino.getNomeVertice());
		} else {
			System.out.println("Grafo não processado");
		}
	}



}
