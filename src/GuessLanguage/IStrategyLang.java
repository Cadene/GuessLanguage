package GuessLanguage;

public interface IStrategyLang {

	double probaLang(String language, String word, GeneralCorpus gc);

}
