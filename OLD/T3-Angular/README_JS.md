- [Variables y tipos](#variables-y-tipos)
  - [Variables](#variables)
  - [Tipos de datos](#tipos-de-datos)
    - [Primitivos:](#primitivos)
    - [No primitivos](#no-primitivos)
    - [Tipos de datos y cambios](#tipos-de-datos-y-cambios)
- [Interacción básica con el usuario](#interacción-básica-con-el-usuario)
  - [Prompt y alert](#prompt-y-alert)
- [Operadores](#operadores)
  - [Asignación](#asignación)
  - [Aritméticos](#aritméticos)
  - [Comparación](#comparación)
  - [Lógicos](#lógicos)
  - [Ternarios](#ternarios)
- [Sentencias de control](#sentencias-de-control)
  - [if](#if)
  - [switch](#switch)
  - [while](#while)
  - [do-while](#do-while)
  - [for](#for)
  - [Arrays](#arrays)
- [Funciones](#funciones)
  - [Callbacks](#callbacks)
- [Fetch](#fetch)
- [Objetos](#objetos)
  - [Relación objeto funciones](#relación-objeto-funciones)
- [Acceso al DOM y modificaciones](#acceso-al-dom-y-modificaciones)
- [Eventos](#eventos)


# Variables y tipos

## Variables

Las variables son elementos del sistema que puede guardar un dato, tanto primitivo como no primitivo. En javascript existen tres grandes tipos de variables: let, var y const. Las dos primeros tipos son muy similares, con la diferencia del alcance de la variable. Mientras que let limita el alcance de la variable, var tiene un alcance más generalista. Para ello vamos a ver un ejemplo

```javascript
if (true) {
  let numero = 20;
  console.log(`Impresión de la variable let dentro del bloque ${numero}`);
}

console.log(`Impresión de la variable let fuera del bloque`);

// Impresión de la variable let dentro del bloque 20
// Impresión de la variable let fuera del bloque - ERROR
```

En el segundo caso la variable no ha podido ser accedida ya que no está declarada en el bloque donde está definida. Sin embargo una variable var tiene un ambigo más grande, siendo accesible desde cualquier parte aunque no coincida en el ámbito de creación

```javascript
if (true) {
  let numero = 20;
  var numeroScope = 30;
  console.log(`Impresión de la variable let dentro del bloque ${numero}`);
}

console.log(`Impresión de la variable var fuera del bloque ${numeroScope}`);
// Impresión de la variable let dentro del bloque 20
// Impresión de la variable var fuera del bloque 30
```

Como se puede ver en el ejemplo anterior, la variable numeroScope que está decladara dentro del bloque if, puede ser accedida desde fuera aunque no es su ámbito correcto.

El último tipo de variable que existe son las constantes. Se trata de un tipo de variable con una sola asignación, no pudiendo cambiar el valor que existe dentro. Para el uso de este tipo de variable se utiliza la palabra reservada const. Siempre que se pueda es recomendable utilizarla ya que así se agrega seguridad al sistema

```javascript
const elementoInmutable = 20;
elementoInmutable = 30;
// Uncaught TypeError: Assignment to constant variabl
```

Como se puede ver la variable elementoInmutable no puede cambiar de valor ya que esta ha sido asignada y se ha declarado como constante. Existe una cosa curiosa con este tipo de variables. En los tipos de datos primitivos no se puede hacer una asignación de valor una vez se ha realizado al ser constante, pero en los tipos de dato no primitivos el dato no puede volver a ser igualado, pero su contenido si puede ser cambiado como por ejemplo en un array añadir un elemento.

```javascript
const arrayInmutable = [1, 2, 3, 4, 5];
// agregar un elemento al array en la parte final
arrayInmutable.push(1);
console.log(arrayInmutable);
// [1,2,3,4,5,1]
arrayInmutable = [1, 4, 7];
// Uncaught TypeError: Assignment to constant variable.
```

Otro ejemplo de este tipo de asignaciones es sobre elementos de tipo json, ya que no se puede asignar a un nuevo objeto pero si se puede añadir una propiedad nueva o cambiar el valor de alguna de las existentes

```javascript
const persona = { nombre: "Borja", apellido: "Martin", edad: 38 };
console.log(persona);
// {nombre: 'Borja', apellido: 'Martin', edad: 38}
persona["expeciancia"] = true;
console.log(persona);
// {nombre: 'Borja', apellido: 'Martin', edad: 38, experiencia: true}
```

En este caso la única forma de garantizar que este tipo de cosas no pasen es congelando el objeto, por lo que no se podrá cambiar su estructura interna

```javascript
const arrayInmutable = Object.freeze([1, 2, 3, 4, 5]);
arrayInmutable.push(1);
// Uncaught TypeError: Cannot add property 5, object is not extensible

const persona = Object.freeze({
  nombre: "Borja",
  apellido: "Martin",
  edad: 38,
});
persona["expeciancia"] = true;
// Uncaught TypeError: Cannot add property 5, object is not extensible
```

## Tipos de datos

Una de las diferencias que tiene js de forma nativa con parte de los lenguajes de programación tradicionales (Java, C#, etc ...) es que no es un lenguaje tipado. Esto quiere decir que no es necesario indicar el tipo de un dato, sino que el navegador (o servidor en el caso de utilizar node) puede decir cual es el tipo que más le conviene. Sin embargo también existe la posibilidad de declara diferentes tipos dentro del código. En js se diferencian dos tipos de datos

### Primitivos:

Aquellos que tienen una representación en byte dentro de la memoria del sistema operativo. Podemos diferenciar los siguientes

- Números: conocidos en el lenguaje como Number. Engloba todo tipo de número (entero, double, float). No hay diferencia entre cada uno de los datos, si bien en el cógio existen diferentes métodos para poder pasar un numero decimal a entero por ejemplo

```javascript
let numeroEntero = 30;
let numeroDecimales = 3.14;
console.log(`El valor de numeroEntero es ${numeroEntero}`);
console.log(`El valor de numeroDecimales es ${numeroDecimales}`);
```

- String: conocido como la concatenación de varias letras al mismo tiempo. Se trata de un tipo primitivo especial, ya que como veremos tiene un conjunto de métodos que se pueden aplicar sobre este tipo de datos

```javascript
let nombre = "Borja";
let profesion = "Profesor";

console.log(`Mi nombre es ${nombre}`);
console.log("Mi prpofesión es la de " + profesion);
```

Los String se pueden representar con comilla doble (""), comilla simple ('') o comilla francesa o invertida. El uso de este último se destina para poder hacer referencia o código js dentro del string de forma directa.

```js
console.log(`La suma de 6 y 7 es ${6 + 7}`);
// La suma de 6 y 7 es 13
```

Además de poder utilizar este tipo de representación con Strings, existe la posibilidad de representar caracteres especiales precedidios del la barra invertida \'. Un uso muy común de esto es el salto de línea

```js
console.log("Ejemplo de impresión\nCon salto de línea");
// Ejemplo de impresión
// Con salto de línea
```

Más adelante veremos cuales son todos los métodos asociados a los tipos de datos String

- Boolean: tipo de dato que puede tener valores true o false. Muy utilizado en las sentencias lógicas que nos ayudan a tomar decisiones.

```js
let variableDecision = false;
console.log(`El resultado de la decisión es ${false}`);
// El resultado de la decisión es false

decision && console.log("Es una decision correcta ");
// no se imprime nada por consola

decision
  ? console.log("La decisión ha sido correcta")
  : console.log("La decisión ha sido falsa");
// La decisión ha sido falsa
```

- Null: tipo de dato curioso ya que represente que la variable tiene valor null. Es decir que la variable ha sido declarada pero se le ha asignado null
- Undefined: tipo de dato que tiene relación con el anterior ya que en este caso, aunque la variable quede declarada no se le asigna ningún valor, por lo que si tipo será unefined

Los dos últimos valores un ejemplo sería el siguiente:

```js
let sinValor = null;
let sinDefinir;
console.log(`El valor de la primera variable es ${sinValor}`);
// El valor de la primera variable es null
console.log(`El valor de la segunda variable es ${sinDefinir}`);
// El valor de la segunda variable es undefined
```

Tampoco es de gran importancia la diferencia entre ambos tipos, ya que podremos utilizar ambos para definir si una variable es de un tipo u otro

En el caso de querer mostrar por consola el tipo de una variable se pueden utilizar

### No primitivos

Si bien los datos primitivos permiten guardar en memoria utilizando una serie limitada de bytes, los tipos no primitivos necesitan de una cantidad de memoria superior, ya que apuntan a un dato complejo. Entre estos tipos complejos podemos distinguir principalmente dos: arrays y objetos.

Más adelante lo veremos, pero podemos definir como array un conjunto de datos que se guardan en una colección mutable. Este conjunto de datos se guarda con relación a posiciones. A diferencia lenguajes de programación como Java, este tipo de colecciones es modificable tanto en contenido como en tamaño.

```javascript
let arrayDatos = [1, 2, 3, 4, 5, 6];
```

Un ejemplo muy claro de este tipo de datos es la comparación. Por ejemplo si se evalúa la igualdad de dos datos primitivos la comparación será true

```javascript
let arrayDatos = [1, 2, 3, 4, 5, 6];
let arrayIgualdad = [1, 2, 3, 4, 5, 6];

let numeroUno = 2;
let numeroDos = 2;

console.log(numeroUno == numeroDos); // true
console.log(arrayDatos == arrayIgualdad); // false
```

Veremos más adelante cuales son los principales métodos que se pueden aplicar sobre los arrays, como el de añadir elementos, eliminar elementos, filtrar elementos, etc...

El otro tipo de dato no primitivo son los objetos. En cuanto a este tipo de dato, existen muchos tipos de objetos que pueden ser útiles en js. Por ejemplo se puede declarar un tipo Date que se trata como object

```javascript
let fecha = new Date();
console.log(fecha);
//Fri Sep 02 2022 19:26:59 GMT+0200 (hora de verano de Europa central)
```

### Tipos de datos y cambios

Como ya se ha dicho, existen diferentes tipos de datos dentro de javascript, que con el set de js básico es asignado por el navegador. Para poder ver el tipo de dato que está asignado a cada variable se puede utilizar el operador type of seguido de la variable que se quiera evaluar.

```javascript
let numero = 3; // number
let numeroDecimal = 3.15; // number
let experiencia = true; // boolean
let nombre = "Borja"; // string
let asignaturas = ["PMDM", "DI", "DAWC"]; // object
let profesor = { nombre: "Borja", edad: 38, experiencia: true }; // object
let carnet = null; // null
let alumno; // undefined

console.log(typeof numero);
console.log(typeof numeroDecimal);
console.log(typeof experiencia);
console.log(typeof asignaturas);
console.log(typeof profesor);
console.log(typeof carnet);
console.log(typeof alumno);
```

Sin embargo, hay en algunas ocasiones que los tipos que queremos manejar tienen que ser unos concretos. Para ello existe lo que se conoce como casting o cambio de tipo. Una cosa importante es que no todos los tipos son convertibles entre sí, sino que solo se puede hacer el cambio entre una serie de tipos

- String en Int (number): Para poder hacer el cambio de una variable String a Int es necesario ejecutar el método parseInt() o Number()

```javascript
let caracter = "5";
let numeroConvert = Number(caracter);
//parseInt(caracter)
console.log(numeroConvert); // 5
console.log(typeof numeroConvert); // number
```

En el caso de no poder hacerse el cambio, la variable daría error de conversión obteniendo un tipo no correcto. En este caso sería NaN (Not a Number)

```javascript
caracter = "Borja";
numeroConvert = Number(caracter);
console.log(numeroConvert); // NaN
```

Hay otra posibilidad de hacer la conversión que es la de agregarle el sigo positivo a la variable, por lo que la conversión se realizaría de forma directa

```javascript
caracter = "5";
console.log(typeof caracter); // string
numeroConvert = +caracter;
console.log(typeof numeroConvert); // number
```

- String en Float: se trata de una conversión muy similar a la anterior, con la diferencia que el número guardará decimales. Para este tipo de conversión además de Number y el signo + se puede utilizar el método parseFloat()

```javascript
let caracterDecimal = "3.14";
let decimalConvert = parseFloat(caracterDecimal);
console.log(typeof caracterDecimal); // number
```

Hay que tener en cuenta que este tipo de conversiones obtiene como resultado un tipo number, al igual que el anterior.

- Float en Int: Si bien hemos dicho al principio que los tipos de datos number aglutinan tanto números con decimales como números sin decimales sin hacer excepcion, se peude hacer una conversión entre tipos que obvia la parte decimal

```javascript
numeroDecimal = 3.14;
numeroEntero = parseInt(numeroDecimal);
console.log(numeroDecimal); // 3
```

Al igual que en los casos anteriores este tipo de conversiones obtiene como resultado una variable de tipo number

# Interacción básica con el usuario

## Prompt y alert

Para poder interactuar con el usuario mediante consola, se utilizan los siguientes métodos:

- Window.alert(): muestra una ventana por consola

```javascript
alert("El proceso se ha terminado");
```

- Window.confirm(): pide confirmación al usuario dando la opción de aceptar o cancelar. Para poder tratar la respuesta se debe guardar en una variable la salida de la función confirm.

```javascript
let confirmacion = confirm("¿estás seguro que quieres terminar el proceso?");
if (confirmacion) {
  alert("El proceso se ha terminado");
}
```

- Window.prompt(): pide un dato al usuario mediante una ventana emergente. De la misma forma que en el caso anterior, se deberá guarda la salida en una variable para poder tratarla más adelante

```javascript
var nombreIntroducido = prompt("por favor introduce tu nombre");
```

En el caso de querer tratar la variable se realizaría de una forma normal

```javascript
let nombreIntroducido = prompt("por favor introduce tu nombre");
let respuesta = confirm(
  `¿Estás seguro que quieres evaluar el nombre ${nombreIntroducido}?`
);
if (respuesta) {
  tieneAes = nombreIntroducido.toLowerCase().includes("a");
  if (tieneAes) {
    alert("El nombre introducido tiene alguna a");
  } else {
    alert("El nombre introducido no tiene ninguna a");
  }
} else {
  alert("Proceso terminado");
}
```

Hay que tener en cuenta que este método devuelve el dato introducido en formato String, por lo que si se quiere en formatu número habría que utilizar el parseInt() o parseFloat() o el Number()

# Operadores

Al igual que en el resto de lenguajes de programación, en js existen los tipocos operadores de asignación, aritméticos, lógicos, de desplazamiento, etc...

## Asignación

Se trata de los operadores más sencillos, ya que son aquellos que permiten la asignación de un valor a una variable.

```javascript
let numeroUno = 30;
let numeroDos = 5;
```

## Aritméticos

Como todo en programación, las matemáticas juegan un papel muy importante. Las operaciones que se pueden realizar sobre los datos son las comunes: suma, resta, multiplicación, división y módulo. A continuación se muestre el uso de los principales

```javascript
let numeroUno = 30;
let numeroDos = 5;

let suma = numeroUno + numeroDos; // 35
let resta = numeroUno - numeroDos; // 25
let multiplicacion = numeroUno * numeroDos; // 150
let division = numeroUno / numeroDos; // 6
let modulo = numeroUno % numeroDos; // 0
let incremento = numeroUno--; // 29
let decremento = numeroUno++; // 31
```

Existe una mezcla entre los operadores de asginación y los operadores aritméticos que permiten la asignación de la operacion entre el valor de la propia variable y un valor indicado

```javascript
suma += 5; // suma = suma + 5 --> suma = 10 + 50
resta += 5; // resta = resta - 5 --> suma = 10 - 50
multiplicacion += 5; // multiplicacion = multiplicacion * 5 --> multiplicacion = 10 * 2
division += 5; // division = division / 5 --> division = 10 / 50
modulo += 5; // modulo = modulo % 50 --> modulo = 2 + 50
```

## Comparación

Los operadores de comparación son aquellos que permite realizar operaciones lógicas. PAra ello se utilizan los siguientes elementos:

```javascript
let mayorQue = 100 > 10; // true
let menorQue = 10 < 100; // true
let mayorIgual = 100 >= 10; // true
let menorIgual = 10 <= 100; // true
let igual = 10 == 10; // true
let noIgual = 100 != 10; // true
```

Dentro de este tipo de operadores el de igualdad tiene un coportamiento que merece la pena comentar. En javascript al igual que en otros lenguajes, existe la posibilidad que dos variables que tengan el mismo valor pero tipos diferentes su comparación sea verdadera.

```javascript
let operandoUno = 4;
let operandoDos = "4";
console.log(operandoUno == operandoDos); // true
console.log(operandoUno === operandoDos); // false
```

En el primer caso, la comparación tan solo se fija en el valor, cambiando los tipos de las variables para que la comparación sea sobre el mismo elemento. Sin ambargo en el segundo caso, la comparación además de ser sobre el valor de la variable también es sobre el tipo de la variable, por lo que en este caso el tipo será false.

## Lógicos

Los operadores lógicos permiten la evaluación de múltiples condiciones para poder obtener un resultado único. Este tipo de operadores aplican la lógica fundamental de las puertas lógicas AND OR y NOT. Los operadores lógicos son && || y ! y la apicación de las mismas son

Existen los mismos elementos que en cualquier lenguaje de programación: AND y OR

- AND: retornará verdadero cuando todas las sentencias que se están evaluando sean verdaderas. En el momento que una de las sentencias sea falsa el resultado será falso.

- OR: retornaría verdadero cuando al menos una de las sentencias que se están evaluando sean verdaderas. En el momento que una de las condiciones sea verdadera se asegura que el resultado es verdadero.

```javascript
let ex1 = true && true; // true
let ex2 = 2 == 2 && 3 >= 6; //false
let ex3 = 2 > 3 || 17 <= 40; //true
let ex4 = false || false; // false
```

## Ternarios

Se trata de un if con una sintaxis especial que es la siguiente:

```javascript
condicion ? valor_si_es_verdadera : valor_si_es_falsa;
```

Un ejemplo sería el siguiente:

```javascript
let decision = true;
decision
  ? console.log("la decición ha sido verdadera")
  : console.log("la decición ha sido falsa");
```

Al igual que en todos los casos anteriores se puede concatenar con cualquiera de los elementos vistos:

```javascript
let nombre = prompt("Por favor introduce tu nombre");
nombre.length > 5
  ? alert("tu nombre es demasiado largo")
  : alert("tu nombre es cumple con los requisitos de longitud");
```

# Sentencias de control

## if

Sentencia de control que evalúa una serie de condiciones. En el caso de encontrar una condición verdadera ejecuta el cuerpo del su bloque correspondiente

```javascript
var nota = 5;
if (nota < 5) {
  console.log("El alumno ha suspendido");
} else {
  console.log("El alumno ha aprobado");
}
```

Su forma de trabajar es idéntica a la vista en java, pudiendo tener tantas sentencias else if como sean necesarias.

```javascript
var nota = 11;
if (nota < 5) {
  console.log("El alumno ha suspendido");
} else if (nota < 10) {
  if (nota < 6) {
    console.log("aprobado raspado");
  } else if (nota < 8) {
    console.log("aprobado con buena nota");
  } else if (nota < 10) {
    console.log("aprobado con muy buena nota");
  } else {
    console.log("perfecto");
  }
} else {
  console.log("algo no me cuadra");
}
```

## switch

Mismo uso y sintaxis que java

```javascript
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
```

## while

Mismo uso y sintaxis que java

```javascript
var numero = 10;
while (numero > 0) {
  alert(`El número es demasiado grande aún, su valor es de ${numero}`);
  numero--;
}
```

## do-while

Muy similar al anterior con la diferencia que nos aseguramos a que al menos existe una ejecución

```javascript
numeroWhile = 10;
do {
  console.log(numeroWhile);
  numeroWhile--;
} while (numeroWhile >= 0);
```

Con los operadores time() y timeEnd() se puede comprobar cual es el tiempo que se tarda en ejecutar un bucle

## for

Sintaxis inicial identica a java

```javascript
for (let index = 0; index < 10; index++) {
  console.log(index);
}
```

Adicionalmente también se cuenta con un bucle foreach que se utiliza para recorrer arrays. Esta forma de aplicar el foreach conlleva la creación de lo que se conoce como función de flecha

```javascript
console.log("recorrido con foreach");

elementos = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
elementos.forEach((element) => {
  console.log(element);
});
```

También se cuanta con la posibilidad de aplicar un forIn y un forOf que se verá más adelante cuando hablemos de los arrays

## Arrays<a name="arrays"></a>

Para poder crear un array se puede realizar dándole un conjunto vacío de elementos, como un conjunto de elementos ya declarados o como un objeto compleja donde se le indica la longitud que tendrá

````javascript
       var coleccion= [];
       var coleccionConDatos = [1,2,3,4,5,6,7,8,9];
       var coleccionCompleja = new Array(10);
````

Dentro de un array se puede guardar cualquier tipo de dato, incluso mezclando los tipos. Como en JS el tipado es dinámico no es necesario identificar el tipo del array.

````javascript
	var arrayNumeros = [1, 2, 3, 4];
	var arrayPalabras = ["Hola", "que", "tal", "estas"]
	var arrayCosas = [1, "hola", 2, "que", false];
````

Para poder acceder a las posiciones de un array se utiliza el índice, teniendo en cuenta que siempre se empieza por 0

````javascript
        arrayNumeros = [1, 2, 3, 4];
        console.log(arrayNumeros[0]); // retornará el valor 1
        console.log(arrayNumeros[2]); // retornará el valor 2
````

Para poder modificar el valor de las posiciones se utiliza el indice y el operador de igualdad
````javascript
        arrayNumeros = [1, 2, 3, 4];
        arrayNumeros[0] = 5; // cambia el valor de 1 por el 5
        arrayNumeros[2] = 6; // cambia el valor de 3 por el 4
````

Dentro de las propiedades del array nos encontramos con una clave que nos servirá para multitud de operaciones:

- .length(): indica la cantidad de elementos que tiene el array

````javascript
        arrayNumeros = [1, 2, 3, 4];
        console.log(`El array tiene ${arrayNumeros.length}`);
````

Con esta longitud se puede recorrer el array de forma completa con un bucle for, iterando en cada una de las posiciones

````javascript
        console.log("Recorrer con un for");
        for (let index = 0; index < arrayNumeros.length; index++) {
            const element = arrayNumeros[index];
            console.log(element);

        }
````

Adicionalmente existe una forma más sencilla de recorrer mediante un foreach. Esta estructura aplica una función de flecha

````javascript
        console.log("Recorrer con un foreach");
        arrayNumeros.forEach(element => {
            console.log(element);
        });
````

Dentro del foreach, cada vez que se hace una iteración el elemento llamado element toma el valor del ítem en cuestión, pudiendo hacer con el lo que se necesite

Del mismo modo se podría buscar un elemento dentro de un array, tanto con el for como con el foreach

````javascript
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
````javascript
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
````javascript
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

````javascript
        arrayUno = [1, 2, 3, 4];
        arrayDos = [5, 6, 7, 8];
        arrayJuntar = arrayUno.concat(arrayDos);
        console.log(arrayJuntar.toString());
````

- .indexOf(): indica la posición de un elemento dado

````javascript
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

````javascript
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

# Funciones

Las funciones son todos aquellos métodos que se quieren ejecutar en determinadas partes de una aplicación web, pudiendo ser llamadas en cualquier momento lo que favorece la reutilización.

La estructura básica de una función es la siguiente: 

````javascript
        function name(params) {
            
        }
````

Del mismo modo una función también se puede asociar a una variable de la siguiente forma.

````javascript
	    var miFuncion = function name(params) {
            
        }
````

Así cuando la variable sea llamada se ejecutaría en contenido de la función. Para poder ejecutar una función de cualquiera de las maneras basta con llamarla, bien a la función directamente o a la variable

````javascript
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

````javascript
        function suma(operando1, operando2) {
            var suma = operando1 + operando2;
            console.log(`La suma de los dos parámetos pasados a la función es de: ${suma}`);
        }

        suma(2, 5);
````

Se pueden pasar tantos parámetros como sean necesarios. En el caso de pasar más valores por argumento que los declarados en la función no da error

````javascript
        function suma(operando1, operando2) {
            var suma = operando1 + operando2;
            console.log(`La suma de los dos parámetos pasados a la función es de: ${suma}`);
        }

        suma(2, 5, 5);
````

En el caso de pasar menos de los indicados pasa exactamente lo mismo, dando valores undefined a aquellos parámetros que no sean pasados, obteniendo como valor NaN (Not - a - Number)

````javascript
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
````javascript
        function parametorsOpcionales(parametroUno, parametroDos) {
            parametroDos = parametroDos || "valor por defecto";
            console.log(`Los parámetos pasados por funcion son ${parametroUno} y ${parametroDos}`);
        }

        parametorsOpcionales(1);
        parametorsOpcionales(1, "ejemplo");
````

B) Utilizando un if

````javascript
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

````javascript
function funcionDefecto(obligatorio, defecto = "defecto") {
  console.log(`${obligatorio} ${defecto}`);
}
````


- Uso de arguments o argumentos invisibles

En muchas ocasiones no es necesario pasar argumentos por una función, o no saber cuantos son necesarios. Para ello JS ofrece la posibilidad de utilizar el array arguments, ya incluido en todas las funciones. Con este array se puede acceder a los argumentos "adicionales" pasados en la llamada a la función. 

````javascript
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

- Valores de retorno

Cuando el llamamiento de una función requiere ademas de ejecutar todo su contenido, la devolución de algún valor se utiliza la palabra reservada return:

````javascript
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

````javascript
        var funcionAnonima = function(parametro) {
            console.log(`El parámetro de la función anónima es ${parametro}`);
        }

        funcionAnonima('Hola');
````

Ó 

````javascript
        function retornaFuncion() {
            return function () {
                console.log('Rotoranada una función anónima');
            }
        }
        retornaFuncion();
````

## Callbacks

Un callback no es un elemento propio del lenguaje, sino que se trata de una técnica de programación que permite la animación de funciones una vez estas han terminado de realizar una tarea. Imaginad el elemento de un proceso que tiene dos subprocesos, donde el segundo solo se puede ejecutar una vez haya terminado el primero. En programación esto se consigue utilizando la palabra return junto con la llamada a una función

````javascript
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

# Fetch

Un ejemplo típico de consumición de promesas son las funciones fetch, que no son más que promesas que ya están creadas en js y consumen un servicio web obteniendo un resultado o un error dependiendo de la respuesta que se obtenga del servidor. Una función fetch tiene la siguiente estructura:

````javascript
fetch("URL A CONSULTAR")
  .then((res) => {})
  .catch((rej) => {});
````
Como se puede ver es una promesa normal, con su tratamiento then y catch. La única diferencia es que se incorpora una url que es sobre la que se hace la consulta. En este ejemplo se utiliza la siguiente URL https://dummyjson.com/products , la cual contesta con una lista de productos en formato JSON. Para poder realizar la promesa y obtener el resultado utilizaríamos el siguiente código

```javascript
fetch("https://dummyjson.com/products")
  .then((res) => {
    console.log(res);
  })
  .catch((rej) => {
    console.log(`Ha habido algún tipo de fallo: ${rej}`);
  });
```

En este caso entraría la promesa por el then ya que se resuelve correctamente y la salida por consola sería la siguiente

````
Response {type: 'cors', url: 'https://dummyjson.com/products', redirected: false, status: 200, ok: true, …}
````

Es algo raro, ya que esperabamos en json. La respuesta es otra promesa, ya que por defecto toda promesa contesta con otra promesa, y es esta la que hay que tratar para poder obtener el json con el que se quiere trabajar. Para ello haríamos lo siguiente:

```javascript
fetch("https://dummyjson.com/products")
  .then((res) => {
    return res.json();
  })
  .then((res) => {
    console.log(res);
  })
  .catch((rej) => {
    console.log(`Ha habido algún tipo de fallo: ${rej}`);
  });
```

Como se puede ver, el segundo then es el que muestra el json de la url y para ello ha tenido que esperar a que el primer tratamiento de la promesa convirtiese la respuesta en json y lo pasase como resultado. Es importante ver el uso del return en el primer then. En el caso en el que cualquiera de los dos then hubiesen fallado el catch se hubiese ejecutado

# Objetos

Al igual que en cualquier lenguaje de programación orientado a objetos, se pueden crear dichos objetos para poder "almacenar dentro" una serie de características y acciones asociadas al mismo. Para ello existen dos formas de crear objetos. La primera es mediante el uso de la palabra reservada new

````javascript
var palabra = new String("ejemplo de objeto");
````

Pero también existe la posibilidad de declararlo en una notación json (javascript object notation). Esta notación no es más que una relación par clave - valor, donde se pueden identificar tantas características como se quiera. Para poder declarar un objeto con esta notación se utiliza los caracteres {} donde en su interior se definen los elementos:

````javascript
var nombre = {nombrePropiedad: "valor",nombreOtraPropiedad: "valor"}
````

Un ejemplo sería

````javascript
var objetoCreado = {nombre:"Borja",apellido:"Martín", edad: 18, carnet: true };
````

En este caso se crea un objeto que tiene las propiedades nombre, apellido, edad y carnet, donde cada una de las propiedades tiene un tipo de dato asociado. Una vez creado el objeto para poder acceder a sus propiedades se llama al nombre de la propiedad

````javascript
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

````javascript
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

````javascript
console.log(objetoCreado['nombre']);
````

Al igual que se ha creado el objeto con una cantidad determinada de propiedades y métodos, también es posible crear o eliminar la propiedad de forma dinámica. Para crear la propiedad basta con llamarla e igualarla un valor 

````javascript
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

````javascript
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

````javascript
console.log(Object.entries(objeto));
let parClaveValor = Object.entries(objeto);
parClaveValor.forEach((element) => {
  console.log(element[0]);
});
````

Algunas otras opciones del objeto son freeze, getOwnProperties, values 

## Relación objeto funciones

Como ya se ha visto antes en la parte de la declaración de funciones, estas pueden tener muchas formas tanto en parámetros como en retornos, y adicionalmente tienen una forma de comportarse especial cuando se trata de objetos. Alguna de estas formas son las siguientes

Cuando se quiere crear un objeto desde una función lo primero que se nos puede ocurrir es el siguiente código:

````javascript
function crearObjeto(param1, param2) {
  return { nombre: param1, apellido: param2 };
}

let objeto = crearObjeto("Borja", "Martin");
console.log(objeto);

````

Sin embargo esto no es del todo necesario siempre que se indique un parámetro que sea el nombre de la propiedad

````javascript
"use strict";

function crearObjeto(nombre, apellido) {
  return { nombre, apellido };
}
let objeto = crearObjeto("Borja", "Martin");
console.log(objeto);

````

Otra de las funciones que se permiten en la relación objeto - funciones es la de desectructurar un objetos. En el siguiente ejemplo se crea un método que saca determinadas propiedades

````javascript
function sacarPropiedades({ nombre, fundacion, estadio }) {
  console.log(nombre);
  console.log(fundacion);
  console.log(estadio);
}
````

Es importante darse cuenta que los parámetros que se le pasan no son normales, sino que son en formato objeto (por los {}). A continuación, si se quiere llamar al método, solo tendremos que pasarle un objeto que tenga las propiedades indicadas como parámetros

````javascript
let equipo = { nombre: "Barcelona", fundacion: 1890, estadio: "CampNou" };
sacarPropiedades(equipo);
````

En el caso de intentar llamarlo normal y corriente:

````javascript
sacarPropiedades("Barcelona", 123, "Camp Nou");

````

Daría un error de tipo undefined

````javascript
undefined
undefined
undefined
````

# Acceso al DOM y modificaciones

Se trata del modelo utilizado por el navegador para poder renderizar la página. Se puede asemejar a todo el código HTML escrito en cualquier editor que es interpretado y ejecutado por el propio navegador. Una de las capacidades más interesantes de JS es el acceso a este modelo y la posibilidad de su modificación de forma dinámica a tiempo real. En concreto, no solo es capaz de modificar, añadir o borrar los elementos del DOM, sino también agregar / modificar atributos, elementos CSS, así como reaccionar ante cualquier evento producido en la página

Como se ha dicho cuando hablamos de DOM, estamos hablando de todos los elementos presentes dentro del código de la página. Estos elementos reciben el nombre de nodos y se pueden clasificar en:

- Nodos de tipo elemento: aquellos que corresponden a una etiqueta HTML como p, h1, div, a, ul, form, etc..
- Nodos de tipo atributo: aquellos que hacen referencia a los atributos de los nodo elemento expuestos anteriormente. Por ejemplo un atributo href de un elemento a
- Nodos de tipo texto: el contenido textual de un nodo
- Nodos de tipo Document: la página completa
- Nodo de tipo comentario: los comentarios de la página


Imaginad el body de una página con la siguiente estructura
````html
<body>

    <h1>Titulo de JS impartido por Borja Martín</h1>
    <p>Titulo correspondiente al segundo curso de DAW del instituto CES Juan Pablo segundo de Formación profesional</p>
    <div id="mi_div"></div>
    <script>
    </script>
</body>
````

En este caso se renderizaría un título y un párrafo, quedando un div vacío. Este div vacío cuenta con un id, mediante la cual puede ser accedido el elemento desde el código js, de forma que se pueda poner cualquier cosa en su interior mediante programación. Si en el script asociado se utiliza el método getElementById() se puede acceder al elemento HTML con dicho id

````html
    <script>
        'use strict'
        let elementoDiv = document.getElementById('mi_div');
        console.log(elementoDiv);
    </script>
````

La salida por consola sería la propia etiqueta. Una vez capturada se puede por ejemplo acceder al código HTML incrustado en la etiqueta mediante la propiedad innerHTML o modificarlo igualando aun valor concreto.

Al igual que se puede modificar y/o acceder al contenido de la etiqueta encontrada, también se pueden hacer accesos y modificaciones de estilos, atributos, etc...Por ejemplo si se quiere cambiar el style de la etiqueta a uno que se haya creado en CSS sería tan sencillo como crear el estilo en css y aplicárselo a la etiqueta encontrada

````javascript
.estilo_js {
    background-color: burlywood;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    font-size: large;
}
````

Y el código HTML 

````html
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

````html
    <script>
        "use strict";

        function cambiarColor(color) {
            elementoDiv.style.backgroundColor = color;
        }

        let elementoDiv = document.getElementById("mi_div");

    </script>
````

Esta función puede ser llamada desde la consola o desde la pulsación de un elemento por ejemplo. 

````html
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

````html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>

  <body>
    <h1 id="titulo">Titulo JacaScript</h1>
    <p id="parrafo_general">
      La finalidad de este curso es sentar las bases del lenguaje de programación web JavaScrip de forma que se puedan hacer Aplicaciones web dinámicas
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

````html
    <script>
        var listaPorId = document.getElementById('lista_contenido');
        var listaPorTag = document.getElementsByTagName('ul');
        var listaPorClass = document.getElementsByClassName('class_lista');

        console.log(listaPorId);
        console.log(listaPorTag);
        console.log(listaPorClass);
    </script>
````

````javascript
<ul id="lista_contenido" class="class_lista">..</ul>
HTMLCollection [ul#lista_contenido.class_lista, lista_contenido: ul#lista_contenido.class_lista]
HTMLCollection [ul#lista_contenido.class_lista, lista_contenido: ul#lista_contenido.class_lista]
````

La diferencia reside en que el primer método (por Id devuelve el contenido íntegro), sin embargo los dos siguientes devuelve un HTMLCollection, por lo que en la mayoría de veces nos interesará este tipo, pasa así poder acceder a sus atributos internos

Imaginad que me interesa sacar llevar a js todos los elementos de una lista ul

````html
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

````html
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

````html
    <script>
        "use strict"
        let elementoPorClass = document.querySelector('.mi_parrafo');
        console.log(elementoPorClass);
        let elementoPorId = document.querySelector('#mi_div');
        console.log(elementoPorId);
    </script>
````


Mediante esta función se puede encontrar cualquier elemento, incluso si están anidados;

````html
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
````html
<div class="elemento_interno"></div>
````

Adicionalmente se puede realizar una query preguntando por todos aquellos elementos que tengan la clase elemento_interno_dos y que estén dentro de una etiqueta cuyo id sea mi_div:

````javascript
        let elementoAnidadoConcreto = document.querySelector('#mi_div .elemento_interno_dos');
        console.log(elementoAnidadoConcreto);
````

En este caso solo existe una coincidencia, pero en el caso de haber varias tan solo se devolvería la primera. Al igual que en casos anteriores se puede ejecutar una función que reciba por parámetros el elemento y modifique alguno de sus elementos

````javascript
        function modificarContenido(elemento) {
            elemento.innerHTML = 'modificaion'
        }
````

- querySelectorAll(): permite pasar un parámetro indicando tanto id como class o etiqueta en el mismo método, incluso anidando elementos. El método devuelve el todos los elementos que cumplan con los parámetros pasados, pudiendo recorrerlos y realizar tareas con ellos

Con el mismo body del ejemplo anterior

````html
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

````html
        <div class="elemento_interno"></div>
        <div class="elemento_interno_dos"></div>
````

Sobre los cuales se podría actuar. Hay que tener en cuenta que esta devolución es mediante una HTMLCollection, por lo que se realiza mediante las operaciones vistas con arrays

````javascript
        console.log(elementosComunes[0]);
        elementosComunes[0].innerHTML = 'Texto modificado del primero'
````

Si se quiere acceder a todos los elementos mediante una función:
````javascript
        function modificarTodosPorSelector(query) {

            let elementos = document.querySelectorAll(query);
            elementos.forEach(element => {
                console.log(element);
            });
        }
````

Imaginad ahora que se quiere agregar algún elemento a todos los divs que se ha devuelvo en la consulta del selector. Para ello, en cada uno de los elementos de la colección se crea un nuevo nodo y se agrega al existente

````javascript
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


# Eventos

Como se acaba de ver, una de las principales capacidades de JS es la capacidad de asociar una parte gráfica con una parte lógica. Cuando se está realizando una aplicación web, si solo nos centramos en los elementos gráficos (HTML y CSS), su apariencia quedará muy bien pero tendrá un contenido totalmente estático, de forma que ante cualquier cambio será necesario acceder al código y realizar las modificaciones necesarias. Esto es totalmente inviable en proyectos que requieran por ejemplo de una interacción media por parte del usuario . El ejemplo más claro de esto son los formularios o la forma de interactuar ante cualquier evento.

Imaginamos un formulario normal y corriente en HTML

````html
    <form id='formulario'>
        <input type="text" inputmode="latin">
        <button type="button">Pulsar para enviar</button>
    </form>
````

En el caso de querer controlar la pulsación del botón directamente, js nos ofrece la posibilidad de asociar una acción a un evento concreto del elemento. Para ello se le pone como atributo al button un onclick, el cual permite asociar una ejecución al elemento que lleva dicho atributo

````html
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

````html
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

````html
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

````html
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

````html
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

````html
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

````html
<body>

    <p id="parrafo_destino"></p>
    <button id='botonListener' type="button">Evento desde código</button>

</body>
````

Imaginad el HTML anterior donde existe un párrafo con un id determinado y un botón con otro id asociado. Mediante estos elementos se puede encontrar el elemento desde el código js

````html
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

````javascript
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

````javascript
    let elemento = document.querySelector('#botonListener');
    elemento.removeEventListener('click', cambiarColor);
````

Al igual que se ha definido en el ejemplo un evento de tipo click, se pueden asociar tantos como sean necesarios. De la misma forma, no es necesario declarar una función y ponerla en el listener, sino que se puede hacer directamente

````javascript
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

````javascript
    let boton = document
        .querySelector("#boton_evento_funcion")
        .addEventListener("click", function(event) {
            console.log(event);
        });
````

En este caso la función de callback recibe como parámetro un objeto que representa toda la información del evento producido: Si ejecutamos el código se puede ver que se muestran todos los parámetros que el evento produce, pudiendo acceder a cualquiera de ellos

Esta técnica se puede realiza con cualquier elemento. Por ejemplo si se quiere sacar la tecla pulsada en un input se puede utilizar la funcionalidad basada en un evento de tipo keyup

```javascript
    let input = document
        .querySelector("#input_funcion")
        .addEventListener("keyup", function(event) {
                console.log(event);
                console.log(String.fromCharCode(event.KeyCode));}
```


Cuando se trabaja con js el orden de carga es muy importante. Esto quiere decir que si nosotros ejecutamos un script antes de los elementos HTML (en el head por ejemplo) puede que muchos de los elementos que intervienen en el código no se encuentran al no haberse cargado

````html
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

````html
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

````html
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