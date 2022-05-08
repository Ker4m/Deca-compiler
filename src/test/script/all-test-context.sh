#! /bin/sh

#Script pour lancer les tests context
#FINAL

# On se place dans le répertoire du projet (quel que soit le
# répertoire d'où est lancé le script) :
cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"

#Si on ne veut pas voir les erreurs et ne pas quitter les tests dès le premier echec : --no-exit
DO_EXIT=$1

#Permet de choisir le repertoire de test pour context : 
#--print ou --def-affect ou --op-arith ou --fonction ou --logic ou --other
#Necessite un premier parametre avant : soit --no-exit comme specifie au dessus ou --exit (peu importe en realite)
PART=$2

#Pour le calcul de la couverture des tests
coverage=0
nbtest=0
valid=0

#Repertoires de test
dir_invalid=src/test/deca/context/invalid/
dir_valid=src/test/deca/context/valid/

test_context_valide () {
    nbtest=$(($nbtest+1))
    var=$(test_context "$1" 2>&1 )
    if test_context "$1" 2>&1 | grep -q -e "$1:[0-9][0-9]*:"
    then
        echo "[\033[31mECHEC\033[0m] Echec inattendu pour test_context sur $1."
        if ! [ "$DO_EXIT" = "--no-exit" ]
        then
          echo "$var"
          exit 1
        fi
    else
        echo "[\033[32mSUCCES\033[0m] Succès attendu de test_context sur $1."
        valid=$(($valid+1))
    fi
}

test_context_invalide () {
    nbtest=$(($nbtest+1))
    var=$(test_context "$1" 2>&1 )
    if test_context "$1" 2>&1 | grep -q -e "$1:[0-9][0-9]*:"
    then
        echo "[\033[32mSUCCES\033[0m] Échec attendu pour test_context sur $1."
        valid=$(($valid+1))
    else
        echo "[\033[31mECHEC\033[0m] Succès inattendu de test_context sur $1."
        if ! [ "$DO_EXIT" = "--no-exit" ]
        then
            echo "$var"
            exit 1
        fi
    fi
}

test () {
    for cas_de_test in "$dir_valid""$1"/*.deca
    do
        test_context_valide "$cas_de_test"
    done

    if [ "$1" != "logic" ];
    then
        for cas_de_test in "$dir_invalid""$1"/*.deca
        do
            test_context_invalide "$cas_de_test"
        done
    fi
}

print () {
    echo "\033[35m ***PRINT TESTS*** \033"

    test "print"
}

def_aff () {
    echo "\033[35m ***DEFINITION AND AFFECTATION TESTS*** \033"

    test "def_affect"
}

op_arith () {
    echo "\033[35m ***ARITHMETIC OPERATION TESTS*** \033"

    test "opArith"
}

logic () {
    echo "\033[35m ***LOGIC OPERATION TESTS*** \033"

    test "logic"
}

class () {
    echo "\033[35m ***CLASS TESTS*** \033"

    test "class"
}

fonction () {
    echo "\033[35m ***FONCTION TESTS*** \033"

    test "fonction"
}

extension () {
    echo "\033[35m ***TAB TESTS*** \033"

    test "extension"
}

other () {
    echo "\033[35m ***OTHER TESTS*** \033"

    test "autre"
}

if [ "$PART" = "--print" ]
then 
    print
else
    if [ "$PART" = "--def-aff" ]
    then
        def_aff
    else
        if [ "$PART" = "--op-arith" ]
        then
            op_arith
        else
            if [ "$PART" = "--logic" ]
            then
                logic
            else
                if [ "$PART" = "--class" ]
                then
                    class
                else
                    if [ "$PART" = "--fonction" ]
                    then
                        fonction
                    else
                        if [ "$PART" = "--tab" ]
                        then
                            extension
                        else
                            if [ "$PART" = "--other" ]
                            then
                                other
                            else
                                print
                                def_aff
                                op_arith
                                logic
                                class
                                fonction
                                extension
                                other
                            fi
                        fi
                    fi
                fi
            fi
        fi
    fi
fi

echo " "
coverage=$(echo "$valid/$nbtest" |bc -l)
coverage=$(echo "$coverage*100" |bc)
echo "Number of tests : $nbtest"
echo "Coverage : $coverage%"