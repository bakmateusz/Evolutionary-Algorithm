package com.mteuszbak.algorythm;

import java.util.Random;

public class Select
{
	//selekcja turniejowa
	
	public static double[] t = new double[10];			//tablica przechowujaca m osobnikow do selekcji turniejowej
	public static int[] ti = new int[10];				//tablica przechowuja polozenie osobnika w populacji
	
	public static void select()
	{

		int mem;
		int m1, m2, m3, m4, m5, m6, m7, m8, m9, m10;
		int i, j;
		int a = 0;	

			//wybor m osobnikow do selekcji turniejowej
			for (mem = 0; mem < Info.popSize-4; mem++)
			{		
				Random rand = new Random();
				m1 = rand.nextInt(Info.popSize);
				m2 = rand.nextInt(Info.popSize);
				m3 = rand.nextInt(Info.popSize);
				m4 = rand.nextInt(Info.popSize);
				m5 = rand.nextInt(Info.popSize);
				m6 = rand.nextInt(Info.popSize);
				m7 = rand.nextInt(Info.popSize);
				m8 = rand.nextInt(Info.popSize);
				m9 = rand.nextInt(Info.popSize);
				m10 = rand.nextInt(Info.popSize);
				
				t[0] = t[1] = t[2] = t[3] = t[4] = t[5] = t[6] = t[7] = t[8] = t[9] = 0;
				ti[0] = ti[1] = ti[2] = ti[3] = ti[4] = ti[5] = ti[6] = ti[7] = ti[8] = ti[9] = 0;
				
				
				//sprawdzanie czy osobnicy sie nie powtorzaja
				for ( i = 0; i < 25; i++)
				{
					if (m1 != m2 && m1 != m3 && m1 != m4 && m1 != m5 && m1 != m6 && m1 != m7 && m1 != m8 && m1 != m9 && m1 != m10)
					{
						t[0] = Population.pfitness[m1][0];
						ti[0] = m1;
					}
					else
					{
						m1 = rand.nextInt(Info.popSize);
					}
					
					if (m2 != m1 && m2 != m3 && m2 != m4 && m2 != m5 && m2 != m6 && m2 != m7 && m2 != m8 && m2 != m9 && m2 != m10)
					{
						t[1] = Population.pfitness[m2][0];
						ti[1] = m2;
					}
					else
					{
						m2 = rand.nextInt(Info.popSize);
					}
					
					if (m3 != m1 && m3 != m2 && m3 != m4 && m3 != m5 && m3 != m6 && m3 != m7 && m3 != m8 && m3 != m9 && m3 != m10)
					{
						t[2] = Population.pfitness[m3][0];
						ti[2] = m3;
					}
					else
					{
						m3 = rand.nextInt(Info.popSize);
					}
					
					if (m4 != m1 && m4 != m2 && m4 != m3 && m4 != m5 && m4 != m6 && m4 != m7 && m4 != m8 && m4 != m9 && m4 != m10)
					{
						t[3] = Population.pfitness[m4][0];
						ti[3] = m4;
					}
					else
					{
						m4 = rand.nextInt(Info.popSize);
					}
					
					if (m5 != m1 && m5 != m2 && m5 != m3 && m5 != m4 && m5 != m6 && m5 != m7 && m5 != m8 && m5 != m9 && m5 != m10)
					{
						t[4] = Population.pfitness[m5][0];
						ti[4] = m5;
					}
					else
					{
						m5 = rand.nextInt(Info.popSize);
					}
					
					if (m6 != m1 && m6 != m2 && m6 != m3 && m6 != m4 && m6 != m5 && m6 != m7 && m6 != m8 && m6 != m9 && m6 != m10)
					{
						t[5] = Population.pfitness[m6][0];
						ti[5] = m6;
					}
					else
					{
						m6 = rand.nextInt(Info.popSize);
					}
					
					if (m7 != m1 && m7 != m2 && m7 != m3 && m7 != m4 && m7 != m5 && m7 != m6 && m7 != m8 && m7 != m9 && m7 != m10)
					{
						t[6] = Population.pfitness[m7][0];
						ti[6] = m7;
					}
					else
					{
						m7 = rand.nextInt(Info.popSize);
					}
					
					if (m8 != m1 && m8 != m2 && m8 != m3 && m8 != m4 && m8 != m5 && m8 != m6 && m8 != m7 && m8 != m9 && m8 != m10)
					{
						t[7] = Population.pfitness[m8][0];
						ti[7] = m8;
					}
					else
					{
						m8 = rand.nextInt(Info.popSize);
					}
					
					if (m9 != m1 && m9 != m2 && m9 != m3 && m9 != m4 && m9 != m5 && m9 != m6 && m9 != m7 && m9 != m8 && m9 != m10)
					{
						t[8] = Population.pfitness[m9][0];
						ti[8] = m9;
					}
					else
					{
						m9 = rand.nextInt(Info.popSize);
					}
					
					if (m10 != m1 && m10 != m2 && m10 != m3 && m10 != m4 && m10 != m5 && m10 != m6 && m10 != m7 && m10 != m8 && m10 != m9)
					{
						t[9] = Population.pfitness[m10][0];
						ti[9] = m10;
					}
					else
					{
						m10 = rand.nextInt(Info.popSize);
					}
				}
				
				
								
				//turniej		
				if ( t[0] > t[1] && t[0] > t[2] && t[0] > t[3] && t[0] > t[4] && t[0] > t[5] && t[0] > t[6] && t[0] > t[7] && t[0] > t[8] && t[0] > t[9])
				{
					a = ti[0];
					
					for (i = 0; i < Info.nVars; i++)
					{
						
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				
				if ( t[1] > t[0] && t[1] > t[2] && t[1] > t[3] && t[1] > t[4] && t[1] > t[5] && t[1] > t[6] && t[1] > t[7] && t[1] > t[8] && t[1] > t[9])
				{
					a = ti[1];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				
				if ( t[2] > t[0] && t[2] > t[1] && t[2] > t[3] && t[2] > t[4] && t[2] > t[5] && t[2] > t[6] && t[2] > t[7] && t[2] > t[8] && t[2] > t[9])
				{
					a = ti[2];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				if ( t[3] > t[0] && t[3] > t[1] && t[3] > t[2] && t[3] > t[4] && t[3] > t[5] && t[3] > t[6] && t[3] > t[7] && t[3] > t[8] && t[3] > t[9])
				{
					a = ti[3];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				if ( t[4] > t[0] && t[4] > t[1] && t[4] > t[2] && t[4] > t[3] && t[4] > t[5] && t[4] > t[6] && t[4] > t[7] && t[4] > t[8] && t[4] > t[9])
				{
					a = ti[4];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				if ( t[5] > t[0] && t[5] > t[1] && t[5] > t[2] && t[5] > t[3] && t[5] > t[4] && t[5] > t[6] && t[5] > t[7] && t[5] > t[8] && t[5] > t[9])
				{
					a = ti[5];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				if ( t[6] > t[0] && t[6] > t[1] && t[6] > t[2] && t[6] > t[3] && t[6] > t[4] && t[6] > t[5] && t[6] > t[7] && t[6] > t[8] && t[6] > t[9])
				{
					a = ti[6];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				if ( t[7] > t[0] && t[7] > t[1] && t[7] > t[2] && t[7] > t[3] && t[7] > t[4] && t[7] > t[5] && t[7] > t[6] && t[7] > t[8] && t[7] > t[9])
				{
					a = ti[7];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				if ( t[8] > t[0] && t[8] > t[1] && t[8] > t[2] && t[8] > t[3] && t[8] > t[4] && t[8] > t[5] && t[8] > t[6] && t[8] > t[7] && t[8] > t[9])
				{
					a = ti[8];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
				if ( t[9] > t[0] && t[9] > t[1] && t[9] > t[2] && t[9] > t[3] && t[9] > t[4] && t[9] > t[5] && t[9] > t[6] && t[9] > t[7] && t[9] > t[8])
				{
					a = ti[9];
					
					for (i = 0; i < Info.nVars; i++)
					{
						for (j = 0; j < 2; j++)
						{
							Population.newpopulation[mem][i][j] = Population.population[a][i][j];
						}
					}
				}
		
			}
			
			Population.population = Population.newpopulation;
		}
		
	}		

	
	

