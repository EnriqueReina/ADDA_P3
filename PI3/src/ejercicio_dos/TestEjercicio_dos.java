package ejercicio_dos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;

import tipos.Monumento;
import tipos.Ruta;

public class TestEjercicio_dos {

	public static void main(String[] args) {
		
		Graph<Monumento,Ruta> grafoConexiones = Ejercicio_dos.createGraph("ficheros/problema_cuatro/P4-Grafo1.txt");
		Graph<Monumento,Ruta> grafoPrecedencias = Ejercicio_dos.createDirGraph("ficheros/problema_cuatro/P4-Grafo2.txt");
		
		System.out.println("=====================APARTADO A========================");
		
		List<Set<Monumento>> s= new ArrayList<>();
		s =  Ejercicio_dos.componentesConexas(grafoConexiones);
		System.out.println("Estan todos los caminos conectados entre si: " + Ejercicio_dos.estaConectado(s));
		System.out.println("Las componentes conexas son: ");		
		for(Set<Monumento> l: s)
		{
			System.out.println(l);
		}
		
		System.out.println("\n=====================APARTADO B========================");
		
		System.out.println("Sitios que pueden visitarse sin haber visitado otros anteriormente: ");
		for(Monumento m: Ejercicio_dos.apartadoB(grafoPrecedencias))
		{
			System.out.println(m);
		}
		
		System.out.println("\n=====================APARTADO C========================");
		
		List<List<Monumento>> sitios = new ArrayList<>();
				
		List<Monumento> grupo1 = new ArrayList<>();
		grupo1.add(Monumento.create("Sitio5"));
		grupo1.add(Monumento.create("Sitio7"));
		grupo1.add(Monumento.create("Sitio9"));
		
		List<Monumento> grupo2 = new ArrayList<>();
		grupo2.add(Monumento.create("Sitio4"));
		grupo2.add(Monumento.create("Sitio5"));
		grupo2.add(Monumento.create("Sitio6"));
		
		List<Monumento> grupo3 = new ArrayList<>();
		grupo3.add(Monumento.create("Sitio0"));
		grupo3.add(Monumento.create("Sitio1"));
		grupo3.add(Monumento.create("Sitio2"));
		
		sitios.add(grupo1);
		sitios.add(grupo2);
		sitios.add(grupo3);
		
		for(List<Monumento> l : sitios)
			System.out.println(Ejercicio_dos.apartadoC(l,grafoConexiones,grafoPrecedencias));
	
	}

}
