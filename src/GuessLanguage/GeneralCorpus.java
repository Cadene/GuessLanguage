package GuessLanguage;

import java.util.HashMap;

public class GeneralCorpus extends Corpus {
	
	HashMap<String, Corpus> HMCorpus;
	IStrategyLang probaLangStrategy = new EqualLangStrategy();

	public GeneralCorpus (String name, HashMap<String, Corpus> HMCorpus){
		super(name);
		this.HMCorpus = HMCorpus;
	}
	
	public Corpus getCorpus(String name){
		return HMCorpus.get(name);
	}
	
	public void setProbaLangStrategy(IStrategyLang strat){
		probaLangStrategy = strat;
	}
	public void setStrategy(IStrategy newStrat){
		for(String lang : HMCorpus.keySet()){
			HMCorpus.get(lang).setStrategy(newStrat);
		}
	}
	public void addCorpus(Corpus newCorpus){
		this.HMCorpus.put(newCorpus.name, newCorpus);
	}
	public void removeCorpus(String corpusName){
		this.HMCorpus.remove(corpusName);
	}
	
	public double probaWord(String word, String language)
	{
		return HMCorpus.get(language).probaWord(word);
	}
	
	public String guessLanguage(String word)
	{
		//System.out.println("\nguessLanguage("+word+"):");
		double max = 0.0;
		String language = "ERROR: corpus length=0";
		double inter;
		for(String lang : HMCorpus.keySet())
		{
			inter = this.probaLang(lang,word);
			//System.out.println(lang + " : " + inter);
			
			if(inter > max)
			{
				max = inter;
				language = lang;
			}
		}
		return language;
	}
	

	public double calculPerf(HashMap<String,String> HMWords)
	{
		return this.calculPerf(HMWords,false);
	}
	
	public double calculPerf(HashMap<String,String> HMWords, boolean printErrors)
	{
		int nbFalse=0;
		for(String word : HMWords.keySet())
		{
			if(!HMWords.get(word).equals(this.guessLanguage(word)))
			{
				if(printErrors)
					System.out.println("ERROR: " + word + " : " + this.guessLanguage(word) + " au lieu de " + HMWords.get(word));
				nbFalse++;	
			}
		}
		return 1 - nbFalse / (double)HMWords.size();
	}
	
	private double probaLang(String language, String word)
	{
		return probaLangStrategy.probaLang(language, word, this);
	}
	
	public double probaLang(String language)
	{
		return this.HMCorpus.get(language).nb_words / (double)this.nb_words;
	}
	
	protected void analyseOccurences()
	{	
		this.nb_carac = 0;
		this.nb_words = 0;
		this.nb_double = 0;
		Integer actual_occ;
		for(String mapKey : this.HMCorpus.keySet())
		{
			Corpus c = this.HMCorpus.get(mapKey);
			if(!c.isAnalysed)
				c.analyse(); //analyseFrequences
			for(int i=0; i<26; i++)
				this.occurences[i] += c.occurences[i];
			for(String double_lettre : c.double_occurences.keySet())
			{
				actual_occ = this.double_occurences.get(double_lettre);
				if(actual_occ == null)
					this.double_occurences.put(double_lettre, c.double_occurences.get(double_lettre));
				else
					this.double_occurences.put(double_lettre, c.double_occurences.get(double_lettre) + actual_occ);
			}
			this.nb_carac += c.nb_carac;
			this.nb_words += c.nb_words;
			this.nb_double += c.nb_double;
		}
	}
	
	
	

}
