#! /bin/sh

#Tente de compiler les .deca en .ass, echoue si .ass non genere
#Puis compare les .res (resultats attendus pour chaque fichier.deca) avec les resultats obtenus avec ima
#Echoue si les resultats sont differents
#De plus, si les resultats sont differents, les .ass ne sont pas supprimes mais gardes dans le repertoire
#./target/gencode-test-report/ass-error
#De meme pour les ouput dans ./target/gencode-test-report/ouput-error

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:./src/main/bin:../global/bin:"$PATH"

ASS_ERROR_DIR=./target/gencode-test-report/ass-error
OUPUT_ERROR_DIR=./target/gencode-test-report/output-error

#Si on ne veut pas voir les erreurs et ne pas quitter les tests dès le premier echec : --no-exit
DO_EXIT=$1

rm -r $ASS_ERROR_DIR 2>/dev/null
rm -r $OUPUT_ERROR_DIR 2>/dev/null

rm ./src/test/deca/codegen/*/*/*.ass 2>/dev/null

echo "\033[35m ***VALID TESTS*** \033"

for cas_de_test in ./src/test/deca/codegen/valid/*/*.deca
do
    var=$(decac "$cas_de_test" 2>&1)
    cas_de_res="${cas_de_test#*valid/}"

    if [ ! -f "${cas_de_test%.deca}".ass ];
    then
        echo "[\033[31mECHEC\033[0m] Fichier ${cas_de_res%.deca}.ass non généré."
        if ! [ "$DO_EXIT" = "--no-exit" ]
        then
          echo "$var"
          exit 1
        fi
    else
        echo "[\033[32mSUCCES\033[0m] Fichier ${cas_de_res%.deca}.ass a été généré."
        output=$(ima "${cas_de_test%.deca}.ass")
        expect_res=$(cat "${cas_de_test%.deca}.res")

        if [ "$expect_res" = "$output" ] || [ "$expect_res" = "$(echo "$output" | grep -o "$expect_res")" ];
        then
            echo "[\033[32mSUCCES\033[0m] Resultat correct."
            rm "${cas_de_test%.deca}.ass"
        else
            echo "[\033[31mECHEC\033[0m] Mauvais résultat ima"
            echo "$output" > "${cas_de_test%.deca}.output"
            mkdir -p $OUPUT_ERROR_DIR/"${cas_de_res%/*.deca}"
            mkdir -p $ASS_ERROR_DIR/"${cas_de_res%/*.deca}"
            mv "${cas_de_test%.deca}.output" $OUPUT_ERROR_DIR/"${cas_de_res%.deca}".output
            mv "${cas_de_test%.deca}.ass" $ASS_ERROR_DIR/"${cas_de_res%.deca}".ass
            if ! [ "$DO_EXIT" = "--no-exit" ]
            then
                echo "$var"
                exit 1
            fi
        fi
    fi
done

echo "\033[35m ***INVALID TESTS*** \033"

for cas_de_test in ./src/test/deca/codegen/invalid/compile/*.deca
do
    var=$(decac "$cas_de_test" 2>&1)

    if [ ! -f "${cas_de_test%.deca}".ass ];
    then
        echo "[\033[31mECHEC\033[0m] Fichier ${cas_de_test#*invalid/}.ass non généré."
        if ! [ "$DO_EXIT" = "--no-exit" ]
        then
          echo "$var"
          exit 1
        fi
    else
        cas_de_res="${cas_de_test#*invalid/}"
        echo "[\033[32mSUCCES\033[0m] Fichier ${cas_de_res%.deca}.ass a été généré."
        output=$(ima "${cas_de_test%.deca}.ass" 2>&1)

        if [ "$output" != "" ];
        then
            echo "[\033[32mSUCCES\033[0m] Une erreur est générée."
            echo "$output"
            rm "${cas_de_test%.deca}.ass"
        else
            echo "[\033[31mECHEC\033[0m] Mauvais résultat ima"
            echo "$output" > "${cas_de_test%.deca}.output"
            mkdir -p $OUPUT_ERROR_DIR/"${cas_de_res%/*.deca}"
            mkdir -p $ASS_ERROR_DIR/"${cas_de_res%/*.deca}"
            mv "${cas_de_test%.deca}.output" $OUPUT_ERROR_DIR/"${cas_de_res%.deca}".output
            mv "${cas_de_test%.deca}.ass" $ASS_ERROR_DIR/"${cas_de_res%.deca}".ass
            if ! [ "$DO_EXIT" = "--no-exit" ]
            then
                echo "$var"
                exit 1
            fi
        fi
    fi
done

for cas_de_test in ./src/test/deca/codegen/invalid/no-compile/*.deca
do
    var=$(decac "$cas_de_test" 2>&1)

    if [ ! -f "${cas_de_test%.deca}".ass ];
    then
        echo "[\033[32mSUCCES\033[0m] Fichier ${cas_de_test#*invalid/}.ass non généré."
        if ! [ "$DO_EXIT" = "--no-exit" ]
        then
          echo "$var"
          exit 1
        fi
    else
        cas_de_res="${cas_de_test#*invalid/}"
        echo "[\033[31mECHEC\033[0m] Fichier ${cas_de_res%.deca}.ass a été généré."
        output=$(ima "${cas_de_test%.deca}.ass" 2>&1)
    fi
done