package br.com.unialfa.ia.core.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Grafo {

	private Set<Vertice> vertices = new HashSet<>();

	public void adicionarVertice(Vertice vertice) {
		vertices.add(vertice);
	}

	public void adicionarVertices(Set<Vertice> vertices) {
		vertices.addAll(vertices);
	}

	public void listarVertices() {
		for (Vertice vertice : vertices) {
			System.out.println("==========");
			System.out.println("#VÉRTICE: <<" + vertice.getNomeVertice() + ">>");
			for (Map.Entry<Vertice, Integer> destinos : vertice.getVerticesAdjacentes().entrySet()) {
				System.out.println("##DESTINO: " + destinos.getKey().getNomeVertice());
				System.out.println("###DISTANCIA:" + destinos.getValue());
			}
		}
	}

	public Set<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(Set<Vertice> vertices) {
		this.vertices = vertices;
	}

	//Djikstra
	public static Grafo calcularMenorCaminhodaOrigem(Grafo grafo, Vertice origem) {
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
	
	public void solucao(Vertice destino) {
		for (Vertice vertice : vertices) {
			if(vertice.getNomeVertice().equals(destino.getNomeVertice())) {
				System.out.println("###SOLUÇÃO###");
				for (Vertice verticeSolucao : vertice.getMenorCaminho()) {
					System.out.println(verticeSolucao.getNomeVertice());
				}
			}
			
		}
	}

}
