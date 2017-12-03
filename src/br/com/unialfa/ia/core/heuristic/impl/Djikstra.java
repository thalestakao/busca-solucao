package br.com.unialfa.ia.core.heuristic.impl;

import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import br.com.unialfa.ia.core.heuristic.IBuscaCega;
import br.com.unialfa.ia.core.model.Grafo;
import br.com.unialfa.ia.core.model.Vertice;

public class Djikstra implements IBuscaCega {

	@Override
	public Grafo processarGrafo(Grafo grafo, Vertice origem) {
		origem.setDistancia(0);

		SortedSet<Vertice> verticesVisitados = new TreeSet<Vertice>();
		SortedSet<Vertice> verticesNaoVisistados = new TreeSet<Vertice>();

		verticesNaoVisistados.add(origem);

		while (!verticesNaoVisistados.isEmpty()) {
			Vertice verticeAtual = verticesNaoVisistados.first();
			verticesNaoVisistados.remove(verticeAtual);
			for (Entry<Vertice, Integer> verticeVizinhoMap : verticeAtual.getVerticesAdjacentes().entrySet()) {
				Integer distanciaVizinho = verticeVizinhoMap.getValue();
				Vertice verticeVizinho = verticeVizinhoMap.getKey();
				if (!verticesVisitados.contains(verticeVizinho)) {
					if (distanciaVizinho + verticeAtual.getDistancia() < verticeVizinho.getDistancia()) {
						verticeVizinho.setDistancia(distanciaVizinho + verticeAtual.getDistancia());
						LinkedList<Vertice> menorCaminho = new LinkedList<>(verticeAtual.getMenorCaminho());
						menorCaminho.add(verticeAtual);
						verticeVizinho.setMenorCaminho(menorCaminho);
						verticesNaoVisistados.add(verticeVizinho);
					}
				}
			}
			verticesVisitados.add(verticeAtual);
		}

		return grafo;

	}


}
