package GuessLanguage;

public class DoubleStrategy implements IStrategy {

	public double probaWord(String word, Corpus c)
	{
		if(word.length()==0)
			return 0.0;
		
		double p;
		Double rslt;
		String double_lettre;
		
		p = c.frequences[word.charAt(0)-'a'];
		
		if(word.length()==1)
			return p;
		
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
