package GuessLanguage;

public class SimpleStrategy implements IStrategy {

	public double probaWord(String word, Corpus c)
	{
		double p = 1.0;
		for(int i=0; i<word.length(); i++)
		{
			p *= c.frequences[word.charAt(i)-'a'];
		}
		return p;
	}
}
