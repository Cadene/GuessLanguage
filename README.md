GuessLanguage
=============

LI323 - Projet1 de statistique par Remi Cadene et Joel Fieux

-------

Readme du projet LI323_P2_CadeneFieux
http://github.com/Tamazy/GuessLanguage

-------

Ce projet Java sous Eclipse contient quatre dossiers :

- bin contient les fichiers compilés,

- src contient les fichiers sources,

- data contient les fichiers annexes donnés en début de projet et générés par notre programme,

- doc contient le sujet et les réponses aux questions.

-------

Afin de compiler et d'executer, deux possibilités :

- sous Eclipse :
  ouvrir Eclipse
  selectionner votre Workspace
  importer (File / Import...)
    selectionner "General / Existing Projects into Workspace", puis Next
    selectionner en root directory le dossier contenant notre dossier projet (ex: Téléchargements), puis Finish
  compiler et executer (Run)

-------

Caractéristiques d’entrées 
-Corpus : 
Non vide,
Tout en minuscules,
Sans lettres accentuées,
Sans signes de ponctuations,
	-Mots :
		Non vide,
		Tout en minuscules,
		Sans lettres accentuées,
		Sans signes de ponctuations,
Ne commence pas par un espace,
Ne fini pas par un espace.


Afin de déterminer la langue d’un mot, il faudra :
•	ajouter des corpus en format .txt dans le dossier corpus
•	créer le corpus général à l’aide de la classe static CorpusFactory
•	analyser le corpus général obtenu avec la méthode analyse()
•	utiliser la méthode guessLanguage(mot) qui retourne le nom du corpus associé
