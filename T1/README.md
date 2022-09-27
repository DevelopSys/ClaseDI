<a name="tema1"></a>

## POO Java

a. Sintaxis básica, variables, bucles

- http://www.developandsys.es/estructuras-control-java/
- http://www.developandsys.es/variables-java/
- http://www.developandsys.es/string-java/

#### [Volver al índice](#tema1)

---

b. Colecciones

- http://www.developandsys.es/arrays-java/
- http://www.developandsys.es/operaciones-con-array/
- http://www.developandsys.es/colecciones-dinamicas-arraylist/
- http://www.developandsys.es/colecciones-dinamicas-hashtable/

#### [Volver al índice](#tema1)

---

c. Clases y objetos

- http://www.developandsys.es/clases-y-objetos/
- http://www.developandsys.es/clases-abstractas/

#### [Volver al índice](#tema1)

---

d. Métodos, sobrecarga y sobreescritura

#### [Volver al índice](#tema1)

---

e. Herencia y Polimorfismo

#### [Volver al índice](#tema1)

---

f. Tratamiento de ficheros

- http://www.developandsys.es/ficheros-flujo-de-datos/

#### [Volver al índice](#tema1)

---

**Ejercicios clase**

Ejercicio 1

- Mostrar por consola la fecha y hora, personalizando el saludo dependiendo de la hora del día. El mensaje se repetirá hasta que se indique que no se quiere volver a consultar la hora. Para ello se deberá pedir el nombre al usuario nada más arrancar el programa y una vez pulsado Enter se mostrar el mensaje:

"Por favor introduce tu nombre: "

"Buenos días (tardes o noches) Luis, Son las 10:30 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" S

"Buenos días (tardes o noches) Luis, Son las 10:32 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" S

"Buenos días (tardes o noches) Luis, Son las 10:34 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" N

"Que tengas buen día"

- Crear un array de elementos de tipo integer con 50 posiciones. Crear un menú que tenga las siguientes opciones:
  - Rellenar: introducirá números de forma aleatoria (estarán comprendidos entre 1 y 200). En caso de que el array esté ya lleno pedirá confirmación.
  - Listar: mostrará por pantalla el contenido del array con la sintaxis: Elemento 1: X
  - Ordenar: ordenará el array con números de menos a mayor.
  - Vaciar: dejará el array vacío
  - Salir: terminará la ejecución del programa

* Modifica el ejercicio anterior para agregar al menú las siguientes opciones:
  - Buscar un elemento: pedir al usuairo un elemento a buscar y mostrar la posición en la que se enciuentra (el primero que se encuentre)
  - Sustituir elemento: pedirá el elemento que quieres sustituir y por el número que quieres sustituir (todos)
  - Calcular max y min
  - Quitar errores de array no relleno

Ejercicio 2

- Crea una aplicación que muestre por consola las tablas de multiplicar de los números entre el 1 y el 10. Esta salida deberá estar formateada de forma correcta.

- Crea una aplicación que permita las siguientes acciones:

  - Pedir por consola la longitud de un array de enteros.
  - Rellenar dicho array con números aleatorios entre el 0 y el 50
  - Indicar cuantos números pares e impares hay
  - Mostrar por consola el número más grande, número más pequeño, suma de todos los números y número medio.

Ejercicio 3

- Crear un juego de adivinación de números. Para ello, nada mas empezar el programa se generará un número aleatorio entre 1 y 100. El programa pedirá al usuario que introduzca números enteros hasta encontrar el correcto. Al finalizar indicará el número de intentos alcanzado. (Opcional: hacerlo iterativo, de forma que al terminar una adivinación pregunte si se quiere volver a intentar. Cada vez que se termina se indica el número de intentos medio, el número mínimo de intentos necesitados y si se ha superado el record)

Ejercicio 4

- Desarrollar un programa que gestione temperaturas máximas y mínimas, y el programa calcule los extremos. Para ello hay que utilizar una coleccion de tipo ArrayList Algunas consideraciones a tener en cuenta son:
  a. Para introducir temperaturas el programa me pedirá un dato doublé

b. Cuando me devuelva los extremos y la media, el programa me devolverá un dato double

