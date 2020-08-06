package com.mteuszbak.algorythm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Population 
{	
	
	public static double[][][] newpopulation = new double[Info.popSize][Info.nVars][2];		//tablica przechowujaca nowa populacje
	public static double[][][] population = new double[Info.popSize][Info.nVars][2];		//tablica przechowujaca osobnikow = populacja
	public static double[][] pfitness = new double[Info.popSize][5];						//tablica przechowujaca dopasowanie dla osobnikow
	public static double[][] person = new double[Info.nVars][2];							//tablica osobnika
	public static double[] gen = new double[2];												//tablica przechowujaca x i y

	
	public static void population() throws FileNotFoundException
	{
		PrintWriter save = new PrintWriter("wynik_PopulacjaPoczatkowa.txt");
		int i, j;
		double x, y;
		double fitness = 0;						//dopasowanie osobnika
		Random rand = new Random();
		
		//tworzenie populacji
		for ( i = 0; i < Info.popSize; i++)
		{
			double[][] person = population[i];
			
			pfitness[i][0] = fitness;		//przypisywanie dopasowanie w rownoleglej tablicy

			
			//tworzenie losowych genow dla osobnika
			for ( j = 0; j < Info.nVars; j++)
			{
				double[] gen = person[j];
				
				x = rand.nextDouble() * (Info.low - Info.high) + Info.high;
				y = rand.nextDouble() * (Info.low - Info.high) + Info.high;
				
				gen[0] = x;
				gen[1] = y;
				
			}
					
		}
	
		//wypisywanie populacji poczatkowej
		for (i = 0; i < Info.popSize; i++)
		{
			save.println("Osobnik " + (i + 1) );
		
			for (j = 0; j < Info.nVars; j++)
			{		
				save.println("Gen - " + "( "+ population[i][j][0] + ", " + population[i][j][1] + " )");
			}
			save.println();
			
		}
		
		save.close();
	}

}
