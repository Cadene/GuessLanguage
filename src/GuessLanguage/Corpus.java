package GuessLanguage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Corpus extends AbstractCorpus {

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

	public void analyseOccurences()
	{	
		int c;
		this.nb_carac = 0.0;
		try 
		{
			// calcul de nb_carac & des occurences
			BufferedReader br = new BufferedReader(new FileReader(this.path + this.name + ".txt"));
			while ((c = br.read()) != -1)
			{
				if(c >= 'a' && c <='z')
				{
					this.occurences[c - 'a']++;
					this.nb_carac++;
				}
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
}