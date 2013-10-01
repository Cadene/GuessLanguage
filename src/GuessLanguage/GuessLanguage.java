package GuessLanguage;

import java.util.*;

public class GuessLanguage
{

    public static void main (String[] args)
    {
        List<String> languages = new ArrayList<String>();
        languages.add("french");
        languages.add("dutch");
        languages.add("english");
        languages.add("italian");
        GeneralCorpus gc = CorpusFactory.makeGeneralCorpus(languages);
        gc.analyse();
        System.out.println(gc.toString());
        
        Corpus en2 = gc.getCorpus("english");
        System.out.println(en2.toString());
        
        System.out.println("gc.probaMot(statistics,english): " + gc.probaWord("statistics","english"));
        System.out.println("gc.probaMot(statistics,french): " + gc.probaWord("statistics","french"));
        System.out.println("gc.probaMot(statistics,italian): " + gc.probaWord("statistics","italian"));
        System.out.println("gc.probaMot(statistics): " + gc.probaWord("statistics") + "\n");
        
        System.out.println("gc.probaMot(probability): " + gc.probaWord("probability") + "\n");

        System.out.println(gc.guessLanguage("statistics"));
        System.out.println(gc.guessLanguage("probability"));
        System.out.println(gc.guessLanguage("france"));
        System.out.println(gc.guessLanguage("baguette"));
        System.out.println(gc.guessLanguage("camembert") + "\n");

    }

}
