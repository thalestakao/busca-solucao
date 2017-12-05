package br.com.unialfa.ia.core.heuristic.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Map.Entry;

import br.com.unialfa.ia.core.heuristic.IBuscaCega;
import br.com.unialfa.ia.core.model.Grafo;
import br.com.unialfa.ia.core.model.Vertice;

public class BuscaEmProfundidade implements IBuscaCega {

	@Override
	public Grafo processarGrafo(Grafo grafo, Vertice origem) {
		Stack<Vertice> stackVertice = new Stack<>();
		List<Vertice> verticesVisitados = new ArrayList<>();

		stackVertice.push(origem);
		while (!stackVertice.isEmpty()) {
			Vertice verticeAtual = stackVertice.pop();
			for (Entry<Vertice, Integer> verticeVizinhoMap : verticeAtual.getVerticesAdjacentes().entrySet()) {
				Vertice verticeVizinho = verticeVizinhoMap.getKey();
				if (!verticesVisitados.contains(verticeVizinho)) {
					LinkedList<Vertice> menorCaminho = new LinkedList<>(verticeAtual.getMenorCaminho());
					menorCaminho.add(verticeAtual);
					verticeVizinho.setMenorCaminho(menorCaminho);
					stackVertice.add(verticeVizinho);
				}
			}
			verticesVisitados.add(verticeAtual);
		}
		return grafo;
	}

}
