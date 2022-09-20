# POO

1. ¿Cuáles serían los atributos de la clase Ventana (de ordenador)? ¿cuáles serían los métodos? Piensa en las propiedades y en el comportamiento de una ventana de cualquier programa.

2. Crea la clase Vehiculo, así como las clases Bicicleta y Coche como subclases de la primera. Para la clase Vehiculo, crea los atributos de clase vehiculosCreados y kilometrosTotales, así como el atributo de instancia kilometrosRecorridos. Crea también algún método específico para cada una de las subclases. Prueba las clases creadas mediante un programa con un menú como el que se muestra a continuación:

```
VEHÍCULOS
1. Anda con la bicicleta
2. Haz el caballito con la bicicleta
3. Anda con el coche
4. Quema rueda con el coche
5. Ver kilometraje de la bicicleta
6. Ver kilometraje del coche
7. Ver kilometraje total
8. Salir
Elige una opción (1-8):
```



3. Crea la clase Pizza con los atributos y métodos necesarios. Sobre cada pizza se necesita saber el tamaño - mediana o familiar - el tipo - margarita, cuatro quesos o funghi - y su estado - pedida o servida. La clase debe almacenar información sobre el número total de pizzas que se han pedido y que se han servido. Siempre que se crea una pizza nueva, su estado es “pedida”. El siguiente código del programa principal debe dar la salida que se muestra:

```
public class PedidosPizza {
	public static void main(String[] args) {
		Pizza p1 = new Pizza("margarita", "mediana");
		Pizza p2 = new Pizza("funghi", "familiar"); p2.sirve();
		Pizza p3 = new Pizza("cuatro quesos", "mediana"); System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		p2.sirve();
		System.out.println("pedidas: " + Pizza.getTotalPedidas());
		System.out.println("servidas: " + Pizza.getTotalServidas());
	}
}

// SALIDA
pizza margarita mediana, pedida
pizza funghi familiar, servida
pizza cuatro quesos mediana, pedida
esa pizza ya se ha servido
pedidas: 3
servidas: 1

```

4. Queremos gestionar la venta de entradas (no numeradas) de Expocoches Campanillas que tiene 3 zonas, la sala principal con 1000 entradas disponibles, la zona de compra-venta con 200 entradas disponibles y la zona vip con 25 entradas disponibles. Hay que controlar que existen entradas antes de venderlas. El menú del programa debe ser el que se muestra a continuación. Cuando elegimos la opción 2, se nos debe preguntar para qué zona queremos las entradas y cuántas queremos. Lógicamente, el programa debe controlar que no se puedan vender más entradas de la cuenta.

```
1. Mostrar número de entradas libres
2. Vender entradas
3. Salir
Elige una opción (1-3):
```

5. Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el control de los artículos de un almacén. De cada artículo se debe saber el código, la descripción, el precio de compra, el precio de venta y el stock (número de unidades). El menú del programa debe tener, al menos, las siguientes opciones:

```
1. Listado
2. Alta
3. Baja
4. Modificación
5. Entrada de mercancía
6. Salida de mercancía
7. Salir
Elige una opción (1-7):
```

La entrada y salida de mercancía supone respectivamente el incremento y decremento de stock de un determinado artículo. Hay que controlar que no se pueda sacar más mercancía de la que hay en el almacén.

# Colecciones: Arraylist y Hashtable

1. Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un ArrayList y que luego calcule la suma, la media, el máximo y el mínimo de esos números. El tamaño de la lista también será aleatorio y podrá oscilar entre 10 y 20 elementos ambos inclusive.

2. Realiza un programa que escoja al azar 10 cartas de la baraja española (10 objetos de la clase Carta donde cada uno tiene valor y palo). Emplea un objeto de la clase ArrayList para almacenarlas y asegúrate de que no se repite ninguna.

3. Modifica el programa anterior de tal forma que las cartas se muestren ordenadas. Primero se ordenarán por palo: bastos, copas, espadas, oros. Cuando coincida el palo, se ordenará por número: as, 2, 3, 4, 5, 6, 7, sota, caballo, rey.

4. Implementa el control de acceso al área restringida de un programa. Se debe pedir un nombre de usuario y una contraseña. Si el usuario introduce los datos correctamente, el programa dirá “Ha accedido al área restringida”. El usuario tendrá un máximo de 3 oportunidades. Si se agotan las oportunidades el programa dirá “Lo siento, no tiene acceso al área restringida”. Los nombres de usuario con sus correspondientes contraseñas deben estar almacenados en una estructura de la clase HashTable. La funcionalidad del programa será la siguiente:

```
1. Registrar usuario
2. Buscar usuario
3. Listar usuario
4. Resetear contraseña
4. Acceder al sistema
5. Salir
```

5. Desarrollar una aplicación para el control de un garaje. El funcionamiento de la aplicación será desde consola mediante un menú que permita acceder a las diferentes opciones. Para la aplicación tendremos que tener en cuenta las siguientes cosas:
   Un coche está formado por los siguientes atributos: marca (string) modelo (string), coste (int), matricula (string). Las opciones de la aplicación serán las siguientes:

```
1. Añadirá un coche al taller, pidiéndome todos los datos necesarios
2. Listar coches
3. Buscar coches: Se pedirá una matrícula y se mostrarán los datos del coche.
4. Mostrar costes: Se mostrará el coste acumulado de todos los coches de la lista.
5. Eliminar coche: Se pedirá una matrícula y se eliminará el coche de la lista
6. Vaciar garaje: Eliminará todos los coches de la lista
```

6.  Crear una aplicación que sea capaz de gestionar elementos multimedia (Agregar, eliminar, buscar y listar elementos). Para ello se deben crear los siguientes tipos:

- Libros: con las características título, autor, año, código, edición, soporte digital y número de páginas
- Música: con las características título, autor, año, código, tipo formato, directo, duración
- Película: con las características titulo, autor, año, código, actores, país, duración
