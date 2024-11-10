# Tema 0 - GwentStone Lite

## Desfasurarea jocului

### Initierea jocului
- Jucatorii aleg cate un deck, iar acesta este amestecat.
- Fiecare jucator primeste un erou reprezentativ.

### Desfasurarea unei runde
1. Fiecare jucator trage o carte din deck in mana.
2. Fiecare jucator primeste mana, care reprezinta valuta jocului.
3. Incepe tura unui jucator in care poate efectua actiunile dorite.
4. Jucatorul poate plasa pe masa carti care au mana necesara mai mica decat mana sa disponibila. Pe langa acest lucru, el poate face atacuri sau poate utiliza diverse abilitati.
5. Dupa ce fiecare jucator isi termina tura, runda se considera incheiata.

### Terminarea jocului
Jocul se termina atunci cand un erou ramane fara viata.

## Arhitectura

### **Card**
Aceasta clasa este abstracta si reprezinta un sablon pentru urmatoarele doua clase:
- **Hero**
- **Minion**

Atat **Hero**, cat si **Minion** sunt clase abstracte, care servesc drept sablon pentru fiecare carte in parte. Am ales aceasta abordare pentru a putea suprascrie metodele specifice fiecarei carti:
- **useAbility()** - foloseste abilitatea cartii respective (am evitat utilizarea unui "switch" mare, respectand principiile programarii orientate pe obiecte).
- **isFront()** - indica daca cartea se afla pe primul rand.
- **isTank()** - indica daca cartea este de tip "Tank" sau de tip numar.

### **Player**
Clasa **Player** contine toate informatiile relevante despre un jucator:
- Eroul jucatorului.
- Mana jucatorului.
- Cartile din mana.
- Deck-ul de carti.

### **GameController**
Clasa **GameController** se ocupa de crearea fiecarui joc.

### **Game**
Clasa **Game** reprezinta jocul in sine. Aici se initializeaza fiecare jucator.
Metode principale:
- **playing()**: Apeleaza functia **playRound()**, care reprezinta o runda jucata.
- **playRound()**: Apeleaza, pentru fiecare jucator, functia **playTurn()**, care se executa pana cand se primeste comanda "endPlayerTurn".
- Aceste functii continua sa ruleze pana cand un erou moare sau pana ce toate actiunile sunt finalizate. Daca un erou moare si mai sunt actiuni (pentru statistici sau debug), acestea vor fi executate.

### **GameTable**
**GameTable** este un singleton ce reprezinta masa de joc pe parcursul aplicatiei. Am ales sa o implementez astfel pentru a avea acces la ea in orice moment, fara a fi necesar sa o transmit ca parametru. Nu am vazut rostul sa adaug **GameTable** ca atribut al clasei **Game**, deoarece este evident ca exista o singura masa in joc.

### Manageri

- **CardManager**: Aici am folosit un **Simple Factory Pattern** pentru a obtine un Minion sau un Hero in functie de tipul cartii din input. Am intalnit implementari care folosesc un **HashMap** pentru a aplica **Factory Method Pattern**, ceea ce mi se pare o solutie mai eleganta, dar si mai complexa, deoarece implica crearea mai multor clase Factory pentru fiecare tip de carte. In cazul de fata, avand in vedere numarul redus de tipuri de carti, consider ca **Simple Factory** este suficient.
  
- **ErrorManager**: Clasa **ErrorManager** se ocupa de gestionarea posibilelor erori care pot aparea in timpul actiunilor. Am creat-o pentru a pastra codul modular si usor de intretinut.

### **CommandAction**
Aceasta este o interfata ce contine doar metoda **execute()**, care va fi suprascrisa de fiecare clasa care reprezinta o actiune specifica. Am ales sa folosesc **Command Pattern** deoarece mi se pare mai elegant decat sa creez un manager de actiuni cu un "switch" mare. Astfel, codul este mai clar si mai usor de extins, iar principiile fundamentale ale programarii orientate pe obiecte (SRP, OCP) sunt respectate.

### **ActionController**
Clasa **ActionController** gestioneaza actiunile, folosind designul descris mai sus. Am creat un **HashMap** in care am asociat fiecarei actiuni un nume (cheie) si o instanta a clasei ce o reprezinta. Astfel, pot executa usor actiunile dorite, iar adaugarea unor noi actiuni devine un proces simplu. In acest fel, respect principii fundamentale ale POO si asigur o codificare clara si modulara.

### **JsonOutManager** ##
Aceasta clasa se ocupa cu gestionarea ouput-ului. Am ales sa o fac singleton deoarece am vrut sa evit parsarea ca parametru in repetate functii, astfel eu am acces la acesta cand vreau.

In rest mai am cateva clase in pachetele **debug**, **error** si **dto**, care sunt utilizate pentru afisarea datelor in format JSON.

## Concluzie

Mi s-a parut o tema interesanta. Am refacut-o de mai multe ori, deoarece a fost destul de dificil sa trec de la o gandire procedurala la una orientata pe obiecte. Am incercat sa respect cat mai bine conceptele fundamentale si sper ca am reusit. Daca unele lucruri ce nu le-am respectat sau care pot fi imbunatatite, as aprecia daca mi le-ati putea specifica.
