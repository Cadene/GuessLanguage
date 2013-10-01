package GuessLanguage;

public abstract class AbstractCorpus {

	protected String name;
	protected double nb_carac;	
	protected int[] occurences;
	protected double[] frequences;
	protected String path = "./corpus/";
	
	public abstract void analyseOccurences();
	
	public void analyse()
	{
		this.analyseOccurences();
		this.analyseFrequences();
	}
	
	public void analyseFrequences()
	{
		for(int i=0; i<26; i++)
		{
			this.frequences[i] = this.occurences[i] / this.nb_carac;
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
