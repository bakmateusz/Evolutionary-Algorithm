package com.mteuszbak.algorythm;

public class Elitist {
	
	public static void elitist ()  
	{		
		int i, j;
		int mem;
		double best = 0;
		int best_mem = 0;

		
		for ( mem = 0; mem < Info.popSize-3; mem++)
		{
			if ( Population.pfitness[mem][0] > Population.pfitness[mem+1][0])
			{
				if ( Population.pfitness[mem][0] >= best)
				{
					best = Population.pfitness[mem][0];
					best_mem = mem;
				}
				if ( Population.pfitness[mem+1][0] >= best)
				{
					best = Population.pfitness[mem+1][0];
					best_mem = mem;
				}
			}
		}
		for (i = 0; i < Info.nVars; i++)
		{
			for (j = 0; j < 2; j++)
			{
				Population.newpopulation[Info.popSize-4][i][j] = Population.population[best_mem][i][j];
			}
		}

	}
}
