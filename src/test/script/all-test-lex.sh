#! /bin/sh

# Test minimaliste du lexer.
# On lance test_lex sur un fichier valide, et les tests invalides.

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"

DO_EXIT=$1

coverage=0
nbtest=0
valid=0

test_lex_invalide () {
    nbtest=$(($nbtest+1))
    var=$(test_lex "$1" 2>&1 )
    if test_lex "$1" 2>&1 | grep -q -e "$1:[0-9][0-9]*:"
    then
        echo "[\033[32mSUCCES\033[0m] Echec attendu pour test_lex sur $1."
        valid=$(($valid+1))
    else
        echo "[\033[31mECHEC\033[0m] Succes inattendu de test_lex sur $1."
        if ! [ "$DO_EXIT" = "--no-exit" ]
        then
          echo "$var"
          exit 1
        fi
    fi
}

test_lex_valide () {
    nbtest=$(($nbtest+1))
    var=$(test_lex "$1" 2>&1 )
    if test_lex "$1" 2>&1 | grep -q -e "$1:[0-9][0-9]*:"
    then
        echo "[\033[31mECHEC\033[0m] Echec inattendu pour test_lex sur $1."
        if ! [ "$DO_EXIT" = "--no-exit" ]
        then
          echo "$var"
          exit 1
        fi
    else
        echo "[\033[32mSUCCES\033[0m] Succes attendu de test_lex sur $1."
        valid=$(($valid+1))
    fi
}  

for cas_de_test in src/test/deca/syntax/invalid/lexer/*.deca
do
    test_lex_invalide "$cas_de_test"
done

for cas_de_test in src/test/deca/syntax/valid/lexer/*.deca
do
    test_lex_valide "$cas_de_test"
done

# for cas_de_test in src/test/deca/context/invalid/*/*.deca
# do
#     test_lex_invalide "$cas_de_test"
# done

# for cas_de_test in src/test/deca/context/valid/*/*.deca
# do
#     test_lex_valide "$cas_de_test"
# done

echo " "
coverage=$(echo "$valid/$nbtest" |bc -l)
coverage=$(echo "$coverage*100" |bc)
echo "Number of tests : $nbtest"
echo "Coverage : $coverage%"