c. Los datos deberán ser guardados de forma dinámica (con un ArrayList)

El menú mediante el cual se introducen los datos es el siguiente:

1. Introducir temperaturas
2. Mostrar temperaturas
3. Ordenar temperaturas
4. Mostrar extremos
5. Mostrar medias
6. Salir

Ejercicio 5

(**Para entregar**) Realiza un programa que simule el funcionamiento de un juego de cartas. Para ello la lógica será la siguiente:

    - Cada jugador se le repartes 10 cartas al azar la baraja española (10 objetos de la clase Carta donde cada uno tiene valor y palo que previamente tienen que estar barajadas).

    - Una vez los jugadores tienen todas las cartas se dan dos turnos de juego y cada jugador puede
        - Descartase de entre 1 y 3 cartas: selecciona el número de cartas (y cuales) y se le reparten cartas aleatorias
        - Robar al rival entre 1 y tres cartas
        - Pasar

    - Cuando se pasan los turnos se decidirá cual es el ganador:
        - Ganará aquel jugador que tenga más cartas del mismo palo ordenadas

Para el ejercicio tendrás que:

- Crear un arraylist y rellenarlo automáticamente
- Montar un menú para que pueda is dandose la mecánica del juego
- Ves mostrando las cartas de cada jugador, reparticiones, etc ... en todo momento

Ejercicio 6

**Para entregar**(Gasolinera) Crear una clase Surtidor que tenga los siguientes elementos:

- Atributo int (capacidadTotal) que represente los litros máximos de gasolina que admite
- Atributo int (capacidadActual) que represente los litros que tiene de gasolina cargados
- Atributo string que represente el tipo de gasolina que tiene
- Atributo boleado que represente si está o no funcionando el surtidor
- Constructor que pida por parámetros la capacidadTotal y el tipo de gasolina e inicialice los atributos.El atributo funcionamiento se iniciará funcionando a true y el atributo capacidadActual será igual que la capacidadTotal.
- Constructor que pida por parámetros el tipo de gasolina (y lo inicialice) y el resto de elementos los inicie por defeco.
- Un método arreglar que no pida parámetros, no retorne nada y modifique el valor de atributo funcionamiento a true
- Un método que rellenar que no devuelva nada y que admita por parámetros un int. El método agregará a la capacidadActual lo pasado por parámetros
- Un método quitarGasolina que reciba por parámetros un int. El método quitará del atributo capacidadTotal lo pasado por parámetros
- Los getter y setter correpondientes

Crear una clase Gasolinera que tenga los siguientes elementos:

- Un atributo de tipo string (nombre)
- Un atributo de tipo ArrayLista donde se guardarán los surtidores (lista)
- Un atributo de tipo int (ganancias)
- Un constructor que pida por parámetros un nombre y lo inicialice. El resto de atributos los inicializará por defecto.
- Un método que sea agregarSurtidor que admita por parámetros un surtidor y lo agrege a la lista de surtidores de la gasolinera
- Un método que sea obtenerGanancias que no reciba nada y que devuelva un int. El método retornará la variable ganancias
- Los getter y setter

Crear una clase Coche que tenga los siguientes elementos:

- Un atributo de tipo string (tipo de gasolina)
- Un atributo de tipo int (litrosDeposito)
- Un constructor que admita un argumento de tipo string y lo inicialice. Los litrosDeposito los iniciará a 0
- Un método que sea ponerGasolina que no devuelva nada y que admita por parámetros un objeto de tipo surtidor y un int con la cantidad de litros a repostar. La funcionalidad será la siguiente:
- El coche ejecutará el método quitarGasolina del surtidor
- Si el surtidor está vacío o intentas poner más gasolina de la que tiene el surtidor saltará un aviso
- Si el surtidor está averiado saltará un aviso
- Si el tipo de gasolina del coche es diferente al tipo de gasolina del surtidor saltará un aviso
- Si no se sumará a litrosDeposito lo que se ha reportado, y al surtidor se le restarán los litros

Crear una clase entrada que tenga:

