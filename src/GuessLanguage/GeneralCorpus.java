package GuessLanguage;

import java.util.HashMap;

public class GeneralCorpus extends Corpus {
	
	HashMap<String, Corpus> HMCorpus;

	public GeneralCorpus (String name, HashMap<String, Corpus> HMCorpus)
	{
		super(name);
		this.HMCorpus = HMCorpus;
	}
	
	public void addCorpus(Corpus newCorpus)
	{
		this.HMCorpus.put(newCorpus.name, newCorpus);
	}
	
	public Corpus getCorpus(String name)
	{
		return HMCorpus.get(name);
	}
	
	public double probaWord(String word, String language)
	{
		return HMCorpus.get(language).probaWord(word);
	}
	
	public String guessLanguage(String word)
	{
		System.out.println("\nguessLanguage("+word+"):");
		double max = 0.0;
		String language = "ERROR: corpus length=0";
		double inter;
		for(String lang : HMCorpus.keySet())
		{
			inter = this.probaLang(lang,word);
			System.out.println(lang + " : " + inter);
			
			
			if(inter > max)
			{
				max = inter;
				language = lang;
			}
		}
		return language;
	}
	
	private double probaLang(String language, String word)
	{
		return probaWord(word,language);
	}
	
	public void analyseOccurences()
	{	
		this.nb_carac = 0.0;
		for(String mapKey : this.HMCorpus.keySet())
		{
			Corpus c = this.HMCorpus.get(mapKey);
			c.analyse(); //analyseFrequences
			for(int i=0; i<26; i++)
				this.occurences[i] += c.occurences[i];
			this.nb_carac += c.nb_carac;
		}
	}
	
	
	

}
