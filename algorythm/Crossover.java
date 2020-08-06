package com.mteuszbak.algorythm;

import java.util.Random;

public class Crossover 
{
	public static double[][] x1 = new double [Info.nVars][1];
	public static double[][] y1 = new double [Info.nVars][1];
	public static double[][] x2 = new double [Info.nVars][1];
	public static double[][] y2 = new double [Info.nVars][1];
	
	public static double[][] x3 = new double [Info.nVars][1];
	public static double[][] y3 = new double [Info.nVars][1];
	public static double[][] x4 = new double [Info.nVars][1];
	public static double[][] y4 = new double [Info.nVars][1];
	
	
	//krzyzowanie usredniajace (arytmetyczne)
	public static void crossover()
	{
		
		int mem;
		int i;
		int a;
		int b;
		double c1, c2, d1, d2, e1, e2, f1, f2;
		double k;
		double x;
		
			
		for ( mem = 0; mem < Info.popSize-4; mem++)
		{			
				x = 0;
				Random rand = new Random();
				x = rand.nextDouble();
			
			//sprawdzenie czy krzyzowanie zachodzi
			if (x < Info.pXover)
			{		
					//losowanie osobnikow do krzyzowania
					a = rand.nextInt(Info.popSize);
					b = rand.nextInt(Info.popSize);
				
					k = rand.nextDouble();				
					
					//wybor osobnikow do krzyzowania
					for ( i = 0; i < Info.nVars; i++)
					{
					x1[i][0] = Population.population[a][i][0];
					y1[i][0] = Population.population[a][i][1];
					
					x2[i][0] = Population.population[b][i][0];
					y2[i][0] = Population.population[b][i][1];	
					}
				
					//krzyzowanie
					for ( i = 0; i < Info.nVars; i++)
					{
						c1 = k * x1[i][0];
						c2 = (1 - k) * x2[i][0];
						x3[i][0] = c1 + c2;
						
						d1 = k * x2[i][0];
						d2 = (1 - k) * x1[i][0];
						x4[i][0] = d1 + d2;
										
						e1 = k * y1[i][0];
						e2 = (1 - k) * y2[i][0];
						y3[i][0] = e1 + e2;
						
						f1 = k * y2[i][0];
						f2 = (1 - k) * y1[i][0];
						y4[i][0] = f1 + f2;	
					
					}			
					//utworzenie osobnikow po krzyzowaniu
					for ( i = 0; i <Info.nVars; i++)
					{
						if ( x3[i][0] > Info.low && x3[i][0] < Info.high && x4[i][0] > Info.low && x4[i][0] < Info.high)
						{
							Population.population[a][i][0] = x3[i][0];
							Population.population[a][i][0] = x4[i][0];
						}
					
						if ( y3[i][0] > Info.low && y3[i][0] < Info.high && y4[i][0] > Info.low && y4[i][0] < Info.high)
						{
							Population.population[a][i][1] = y3[i][0];
							Population.population[a][i][1] = y4[i][0];
						}
					}
			}
			
			//krzyzowanie najlepszego osobnika z najlepszym osobnikiem poprzedniej populacji
			for ( i = 0; i < Info.nVars; i++)
			{
				
						c1 = c2 = d1 = d2 = e1 = e2 = f1 = f2 = 0;
						k = 0;
					
						k = rand.nextDouble();
						x1[i][0] = x2[i][0] = y1[i][0] = y2[i][0] = 0;
						x3[i][0] = x4[i][0] = y3[i][0] = y4[i][0] = 0;
						
						
						//wybor osobnikow do krzyzowania
						for ( i = 0; i < Info.nVars; i++)
						{
						x1[i][0] = Population.population[Info.popSize-3][i][0];
						y1[i][0] = Population.population[Info.popSize-3][i][1];
						
						x2[i][0] = Population.population[Info.popSize-4][i][0];
						y2[i][0] = Population.population[Info.popSize-4][i][1];	
						}
					
						//krzyzowanie
						for ( i = 0; i < Info.nVars; i++)
						{
							c1 = k * x1[i][0];
							c2 = (1 - k) * x2[i][0];
							x3[i][0] = c1 + c2;
							
							d1 = k * x2[i][0];
							d2 = (1 - k) * x1[i][0];
							x4[i][0] = d1 + d2;
											
							e1 = k * y1[i][0];
							e2 = (1 - k) * y2[i][0];
							y3[i][0] = e1 + e2;
							
							f1 = k * y2[i][0];
							f2 = (1 - k) * y1[i][0];
							y4[i][0] = f1 + f2;	
						
						}
					
						//utworzenie osobnikow po krzyzowaniu
						for ( i = 0; i <Info.nVars; i++)
						{
							if ( x3[i][0] > Info.low && x3[i][0] < Info.high && x4[i][0] > Info.low && x4[i][0] < Info.high)
							{
								Population.population[Info.popSize-3][i][0] = x3[i][0];
								Population.population[Info.popSize-4][i][0] = x4[i][0];
							}
						
							if ( y3[i][0] > Info.low && y3[i][0] < Info.high && y4[i][0] > Info.low && y4[i][0] < Info.high)
							{
								Population.population[Info.popSize-3][i][1] = y3[i][0];
								Population.population[Info.popSize-4][i][1] = y4[i][0];
							}
								
						}
			}
		}				
	}
}
