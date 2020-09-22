1. ¿Cuáles serían los atributos de la clase Ventana (de ordenador)? ¿cuáles serían los métodos? Piensa en las propiedades y en el comportamiento de una ventana de cualquier programa.


2. Crea la clase Vehiculo, así como las clases Bicicleta y Coche como subclases de la primera. Para la clase Vehiculo, crea los atributos de clase vehiculosCreados y kilometrosTotales, así como el atributo de instancia kilometrosRecorridos. Crea también algún método específico para cada una de las subclases. Prueba las clases creadas mediante un programa con un menú como el que se muestra a continuación:

VEHÍCULOS
- 1 Anda con la bicicleta
- 2 Haz el caballito con la bicicleta 
- 3 Anda con el coche
- 4 Quema rueda con el coche
- 5 Ver kilometraje de la bicicleta 
- 6 Ver kilometraje del coche
- 7 Ver kilometraje total
- 8 Salir
Elige una opción (1-8):


3. Crea la clase Pizza con los atributos y métodos necesarios. Sobre cada pizza se necesita saber el tamaño - mediana o familiar - el tipo - margarita, cuatro quesos o funghi - y su estado - pedida o servida. La clase debe almacenar información sobre el número total de pizzas que se han pedido y que se han servido. Siempre que se crea una pizza nueva, su estado es “pedida”. El siguiente código del programa principal debe dar la salida que se muestra:

````
public class PedidosPizza {
	public static void main(String[] args) {
		Pizza p1 = new Pizza("margarita", "mediana"); Pizza p2 = new Pizza("funghi", "familiar"); p2.sirve();
		Pizza p3 = new Pizza("cuatro quesos", "mediana"); System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		p2.sirve();
		System.out.println("pedidas: " + Pizza.getTotalPedidas()); System.out.println("servidas: " + Pizza.getTotalServidas());
	}	 
}

// SALIDA
pizza margarita mediana, pedida
pizza funghi familiar, servida
pizza cuatro quesos mediana, pedida
esa pizza ya se ha servido
pedidas: 3
servidas: 1

````


4. Queremos gestionar la venta de entradas (no numeradas) de Expocoches Campanillas que tiene 3 zonas, la sala principal con 1000 entradas disponibles, la zona de compra-venta con 200 entradas disponibles y la zona vip con 25 entradas disponibles. Hay que controlar que existen entradas antes de venderlas.


5. Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el control de los artículos de un almacén. De cada artículo se debe saber el código, la descripción, el precio de compra, el precio de venta y el stock (número de unidades). El menú del programa debe tener, al menos, las siguientes opciones:

- 1 Listado
- 2 Alta
- 3 Baja
- 4 Modificación
- 5 Entrada de mercancía 
- 6 Salida de mercancía 
- 7 Salir

La entrada y salida de mercancía supone respectivamente el incremento y decremento de stock de un determinado artículo. Hay que controlar que no se pueda sacar más mercancía de la que hay en el almacén.




