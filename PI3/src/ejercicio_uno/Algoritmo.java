package ejercicio_uno;

import java.util.ArrayList;
import java.util.List;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;

public class Algoritmo implements ValuesInRangeProblemAG<Integer, List<Integer>> {

	private Integer n;
	private List<List<Integer>> barrios;
	private List<Integer> barriosEstaciones = new ArrayList<>();

	public Algoritmo(Integer n, String gv) {
		this.n = n;
		this.barrios = Ejercicio_uno.gruposFactoria(gv);
	}
	
	public List<List<Integer>> anyadeVals(List<Integer> l, List<List<Integer>> l2) {
		List<List<Integer>> res = new ArrayList<>();

		for (List<Integer> i : l2) {
			List<Integer> temp = new ArrayList<>();

			for (int j = 0; j < i.size(); j++) {
				int z = l.get(i.get(j));
				temp.add(z);
			}

			res.add(temp);
		}

		return res;
	}

	public List<Integer> sumaPesos(List<List<Integer>> l) {
		List<Integer> res = new ArrayList<>();
		Integer sum = 0;

		for (List<Integer> lista : l) {
			for (Integer i : lista) {
				sum += i;
			}

			res.add(sum);
			sum = 0;
		}

		return res;
	}

	public Integer getVariableNumber() {
		return n;
	}

	@Override
	public Integer getMax(Integer i) {

		return barriosEstaciones.size() - 1;
	}

	@Override
	public Integer getMin(Integer i) {
		return 0;
	}

	@Override
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {

		Long k = 100000000l;
		Double res = 0.0;
		Double sum = 0.0;
		int b = 0;
		int u = 0;

		List<Integer> sol = this.getSolucion(cr);
		List<List<Integer>> copiaBarriosVecinos = anyadeVals(sol, barrios);
		List<Integer> l = sumaPesos(copiaBarriosVecinos);

		for (Integer i : sol) {
			sum += i;
		}

		res += sum;

		for (int i = 0; i < l.size(); i++) {
			b += l.get(i);
			b = b - 1;

			if (b < 0) {
				u -= b;
			}
		}

		res = -res - k * u;

		return res;
	}

	@Override
	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		List<Integer> cromo = cr.decode();
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < cromo.size(); i++) {
			res.add(cromo.get(i));
		}

		return res;
	}
}
