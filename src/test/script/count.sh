#! /bin/sh

# Compte le nombre de fichier de test

cd "$(dirname "$0")"/../../.. || exit 1

cd src/test/deca 
count=$(find . -name *.deca  | wc -l)
echo "Nombre de fichiers : $count"

count_lines=$(find . -name *.deca | xargs cat | wc -l)
echo "Nombre de lignes de tests : $count_lines"