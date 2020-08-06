package com.mteuszbak.algorythm;

import static java.lang.Math.*;
import java.util.Random;

public class Mutation
{

	public static void mutation() 
	{

		int mem;
		int i;
		double x, y, z1, z2, z3, z4, z5;
		double mut, mut4;
		double odch = 0;
		Random rand = new Random();
		
		for (mem = 0; mem < Info.popSize-4; mem++)
		{
			mut = 0;
			mut = rand.nextDouble();
				
			if ( mut < Info.pMut)
			{
				for (i = 0; i < Info.nVars; i++)
				{
					double mut2 = 0;
					mut2 = rand.nextDouble();
					
					if( mut2 < 0.01)
					{
						z1 = rand.nextDouble();
						z2 = rand.nextDouble();
						z3 = rand.nextDouble();
						z4 = rand.nextDouble();
						z5 = rand.nextDouble();
					
						double sred = (z1+z2+z3+z4+z5)/5;
						double odch1 = pow( (z1-sred), 2);
						double odch2 = pow( (z2-sred), 2);
						double odch3 = pow( (z3-sred), 2);
						double odch4 = pow( (z4-sred), 2);
						double odch5 = pow( (z5-sred), 2);
						
						double mut3 = 0;
						mut3 = rand.nextDouble();
						
						if (mut3 <= 0.5)
						{
							odch = sqrt((odch1+odch2+odch3+odch4+odch5));
						}
						if (mut3 > 0.5 && mut3 <= 0.8 )
						{
							odch = (sqrt((odch1+odch2+odch3+odch4+odch5)))/2;
						}
						else
						{
							odch = (sqrt((odch1+odch2+odch3+odch4+odch5)))/3;
						}
					
						x = Population.population[mem][i][0];
						y = Population.population[mem][i][1];
						
							if (x >= Info.high-(Info.high/11))
							{
								Population.population[mem][i][0] = x - odch;
							}
							if (x > Info.high-(Info.high/4) && x <= Info.high-(Info.high/5))
							{
								Population.population[mem][i][0] = x + odch;
							}
							if (x > Info.high-(Info.high/2) && x <= Info.high-(Info.high/4))
							{
								Population.population[mem][i][0] = x + odch;
							}					
							
							if (x < Info.low+(Info.high/11))
							{
								Population.population[mem][i][0] = x + odch;
							}
							if (x < Info.low+(Info.high/4) && x >= Info.low+(Info.high/5))
							{
								Population.population[mem][i][0] = x - odch;
							}
							if (x < Info.low+(Info.high/2) && x >=  Info.low+(Info.high/4))
							{
								Population.population[mem][i][0] = x - odch;
							}					

														
							
							if (y > Info.high-(Info.high/11))
							{
								Population.population[mem][i][1] = y - odch;
							}
							if (y > Info.high-(Info.high/4) && y <= Info.high-(Info.high/5))
							{
								Population.population[mem][i][1] = y + odch;
							}
							if (y > Info.high-(Info.high/2) && y <= Info.high-(Info.high/4))
							{
								Population.population[mem][i][1] = y + odch;
							}
							
							if (y < Info.low+(Info.high/11))
							{
								Population.population[mem][i][1] = y + odch;
							}
							if (y < Info.low+(Info.high/4) && y >= Info.low+(Info.high/5))
							{
								Population.population[mem][i][1] = y - odch;
							}
							if (y < Info.low+(Info.high/2) && y >=  Info.low+(Info.high/4))
							{
								Population.population[mem][i][1] = y - odch;
							}
							
							
						}

					else
					{
						double xi = rand.nextDouble() * (Info.low - Info.high) + Info.high;
						double yi = rand.nextDouble() * (Info.low - Info.high) + Info.high;
							
						Population.population[mem][i][0] = xi;
						Population.population[mem][i][1] = yi;
					}
				}					
			}				
		}
		for ( mem = 1; mem < 4; mem++)
		{
			for ( i = 0; i < Info.nVars; i++)
			{
				z1 = rand.nextDouble();
				z2 = rand.nextDouble();
				z3 = rand.nextDouble();
				z4 = rand.nextDouble();
				z5 = rand.nextDouble();
			
				double sred = (z1+z2+z3+z4+z5)/5;
				double odch1 = pow( (z1-sred), 2);
				double odch2 = pow( (z2-sred), 2);
				double odch3 = pow( (z3-sred), 2);
				double odch4 = pow( (z4-sred), 2);
				double odch5 = pow( (z5-sred), 2);
				
				double mut3 = 0;
				mut3 = rand.nextDouble();
				
				if (mut3 <= 0.5)
				{
					odch = sqrt((odch1+odch2+odch3+odch4+odch5));
				}
				if (mut3 > 0.5 && mut3 <= 0.8 )
				{
					odch = (sqrt((odch1+odch2+odch3+odch4+odch5)))/2;
				}
				else
				{
					odch = (sqrt((odch1+odch2+odch3+odch4+odch5)))/3;
				}
			
				x = Population.population[Info.popSize-mem][i][0];
				y = Population.population[Info.popSize-mem][i][1];
				
				mut4 = rand.nextDouble();
				if (x >= 1  && mut4 < 0.5)
				{
					Population.population[Info.popSize-mem][i][0] = x - odch/2;
				}
				if (x >= 1 && mut4 > 0.5)
				{
					Population.population[Info.popSize-mem][i][0] = x + odch/2;
				}				
				
				mut4 = rand.nextDouble();
				if (x <= -1 && mut4 < 0.5)
				{
					Population.population[Info.popSize-mem][i][0] = x + odch/2;
				}
				if (x <= -1 && mut4 > 0.5)
				{
					Population.population[Info.popSize-mem][i][0] = x - odch/2;
				}	
											
				mut4 = rand.nextDouble();
				if (y >= 1 && mut4 < 0.5)
				{
					Population.population[Info.popSize-mem][i][1] = y - odch/2;
				}
				if (y >= 1 && mut4 > 0.5)
				{
					Population.population[Info.popSize-mem][i][1] = y + odch/2;
				}
				
				mut4 = rand.nextDouble();
				if (y <= -1 && mut4 < 0.5)
				{
					Population.population[Info.popSize-mem][i][1] = y + odch/2;
				}	
				if (y <= -1 && mut4 > 0.5)
				{
					Population.population[Info.popSize-mem][i][1] = y - odch/2;
				}
				
				
				
				mut4 = rand.nextDouble();
				if (x < 1 && x > 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x - odch/2;
				}
				if (x < 1 && x > 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x + odch/2;
				}				
				
				mut4 = rand.nextDouble();
				if (x > -1 && x < 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x + odch/2;
				}
				if (x > -1 && x < 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x - odch/2;
				}	
											
				mut4 = rand.nextDouble();
				if (y < 1 && y > 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y - odch/2;
				}
				if (y < 1 && y > 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y + odch/2;
				}
				
				mut4 = rand.nextDouble();
				if (y > -1 && y < 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y + odch/2;
				}	
				if (y > -1 && y < 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y - odch/2;
				}
				
				
				
				mut4 = rand.nextDouble();
				if (x < 0.25 && x > 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x + odch/2;
				}
				if (x < 0.25 && x > 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x - odch/2;
				}				
				
				mut4 = rand.nextDouble();
				if (x > -0.25 && x < 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x - odch/2;
				}
				if (x > -0.25 && x < 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][0] = x + odch/2;
				}	
											
				mut4 = rand.nextDouble();
				if (y < 0.25 && y > 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y + odch/2;
				}
				if (y < 0.25 && y > 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y - odch/2;
				}
				
				mut4 = rand.nextDouble();
				if (y > -0.25 && y < 0 && mut4 < 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y - odch/2;
				}	
				if (y > -0.25 && y < 0 && mut4 < 0.5 && mut4 > 0.25)
				{
					Population.population[Info.popSize-mem][i][1] = y + odch/2;
				}
			}
		}
	}
}	
