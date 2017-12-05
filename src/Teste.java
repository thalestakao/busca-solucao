import br.com.unialfa.ia.core.heuristic.SolucaoCtx;
import br.com.unialfa.ia.core.heuristic.impl.BuscaEmProfundidade;
import br.com.unialfa.ia.core.model.Grafo;
import br.com.unialfa.ia.core.model.Vertice;

public class Teste {

	public static void main(String[] args) {
		Vertice goiania = new Vertice("Goiania");
		Vertice belaVista = new Vertice("Bela Vista de Goiás");
		Vertice caldasNovas = new Vertice("Caldas Novas");
		Vertice morrinhos = new Vertice("Morrinhos");
		Vertice edeia = new Vertice("Edeia");
		Vertice hidrolandia = new Vertice("Hidrolandia");
		Vertice silvania = new Vertice("Silvania");
		Vertice vianapolis = new Vertice("Vianapolis");
		Vertice ipameri = new Vertice("Ipameri");
		Vertice pontalina = new Vertice("Pontalina");
		Vertice piracanjuba = new Vertice("Piracanjuba");
		Vertice orizona = new Vertice("Orizona");

		Vertice[] cidades = { goiania, belaVista, caldasNovas, morrinhos, edeia, hidrolandia, silvania, vianapolis,
				ipameri, pontalina, piracanjuba, orizona };
		
		goiania.adicionarDestino(belaVista, 481);
		goiania.adicionarDestino(edeia, 124);
		goiania.adicionarDestino(hidrolandia, 33);
		goiania.adicionarDestino(silvania, 67);

		belaVista.adicionarDestino(caldasNovas, 117);

		edeia.adicionarDestino(pontalina, 69);

		pontalina.adicionarDestino(morrinhos, 124);

		morrinhos.adicionarDestino(caldasNovas, 57);

		hidrolandia.adicionarDestino(piracanjuba, 70);
		hidrolandia.adicionarDestino(morrinhos, 90);

		silvania.adicionarDestino(vianapolis, 18);

		vianapolis.adicionarDestino(orizona, 46);

		orizona.adicionarDestino(ipameri, 95);

		ipameri.adicionarDestino(caldasNovas, 61);

		Grafo grafo = new Grafo();
		
		grafo.adicionarVertice(goiania);
		grafo.adicionarVertice(belaVista);
		grafo.adicionarVertice(caldasNovas);
		grafo.adicionarVertice(hidrolandia);
		grafo.adicionarVertice(pontalina);
		grafo.adicionarVertice(orizona);
		grafo.adicionarVertice(morrinhos);
		grafo.adicionarVertice(edeia);
		grafo.adicionarVertice(silvania);
		grafo.adicionarVertice(vianapolis);
		grafo.adicionarVertice(piracanjuba);
		grafo.adicionarVertice(ipameri);
		
		
		grafo.listarVertices();

		
		SolucaoCtx.buscaCega = new BuscaEmProfundidade();
		
		Grafo solucao = SolucaoCtx.processarGrafo(grafo, goiania);
		
		System.out.println("=============================================");
//	
		
		SolucaoCtx.processarSolucao(solucao, caldasNovas);

	}

}
