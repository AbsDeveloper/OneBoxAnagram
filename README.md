# OneBoxAnagram

CONSTRUCCION

Para la gestion y construccion del proyecto se ha utilizado la herramienta Maven, para construirlo se puede invocar al goal "package" añadiendo el goal "clean" por delante en caso de ser necesario:

mvn clean package

El goal package ejecutara los test incluidos en el ejercicio.

Para ejecutarlo se puede realizar de varias formas:

Ejecutarlo desde la linea de comandos como por ejemplo:

java -jar target\onebox-anagram-0.0.1-SNAPSHOT.jar poema.txt

O bien, desde eclipse, Run --> Run Configurations --> Java Application y añadiendo los parametros de entrada

PARAMETROS DE ENTRADA

La aplicacion acepta un parametro de entrada:

1º Ruta del fichero del poema

Ejemplo Poema anagrama : java -jar target\onebox-anagram-0.0.1-SNAPSHOT.jar poema.txt
