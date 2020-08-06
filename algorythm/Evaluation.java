package com.mteuszbak.algorythm;

import static java.lang.Math.*;

public class Evaluation 
{
	public static double[] xi = new double [Info.nVars];
	public static double[] yi = new double [Info.nVars];
	public static double[] xj = new double [Info.nVars];
	public static double[] yj = new double [Info.nVars];
	
	
	public static void evaluation()
	{
		
	
		int mem;
		int i, j;
		double ri2, sum_ri2, rij, sum, sum2, U = 0.0;
		double prij = 0.0;

		for ( mem = 0; mem < Info.popSize; mem++)
		{
			//zerowanie wielkosci
			
			ri2 = sum_ri2 = sum = sum2 = U = 0.0;	
			
			
			//wczytywanie xi
			for ( i = 0; i < Info.nVars; i++)
			{
				double x = Population.population[mem][i][0];
				xi[i] = x;

			}
			
			//wczytywanie yi
			for ( i = 0; i < Info.nVars; i++)
			{
				double y = Population.population[mem][i][1];
				yi[i] = y;
				
			}
			
			
			//obliczanie Sigma ri^2
			for ( i = 0; i < Info.nVars; i++)
			{
				ri2 = ( (xi[i]*xi[i]) + (yi[i]*yi[i]) );
				sum_ri2 += ri2;	
				
			}
			
			//obliczanie Sigmy Sigmy 1/rij
			for (i = 0; i < Info.nVars-1; i++)
			{
							
				for (j = i+1; j < Info.nVars; j++)
				{
		
					rij = ( (xi[i]*xi[i] - 2.0*xi[i]*xi[j] + xi[j]*xi[j]) + (yi[i]*yi[i] - 2.0*yi[i]*yi[j] + yi[j]*yi[j]) );
										
					if (rij>= 0)
		            {
		                prij = sqrt(rij);
		            }
		           

		            if(prij != 0)
		            {
		                sum = 1.0/prij;

		            }
		            else
		            {

		                sum = 9999999999999.9;
		            }

		            sum2 += sum;	
				}	
			}
			
			//obliczanie   U = Sigma ri^2 + Sigma Sigma 1/rij		
			U = sum_ri2 + sum2; 
			
			Population.pfitness[mem][1] = U;
			Population.pfitness[mem][2] = U/Info.nVars;
			
			if ( U < Info.C)
			{
				Population.pfitness[mem][0] = Info.C - U;
			}
			else
			{
				Population.pfitness[mem][0] = 0.0;
			}
		}
	}
}
