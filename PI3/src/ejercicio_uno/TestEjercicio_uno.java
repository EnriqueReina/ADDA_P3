package ejercicio_uno;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class TestEjercicio_uno {
	
	public static void main(String[] args) {

		System.out.println("Archivo de texto: ");
		archivoDeTexto();

		Integer n = 6;
		String grupoVecinos = "{b0, b1}, {b0, b1, b5}, {b2, b3}, {b2, b3, b4}, {b3, b4, b5}, {b1, b4, b5}";
		String s = Ejercicio_uno.CreaLp(n, grupoVecinos);
		Ejercicio_uno.EscribeEnFichero(s, "generateLpSolve");

		System.out.println("Archivo Generado: ");
		archivoGenerado(s);
		
	}

	public static void archivoDeTexto() {
		SolutionPLI a = AlgoritmoPLI.getSolutionFromFile("ficheros/lpsolve.txt");
		System.out.println("-------------------");
		System.out.println("________");
		System.out.println(a.getGoal());
		for (int j = 0; j < a.getNumVar(); j++) {
			System.out.println(a.getName(j) + " = " + a.getSolution()[j]);
		}
		System.out.println("________\n");
	}

	public static void archivoGenerado(String s) {

		SolutionPLI a = AlgoritmoPLI.getSolution(s);
		System.out.println("-------------------");
		System.out.println("________");
		System.out.println(a.getGoal());
		for (int j = 0; j < a.getNumVar(); j++) {
			System.out.println(a.getName(j) + " = " + a.getSolution()[j]);
		}
		System.out.println("________\n");
	}
}
