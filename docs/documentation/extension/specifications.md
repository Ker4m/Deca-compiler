# Extension : TAB

## Spécifications

### Tableaux

- Déclarer un Tableau : _Must Have_

Voici les trois manières de déclarer un tableau :

```java
int[] array;
array = new int[taille];
```
```java
int[] array = new int[taille];
```
```java
int[] array = {0 , 1 , 2};
```

- Accès à un élément du tableau : _Must Have_

L'accès à un élément du tableau se fait un appelant son indice entre crochet,
c'est-à-dire, comme ceci :

```java
int element = array[indice];
```

- Méthodes natives sur les tableaux : _Must Have_

Il sera possible d'accéder à la longueur du tableau de cette manière :

```java
int longueur = array.length;
```

### Matrices

- Déclarer une matrice : _Must Have_

Voici les trois manières de déclarer une matrice :

```java
int[] matrix;
matrix = new int[longueur, largeur];
```
```java
int[] matrix = new int[longueur, largueur];
```
```java
int[] matrix = {{0 , 1 , 2}, {3, 4, 5}};
```

- Accès à un élément de la matrice : _Must Have_

L'accès à un élément du tableau se fait un appelant son indice entre crochet, ligne puis colonne,
c'est-à-dire, comme ceci :

```java
int element = matrix[ligne, colonne];
```

- Méthodes natives sur les matrices : _Must Have_

Il sera possible d'accéder à la taille de la matrice de cette manière :

```java
int longueur = matrix.length;
int largeur = matrix.width;
int taille = matrix.length;
```

### Calcul Matriciel

- Matrice identité : _Nice to Have_

Il sera possible de créer une matrice identité de cette manière :

```java
int[] matrix;
matrix = new int[longueur, largeur];
matrix.setIdentity();
```
```java
int[] matrix = new int[longueur, largueur];
matrix.setIdentity();
```

- Matrice nulle : _Nice to Have_

Il sera possible de créer une matrice identité de cette manière :

```java
int[] matrix;
matrix = new int[longueur, largeur];
matrix.setZero();
```
```java
int[] matrix = new int[longueur, largueur];
matrix.setZero();
```

- Somme de matrices : _Must Have_

Il sera possible de faire la somme terme à terme de matrices de cette façon :

```java
int[] matrixResult = matrix1.sum(matrix2); // À voir si on implémente M = M1 + M2
```

- Multiplication par une constante : _Must Have_

Il sera possible de multiplier une matrice par une constante de cette manière :

```java
int constant = 2;
int[] matrixResult = matrix.multConst(constant); // À voir si on implémente M = constant * M1
```

- Produit matriciel : _Must Have_

Il sera possible d'effectuer un produit matriciel comme ceci :

```java
int[] matrixResult = matrix1.matrixProd(matrix2); // À voir si on implémente M = M1 * M2
```

L'algorithme utilisé, afin d'avoir les meilleures performances possible, sera celui de
[Strassen](https://en.wikipedia.org/wiki/Strassen_algorithm).

- Transposée : _Should Have_

Il sera possible de calculer la transposée d'une matrice de cette façon :

```java
int[] matrixResult = matrix.transpose();
```

- Déterminant : _Nice to Have_

Il sera possible de calculer un déterminant comme ceci :

```java
float determinant = matrix.getDeterminant();
```

Pour calculer le déterminant rapidement, nous allons utilisé la
[décomposition LU](https://fr.wikipedia.org/wiki/D%C3%A9composition_LU), un des algorithmes les plus efficaces
pour faire cela. De plus, on pourra envisager de stocker les matrices L et U afin d'optimiser l'inversion.

- Inverse : _Nice to Have_

Il sera possible de calculer une matrice inverse comme ceci :

```java
float[] inverseMatrix = matrix.invert();
```

Tout comme le déterminant, nous calculerons l'inverse à partir de la
[décomposition LU](https://fr.wikipedia.org/wiki/D%C3%A9composition_LU) de la matrice.

- Valeurs propres : _Nice to Have_

Il sera possible de calculer les valeurs propres d'une matrice comme ceci :

```java
float[] eigenvalues = matrix.getEigenvalues();
```

Cette dernière spécification sera sans doute compliqué à mettre en place. Une piste pour les algorithmes à utilisés sont
[la méthode de Jacobi ou la méthode de Givens](https://www.math.univ-paris13.fr/~halpern/teaching/MACS1_2010/systemes.pdf).