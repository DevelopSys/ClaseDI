
## <a name="indice"></a>

1. Bases del lenguaje

	2. [Use strict](#id1)
	3. [Variables](#variables)
	4. [Operadores](#operadores)
	5. [Comparadores](#comparadores)
	6. [Sentencias de control y bucles](#bucles)
	7.  [Librerías comunes](#librerías)
	7. [Prompt y alert](#usuario)
	8. [Arrays](#arrays)
	9. [Funciones](#funciones)
	10. [Objetos](#objetos)


## Uso de use strict<a name="variables"></a>

EL modo estricto es un "filtro" que js permite crear códigos más seguros y sin errores ya que no deja pasar ningún elemento que no cumpla con todas las normas de programación. Su uso no es necesario pero si es bastante recomendable ya que permite hacer un código de calidad. Para poder activarlo simplemente hay que poner al inicio del código 'use strict'

Las principales características del modo estricto son:

- no se pueden declarar variables ya declaradas
- no se puede utilizar un objeto que aún no está declarado
- no se permite borrar una variable que se usa durante el código
- no se permite duplicar el nombre de parámetros dentro de una función
- no se permite nombrar variables con palabras reservadas del lenguaje

## Uso de variables<a name="variables"></a>

Para declarar variables se utilizan las palabras reservadas const, let y var, seguido de su nombre y su valor (si lo tienen)

````
var variable = "Hola";
````

Los tipos de variables que podemos encontrar en JS son:

- string: letras que van entre comilla simple o doble. 
- boolean: valores true o false. 
- number: números sin identificar el tipo concreto 
- null: sin valor asignado
- undefined: aquellas variables que se han declarado pero nunca se les ha dado un valor

````
var palabra = "hola";
var numero = 5;
var numeroDos = 3.14;
var verdadero = true;
var sinValor = null;
Var sinDefinir;
````

Las variables tienen un tipado dinámico

````
<script type="text/javascript">
        var variable = "Hola";
        console.log(variable);
        console.log(typeof(variable));
        variable = 2;
        console.log(variable);
        console.log(typeof(variable));
</script>
````

Al igual que en cualquier lenguaje de programación se pueden realizar cambios de tipos entre las variables. Para ello se utilizan los métodos parseInt, parseFloat, etc....

````
        var numero1 = 24;
        var numero2 = 31.5;
        var suma = numero1 + numero2;
        console.log("la suma es " + suma); // la salida sería 55.5
        console.log("la suma es " + parseInt(suma));   // la salida sería 5
        var sumaDos = numero1.toString() + numero2.toString();
        console.log("la suma es " + sumaDos); // la salida sería 2431.5
````

Si no se indica nada, JS intenta realizar la mejora traducción posible entre todos los elementos. De esta forma la siguiente entrada obtendría la siguiente salida:

````
console.log(5 + 5);
// salida 10
console.log(5 + "7");
// salida 57
console.log(5 + 5 + "7");
// salida 107
````


Adicionalmente al uso de las variables primitivas, existen las variables de datos complejos. Al igual que se vio en Java existen tipos complejos que nos ofrecen la posibilidad de acceder a métodos. Estas variables son String, Number, Boolean. Al igual que en java para poder crear tipos complejos se utiliza la palabra reservada new

````
var fraseCompleja = new String("Ejemplo de frase compleja");
console.log(fraseCompleja.toUpperCase());
console.log(typeof(fraseCompleja));
var fraseNormal = "Ejemplo de frase normal"
console.log(fraseNormal.toUpperCase());
console.log(typeof(fraseNormal));
````

La salida de esto será 

````
EJEMPLO DE FRASE COMPLEJA
object
EJEMPLO DE FRASE NORMAL
string
````

Al igual que el uso del operador typeof es interesante ya que indica el tipo concreto de la variable, en ocasiones el uso de la función isNaN() puede resultar útil también. En este caso, la función indica si un argumento pasado es número o no (cuidado con la salida porque es la negación)

Cuando se utilizan variables en JS se pueden utilizar las siguiente palabra reservadas: 

- let: es utilizado para un ámbito de bloque
- var: es utilizado para un ámbito del archivo entero
- const: es utilizado cuando se quieren crear constantes

Para entender esto vamos a ejecutar un ejemplo


````
        var variable = "Valor inicial"
        console.log(variable);
        if (true) {
            variable = "Valor cambiado en el bloque ";
            console.log(variable);
        }
        variable = "Valor cambiado fuera del bloque";
        console.log(variable);
````

La salida sería la siguiente

````
Valor inicial
Valor cambiado en el bloque 
Valor cambiado en el bloque 
Valor cambiado fuera del bloque
````

Con estos valores de salida se puede observar que el valor de la variable siempre es accesible y modificable desde cualquier punto del archivo, por lo que su ámbito es más genérico.

Sin embargo si utilizamos variables declaradas con let, su ámbito es más reducido

````
        var variable = "Valor con var";
        if (true) {
            let variable = "Valor con let";
            console.log(variable);

        }
        console.log(variable);
````
La salida sería la siguiente:
````
Valor con let
Valor con var
````

Se puede ver como aunque sea el mismo nombre de variable, como están declaradas con un ámbito diferente, son llamadas de forma diferente.
De todas formas el uso diferenciado entre let y var ya no está muy diferenciado.

Siempre que utilicemos una variable var va a poder ser accesible desde cualquier parte del script, y podremos utilizar la palabra reservada this. Sin embargo cuando se utilice una variable con let, esta tan solo existirá en el ámbito en la que ha sido creada.        

### Formato de salida

Normalmente la forma en la que será la salida es mediante asociación a elementos del DOM de la web a la que el script se asocia. Pero también es posible sacar datos por consola como se ha visto mediante el método console.log().

````
console.log('en el caso de querer saltos de linea \n se utilizan carácteres especiales');
````

Dentro de este método como parámetros se puede pasar un objeto, un String, un Number , una variable o concatenaciones de todas las posibilidades. Para concatenar se utiliza el carácter + de la siguiente forma

````
console.log('Mi nombre es ' + 'Borja' + ' y tengo ' + 18 + ' años');
````

En este ejemplo la salida por consola mostrara el mensaje indicado, habiendo concatenado dos cadenas de texto con un número mediante +. De la misma forma se podría hacer concatenando variables que tienen un valor definido

````
var nombre = "Borja";
var edad = 18;
console.log('Mi nombre es ' + nombre + ' y tengo ' + edad + ' años');
````

Por último existe la posibilidad de representar el contenido de la variable directamente sin necesidad de concatenar. Para ello se utiliza las comillas tumbadas en vez de las comillas simples, y se llama a la variable de la siguiente forma: ${variable}

````
var nombre = "Borja";
var edad = 18;
console.log(`Mi nombre es ${nombre} y tengo ${edad} años`);
````

En el caso de utilizar el **template string** también podemos utilizar cualquier expresión código de JS que queramos

````
let nombre = "Borja";
let edad = 17;
let mayor;
console.log(
  `Mi nombre es ${nombre} y tengo una edad de ${edad}, ${
    mayor ? edad > 18 : edad < 18
  }`
);
````


Adicionalmente se pueden utiliza caracteres especiales para indicar saltos de linea, tabulaciones, etc...

- \t : Tabulador
- \' : Comillas Simples 
- \" : Comillas Dobles 
- \n : Salto de línea

De la misma forma también se puede formatearse una salida de datos, utilizando los siguientes elementos:

- %s:  Cadena 
- %d o %i:  Número entero 
- %f: Decimal
- %o:  DOM
- %O:  Objeto js
- %c: CSS

````
console.log('%c Mi nombre es %s y tengo %d años', 'background: #3EBDFF;', nombre, edad, );
````
En este caso aparecería un texto por consola con el fondo de color azul. Es importante tener en cuenta que el formato de css debería aparecer en la primera posición.

Otros métodos interesantes de consola:

- assert(): aparece un mensaje de error en la consola si la afirmación es falsa.

````
console.assert(0 > 8);
// falso por lo que la salida por consola existe: Assertion failed: console.assert
var palabra = "Alumno";
var letra = "A";
console.assert(palabra.includes(letra));
// verdadero, por lo que no hay salida por consola

````

- clear(): limpia la consola
- group(): junta mensajes por consola
- groupCollapsed() junta mensajes por consola minimizados
- time(): inicia un contador en ms
- timeEnd(): para el contador iniciado con el método anterior y muestra el tiempo empleado
````
console.time("Tiempo");
for (let index = 0; index < 300; index++) {
    console.log("elemento");
}
console.log('El tiempo empleado para realizar la tarea ha sido de: ')
console.timeEnd("Tiempo");
````


- info(), warm(), error(), log(): realizan tareas muy similares con la diferencia que se muestran con estilos diferentes

[Volver al inicio](#indice)

## Operadores<a name="operadores"></a>

- Asignación

````
var x=1;
var y=2;
x=y;
console.log(`El valor de x es ${x}`, x);
````

- +=Suma
````
var x=1;
var y=2;
x+=y;//es lo mismo que poner x=x+y
console.log(`El valor de x es ${x}`, x);
````

- -=Resta
````
var x=1;
var y=2;
var resta = x-y
console.log(`El valor de la resta es ${resta}`);
````

- suma / resta ternaria

````
var x = 5;
var y = 6;
x++;
x++;
y--;
y--;
console.log(`Los nuevos valores de las variables son x: ${x} e y: ${y}`);
````

- *=Multiplicación 
````
var x=1;
var y=2;
var multiplicacion = x*y;
console.log(`El valor de la multiplicación x es ${multiplicación}`);
````

- /=División
````
var x=1;
var y=2;
var division = x/y; 
console.log(`El valor de dividir ${x} entre ${y} es ${division}`);
````

- %=Módulo
````
var x=4;
var y=2;
var modulo = x%y;
console.log(`El módulo de dividir ${x} entre ${y} es ${modulo}`);
````

[Volver al inicio](#indice)


## Comparadores<a name="comparadores"></a>

En cuanto a comparadores existen los tradicionales que se han visto durante el curso de programación:

````
var mayorQue = 100 > 10;
var menorQue = 10 < 100;
var mayorIgual = 100 >= 10;
var menorIgual = 10 <= 100;
varigual= 10==10;
var noIgual = 100 != 10;
````

Pero se incluyen los operadores que además de comprobar el valor de los elementos también comprueban su tipología. Por ejemplo:

````
// la variable tomaría un valor verdadero
var igualQue = 100 == 100
// de la misma forma retornaría verdadero, ya que el valor guardado es el mismo
var igualQueSinTipo = 100 == '100'
// en este caso retorna un valor de falso ya que el tipo de los datos no coinciden
var igualPeroDiferente = 100 === '100'
````

En un principio puede parecer que no es muy útil, sin embargo para hacer comparación de tipos resulta altamente valido

### Relaciones lógicas

Existen los mismos elementos que en cualquier lenguaje de programación: AND y OR
- AND: retornará verdadero cuando todas las sentencias que se están evaluando sean verdaderas. En el momento que una de las sentencias sea falsa el resultado será falso.

- OR: retornaría verdadero cuando al menos una de las sentencias que se están evaluando sean verdaderas. En el momento que una de las condiciones sea verdadera se asegura que el resultado es verdadero.

````
var ex1 = true && true; // true
var ex2=(2==2)&&(3>=6);//false
var ex3=(2>3)||(17<=40); //true
var ex4 = false || false; // false
````

## Operadores de objeto

- . : utilizado cuando se quiere acceder a una característica o método declarado en el objeto.

````
let fechaAhora = new Date();
console.log(fechaAhora);

let fechaPasada = new Date(
  fechaAhora.getFullYear() - 10,
  fechaAhora.getMonth(),
  fechaAhora.getDate()
);
console.log(fechaPasada);

````

- [] : utilizado para el acceso a arrays o elementos dentro de un objeto

````
numeros = [1, 2, 3, 4, 5, 6];
console.log(numeros[0]);
````


[Volver al inicio](#indice)

## Sentencias de control y bucles<a name="sentencias"></a>

### if
Sentencia de control que evalúa una serie de condiciones. En el caso de encontrar una condición verdadera ejecuta el cuerpo del su bloque correspondiente

````
        var nota = 5;
        if (nota < 5) {
            console.log("El alumno ha suspendido");

        } else {
            console.log("El alumno ha aprobado");
        }
````

Su forma de trabajar es idéntica a la vista en java, pudiendo tener tantas sentencias else if como sean necesarias.

````
        var nota = 11;
        if (nota < 5) {
            console.log("El alumno ha suspendido");

        } else if (nota < 10) {
            if (nota < 6) {
                console.log('aprobado raspado');

            } else if (nota < 8) {
                console.log('aprobado con buena nota');

            } else if (nota < 10) {
                console.log('aprobado con muy buena nota');
            } else {
                console.log('perfecto');

            }
        } else {
            console.log('algo no me cuadra');

        }
````

### if ternario

Se trata de un if con una sintaxis especial que es la siguiente:
````
condicion ? valor_si_es_verdadera : valor_si_es_falsa 
````

Un ejemplo sería el siguiente:

````
        var decision = true;
        decision ? console.log("la decición ha sido verdadera") : console.log("la decición ha sido falsa");
````

Al igual que en todos los casos anteriores se puede concatenar con cualquiera de los elementos vistos:

````
        var nombre = prompt('Por favor introduce tu nombre');
        nombre.length > 5 ? alert("tu nombre es demasiado largo") : alert("tu nombre es cumple con los requisitos de longitud")
````


### switch

Mismo uso y sintaxis que java

````
      var casoEvaluar = 4;
      switch (key) {
        case 1:
          console.log("Ejecución por el caso 1");

          break;
        case 2:
          console.log("Ejecución por el caso 2");
          break;
        case 3:
          console.log("Ejecución por el caso 3");
          break;
        case 4:
          console.log("Ejecución por el caso 4");
          break;

        default:
          console.log("Ejecución no contemplada");
          break;
      }
````

### while

Mismo uso y sintaxis que java

````
        var numero = 10;
        while (numero > 0) {
            alert(`El número es demasiado grande aún, su valor es de ${numero}`);
            numero--;
        }
````


### do-while

Muy similar al anterior con la diferencia que nos aseguramos a que al menos existe una ejecución

````
        numeroWhile = 10;
        do {
            console.log(numeroWhile);
            numeroWhile--;
        } while (numeroWhile >= 0);
````

Con los operadores time() y timeEnd() se puede comprobar cual es el tiempo que se tarda en ejecutar un bucle

### for

Sintaxis inicial identica a java

````
        for (let index = 0; index < 10; index++) {
            console.log(index);
        }
````

Adicionalmente también se cuenta con un bucle foreach que se utiliza para recorrer arrays. Esta forma de aplicar el foreach conlleva la creación de lo que se conoce como funci´

````
        console.log('recorrido con foreach');

        elementos = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
        elementos.forEach(element => {
            console.log(element);

        });
````

También se cuanta con la posibilidad de aplicar un forIn y un forOf

[Volver al inicio](#indice)

## Librerías comunes<a name="librerías"></a>

### Date
Para poder trabajar con Fechas, se utiliza la librería Date.js. Para ello el punto de partida inicial es la creción de un objeto de tipo Date 
````
Date fecha = new Date()
````
Esta creación asigna a la variable la fecha del sistema

````
        fecha = new Date();
        console.log(fecha);
        // salida: Wed May 13 2020 18:48:36 GMT+0200 (hora de verano de Europa central)
````

Del mismo modo, se pueden crear fechas de un momento concreto pasando parámetros por constructor

````
var newYear = new Date(2020, 1, 1); // AAAA, MM, DD
var newYear = new Date(2020, 1, 1, 0, 0, 0); // AAAA, MM, DD, HH, MM, SS
````

Esta objeto fecha tiene métodos interesantes: 

- Getters

Que nos devuelven información concreta de aquello que le pidamos. Entre lo que podemos encontrar

````
      var ahora = new Date();
      console.log("Con UTC: ");
      console.log("==== FECHA ====");
      console.log("El año: " + ahora.getUTCFullYear());
      console.log("El mes: " + ahora.getUTCMonth());
      console.log("El día de la semana: " + ahora.getUTCDay()); // 0 - 6 (D - S)
      console.log("El día del mes: " + ahora.getUTCDate()); // 1-31
      console.log("==== HORA ====");
      console.log("Horas: " + ahora.getUTCHours());
      console.log("Minutos: " + ahora.getUTCMinutes());
      console.log("Segundos: " + ahora.getUTCSeconds());
      console.log("milisegundos: " + ahora.getUTCMilliseconds());
````

- Setters

Que nos permiten ajustar información concreta. 

````
        fechaNueva = new Date();
        fechaNueva.setMonth(-1);
        console.log(`${fechaNueva.getUTCDay()} \ ${fechaNueva.getMonth()} \ ${fechaNueva.getUTCFullYear()}`);
````


- toString()

Al igual que en cualquier objeto de programación, la llamada al método toString() pasa a String el contenido del objeto. Adicionalmente, se pueden construir cadenas de fecha con un formato concreto, siguiendo las normas del standard ISO 8601

````
        fechaString = new Date();
        console.log(fechaString.toUTCString()); // 		Sat, 16 May 2020 09:40:06 GMT
        console.log(fechaString.toISOString()); // 		2020-05-16T09:40:06.268Z
````

### String

- .toLowerCase() // .toUpperCase(): Devuelve una cadena de texto en minúscula o mayúscula respectivamente

````
      cadena = "Texto para Pasar a mayúsculas";
      console.log(cadena.toUpperCase());
      cadena = "TEXTO PARA PASAR A MINÚCULA";
      console.log(cadena.toLowerCase());
````


- .length: indica la cantidad de elementos que tiene una cadena. Se trata de una propiedad, por lo que no es necesario utilizar los paréntesis

````
        cadena = "Ejemplo de cadena de texto";
        console.log(`La cadena de texto tiene una longitud de ${cadena.length}`);
````


- .charAt(): Devuelve el carácter específico de la posición dada. 

````
        cadena = "Texto para Pasar a mayúsculas";
        console.log('La letra de la posicion 0 es ' + cadena.charAt(0));
````

¿Cómo se podrían sacar todas la letras de una cadena?

- .charCodeAt(): Devuelve el código ASCII del carácter específico situado en la posición dada.

        cadena = "Sacar códigos asci de letras";
        console.log(`El código de la letra ${cadena.charAt(0)} es ${cadena.charCodeAt(0)}`);

¿Cómo se podrían sacar el código ASCII de todas la letras de una cadena?

- .concat(): Anexa una cadena de texto a otra

````
        cadena = "Primera parte de la cadena completa ";
        cadena2 = "segunda parte de la cadena completa";
        cadena = cadena.concat(cadena2, " tercera parte", "\n", " cuarta parte");
        console.log(cadena);
````

- .indexOf(): Devuelve la posición de un carácter o palabra dada

````
        cadena = "Buscar la posición de una letra";
        letra = 'a';
        console.log(`la posición de la letra ${letra} es ${cadena.indexOf(letra)}`);
````

¿Como se puede hacer para personalizar el mensaje en caso de que la letra no está presente en la cadena?

- .link(): Crea un link. Es utilizado para modificaciones de DOM. Lo utilizaremos más adelante

- .trim(): Elimina espacios vacíos

````
        cadena = "     Frase con espacios      "
        cadena = cadena.trim();
        console.log(cadena);
````


- .substr(): Devuelve la cadena de texto situada entre dos posiciones dadas

````
        cadena = "Sacar partes de la cadena";
        console.log(cadena.substr(0, 5));
````


- .split(): Devuelve el array de elemento separados por el carácter indicado

````
        cadena = "Esto es una frase que tiene unas cuantas palabras"
        palabras = cadena.split(' ');
        console.log(`El número de palabras que tiene la cadena de texto metida es ${palabras.length} `);
````

[Volver al inicio](#indice)

## Prompt y alert<a name="usuario"></a>

Para poder interactura con el usuario mediante consola, se utilizan los siguientes métodos:

- Window.alert(): muestra una ventana por consola

````
alert("El proceso se ha terminado");
````

- Window.confirm(): pide confirmación al usuario dando la opción de aceptar o cancelar. Para poder tratar la respuesta se debe guardar en una variable la salida de la función confirm.

````
var confirmacion = confirm("¿estás seguro que quieres terminar el proceso?");
if (confirmacion){
	alert("El proceso se ha terminado");
}
````

- Window.prompt(): pide un dato al usuario mediante una ventana emergente. De la misma forma que en el caso anterior, se deberá guarda la salida en una variable para poder tratarla más adelante

````
var nombreIntroducido = prompt("por favor introduce tu nombre");
````

En el caso de querer tratar la variable se realizaría de una forma normal

````
        var nombreIntroducido = prompt("por favor introduce tu nombre");
        var respuesta = confirm(`¿Estás seguro que quieres evaluar el nombre ${nombreIntroducido}?`);
        if (respuesta) {
            tieneAes = nombreIntroducido.toLowerCase().includes('a')
            if (tieneAes) {
                alert('El nombre introducido tiene alguna a')
            } else {
                alert('El nombre introducido no tiene ninguna a')
            }
        } else {
            alert('Proceso terminado');
        }
````

[Volver al inicio](#indice)

## Arrays<a name="arrays"></a>

Para poder crear un array se puede realizar dándole un conjunto vacío de elementos, como un conjunto de elementos ya declarados o como un objeto compleja donde se le indica la longitud que tendrá

````
       var coleccion= [];
       var coleccionConDatos = [1,2,3,4,5,6,7,8,9];
       var coleccionCompleja = new Array(10);
````

Dentro de un array se puede guardar cualquier tipo de dato, incluso mezclando los tipos. Como en JS el tipado es dinámico no es necesario identificar el tipo del array.

````
	var arrayNumeros = [1, 2, 3, 4];
	var arrayPalabras = ["Hola", "que", "tal", "estas"]
	var arrayCosas = [1, "hola", 2, "que", false];
````

Para poder acceder a las posiciones de un array se utiliza el índice, teniendo en cuenta que siempre se empieza por 0

````
        arrayNumeros = [1, 2, 3, 4];
        console.log(arrayNumeros[0]); // retornará el valor 1
        console.log(arrayNumeros[2]); // retornará el valor 2
````

Para poder modificar el valor de las posiciones se utiliza el indice y el operador de igualdad
````
        arrayNumeros = [1, 2, 3, 4];
        arrayNumeros[0] = 5; // cambia el valor de 1 por el 5
        arrayNumeros[2] = 6; // cambia el valor de 3 por el 4
````

Dentro de las propiedades del array nos encontramos con una clave que nos servirá para multitud de operaciones:

- .length(): indica la cantidad de elementos que tiene el array

````
        arrayNumeros = [1, 2, 3, 4];
        console.log(`El array tiene ${arrayNumeros.length}`);
````

Con esta longitud se puede recorrer el array de forma completa con un bucle for, iterando en cada una de las posiciones

````
        console.log("Recorrer con un for");
        for (let index = 0; index < arrayNumeros.length; index++) {
            const element = arrayNumeros[index];
            console.log(element);

        }
````

Adicionalmente existe una forma más sencilla de recorrer mediante un foreach. Esta estructura aplica una función de flecha

````
        console.log("Recorrer con un foreach");
        arrayNumeros.forEach(element => {
            console.log(element);
        });
````

Dentro del foreach, cada vez que se hace una iteración el elemento llamado element toma el valor del ítem en cuestión, pudiendo hacer con el lo que se necesite

Del mismo modo se podría buscar un elemento dentro de un array, tanto con el for como con el foreach

````
        arrayNombres = ["Borja", "Luis", "Jesus", "Roberto", "Manuel", "Victor"];
        for (let index = 0; index < arrayNombres.length; index++) {
            const element = arrayNombres[index];
            if (element === "Luis") {
                console.log('Elemento encontrado');
            }

        }

		// ó
		
        arrayNombres.forEach(element => {
            if (element === 'Luis'){
                console.log('Elemento encontrado');
            }
        });
````

Los métodos que se pueden aplicar a un array son:

- .sort(): ordena alfabéticamente o numéricamente el contenido del array
````
        arrayNombres = ["Borja", "Luis", "Jesus", "Roberto", "Manuel", "Victor"];
        console.log("Array sin ordenar");
        arrayNombres.forEach(element => {
            console.log(element);

        });

        arrayNombres.sort();
        console.log("Array ordenado");
        arrayNombres.forEach(element => {
            console.log(element);

        });
````

- .reverse(): invierte el orden del array
````
        arrayNombres = ["Borja", "Luis", "Jesus", "Roberto", "Manuel", "Victor"];
        console.log("Array normal");
        arrayNombres.forEach(element => {
            console.log(element);

        });

        arrayNombres.reverse();
        console.log("Array invertido");
        arrayNombres.forEach(element => {
            console.log(element);

        });
````

- .join(): junta todos los elementos del array en una sola cadena 
- .concat(): retorna dos arrays juntos

````
        arrayUno = [1, 2, 3, 4];
        arrayDos = [5, 6, 7, 8];
        arrayJuntar = arrayUno.concat(arrayDos);
        console.log(arrayJuntar.toString());
````

- .indexOf(): indica la posición de un elemento dado

````
        arrayUno = [1, 2, 3, 4];
        posicionNumero = arrayUno.indexOf(1);
        if (arrayUno.indexOf(1) >= 0) {
            console.log(`El índice del elemento 1 es ${posicionNumero}`);
        } else {
            console.log('El elemento no está presente');

        }
````

- .push(): añade elementos al final del array
- .unShift(): añade elementos al final del array
- .pop(): elimina el último elemento
- .shift() elimina el primer elemento

````
        arrayElementos = [1, 2, 3];
        console.log('El array tienen una longitud de %d', arrayElementos.length);
        arrayElementos.push(4, 4, 5);
        console.log('El array tienen una longitud de %d', arrayElementos.length);
        arrayElementos.unshift(0);
        console.log('El array tienen una longitud de %d', arrayElementos.length);
        arrayElementos.pop();
        console.log('El array tienen una longitud de %d', arrayElementos.length);
        arrayElementos.shift()
        console.log('El array tienen una longitud de %d', arrayElementos.length);
        arrayElementos.splice(4);
        console.log('El array tienen una longitud de %d', arrayElementos.length);
````

[Volver al inicio](#indice)

## Funciones<a name="funciones"></a>

Las funciones son todos aquellos métodos que se quieren ejecutar en determinadas partes de una aplicación web, pudiendo ser llamadas en cualquier momento lo que favorece la reutilización.

La estructura básica de una función es la siguiente: 

````
        function name(params) {
            
        }
````

Del mismo modo una función también se puede asociar a una variable de la siguiente forma.

````
	    var miFuncion = function name(params) {
            
        }
````

Así cuando la variable sea llamada se ejecutaría en contenido de la función. Para poder ejecutar una función de cualquiera de las maneras basta con llamarla, bien a la función directamente o a la variable

````
        function funcionInicial() {
            console.log('Llamada la funcion inicial');
        }
        
        var variableFuncion = function() {
            console.log("Llamada la variable que ejecuta la función");
        };
        
        funcionInicial();
        variableFuncion();

````

Como en todo lenguaje de programación, las funciones van acompañadas tanto de argumentos como de retornos. Es importante tener en cuenta que los argumentos pueden ser datos simples, objetos o incluso funciones En ambos casos, cuando estamos hablando de JS no es necesario tiparlos  por el dinamismo que se vio al principio del curso. Los usos que se dan de los argumentos y las formas de retorno son las siguientes:

- Uso normal

````
        function suma(operando1, operando2) {
            var suma = operando1 + operando2;
            console.log(`La suma de los dos parámetos pasados a la función es de: ${suma}`);
        }

        suma(2, 5);
````

Se pueden pasar tantos parámetros como sean necesarios. En el caso de pasar más valores por argumento que los declarados en la función no da error

````
        function suma(operando1, operando2) {
            var suma = operando1 + operando2;
            console.log(`La suma de los dos parámetos pasados a la función es de: ${suma}`);
        }

        suma(2, 5, 5);
````

En el caso de pasar menos de los indicados pasa exactamente lo mismo, dando valores undefined a aquellos parámetros que no sean pasados, obteniendo como valor NaN (Not - a - Number)

````
        function suma(operando1, operando2) {
            var suma = operando1 + operando2;
            console.log(`La suma de los dos parámetos pasados a la función es de: ${suma}`);
            console.log(`La suma de ${operando1} y ${operando2} es de: ${suma}`);
        }
        suma(2);
        suma(2, 6)
        suma(2, 3, 7)
````

- Parámetros opcionales

Se puede indicar a las funciones que algunos parámetros de la función (en concreto los últimos) sea opcionales. Para ellos se pueden utilizar dos formas:

A) Utilizando el operador OR || 
````
        function parametorsOpcionales(parametroUno, parametroDos) {
            parametroDos = parametroDos || "valor por defecto";
            console.log(`Los parámetos pasados por funcion son ${parametroUno} y ${parametroDos}`);
        }

        parametorsOpcionales(1);
        parametorsOpcionales(1, "ejemplo");
````

B) Utilizando un if

````
        function sumaOptativa(a, b) {
            if (typeof b === 'undefined') {
                b = 0;
            }
            var suma = a + b;
            console.log(`La suma de ${a} y ${b} es de: ${suma}`);
        }
        sumaOptativa(1, 5);
        sumaOptativa(5);
````

C) De forma directa

````
function funcionDefecto(obligatorio, defecto = "defecto") {
  console.log(`${obligatorio} ${defecto}`);
}
````


- Uso de arguments o argumentos invisibles

En muchas ocasiones no es necesario pasar argumentos por una función, o no saber cuantos son necesarios. Para ello JS ofrece la posibilidad de utilizar el array arguments, ya incluido en todas las funciones. Con este array se puede acceder a los argumentos "adicionales" pasados en la llamada a la función. 

````
        function argumentosInvisibles() {
            console.log('La función ha sido llamada con ' + arguments.length + 'y son los siguientes');
            for (let index = 0; index < arguments.length; index++) {
                const element = arguments[index];
                console.log(element);
            }
        }

        argumentosInvisibles(1, "llamada", false, 3.14);
````

Este uso solo funciona para funciones con construcción normal. En el caso de querer utilizar lo mismo con una función de flecha se trendrían que utilizar el parámetro de array

````

````


- Valores de retorno

Cuando el llamamiento de una función requiere ademas de ejecutar todo su contenido, la devolución de algún valor se utiliza la palabra reservada return:

````
        function argumentosInvisibles() {
            console.log('La función ha sido llamada con ' + arguments.length + 'y son los siguientes');
            for (let index = 0; index < arguments.length; index++) {
                const element = arguments[index];
                console.log(element);
            }
        }

        argumentosInvisibles(1, "llamada", false, 3.14);

````


Cuidado porque los valores de retorno no solo tienen por que ser números, letras o boleados, sino que también pueden ser funciones, como se verá en el siguiente punto. Una cosa importante es que sobre una función no pueden existir tipos de retorno diferentes

- Funciones anónimas 

En JS no es necesario declarar nombre a la funcione, ya que se pueden declarar directamente, o bien retornarlas en otra función. 

````
        var funcionAnonima = function(parametro) {
            console.log(`El parámetro de la función anónima es ${parametro}`);
        }

        funcionAnonima('Hola');
````

Ó 

````
        function retornaFuncion() {
            return function () {
                console.log('Rotoranada una función anónima');
            }
        }
        retornaFuncion();
````

### Callbacks

Un callback no es un elemento propio del lenguaje, sino que se trata de una técnica de programación que permite la animación de funciones una vez estas han terminado de realizar una tarea. Imaginad el elemento de un proceso que tiene dos subprocesos, donde el segundo solo se puede ejecutar una vez haya terminado el primero. En programación esto se consigue utilizando la palabra return junto con la llamada a una función

````
        function primeraFuncion() {
            console.log("Este es el primer subproceso");
            return segundaFuncion();
        }

        function segundaFuncion() {
            console.log("Este es el segundo subproceso");
            console.log('Tarea terminada');

        }
        primeraFuncion();
````

Incluso es posible pasar funciones como parámetros, favoreciendo el flujo interno de la ejecución.

### Ejecuciones asíncronas

Hasta ahora todo el código qué se ejecutaba de una manera secuencial. Cada línea de código se ejecuta después de la anterior. Este estilo de programación en muchos casos puede ser poco productiva, y más hablando de un desarrollo web.

La asincronía es una caracteristica propia de ciertos métodos que permiten su ejecución en un segundo plano, de forma que resulta imposible saber cuándo terminará. Además antes de terminar su ejecución se ejecutan la siguiente línea de código, por lo que se pueden ejecutar más de una tarea al mismo tiempo Para poder controlar estas ejecuciones asíncronas, existen muchas técnicas, entre las cuales se encuentra la ejecución de Callbacks o la ejecución por eventos (como introdujimos en el desarrollo de la librería swing de java). Para los primeros ejemplos voy a utilizar la función de JS setTimeout() la cual recibe por parámetros la función a ejecutar y el tiempo que transcurre hasta que empieza. Por defecto esta función setTimeout ya es asíncrona()

````
        function primeraAsincrona() {
            setTimeout(function() {
                console.log('ejecucion realizada');
            }, 1000);
        }
        console.log('Llamada a la función asíncrona');
        primeraAsincrona();
        console.log('Llamada de cualquier cosa');
````

La salida sería 

````
Llamada a la función asíncrona
Llamada de cualquier cosa
ejecucion realizada
````


Como se puede ver en la salida, el orden es inverso a la llamada de las funciones ya que primero aparece en la consola en mensaje "Llamada de cualquier cosa" pese a ser llamado después que la función primeraAsincrona(). Esto se debe al trabajo asíncrono, ya que dicha función trabaja en segundo plano, realizando todas las tareas necesarias y esperando el número indicado en la función setTimeout().

Imaginad el supuesto que se quieren representar datos traídos de una base de datos. Para ello lo primero que se necesita es conectar con la base de datos, traerlos, y representarlos. Siempre en ese orden. Pero además se necesite que el sistema continue trabajando por detrás. Para ello todos los pasos que conlleva el pintado de los datos tendrá que ser asíncrono, es decir trabajado en segundo plano

````
        function traerDatos(callback) {
            setTimeout(function() {
                console.log('Durante esta ejecución se han traido una serie de datos');
                var dato = 'datos traidos';
                callback(dato);
            }, 2000);
        }

        function pintarDatos(param) {
            console.log('Durante la ejecución de esta función los datos son puntados: ' + param);
        }

        traerDatos(pintarDatos);
````

En este ejemplo se puede ver que la función traerDatos tiene como parámetro una función de callback, que es utilizada una vez se haya terminado una determinada ejecución. Es importante ver que cuando se llama como parámetro a una función no es necesario poner los paréntesis.

[Volver al inicio](#indice)

## Objetos<a name="objetos"></a>

Al igual que en cualquier lenguaje de programación orientado a objetos, se pueden crear dichos objetos para poder "almacenar dentro" una serie de características y acciones asociadas al mismo. Para ello existen dos formas de crear objetos. La primera es mediante el uso de la palabra reservada new

````
var palabra = new String("ejemplo de objeto");
````

Pero también existe la posibilidad de declararlo en una notación json (javascript object notation). Esta notación no es más que una relación par clave - valor, donde se pueden identificar tantas características como se quiera. Para poder declarar un objeto con esta notación se utiliza los caracteres {} donde en su interior se definen los elementos:

````
var nombre = {nombrePropiedad: "valor",nombreOtraPropiedad: "valor"}
````

Un ejemplo sería

````
var objetoCreado = {nombre:"Borja",apellido:"Martín", edad: 18, carnet: true };
````

En este caso se crea un objeto que tiene las propiedades nombre, apellido, edad y carnet, donde cada una de las propiedades tiene un tipo de dato asociado. Una vez creado el objeto para poder acceder a sus propiedades se llama al nombre de la propiedad

````
<script type="text/javascript">
        var objetoCreado = {
            nombre: "Borja",
            apellido: "Martín",
            edad: 18,
            carnet: true
        };
        console.log(objetoCreado.nombre);
</script>
````

Del mismo modo se pueden declarar métodos para darle funcionalidad al objeto utilizando la palabra reservada function. Se realiza de la misma forma:

````
    <script type="text/javascript">
        var objetoCreado = {
            nombre: "Borja",
            apellido: "Martín",
            edad: 18,
            carnet: true,
            mostrarDatos: function() {
                console.log(this.nombre, this.apellido, this.edad, this.carnet);
            },
        };
        console.log(objetoCreado.nombre);
        console.log(objetoCreado.mostrarDatos());
</script>
````

En este ejemplo se crea una función llamada mostrarDatos que imprime por consola todos los datos del objeto en cuestión. Es importante ver el uso de la palabra reservada this.

Adicionalmente se pude utiliza el acceso por posición para ver el contenido de la propiedad. La forma de realizarlo sería de la siguiente forma

````
console.log(objetoCreado['nombre']);
````

Al igual que se ha creado el objeto con una cantidad determinada de propiedades y métodos, también es posible crear o eliminar la propiedad de forma dinámica. Para crear la propiedad basta con llamarla e igualarla un valor 

````
let objeto = {
  nombre: "Borja",
  apellido: "Martin",
  edad: 18,
  mostraDatos: () => {
    console.log(objeto.nombre);
  },
};

objeto.nuevaEdad = 20;
````

Para poder eliminarla no basta con igualar la propiedad a null, ya que eso eliminaría el contenido de la propiedad. Para poder eliminar una propiedad hay que utilizar la palabra reservada delete

````
let objeto = {
  nombre: "Borja",
  apellido: "Martin",
  edad: 18,
  mostraDatos: () => {
    console.log(objeto.nombre);
  },  
  nuevaEdad: 20,
};

console.log(objeto);
delete objeto.edad;
console.log(objeto);
````

Otra de las posibilidades que existen a la hora de trabajar con un objeto es la conversión del objeto a formato Array, guardando todos los datos en clave-valor. Para poder hacer esto se ejecuta el método object.entries

````
console.log(Object.entries(objeto));
let parClaveValor = Object.entries(objeto);
parClaveValor.forEach((element) => {
  console.log(element[0]);
});
````

Algunas otras opciones del objeto son freeze, getOwnProperties, values 

### Relación objeto funciones

Como ya se ha visto antes en la parte de la declaración de funciones, estas pueden tener muchas formas tanto en parámetros como en retornos, y adicionalmente tienen una forma de comportarse especial cuando se trata de objetos. Alguna de estas formas son las siguientes

Cuando se quiere crear un objeto desde una función lo primero que se nos puede ocurrir es el siguiente código:

````
function crearObjeto(param1, param2) {
  return { nombre: param1, apellido: param2 };
}

let objeto = crearObjeto("Borja", "Martin");
console.log(objeto);

````

Sin embargo esto no es del todo necesario siempre que se indique un parámetro que sea el nombre de la propiedad

````
"use strict";

function crearObjeto(nombre, apellido) {
  return { nombre, apellido };
}
let objeto = crearObjeto("Borja", "Martin");
console.log(objeto);

````

Otra de las funciones que se permiten en la relación objeto - funciones es la de desectructurar un objetos. En el siguiente ejemplo se crea un método que saca determinadas propiedades

````
function sacarPropiedades({ nombre, fundacion, estadio }) {
  console.log(nombre);
  console.log(fundacion);
  console.log(estadio);
}
````

Es importante darse cuenta que los parámetros que se le pasan no son normales, sino que son en formato objeto (por los {}). A continuación, si se quiere llamar al método, solo tendremos que pasarle un objeto que tenga las propiedades indicadas como parámetros

````
let equipo = { nombre: "Barcelona", fundacion: 1890, estadio: "CampNou" };
sacarPropiedades(equipo);
````

En el caso de intentar llamarlo normal y corriente:

````
sacarPropiedades("Barcelona", 123, "Camp Nou");

````

Daría un error de tipo undefined

````
undefined
undefined
undefined
````



[Volver al inicio](#indice)

## <a name="index"></a>

3. Trabajo con DOM, BOM y eventos

	1. [Acceso al dom y modificaciones](#dom)
	2. [Configuración de eventos: en linea y listener](#eventos)
	3. [Timers: introducción a la asincronía](#timers)
	4. [Acceso al bom y trabajo el navegador ](#bom)
	5. [Almacenamiento en navegador](#web)

Una de las características que hacer muy potente el uso de JS es su alta disponibilidad a la hora de realizar tareas dinámicas. Para ello existen diferentes elementos que se pueden modificar y/o acceder en tiempo real: 

- DOM: Document Object Model, es una interfaz para HTML, CSS y SVG que nos facilita una representación en forma de árbol sobre la que podremos trabajar con JavaScript.
- BOM: Browser Object Model, que contiene información de todos los elementos propios del navegador y/o dispositivos donde se ejecutan como por ejemplo: versión de navegador, tamaños de pantalla, historial 

## Acceso al DOM y modificaciones<a name="dom"></a>

Se trata del modelo utilizado por el navegador para poder renderizar la página. Se puede asemejar a todo el código HTML escrito en cualquier editor que es interpretado y ejecutado por el propio navegador. Una de las capacidades más interesantes de JS es el acceso a este modelo y la posibilidad de su modificación de forma dinámica a tiempo real. En concreto, no solo es capaz de modificar, añadir o borrar los elementos del DOM, sino también agregar / modificar atributos, elementos CSS, así como reaccionar ante cualquier evento producido en la página

Como se ha dicho cuando hablamos de DOM, estamos hablando de todos los elementos presentes dentro del código de la página. Estos elementos reciben el nombre de nodos y se pueden clasificar en:

- Nodos de tipo elemento: aquellos que corresponden a una etiqueta HTML como p, h1, div, a, ul, form, etc..
- Nodos de tipo atributo: aquellos que hacen referencia a los atributos de los nodo elemento expuestos anteriormente. Por ejemplo un atributo href de un elemento a
- Nodos de tipo texto: el contenido textual de un nodo
- Nodos de tipo Document: la página completa
- Nodo de tipo comentario: los comentarios de la página


Imaginad el body de una página con la siguiente estructura
````
<body>

    <h1>Titulo de JS impartido por Borja Martín</h1>
    <p>Titulo correspondiente al segundo curso de DAW del instituto CES Juan Pablo segundo de Formación profesional</p>
    <div id="mi_div"></div>
    <script>
    </script>
</body>
````

En este caso se renderizaría un título y un párrafo, quedando un div vacío. Este div vacío cuenta con un id, mediante la cual puede ser accedido el elemento desde el código js, de forma que se pueda poner cualquier cosa en su interior mediante programación. Si en el script asociado se utiliza el método getElementById() se puede acceder al elemento HTML con dicho id

````
    <script>
        'use strict'
        let elementoDiv = document.getElementById('mi_div');
        console.log(elementoDiv);
    </script>
````

La salida por consola sería la propia etiqueta. Una vez capturada se puede por ejemplo acceder al código HTML incrustado en la etiqueta mediante la propiedad innerHTML o modificarlo igualando aun valor concreto.

Al igual que se puede modificar y/o acceder al contenido de la etiqueta encontrada, también se pueden hacer accesos y modificaciones de estilos, atributos, etc...Por ejemplo si se quiere cambiar el style de la etiqueta a uno que se haya creado en CSS sería tan sencillo como crear el estilo en css y aplicárselo a la etiqueta encontrada

````
.estilo_js {
    background-color: burlywood;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    font-size: large;
}
````

Y el código HTML 

````
    </div>
    <script>
        "use strict";
        let elementoDiv = document.getElementById("mi_div");
        console.log(elementoDiv);
        console.log(elementoDiv.innerHTML);
        elementoDiv.innerHTML = "<ul><li>elemento uno</li></ul>";
        elementoDiv.className = "estilo_js";
    </script>
````

De igual forma se puede hacer más dinámico aun si nos creamos por ejemplo una función que pueda ser llamada desde cualquier elemento mediante un evento (que se verán más adelante) o simplemente desde la consola. Para ello en el código js se crea una función que reciba como parámetro un color y lo aplique en los estilos

````
    <script>
        "use strict";

        function cambiarColor(color) {
            elementoDiv.style.backgroundColor = color;
        }

        let elementoDiv = document.getElementById("mi_div");

    </script>
````

Esta función puede ser llamada desde la consola o desde la pulsación de un elemento por ejemplo. 

````
    <script>
        'use strict'
        let elementoDiv = document.getElementById('mi_div');
        console.log(elementoDiv);
        console.log(elementoDiv.innerHTML);
        elementoDiv.innerHTML = '<ul><li>elemento uno</li></ul>';
    </script>
````

En el ejemplo que se acaba de ver, se ha accedido al elemento mediante una ID, pero js permite acceder a los elementos mediante diferentes métodos "tradicionales" getElementById, getElementByClassName, getElementByTagName

Imaginad una web con la siguiente estructura

````
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>

  <body>
    <h1 id="titulo">Titulo propio impartido en el CES Juan Pablo II</h1>
    <p id="parrafo_general">
      Este título propio será impartido para los alumnos del ciclo de Desarrollo
      de Aplicaciones Multiplataforma de CES JuanPablo II. La finalidad de este
      curso es sentar las bases del lenguaje de programación web JavaScrip de
      forma que se puedan hacer Aplicaciones web dinámicas
    </p>

    <p>El contenido del curso será</p>

    <ul id="lista_contenido">
      <li>1. Introducción</li>
      <li>2. DOM y BOM</li>
      <li>3. Gestión de eventos</li>
      <li>4. Almacenamiento interno</li>
    </ul>

    <script></script>
  </body>
</html>

````

Como se puede ver, algunos nodos del DOM de la página cuentan con el atributo id. Este atributo (al igual que otros como el class o el tag) permiten a js acceder a su contenido mediante los métodos getElementById, getElementByClassName, getElementByTagName

````
    <script>
        var listaPorId = document.getElementById('lista_contenido');
        var listaPorTag = document.getElementsByTagName('ul');
        var listaPorClass = document.getElementsByClassName('class_lista');

        console.log(listaPorId);
        console.log(listaPorTag);
        console.log(listaPorClass);
    </script>
````

````
<ul id="lista_contenido" class="class_lista">..</ul>
HTMLCollection [ul#lista_contenido.class_lista, lista_contenido: ul#lista_contenido.class_lista]
HTMLCollection [ul#lista_contenido.class_lista, lista_contenido: ul#lista_contenido.class_lista]
````

La diferencia reside en que el primer método (por Id devuelve el contenido íntegro), sin embargo los dos siguientes devuelve un HTMLCollection, por lo que en la mayoría de veces nos interesará este tipo, pasa así poder acceder a sus atributos internos

Imaginad que me interesa sacar llevar a js todos los elementos de una lista ul

````
    <script>
        var lista = document.getElementsByTagName('ul')[0].children;
        for (let index = 0; index < lista.length; index++) {
            const element = lista[index];
            console.log(element.innerHTML);
        }
    </script>
````

En este caso se accede a la propiedad children de la lista. Sobre la variable se realiza un array para recorrer la variable y de cada elemento iterado se accede a la propiedad innerHTML

Adicionalmente se pueden utilizar una serie de métodos que son interesantes, ya que nos devuelven directamente una serie de elementos comunas:

- anchor: todas las etiquetas -a- del documento con el atributo name
- applets: todos las etiquetas applet del documento
- forms: todos las etiquetas form del documento
- images: todas las etiquetas img del documento
- links: todas las etiquetas -a- del documento con el atributo href
- scripts: todas las etiquetas script del documento

````
    <ul>
        <li><a href="https://github.com/DevelopSys/CursoJS">Repositorio DevSys</a></li>
        <li><a href="https://classroom.google.com/">Classroom</a></li>
        <li><a href="http://www.developandsys.es">Develop and system</a></li>
    </ul>

    <script>
    
        var links = document.links;
        for (let index = 0; index < links.length; index++) {
            const element = links[index];
            console.log(element.href);

        }
    </script>
````


Adicionalmente js nos permite utilizar selectores especiales que permiten realizar querys sobre todos los elementos de un DOM de forma más concreta. Estos métodos son querySelector() y querySelectorAll().

- querySelector(): permite pasar un parámetro indicando tanto id como class o etiqueta en el mismo método, incluso anidando elementos. El método devuelve el primer elemento que cumpla con los parámetros pasados, aunque exista más de uno

````
    <script>
        "use strict"
        let elementoPorClass = document.querySelector('.mi_parrafo');
        console.log(elementoPorClass);
        let elementoPorId = document.querySelector('#mi_div');
        console.log(elementoPorId);
    </script>
````


Mediante esta función se puede encontrar cualquier elemento, incluso si están anidados;

````
<body>
    <h1>Titulo de JS impartido por Borja Martín</h1>
    <p class="mi_parrafo">
        Titulo correspondiente al primer curso de DAM del instituto CES Juan Pablo segundo de Formación profesional
    </p>
    <div id="mi_div">
        Párrafo diferente
        <div class="elemento_interno"></div>
        <div class="elemento_interno_dos"></div>

    </div>
    <script>
        "use strict"
        let elementoAnidado = document.querySelector('#mi_div div');
        console.log(elementoAnidado);
    </script>
</body>
````

La salida del método document.querySelector('#mi_div div') devería devolver todos los elementos con la etiqueta div que estén dentro de una etiqueta cuyo id es mi_div. En el caso de la función querySelector solo devolvería el primero, por lo que el resultado sería:        
````
<div class="elemento_interno"></div>
````

Adicionalmente se puede realizar una query preguntando por todos aquellos elementos que tengan la clase elemento_interno_dos y que estén dentro de una etiqueta cuyo id sea mi_div:

````
        let elementoAnidadoConcreto = document.querySelector('#mi_div .elemento_interno_dos');
        console.log(elementoAnidadoConcreto);
````

En este caso solo existe una coincidencia, pero en el caso de haber varias tan solo se devolvería la primera. Al igual que en casos anteriores se puede ejecutar una función que reciba por parámetros el elemento y modifique alguno de sus elementos

````
        function modificarContenido(elemento) {
            elemento.innerHTML = 'modificaion'
        }
````

- querySelectorAll(): permite pasar un parámetro indicando tanto id como class o etiqueta en el mismo método, incluso anidando elementos. El método devuelve el todos los elementos que cumplan con los parámetros pasados, pudiendo recorrerlos y realizar tareas con ellos

Con el mismo body del ejemplo anterior

````

<body>
    <h1>Titulo de JS impartido por Borja Martín</h1>
    <p class="mi_parrafo">
        Titulo correspondiente al primer curso de DAM del instituto CES Juan Pablo segundo de Formación profesional
    </p>
    <div id="mi_div">
        Párrafo diferente
        <div class="elemento_interno"></div>
        <div class="elemento_interno_dos"></div>

    </div>
    <script>
        "use strict"
        let elementosComunes = document.querySelectorAll("#mi_div div");
        console.log(elementosComunes);
    </script>
</body>

````


El método document.querySelectorAll("#mi_div div") devuelve todos los elementos con la etiqueta div y que están dentro de un elemento con el id mi_div. En este caso devolvería dos nodos

````
        <div class="elemento_interno"></div>
        <div class="elemento_interno_dos"></div>
````

Sobre los cuales se podría actuar. Hay que tener en cuenta que esta devolución es mediante una HTMLCollection, por lo que se realiza mediante las operaciones vistas con arrays

````
        console.log(elementosComunes[0]);
        elementosComunes[0].innerHTML = 'Texto modificado del primero'
````

Si se quiere acceder a todos los elementos mediante una función:
````
        function modificarTodosPorSelector(query) {

            let elementos = document.querySelectorAll(query);
            elementos.forEach(element => {
                console.log(element);
            });
        }
````

Imaginad ahora que se quiere agregar algún elemento a todos los divs que se ha devuelvo en la consulta del selector. Para ello, en cada uno de los elementos de la colección se crea un nuevo nodo y se agrega al existente

````
        function modificarTodosPorSelector(query) {

            let elementos = document.querySelectorAll(query);
            elementos.forEach(element => {
                console.log(element);
                let parrafo = document.createElement('p');
                let texto = document.createTextNode('Ejemplo de modificacion');
                parrafo.appendChild(texto);
                element.appendChild(parrafo);
            });
        }
````

[Volver al inicio](#index)


## Eventos<a name="eventos"></a>

Como se acaba de ver, una de las principales capacidades de JS es la capacidad de asociar una parte gráfica con una parte lógica. Cuando se está realizando una aplicación web, si solo nos centramos en los elementos gráficos (HTML y CSS), su apariencia quedará muy bien pero tendrá un contenido totalmente estático, de forma que ante cualquier cambio será necesario acceder al código y realizar las modificaciones necesarias. Esto es totalmente inviable en proyectos que requieran por ejemplo de una interacción media por parte del usuario . El ejemplo más claro de esto son los formularios o la forma de interactuar ante cualquier evento.

Imaginamos un formulario normal y corriente en HTML

````
    <form id='formulario'>
        <input type="text" inputmode="latin">
        <button type="button">Pulsar para enviar</button>
    </form>
````

En el caso de querer controlar la pulsación del botón directamente, js nos ofrece la posibilidad de asociar una acción a un evento concreto del elemento. Para ello se le pone como atributo al button un onclick, el cual permite asociar una ejecución al elemento que lleva dicho atributo

````
<body>
    <h1>Formulario de introducción de datos</h1>

    <form id='formulario'>
        <input type="text" inputmode="latin">
        <button type="button" onclick="saludar()" id='boton'>Pulsar para enviar</button>
    </form>

</body>

<script>
    function saludar() {
        console.log('Botón pulsado');
    }
</script>
````


Como se puede ver, al botón se le asocia un evento onclick el cual está igualado a una función que nos hemos creado en el script. De esta forma cuando el botón sea pulsado, se escribirá en consola el texto indicado. Esto es lo que se conoce como eventos en línea. 

El ejemplo anterior se puede modificar de forma que la función pueda admitir por parámetros tantos elementos como sea necesario. Por ejemplo se puede pasar por parámetro el contenido del campo de texto del formulario

````
<body>
    <h1>Formulario de introducción de datos</h1>

    <form id='formulario'>
        <input type="text" inputmode="latin" id="nombre">
        <button type="button" onclick="saludar(nombre.value)" id="boton">Pulsar para enviar</button>
    </form>

</body>

<script>
    function saludar(nombre) {
        console.log(`El nombre introducido es ${nombre}`);
    }
</script>
````

Se pueden pasar tantos elementos como sean necesarios. En el siguiente ejemplo se capturan y pasan por parámetros tres elementos, necesitando convertir uno de ellos a fecha

````
<body>
    <h1>Formulario de introducción de datos</h1>

    <form id='formulario'>
        <input type="text" inputmode="latin" id="nombre" placeholder="introduce tu nombre">
        <input type="text" inputmode="latin" id="apellido" placeholder="introduce tu apellido">
        <input type="date" id="fecha">

        <button type="button" onclick="saludar(nombre.value, apellido.value,fecha.value)" id="boton">Pulsar para enviar</button>
    </form>

</body>

<script>
    function saludar(nombre, apellido, fecha) {
        fecha = new Date(fecha);
        fecha.getYear()

        console.log(`Hola ${nombre} ${apellido}, naciste el ${fecha.getDate()}/${fecha.getMonth()+1}/${fecha.getFullYear()}`);
    }
</script>
````


Los eventos más comunes en js son los siguientes:

- onchange: An HTML element has been changed

- onclick: The user clicks an HTML element

- onmouseover: The user moves the mouse over an HTML element

- onmouseout: The user moves the mouse away from an HTML element

- onkeydown: The user pushes a keyboard key

- onload: The browser has finished loading the page

Hay que tener en cuenta que muchas veces los parámetros capturados e introducidos es necesario castearlos a los tipos concretos ya que si no daría fallo. En este ejemplo se simula el funcionamiento de una calculadora de dos operandos

````
<body>
  
    <h1>Formulario de calculo</h1>

    <form id="formulario_calc">
        <input type="number" id="op1" />
        <input type="number" id="op2" />
        <input type="radio" id="suma" name="operacion" value="1" />
        <label for="suma">Suma</label>
        <input type="radio" id="resta" name="operacion" value="2" />
        <label for="resta">Resta</label>
        <input type="radio" id="multiplicacion" name="operacion" value="3" />
        <label for="multiplicacion">Multiplicación</label>
        <input type="radio" id="division" name="operacion" value="4" />
        <label for="division">División</label>
        <button type="button" onclick="realizarCalculo(op1.value, op2.value)" id="boton_calc">
        calcular
      </button>
    </form>
</body>

<script>
    function realizarCalculo(op1, op2) {
        operacion = document.querySelector('input[name="operacion"]:checked').value;
        var resultado;
        switch (parseInt(operacion)) {
            case 1:
                resultado = op1 + op2;
                console.log('entra');
                break;
            case 2:
                resultado = op1 - op2;
                break;
            case 3:
                resultado = op1 * op2;
                break;
            case 4:
                resultado = op1 / op2;
                break;
        }

        console.log(resultado);

        console.log(`El resultado de realizar la suma es ${resultado}`);
    }
</script>
````

En este caso sacará por consola el resultado de la operación del valor introducido en el campo op1 y en el op2, dependiendo de cuál sea la operación. Hay que tener especial cuidado porque los elementos los recoge como texto, por lo que el resultado de sumar 1 y 5 sería 15 ya que los concatena (recordad el tipado dinámico). El resto de operaciones las haría sin problema ya que no puede asignar operaciones sobre cadenas de * / y -. Para solucionar esto basta con forzar a que los parámetros sean números, modificando la función de la siguiente forma

````
<script>
    function realizarCalculo(op1, op2) {
        operacion = document.querySelector('input[name="operacion"]:checked').value;
        var resultado;
        switch (parseInt(operacion)) {
            case 1:
                resultado = op1 + op2;
                console.log('entra');

                break;
            case 2:
                resultado = op1 - op2;
                break;
            case 3:
                resultado = op1 * op2;

                break;
            case 4:
                resultado = op1 / op2;
                break;
        }

        console.log(resultado);

        console.log(`El resultado de realizar la suma es ${resultado}`);
    }
</script>
````

Aunque esto se verá más adelante con detalle, js permite no solo seleccionar los elementos del DOM de una página, sino también modificar su contenido. Por ejemplo mediante métodos como getElementById() se puede utilizar un elemento HTML para mostrar la salida de una función js

````
<body>
    <h1>Formulario de introducción de datos</h1>

    <form id="formulario_calc">
        <input type="number" id="op1" />
        <input type="number" id="op2" />
        <input type="radio" id="suma" name="operacion" value="1" />
        <label for="suma">Suma</label>
        <input type="radio" id="resta" name="operacion" value="2" />
        <label for="resta">Resta</label>
        <input type="radio" id="multiplicacion" name="operacion" value="3" />
        <label for="multiplicacion">Multiplicación</label>
        <input type="radio" id="division" name="operacion" value="4" />
        <label for="division">División</label>
        <button type="button" onclick="realizarCalculo(op1.value, op2.value)" id="boton_calc">
        calcular
      </button>
    </form>

    <p id="parrafo_destino"></p>

</body>

<script>
    function realizarCalculo(op1, op2) {
        operacion = document.querySelector('input[name="operacion"]:checked').value;
        var resultado;
        switch (parseInt(operacion)) {
            case 1:
                resultado = parseInt(op1) + parseInt(op2);
                console.log('entra');

                break;
            case 2:
                resultado = op1 - op2;
                break;
            case 3:
                resultado = op1 * op2;

                break;
            case 4:
                resultado = op1 / op2;
                break;
        }

        console.log(resultado);

        console.log(`El resultado de realizar la suma es ${resultado}`);
        parrafo = document.getElementById('parrafo_destino').innerHTML = `El resultado de realizar la suma es ${resultado}`;
    }

</script>

````

Como se ha visto en el código HTML se asigna directamente el evento asociado. Esta técnica se llama en linea y en muchas ocasiones puede resultar algo tedioso ya que hay que ir dando elemento a elemento la funcionalidad. Existe otra posibilidad que es la de asociar un escuchador al elemento desde código. Para ello se utilizan los listener

````
<body>

    <p id="parrafo_destino"></p>
    <button id='botonListener' type="button">Evento desde código</button>

</body>
````

Imaginad el HTML anterior donde existe un párrafo con un id determinado y un botón con otro id asociado. Mediante estos elementos se puede encontrar el elemento desde el código js

````
<script>
    let elemento = document.querySelector('#botonListener');
    console.log(elemento);
</script>
````

Una vez encontrado el elemento se puede poner un escuchador con la siguiente sintaxis
````
elemento.addEventListener(evento_escucha, nombre_funcion_asociada,valor_defecto);
````

Con esa sintaxis el elemento concreto se podría a escuchar de forma automática. En el ejemplo del HTML anterior sería de la siguiente forma:

````
    let elemento = document.querySelector('#botonListener');
    console.log(elemento);
    elemento.addEventListener('click', pulsarBoton);

    function pulsarBoton() {
        console.log('pulsación realizada');
        let elementoTexto = document.createTextNode('Texto a poner en el nuevo elemento');
        document.querySelector('#parrafo_destino').appendChild(elementoTexto)
    }
````

Es importante tener en cuenta que del mismo modo que se pueden añadir escuchadores a los elementos , también se pueden eliminar escuchadores indicando el tipo de evento que se quiere borrar y la función que tiene asociada

````
    let elemento = document.querySelector('#botonListener');
    elemento.removeEventListener('click', cambiarColor);
````

Al igual que se ha definido en el ejemplo un evento de tipo click, se pueden asociar tantos como sean necesarios. De la misma forma, no es necesario declarar una función y ponerla en el listener, sino que se puede hacer directamente

````
    elemento.style.fontSize = '10px';
    elemento.addEventListener('mouseover', function() {
        console.log('El ratón está por encima del elemento');
        elemento.style.fontSize = '20px';

    });

    elemento.addEventListener('mouseout', function() {
        elemento.style.fontSize = '10px';
        console.log('El ratón está por fuera del elemento');

    });
````

Una cosa importante cuando se trabaja con eventos es que las funciones que se ejecutan pueden recibir tántos parámetros como sean necesarios tal y como se vió cuando creamos las funciones, pero a la hora de trabajar con eventos lo normal es que reciban un parámetro de tipo event  donde se puede encontrar toda la información del evento asociado. Suponer que se tiene un botón al que se le quiere dar una funcionalidad concreta;

````
    let boton = document
        .querySelector("#boton_evento_funcion")
        .addEventListener("click", function(event) {
            console.log(event);
        });
````

En este caso la función de callback recibe como parámetro un objeto que representa toda la información del evento producido: Si ejecutamos el código se puede ver que se muestran todos los parámetros que el evento produce, pudiendo acceder a cualquiera de ellos

Esta técnica se puede realiza con cualquier elemento. Por ejemplo si se quiere sacar la tecla pulsada en un input se puede utilizar la funcionalidad basada en un evento de tipo keyup

``
    let input = document
        .querySelector("#input_funcion")
        .addEventListener("keyup", function(event) {
                console.log(event);
                console.log(String.fromCharCode(event.KeyCode));}
``


Cuando se trabaja con js el orden de carga es muy importante. Esto quiere decir que si nosotros ejecutamos un script antes de los elementos HTML (en el head por ejemplo) puede que muchos de los elementos que intervienen en el código no se encuentran al no haberse cargado

````
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        let elemento = document.querySelector('body div[id=container]')
        console.log(elemento);
    </script>

</head>

<body>
    <div id="container">
        <h1>Ejemplo de carga de elementos</h1>
    </div>
</body>
</html>
````

En este ejemplo se busca un elemento cuya etiqueta es div y su id es container. Evidentemente este elemento existe dentro del código HTML pero como el script se está ejecutando antes que los elementos HTML el resultado es nulo. Sin embargo si se cambia el orden, la salida si será correcta

````
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <div id="container">
        <h1>Ejemplo de carga de elementos</h1>
    </div>
</body>

<script>
    let elemento = document.querySelector('body div[id=container]')
    console.log(elemento);
</script>

</html>
````

Otra posibilidad es utilizar los listen para indica que cuando el navegador termine de realizar la carga del HTML ejecute los elementos que se quieran

````
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        window.addEventListener('load', function() {
            console.log('carga terminada');
            let elemento = document.querySelector('body div[id=container]')
            console.log(elemento);
        })
    </script>
</head>

<body>
    <div id="container">
        <h1>Ejemplo de carga de elementos</h1>
    </div>
</body>

</html>
````

Con esto, lo que se consigue es poner un escuchador a la ventana para que cuando termine la carga se ejecute la función indicada la cual realiza la instancia de los elementos. En este caso pese a que el script se ejecuta antes que el código HTML, se indica que parte del mismo se ejecute cuando termine de hacer la carga, por lo que la salida no será nula