package GuessLanguage;

import java.util.*;

public class GuessLanguage
{

    public static void main (String[] args)
    {
    	System.out.println("= = = Guess Language = = =");
    	System.out.println();

    	/* 1. Construction d'un modole de langage */
    	
    	// Creation d'un Corpus geral & affichage
    	Corpus tc = CorpusFactory.makeCorpus("test");
    	tc.analyse();
    	System.out.println(tc.toString());
    	
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
        
        /* 2. Prediction de la langue d'un mot */
        
        // 2.6.
        //17 /9v /8f
        HashMap<String,String> HMWords = new HashMap<String,String>();
        HMWords.put("fatta","italian");
        HMWords.put("ora","italian");
        HMWords.put("che","italian");
        HMWords.put("dato","italian");
        HMWords.put("volta","italian");
        HMWords.put("by","english");
        HMWords.put("other","english");
        HMWords.put("mean","english");
        HMWords.put("statistics","english");
        HMWords.put("chocolate","english");
        HMWords.put("president","english");
        HMWords.put("thanks","english");
        HMWords.put("potatoes","english");
        HMWords.put("constitutionnellement","french");
        HMWords.put("peter","english");
        HMWords.put("pomme","french");
        HMWords.put("daar","dutch");
        
        System.out.println("= Strategie Simple Lettre avec Corpus egaux=");
        System.out.println("Performance de la liste de mots = " + gc.calculPerf(HMWords));
        System.out.println();
        
        gc.setProbaLangStrategy(1);
        System.out.println("= Strategie Simple Lettre avec Corpus non egaux =");
        System.out.println("Performance de la liste de mots = " + gc.calculPerf(HMWords));
        System.out.println();
        
        
        // 3.1.1
        // Plus la taille du corpus est grande, plus le corpus est representatif de la langue
        
        // 3.1.2
        // 
        
        gc.setStrategy(new DoubleStrategy());
        gc.setProbaLangStrategy(0);
        System.out.println("= Strategie Double Lettre avec Corpus egaux =");
        System.out.println("Performance de la liste de mots = " + gc.calculPerf(HMWords));
        System.out.println();
        /*System.out.println("gc.probaMot(probability): " + gc.probaWord("probability") + "\n");

        System.out.println(gc.guessLanguage("statistics"));
        System.out.println(gc.guessLanguage("probability"));
        System.out.println(gc.guessLanguage("france"));
        System.out.println(gc.guessLanguage("baguette"));
        System.out.println(gc.guessLanguage("camembert") + "\n");
        */
        

    }

}
