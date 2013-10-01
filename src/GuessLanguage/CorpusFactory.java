package GuessLanguage;

import java.util.HashMap;
import java.util.List;

public class CorpusFactory {
	
	public static Corpus makeCorpus(String name)
	{
		return new Corpus(name);
	}
	
	public static GeneralCorpus makeGeneralCorpus(List<String> languages)
	{
		HashMap<String, Corpus> HMCorpus = new HashMap<String, Corpus>();
		String name = "GeneralCorpus from ";
		for(String lang : languages)
		{
			HMCorpus.put(lang, new Corpus(lang));
			name += "." + lang;
		}
		name+= ".";
		return new GeneralCorpus(name,HMCorpus);
	}

}