- Crear tres surtidores. Dos con capacidad total y tipo de gasolina y uno con tipo de gasolina
- Crear una gasolinera.
- Agregar los tres surtidores a la gasolinera
- Crear un coche con tipo de gasolina
- Ejecutar el método ponerGasolina del coche (respotando una cantidad concreta).
- Prueba todas las combinación para comprobar los posibles fallos del método.

Ejercicio 7

**Para entregar** (IMC)
Crear una clase Persona que tenga las siguientes características:

- Tres atributos de tipo String nombre, DNI, sexo (H hombre, M mujer)
- Dos atributos de tipo double peso y altura.
- Un atributo de tipo int edad
- Un constructor por defecto, que inicialice todos los valores por defecto (aquellos que sean Complejos pondrá "defecto").
- Un constructor con el nombre, edad y sexo, el resto por defecto.
- Un constructor con todos los atributos como parámetro.
- Un método calcularIMC que no pida nada por parámetros y que devuelva un int. La funcionalidad del método será la siguiente
  calculará si la persona esta en su peso ideal (peso/(altura^2))
- si esta fórmula devuelve un valor menor que 20, la función devuelve un -1
- si devuelve un número entre 20 y 25 (incluidos), significa que esta por debajo de su peso ideal la función devuelve un 0
- si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1.
- Un método esMayorDeEdad que no admita parámetros y retorne un booleano. Si la persona es mayor igual que 18 retornará true, sino false
- toString: devuelve toda la información del objeto formateada en json
- getter y setter correpondientes

Crear una clase Entrada que tenga las siguientes características

- Pide por teclado el nombre, la edad, sexo, peso y altura.
- Crea 3 objetos de tipo persona
- el primer objeto obtendrá las anteriores variables pedidas por teclado
- el segundo objeto obtendrá todos los anteriores menos el peso y la altura
- el último por defecto, para este último utiliza los métodos set para darle a los atributos un valor.
- Para cada objeto, comprobar el imc mostrando un aviso para cada caso
- Estas en peso ideal, estas en sobrepeso o estás por debajo de peso

Por último, mostrar la información de cada objeto.

Ejercicio 8

- Crear una apliación que permita la gestion de usuarios de tipo Alumno. Para ello hay que tener en cuenta que debe existir un Alumno que tenga nombre (string), apellido (string), dni (string) y matrícula (int). Mediante un menú se podrán realizar las siguientes operaciones:

1. Agregar alumno
2. Buscar alumno
3. Borrar alumno
4. Listar alumnos
5. Listar dnis
6. Salir

En cada una de las opciones se pedirán los datos asociados a la opción. Hay que tener en cuenta que no puede haber dados de alta dos alumnos que tengan el mismo dni. Realizar la programación para que la matrícula se genere de forma automática y no esté ya introducida en el sistema

En todos los casos deben existir mensajes de confirmación tanto si la operación se ha llevado a cabo como si se ha producido algún fallo. Para la realización del problema utilizar una colección de tipo HashTable

Ejercicio 9

