clear
(set -x;decac)
read -n 1 -s -r -p " "
(set -x;decac -b)
read -n 1 -s -r -p " "
clear
(set -x;cat -n decompile.deca)
read -n 1 -s -r -p " "
(set -x;decac -p decompile.deca)
read -n 1 -s -r -p " "
clear
(set -x;cat -n lexer.deca)
(set -x;decac lexer.deca)
read -n 1 -s -r -p " "
clear
(set -x;cat -n parser.deca)
(set -x;decac parser.deca)
read -n 1 -s -r -p " "
(set -x;cat -n parser2.deca)
(set -x;decac parser2.deca)
read -n 1 -s -r -p " "
clear
(set -x;cat -n assembleur.deca)
(set -x;decac assembleur.deca)
(set -x;ima assembleur.ass)
(set -x;ima assembleur.ass)
read -n 1 -s -r -p " "
clear
(set -x;cat -n assembleur2.deca)
(set -x;decac assembleur2.deca)
(set -x;ima assembleur2.ass)
read -n 1 -s -r -p " "
clear
(set -x;cat -n heritage.deca)
read -n 1 -s -r -p " "
clear
(set -x;decac heritage.deca)
(set -x;cat heritage.ass)
read -n 1 -s -r -p " "
clear
(set -x;decac -c heritage.deca)
(set -x;cat heritage.ass)
read -n 1 -s -r -p " "
clear
(set -x;decac -c -n heritage.deca)
(set -x;cat heritage.ass)
read -n 1 -s -r -p " "