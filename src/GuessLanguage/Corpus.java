package GuessLanguage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Corpus {

	protected String name;
	protected int nb_carac;	
	protected int[] occurences;
	protected double[] frequences;
	protected String path = "./corpus/";
	protected int nb_words;
	
	public Corpus (String name)
	{
		this.name = name;
		
		this.occurences = new int[26];		
		for(int i=0; i<26; i++)
		{
			this.occurences[i]=0;
		}

		this.frequences = new double[26];
	}

	public void setPath(String newPath)
	{
		path = newPath;
	}
	
	public void analyse()
	{
		this.analyseOccurences();
		this.analyseFrequences();
	}
	
	/* Supposons qu'un Corpus possede au moins 1 mot et qu'il ne se fini pas par un espace */
	public void analyseOccurences()
	{	
		int c;
		this.nb_carac = 0;
		this.nb_words = 1;
		int buff = 0;
		try 
		{
			// calcul de nb_carac & des occurences
			BufferedReader br = new BufferedReader(new FileReader(this.path + this.name + ".txt"));
			while ((c = br.read()) != -1)
			{
				if(c >= 'a' && c <= 'z')
				{
					this.occurences[c - 'a']++;
					this.nb_carac++;
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
	
	public void analyseFrequences()
	{
		double nb_carac = (double)this.nb_carac;
		for(int i=0; i<26; i++)
		{
			this.frequences[i] = this.occurences[i] / nb_carac;
		}
	}
	
	public double probaWord(String word)
	{
		double p = 1.0;
		for(int i=0; i<word.length(); i++)
		{
			p *= this.frequences[word.charAt(i)-'a'];
		}
		return p;
	}
	
	public String toString()
	{
		String s = "=== Corpus ===\n";
		s += "name: " + this.name + "\n";
		s += "nb_carac: " + (int)this.nb_carac + "\n";
		s += "nb_words: " + this.nb_words + "\n";
		s += "occurences:\n";
		for(int i=0; i<26; i++)
		{
			s += "["+ (char)(i+97) +"] - " + this.occurences[i] + "\n";
		}
		s += "frequences:\n";
		for(int i=0; i<26; i++)
		{
			s += "["+ (char)(i+97) +"] - " + this.frequences[i] + "\n";
		}
	
		return s;
	}
	
	
}