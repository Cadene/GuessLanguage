package GuessLanguage;

public class NEqualLangStrategy implements IStrategyLang {

	public double probaLang(String language, String word, GeneralCorpus gc)
	{
		return gc.probaWord(word,language) * gc.probaLang(language);
	}
}
