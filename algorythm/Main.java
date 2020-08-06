package com.mteuszbak.algorythm;

import static java.lang.Math.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main
{
	public static double[] bestfitness = new double[3];
	public static double[] r = new double[Info.nVars];
	
	public static void main (String[] args) throws FileNotFoundException
	{
		bestfitness[0] = 0;
		bestfitness[1] = 0;
		int generation = Info.generetion = 0 ;
		double pr;
		int i;
		
		PrintWriter save = new PrintWriter("wyniki_beta"+Info.nVars+".txt");
		
		System.out.println("Program is starting!!!");		
		
		//tworzenie populacji
		System.out.println("Initialize population...");
		Population.population();
		
		//ocena populacji poczatkowej
		System.out.println("Evaluation...");
		Evaluation.evaluation();
		
		//wybor najlepszego osobnika
		Best.best();
		
		//petla
		System.out.println("Loop...");
		while (generation < Info.maxPop)
		{
			generation++;
			
			System.out.println("Generacja: "+generation+"  -  U/N = "+bestfitness[2]);
			
			Select.select();				//selekcja turniejowa
			Crossover.crossover();			//krzyzowanie usredniajace
			Mutation.mutation();			//mutacja
			Verify.verify();				//sprawdzenie czy czasteczki znajduja sie w przedziale
			Evaluation.evaluation();		//ocena populacji
			Elitist.elitist();				//zapisanie najlepszego czlonka populacji
			Best.best();					//zapisanie najlepszego rozwiazania
		}
			
		
		//wypisywanie parametrow do pliku txt
		save.println("Konfiguracja podstawowa dla " + Info.nVars + " ladunkow, przy czym q1 = q2 = 1");
		save.println();
		save.println();
		save.println("Parametry algorytmu genetycznego:");
		save.println("Liczebnosc populacji : " + Info.popSize);
		save.println("Liczba iteracji algorytmu (liczba pokolen) : " + Info.maxPop);
		save.println("Prawdopodobienstwo krzyzowania : " + Info.pXover);
		save.println("Prawdopodobienstwo mutacji : " + Info.pMut);
		save.println("Przedział : " + "( " + Info.low + ", " + Info.high + " )");
		save.println("Wspolczynnik C, ktory jest zalezny od funkcji : " + Info.C);
		save.println();
		save.println();
		save.println("Najlepsza konfiguracja :");
		save.println();
		
		//wypisanie x
		save.print("x:");
		save.println();
		for ( i = 0; i < Info.nVars; i++)
		{
			save.println(Info.best[i][0]);
		}
		
		//wypisanie y
		save.println();
		save.print("y:");
		save.println();
		
		for ( i = 0; i < Info.nVars; i++)
		{
			save.println(Info.best[i][1]);
		}
		
		//wypisanie promienia
		save.println();
		save.println("Promień: ");
		save.println();
		for ( i = 0; i < Info.nVars; i++)
		{
			pr = (Info.best[i][0]*Info.best[i][0])+ (Info.best[i][1]*Info.best[i][1]);
			r[i] = sqrt(pr);
			
			save.println(i + ". " + r[i]);
		}
		
		//wypisanie U oraz wypisanie U/N
		save.println();
		save.println();
		save.println("Najlepsze rozwiazanie (U) = "+ bestfitness[1]);
		save.println();
		save.println("Najlepsze rozwiazanie na 1 czasteczke (U) = "+ bestfitness[2]);
		System.out.println("End");
	
		save.close();
	}
}
	



