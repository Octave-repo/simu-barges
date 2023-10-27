# Projet Simulation de Barges

## Execution

- Ouvrir le projet avec un IDE (Intetlij / Eclipse)
- Executer la fonction main de la classe Main

## Ce qui fonctionne

- Lecture des demandes dans un fichier JSON
- Lecture des services dans un fichier JSON
- Traitement des demandes sous forme d'événement simple
- Les terminaux possèdent tous 10 conteneurs de base
- Possibilité de refus en cas de:

  - Aucun service ne permet de satisfaire la demande
  - La livraison ne peut pas être effectuée à temps

- Affichage des statistiques à la fin de la simulation
  
  - Quantité de demandes traitées
  - Quantité de demandes non traitées (par raison)
  - Nombres de conteneurs sur chaque terminal*

## Ce qui ne fonctionne pas / Ce que j'aurrais voulu ajouter

- Les chemins "composé", si on souhaite faire A->D mais le service propose uniquement A->B, B->D on ne pourra pas prendre ce service
- La vérification de la disponibilité des conteneurs. Pour le moment, on peut avoir une quantité négative de conteneur
 