# Gestion des risques de mise en production

## Actions à effectuer

- [ ] Vérifier que tous les documents sont présents
- [ ] Lancer une analyse du code
- [ ] Optimiser le code et résoudre les points de l'analyse
- [ ] Merge les branches de développement (_develop_ par exemple) sur _master_
- [ ] Vérifier que la branche _master_ soit à jour
- [ ] Récupérer les sources depuis _master_
- [ ] Vérifier que le projet compile
- [ ] Vérifier que tous les tests qui doivent passer passent
- [ ] Vérifier que common-test.sh passe
- [ ] Faire un mvn clean

## Description des actions à effectuer

### Vérifier que tous les documents sont présents

Il faut reprendre la liste des documents demander pour le rendu et regarder un par un s'ils sont bien tous présents.

### Lancer une analyse du code

On lancera une analyse de code grâce à un IDE, par exemple sur IntelliJ.

### Optimiser le code et résoudre les points de l'analyse

On se servira du rapport de l'analyse de code pour optimiser le code et résoudre les possibles warnings.

### Merge les branches de développement (_develop_ par exemple) sur _master_

On vérifiera d'avoir merge toutes les branches de développement.

### Vérifier que la branche _master_ soit à jour

On regardera si la branche _master_ a bien reçu toutes les modifications nécessaires au rendu.

### Récupérer les sources depuis _master_

On récupèrera les sources dans un nouveau répertoire afin de s'assurer d'avoir exactement ce qui va être rendu.

### Vérifier que le projet compile

On s'assurera que ce qu'on rend compile bien.

### Vérifier que tous les tests qui doivent passer passent

On lancera tous les tests par un _mvn verify_ et on vérifiera que tous les tests qui sont censés passer passent.

### Vérifier que common-test.sh passe

On s'assurera que common-test.sh passe bien.

### Faire un mvn clean

On lancera cette commande pour nettoyer le projet.