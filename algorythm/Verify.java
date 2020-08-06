package com.mteuszbak.algorythm;

import java.util.Random;

public class Verify {

	public static double[] x = new double[1];
	public static double[] y = new double[1];
	
	public static void verify ()
	{
		int mem;
		int i;
		Random rand = new Random();
		
		//spradzenie czy dana czastka znajduje sie w podanym przedziale
		for ( mem = 0; mem < Info.popSize; mem++)
		{
			for ( i = 0; i < Info.nVars; i++)
			{
				x[0] = Population.population[mem][i][0];
				y[0] = Population.population[mem][i][1];
				
				if (x[0] > Info.high)
				{
					double xi = rand.nextDouble() * (Info.low - Info.high) + Info.high;
					Population.population[mem][i][0] = xi;
				}
				if (x[0] < Info.low)
				{
					double xi = rand.nextDouble() * (Info.low - Info.high) + Info.high;
					Population.population[mem][i][0] = xi;
				}
				
				
				if (y[0] > Info.high)
				{
					double yi = rand.nextDouble() * (Info.low - Info.high) + Info.high;
					Population.population[mem][i][1] = yi;
				}
				if (y[0] < Info.low)
				{
					double yi = rand.nextDouble() * (Info.low - Info.high) + Info.high;
					Population.population[mem][i][1] = yi;
				}
			}
		}
	}
}
