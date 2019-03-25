package ejercicio_dos;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;

import tipos.Monumento;
import tipos.Ruta;
import us.lsi.common.Files2;
import us.lsi.graphs.GraphsReader;

public class Ejercicio_dos {

	public static Graph<Monumento, Ruta> createGraph(String fn) {
		Graph<Monumento, Ruta> g = GraphsReader.newGraph(fn, Monumento::create, Ruta::create,
				() -> new SimpleWeightedGraph<>(Monumento::create, Ruta::create), Ruta::getTiempo);

		return g;
	}

	public static Graph<Monumento, Ruta> createDirGraph(String fn) {
		Graph<Monumento, Ruta> g = GraphsReader.newGraph(fn, Monumento::create, Ruta::create,
				() -> new SimpleDirectedGraph<>(Ruta.class));

		return g;
	}

	public static String estaConectado(List<Set<Monumento>> set) {
		if (set.size() > 1)
			return "No";
		else
			return "Si";
	}

	public static List<Set<Monumento>> componentesConexas(Graph<Monumento, Ruta> g) {
		ConnectivityInspector<Monumento, Ruta> conexo = new ConnectivityInspector<Monumento, Ruta>(g);
		return conexo.connectedSets();
	}

	public static List<Monumento> apartadoB(Graph<Monumento, Ruta> g) {
		List<Monumento> res = g.vertexSet().stream().collect(Collectors.toList());
		List<Ruta> rutas = g.edgeSet().stream().collect(Collectors.toList());
		for (Ruta r : rutas) {
			Monumento target = r.getTo();
			if (res.contains(target))
				res.remove(target);
		}
		return res;
	}

	public static String apartadoC(List<Monumento> l, Graph<Monumento, Ruta> gc, Graph<Monumento, Ruta> gp) {
		Double time = 0.0;
		List<Monumento> newPath = new ArrayList<>();

		for (int i = 0; i < l.size() - 1; i++) {
			ShortestPathAlgorithm<Monumento, Ruta> sp = new DijkstraShortestPath<>(gc);
			ShortestPathAlgorithm<Monumento, Ruta> sp2 = new DijkstraShortestPath<>(gp);
			GraphPath<Monumento, Ruta> path = sp.getPath(l.get(i), l.get(i + 1));
			GraphPath<Monumento, Ruta> pathPrecedencia = sp2.getPath(l.get(i), l.get(i + 1));
			if (path == null) {
				return "No es posible según el grafo de conexiones visitar " + l.toString();

			} else if (pathPrecedencia == null) {
				return "No es posible según el grafo de precedencias visitar en el orden " + l.toString();
			} else {
				for (Ruta r : path.getEdgeList()) {
					time += r.getTiempo();

					Monumento mF = r.getFrom();
					Monumento mT = r.getTo();

					if (!newPath.contains(mF))
						newPath.add(mF);

					if (!newPath.contains(mT))
						newPath.add(mT);
				}
			}
		}

		return "Visita de " + l.toString() + " respetando el orden con menor tiempo (" + time + " mins):\n"
				+ newPath.toString();

	}

	public static void exportaGraph(Graph<Monumento, Ruta> g, String fn) {

		DOTExporter<Monumento, Ruta> de = new DOTExporter<Monumento, Ruta>(new IntegerComponentNameProvider<>(),
				v -> v.getName(), a -> a.getNombreRuta() + " (" + a.getTiempo() + ")");

		PrintWriter pw = Files2.getWriter("ficheros/" + fn + ".txt");
		de.exportGraph(g, pw);
	}

}
