package GuessLanguage;

public class DoubleStrategy implements IStrategy {

	public double probaWord(String word, Corpus c)
	{
		double p = 1.0;
		Double rslt;
		String double_lettre;
		for(int i=0; i<word.length()-1; i++)
		{
			double_lettre = "" + word.charAt(i) + word.charAt(i+1);
			//System.out.println(word + " : " + double_lettre);
			rslt = c.double_frequences.get(double_lettre);
			if(rslt == null){
				return 0;
			}
			p *= rslt.doubleValue(); 
		}
		return p;
	}
}
