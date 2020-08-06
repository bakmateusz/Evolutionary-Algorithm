package com.mteuszbak.algorythm;


public class Info 
{
	public static int maxPop = 10000000;		//liczba pokolen
	public static int popSize = 300;			//liczebnosc populacji
	public static int nVars = 9;				//liczba czastek
	public static int C = 500;					//wspolczynnik C
	
	public static double pXover = 0.7;			//prawdopodobienstwo krzyzowania
	public static double pMut = 0.35;			//prawdopodobienstwo mutacji
	
	public static double low = -3.0;			//dolne ograniczenie
	public static double high = 3.0;			//gorne ograniczenie

	public static int generetion;				//numer pokolenia
	
	public static double[][] best = new double[nVars][3];		//najlepszy osobnik

}