- Realizar una aplicación para la gestión de trabajadores. La aplicación podrá registrar trabajadores (asalariados y/o autónomos. Cada uno de los anteriores tiene las siguientes características:

1. Asalariados: nombre, apellido, dni, sueldo, número de pagas
2. Autónomo: nombre, apellido, dni, sueldo

La aplicación tendrá la capacidad de:

- Registrar un trabajador. Para ello preguntará si se quiere registrar un asalariado o un autónomo y pedirá los datos del trabajador
- Listar trabajadores. Para ello preguntará si se quiere listar los asalariados, los autónomos o todos
- Mostrar datos de trabajador. Para ello pedirá el DNI y mostrará el siguiente formato:

Si es asalariado:

- Nombre: XXX
- Apellido: XXX
- DNI: XXX
- Salario Anual: XXX
- Salario Mensual: XXX
- Número de Pagas: XX

Si es autónomo

- Nombre: XXX
- Apellido: XXX
- DNI: XXX
- Salario Anual: XXX

Utilizar la herencia y el polimorfismo para juntar el máximo de propiedades y métodos .

Ejercicio 10

- Crear una aplicación que sea capaz de gestionar elementos multimedia (Agregar, eliminar y listar elementos). Para ello se deben crear los siguientes tipos:

1. Libros: con las características título, autor, año, código, edición, soporte digital y número de páginas
2. Múscia: con las características título, autor, año, código, tipo formato, directo, duración
3. Película: con las caracteristivas titulo, autor, año, código, actores, país, duración

La aplicación permitirá:

1. Agregar elemento, dando la posibilidad a agregar libro, música o película. Se pedirán los datos del elemento seleccioando. Tan solo se podrá agregar un elemento siempre y cuando no está metido en la colección
2. Eliminiar elemento, teniendo en cuenta que solo se podrán eleminar elementos que estén en la colección
3. Listar elementos, dando la posibilidad de listar libros, música, películas o todos
4. Importar lista de elementos
5. Exportar lista de elementos

El formato de salida deberá mostrar todos los datos del elemento en cuestión

Ejercicio 11

Desarrollar una clase Coche que tenga las siguientes características:

- Atributo de tipo int que represente los caballos
- Atributo de tipo int que represente la velocidad
- Atributo de tipo String que represente la matricula
- Atributo de tipo String que represente el modelo
- Atributo de tipo double que represente los kilómetros recorridos
- Un constructor vacío que inicialice los cv a 0, la velocidad a 0, la matricula a 0000AAA, el modelo a "sin especificar" y los km a 0.0
- Un constructor con los siguientes parámetros: modelo, matrícula y cv. Se iniciarán los atributos a los parámetros pasados y el resto lo hará a los valores por defecto
- Un método acelerar que reciba como parámetros un argumento de tipo int, que no retorne nada y realice la siguiente funcionalidad:
- Incrementa la velocidad en la cantidad pasada por parámetros
- Incrementa los kilómetros en: velocidad * ((caballos)*número aleatorio entre 1 y 10)
- La velocidad máxima del coche es 180, en el caso de superarla se pondrá el valor 180 y se mostrará un mensaje por pantalla
- Un método frenar que reciba como parámetros un argumento de tipo int, que no retorne nada y realice la siguiente funcionalidad:
- Decrementa la velocidad en la cantidad pasada por parámetros
- La velocidad mínima del coche es 0, en el caso de superarla se pondrá el valor 0 y se mostrará un mensaje por pantalla
- Un método parar que no recibirá nada por parámetros y que no devuelva nada. Su funcionalidad será la siguiente:
- Pondrá la velocidad del cocha a 0
- Un método resetear que no reciba nada por parámetros y no devuelva nada. Su funcionalidad será la siguiente:
- Pondrá la velocidad del coche a 0 y los kilómetros a 0
- Un método mostrar datos que muestre por pantalla los datos del coche con el siguiente formato:
- Matrícula: XXX Modelo: XXX CV: XXX Velocidad: XXX Kilómetros: XXX
- Un método setter para cada uno de los atributos
- Un método getter para cada uno de los atributos

Desarrollar una clase Entrada que represente el punto de entrada de la aplicación. La funcionalidad de la aplicación será la siguiente

- Crear dos coches:
- (CocheA) Uno con el constructor por defectoç
- (CocheB) Uno pasando modelo, matricula y caballos
- Muestra por pantalla los datos de los dos coches
- Modifica los datos del CocheA y por
- Modelo, Matricula y CV
- Modifica la velocidad del CocheA en un número aleatorio entre 10 y 30
- Modifica la velocidad del CocheB en un número aleatorio entre 10 y 30
- Muestra por pantalla los datos de los dos coches
- Imprime por pantalla el siguiente mensaje, teniendo en cuenta que el coche ganador será el que más km haya recorrido
- El ganador es modelo matricula con km recorridos

(CarreraCompleta)
Modifica el ejercicio anterior para que en la clase entrada:

- Exista un atributo de tipo int que sea kilometrosEtapa iniciado a 10000
- El programa deberá realizar aceleraciones de los dos coches de forma sucesiva, mientras que ninguno de los dos haya llegado al valor de kilometrosEtapa (do while)
- Cuando uno de los dos coches haya llegado a los mostrará por pantalla el siguiente mensaje, teniendo en cuenta que el coche ganador será el que más km haya recorrido
- El ganador es modelo matricula con km recorridos
