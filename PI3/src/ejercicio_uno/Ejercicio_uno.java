package ejercicio_uno;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;

public class Ejercicio_uno {

	public static String CreaLp(Integer n, String f, String gruposV) {
		// funcion a minimizar
		String res = "";
		res += "min: ";
		for (int i = 0; i < n; i++) {
			if (i != n - 1)
				res += ("+x" + i + " ");
			else
				res += ("+x" + i + ";");
		}

		// Grupos
		

		List<List<Integer>> g = gruposFactoria(gruposV);

		res += "\n\n";

		// añade cond
		for (int j = 0; j < g.size(); j++) {
			res += "c" + j + ":";
			for (int k = 0; k < g.get(j).size(); k++) {
				res += " +x" + g.get(j).get(k);
			}
			res += " >= 1;";
			res += "\n";
		}

		res += "\n";
		// Declarar variables
		res += "bin";
		for (int j = 0; j < n; j++) {
			if (j != n - 1)
				res += " x" + j + ",";
			else
				res += " x" + j + ";";
		}

		res += "\n";

		return res;
	}
	
	public static List<List<Integer>> gruposFactoria(String gruposV)
	{
		List<List<Integer>> res = new ArrayList<>();
		
		String[] trozos = gruposV.split("}");
		int i = 0;
		for (String s : trozos) {
			s = s.replace('{', ' ');
			s = s.replace('b', ' ');
			trozos[i] = s;
			i++;
		}

		for (String s : trozos) {
			List<Integer> l = new ArrayList<>();
			String[] t = s.split(",");

			for (int j = 0; j < t.length; j++) {
				String s2 = t[j].trim();

				if (!s2.matches("")) {
					Integer x = Integer.parseInt(s2);
					l.add(x);
				}
			}
			res.add(l);
		}
		
		return res;		
	}
	
	public static void EscribeEnFichero(String s, String fn) {
		PrintWriter pw = Files2.getWriter("ficheros/" + fn + ".txt");
		pw.write(s);
		pw.close();
	}
}
