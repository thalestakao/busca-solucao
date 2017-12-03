package br.com.unialfa.ia.core.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vertice implements Comparable{

	private String nomeVertice;

	private Map<Vertice, Integer> verticesAdjacentes = new HashMap<>();
	
	//distancia infinta
	private Integer distancia = Integer.MAX_VALUE;

	private List<Vertice> menorCaminho = new LinkedList<>();
	
	public void adicionarDestino(Vertice destino, Integer distancia) {

		verticesAdjacentes.put(destino, distancia);

	}
	
	public Vertice(String nomeVertice) {
		this.nomeVertice = nomeVertice;
	}
	
	public Vertice(String nomeVertice, Map<Vertice, Integer> verticesAdjacentes) {
		this.nomeVertice = nomeVertice;
		this.verticesAdjacentes = verticesAdjacentes;
	}

	public String getNomeVertice() {
		return nomeVertice;
	}

	public void setNomeVertice(String nomeVertice) {
		this.nomeVertice = nomeVertice;
	}

	public Map<Vertice, Integer> getVerticesAdjacentes() {
		return verticesAdjacentes;
	}

	public void setVerticesAdjacentes(Map<Vertice, Integer> verticesAdjacentes) {
		this.verticesAdjacentes = verticesAdjacentes;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public List<Vertice> getMenorCaminho() {
		return menorCaminho;
	}

	public void setMenorCaminho(List<Vertice> menorCaminho) {
		this.menorCaminho = menorCaminho;
	}

	@Override
	public int compareTo(Object o) {
		Vertice v = (Vertice) o;
		if(this.distancia < v.getDistancia()) {
			return -1;
		} else if(this.distancia > v.getDistancia()){
			return 1;			
		}
		return 0;
	}

		
	
	

}
