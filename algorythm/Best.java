package com.mteuszbak.algorythm;

public class Best
{

	public static void best()
	{
		int mem;
		int i, j, n;
		
		//wybieranie najlepszego osobnika populacji
		for ( mem = 0; mem < Info.popSize; mem++)
		{
			//sprawdzanie czy dopasowanie jest wieksze
			if (Population.pfitness[mem][0] > Main.bestfitness[0])
				{
					Main.bestfitness[0] = Population.pfitness[mem][0];		//dopasowanie
					Main.bestfitness[1] = Population.pfitness[mem][1];		//U
					Main.bestfitness[2] = Population.pfitness[mem][2];		//U/N
					
					for ( i = 0; i < Info.nVars; i++)
						{
						for ( j = 0; j < 2; j++)
							{
								Info.best[i][j] = Population.population[mem][i][j];
								for ( n = 1; n < 4; n++)
								{
									Population.newpopulation[Info.popSize-n][i][j] = Info.best[i][j];
									
								}
							}
						}	
				}	
		}
	}
}
