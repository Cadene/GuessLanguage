package GuessLanguage;

import java.util.*;

public class GuessLanguage
{

    public static void main (String[] args)
    {
    	System.out.println("= = = Guess Language = = =");
    	System.out.println();

    	/* 1. Construction d'un modole de langage */
    	
    	// Creation d'un Corpus general & affichage
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
        
        gc.setProbaLangStrategy(new EqualLangStrategy());
        System.out.println("= Strategie Simple Lettre avec Corpus egaux=");
        System.out.println("Performance de la liste de mots = " + gc.calculPerf(HMWords));
        System.out.println();
        
        gc.setProbaLangStrategy(new NEqualLangStrategy());
        System.out.println("= Strategie Simple Lettre avec Corpus non egaux =");
        System.out.println("Performance de la liste de mots = " + gc.calculPerf(HMWords));
        System.out.println();
        
        gc.setStrategy(new DoubleStrategy());
        gc.setProbaLangStrategy(new EqualLangStrategy());
        System.out.println("= Strategie Double Lettre avec Corpus egaux =");
        System.out.println("Performance de la liste de mots = " + gc.calculPerf(HMWords));
        System.out.println();
        
        gc.removeCorpus("french");
        gc.removeCorpus("english");
        gc.addCorpus(CorpusFactory.makeCorpus("frenchPlus","french"));
        gc.addCorpus(CorpusFactory.makeCorpus("englishPlus","english"));
        gc.analyse();
        
        gc.setProbaLangStrategy(new EqualLangStrategy());
        System.out.println("= Strategie Simple Lettre avec Corpus egaux=");
        System.out.println("Performance de la liste de mots = " + gc.calculPerf(HMWords));
        System.out.println();
        
        
        // 3.1.1
        // Plus la taille du corpus est grande, plus le corpus est representatif de la langue
        
        // 3.1.2
        // 
        
        
        
        
        

    }

}
