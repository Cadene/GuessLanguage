package GuessLanguage;

public class EqualLangStrategy implements IStrategyLang{

	public double probaLang(String language, String word, GeneralCorpus gc)
	{
		return gc.probaWord(word,language);
	}

}
