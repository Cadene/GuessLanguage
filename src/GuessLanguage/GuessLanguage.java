package GuessLanguage;

import java.util.*;

public class GuessLanguage
{

    public static void main (String[] args)
    {
    	System.out.println("= = = Guess Language = = =");
    	System.out.println();

    	/* 1. Construction d'un modèle de langage */
    	
    	// Création d'un Corpus général & affichage
        List<String> languages = new ArrayList<String>();
        languages.add("french");
        languages.add("dutch");
        languages.add("english");
        languages.add("italian");
        GeneralCorpus gc = CorpusFactory.makeGeneralCorpus(languages);
        gc.analyse();
        System.out.println(gc.toString());
        
        // 1.2.
        System.out.println("p(statistics/anglais): " + gc.probaWord("statistics","english"));
        System.out.println("p(statistics): " + gc.probaWord("statistics") + "\n");
        
        //Cherchons des exemples pertinants
        
        /* 2. Prédiction de la langue d'un mot */
        
        // 2.6.
        System.out.println("fatta : " + gc.guessLanguage("fatta"));
        System.out.println("ora : " + gc.guessLanguage("ora"));
        System.out.println("che : " + gc.guessLanguage("che"));
        System.out.println("dota : " + gc.guessLanguage("dota"));
        System.out.println("volta : " + gc.guessLanguage("volta"));
        System.out.println("by : " + gc.guessLanguage("by"));
        System.out.println("other : " + gc.guessLanguage("other"));
        System.out.println("mean : " + gc.guessLanguage("mean"));
        System.out.println("statistics : " + gc.guessLanguage("statistics"));
        System.out.println("chocolate : " + gc.guessLanguage("chocolate"));
        System.out.println("president : " + gc.guessLanguage("president"));
        System.out.println("thanks : " + gc.guessLanguage("thanks"));
        System.out.println("patatoes : " + gc.guessLanguage("patatoes"));
        System.out.println("constitutionnellement : " + gc.guessLanguage("constitutionnellement"));
        System.out.println("peter : " + gc.guessLanguage("peter"));
        System.out.println("pomme : " + gc.guessLanguage("pomme"));
        System.out.println("daar : " + gc.guessLanguage("daar"));
        
        
        /*System.out.println("gc.probaMot(probability): " + gc.probaWord("probability") + "\n");

        System.out.println(gc.guessLanguage("statistics"));
        System.out.println(gc.guessLanguage("probability"));
        System.out.println(gc.guessLanguage("france"));
        System.out.println(gc.guessLanguage("baguette"));
        System.out.println(gc.guessLanguage("camembert") + "\n");
        */
        

    }

}
