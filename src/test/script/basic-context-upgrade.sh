#! /bin/sh

# Auteur : gl09
# Version initiale : 01/01/2022

# Test minimaliste de la vérification contextuelle.
# Le principe et les limitations sont les mêmes que pour basic-synt.sh
cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"

#Print et println

var=$(test_context src/test/deca/context/valid/provided/hello-world.deca 2>&1 )
if test_context src/test/deca/context/valid/provided/hello-world.deca 2>&1 | \
    grep -q -e 'hello-world.deca:[0-9]'
then
    echo "Echec inattendu pour test_context hello-world"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context hello-world"
fi

var=$(test_context src/test/deca/context/valid/provided/hello-world_basic.deca 2>&1)
if test_context src/test/deca/context/valid/provided/hello-world_basic.deca 2>&1 | \
    grep -q -e 'hello-world_basic.deca:[0-9]'
then
    echo "Echec inattendu pour test_context hello-world_basic"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context hello-world_basic"
fi

var=$(test_context src/test/deca/context/valid/provided/print-float.deca 2>&1)
if test_context src/test/deca/context/valid/provided/print-float.deca 2>&1 | \
    grep -q -e 'print-float.deca:[0-6]'
then
    echo "Echec inattendu pour test_context print-float"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context print-float"
fi

var=$(test_context src/test/deca/context/valid/provided/print-int.deca 2>&1)
if test_context src/test/deca/context/valid/provided/print-int.deca 2>&1 | \
    grep -q -e 'print-int.deca:[0-6]'
then
    echo "Echec inattendu pour test_context print-int"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context print-int"
fi

var=$(test_context src/test/deca/context/valid/provided/print-concat.deca 2>&1)
if test_context src/test/deca/context/valid/provided/print-concat.deca 2>&1 | \
    grep -q -e 'print-concat.deca:[0-7]'
then
    echo "Echec inattendu pour test_context print-concat"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context print-concat"
fi

var=$(test_context src/test/deca/context/valid/provided/print-concat-int.deca 2>&1)
if test_context src/test/deca/context/valid/provided/print-concat-int.deca 2>&1 | \
    grep -q -e 'print-concat-int.deca:[0-7]'
then
    echo "Echec inattendu pour test_context print-concat-int"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context print-concat-int"
fi

var=$(test_context src/test/deca/context/valid/provided/print-concat-float.deca 2>&1)
if test_context src/test/deca/context/valid/provided/print-concat-float.deca 2>&1 | \
    grep -q -e 'print-concat-float.deca:[0-7]'
then
    echo "Echec inattendu pour test_context print-concat-float"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context print-concat-float"
fi

var=$(test_context src/test/deca/context/invalid/provided/print-concat-incompatible.deca 2>&1)
if test_context src/test/deca/context/invalid/provided/print-concat-incompatible.deca 2>&1 | \
    grep -q -e 'print-concat-incompatible.deca:10:'
then
    echo "Echec attendu pour test_context print-concat-incompatible"
else
    echo "Succes inattendu de test_context print-concat-incompatible"
    echo "$var"
    exit 1
fi

#Definitions et affectations

var=$(test_context src/test/deca/context/valid/provided/double-def.deca 2>&1)
if test_context src/test/deca/context/valid/provided/double-def.deca 2>&1 | \
    grep -q -e 'double-def.deca:[0-6]'
then
    echo "Echec inattendu pour test_context double def"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context double def"
fi

#affectation types différents

var=$(test_context src/test/deca/context/invalid/provided/affect-incompatible.deca 2>&1)
if test_context src/test/deca/context/invalid/provided/affect-incompatible.deca 2>&1 | \
    grep -q -e 'affect-incompatible.deca:15:'
then
    echo "Echec attendu pour test_context affect-incompatible"
else
    echo "Succes inattendu de test_context affect-incompatible"
    echo "$var"
    exit 1
fi

#OpArith

var=$(test_context src/test/deca/context/valid/provided/plus.deca 2>&1)
if test_context src/test/deca/context/valid/provided/plus.deca 2>&1 | \
    grep -q -e 'plus.deca[0-7]'
then
    echo "Echec inattendu pour test_context plus"
    echo "$var"
    exit 1
else
    echo "Succes attendu de test_context Plus"
fi

