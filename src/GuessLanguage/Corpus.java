package GuessLanguage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Corpus {

	protected String name;
	protected String subName;
	protected String path = "./corpus/";
	
	protected boolean isAnalysed = false;
	
	protected int nb_carac;
	protected int[] occurences;
	protected double[] frequences;
	protected int nb_words;
	protected int nb_double;
	protected HashMap<String, Integer> double_occurences;
	protected HashMap<String, Double> double_frequences;
	
	protected IStrategy strategy;
	
	public Corpus (String name)
	{
		this(name,name);
	}
	
	public Corpus (String subName, String name)
	{
		this.subName = subName;
		this.name = name;
		
		this.occurences = new int[26];		
		for(int i=0; i<26; i++)
		{
			this.occurences[i]=0;
		}

		this.frequences = new double[26];
		
		this.double_occurences = new HashMap<String, Integer>();
		this.double_frequences = new HashMap<String, Double>();
		
		this.strategy = new SimpleStrategy();
	}
	
	
	public double[] getFrequences(){
		return frequences;
	}
	public HashMap<String, Double> getDouble_frequences(){
		return double_frequences;
	}
	
	public void setPath(String newPath){
		path = newPath;
	}
	public void setStrategy(IStrategy newStrat){
		strategy = newStrat;
	}
	
	public void analyse()
	{
		this.analyseOccurences();
		this.analyseFrequences();
		this.isAnalysed = true;
	}
	
	/* Supposons qu'un Corpus possede au moins 1 mot et qu'il ne se fini pas par un espace */
	protected void analyseOccurences()
	{	
		int c;
		int buff = 0;
		
		this.nb_carac = 0;
		this.nb_words = 1;
		this.nb_double = 0;
		String double_lettre;
		Integer actual_integer;
		
		try 
		{
			// calcul de nb_carac & des occurences
			BufferedReader br = new BufferedReader(new FileReader(this.path + this.subName + ".txt"));
			while ((c = br.read()) != -1)
			{
				if(c >= 'a' && c <= 'z')
				{
					this.occurences[c - 'a']++;
					this.nb_carac++;
					
					
					if(buff != 0 && buff != ' ')
					{
						double_lettre = "" + (char)buff + (char)c;
						
						actual_integer = this.double_occurences.get(double_lettre);
						
						if(actual_integer == null){
							this.double_occurences.put(double_lettre, new Integer(1));
						}else{
							actual_integer++;
							this.double_occurences.put(double_lettre, actual_integer);
						}

						this.nb_double++;
					}
				}
				
				if(c == ' ')
				{
					if(this.nb_carac != 0)
					{
						if(buff != ' ')
							this.nb_words++;
					}
				}
				
				
				buff = c;
			}
			br.close();		
		}
		catch (FileNotFoundException exc)
		{
			System.out.println ("File not found");
		}
		catch (IOException ioe)
		{
			System.out.println ("Erreur IO");
		}
	}
	protected void analyseFrequences()
	{
		for(int i=0; i<26; i++)
		{
			this.frequences[i] = this.occurences[i] / (double) this.nb_carac;
		}
		for(String double_lettre : this.double_occurences.keySet())
		{
			this.double_frequences.put(double_lettre,
				this.double_occurences.get(double_lettre) / (double)this.nb_double);
		}
	}
	
	public double probaWord(String word){
		return this.strategy.probaWord(word, this);
	}
	
	public String toString()
	{
		String s = "=== Corpus ===\n";
		s += "name: " + this.name + "\n";
		s += "nb_carac: " + this.nb_carac + "\n";
		s += "nb_words: " + this.nb_words + "\n";
		s += "nb_double: " + this.nb_double + "\n";
		s += "occurences et frequences:\n";
		for(int i=0; i<26; i++)
		{
			s += "["+ (char)(i+97) +"]  : " + this.occurences[i] + "\t: " + this.frequences[i] + "\n";
		}
		s += "double_(occurences et frequences):\n";
		for(String double_lettre : this.double_occurences.keySet())
		{
			s += "[" + double_lettre + "] : " + this.double_occurences.get(double_lettre)
					+ "\t: " + this.double_frequences.get(double_lettre) + "\n";
		}
	
		return s;
	}
	
	
}