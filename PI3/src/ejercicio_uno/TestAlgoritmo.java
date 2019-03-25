package ejercicio_uno;

import java.util.List;

import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.BinaryChromosome;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class TestAlgoritmo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setCondiciones();
	
		String grupoVecinos = "{b0, b1}, {b0, b1, b5}, {b2, b3}, {b2, b3, b4}, {b3, b4, b5}, {b1, b4, b5}";
		Integer n = 6;
		
		ValuesInRangeProblemAG<Integer, List<Integer>> p = new Algoritmo(n,grupoVecinos);
		AlgoritmoAG<BinaryChromosome> alg = AlgoritmoAG.create(ChromosomeType.Binary, p);
		alg.ejecuta();
		
		BinaryChromosome sol = alg.getBestChromosome();
		List<Integer> problemSol = p.getSolucion(sol);
		
		System.out.println("Sol: " + problemSol);
		
		for(int i = 0; i < problemSol.size(); i++)
		{
			if(problemSol.get(i) == 1)
				System.out.println("El barrio b"+ (i+1) + " tiene estacion.");
		}
			
		System.out.println("Coste (Numero de esatciones): " + -1 *  p.fitnessFunction(sol));
	}
	
	public static void setCondiciones()
	{
		AlgoritmoAG.ELITISM_RATE = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 50;

		StoppingConditionFactory.NUM_GENERATIONS = 50;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 1;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;
	}

}
