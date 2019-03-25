package ejercicio_dos;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;

import tipos.Monumento;
import tipos.Ruta;

public class TestEjercicio_dos {

	public static void main(String[] args) {

		Graph<Monumento, Ruta> grafoConexiones = Ejercicio_dos.createGraph("ficheros/problema_cuatro/P4-Grafo1.txt");
		Graph<Monumento, Ruta> grafoPrecedencias = Ejercicio_dos.createDirGraph("ficheros/problema_cuatro/P4-Grafo2.txt");

		System.out.println("=====================APARTADO A========================");
		List<Set<Monumento>> s = Ejercicio_dos.componentesConexas(grafoConexiones);
		imprimeA(s);

		System.out.println("\n=====================APARTADO B========================");
		imprimeB(grafoPrecedencias);
		
		System.out.println("\n=====================APARTADO C========================");

		List<Monumento> grupo1 = Arrays.asList(Monumento.create("Sitio5"), Monumento.create("Sitio7"),
				Monumento.create("Sitio9"));
		List<Monumento> grupo2 = Arrays.asList(Monumento.create("Sitio4"), Monumento.create("Sitio5"),
				Monumento.create("Sitio6"));
		List<Monumento> grupo3 = Arrays.asList(Monumento.create("Sitio0"), Monumento.create("Sitio1"),
				Monumento.create("Sitio2"));

		List<List<Monumento>> sitios = Arrays.asList(grupo1, grupo2, grupo3);
		imprimeC(sitios, grafoConexiones, grafoPrecedencias);

	}
	
	public static void imprimeA(List<Set<Monumento>> s)
	{
		System.out.println("Estan todos los caminos conectados entre si: " + Ejercicio_dos.estaConectado(s));
		System.out.println("Las componentes conexas son: ");
		for (Set<Monumento> l : s) {
			System.out.println(l);
		}
	}
	
	public static void imprimeB(Graph<Monumento, Ruta> grafoPrecedencias)
	{
		System.out.println("Sitios que pueden visitarse sin haber visitado otros anteriormente: ");
		for (Monumento m : Ejercicio_dos.apartadoB(grafoPrecedencias)) {
			System.out.println(m);
		}
	}
	
	public static void imprimeC(List<List<Monumento>> sitios,Graph<Monumento, Ruta> grafoConexiones,Graph<Monumento, Ruta> grafoPrecedencias)
	{
			for (List<Monumento> l : sitios)
				System.out.println(Ejercicio_dos.apartadoC(l, grafoConexiones, grafoPrecedencias));
	}

}
