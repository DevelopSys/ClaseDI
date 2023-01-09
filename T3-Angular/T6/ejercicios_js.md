1. (hobbies) Crear una aplicación web que tenga lo siguientes:
	- Objeto llamado obj1 con la siguiente estructura {nombre: "Valor correcto", apellido: "Apellido correcto", edad: 23, hobbies: ["Futbol","Series", "Videojuegos","Cine"]}
	- Objeto llamado obj2 con la siguiente estructura {nombre: "Valor", apellido: "Apellido", edad: 32, hobbies: ["Lectura", "Televisión"]}
	- Crear un array llamado usuarios, donde se guardan el obj1 y el obj2
	- Saca por consola todos aquellos hobbies del objeto cuyo nombre es Valor correcto
2. Crea tres arrays de jugadores (jugadoresMadrid, jugadoresBarsa, jugadoresAtleti). Realiza las siguientes operaciones:
	- Crea tres objetos llamados: Barsa, Madrid, Atleti. Cada uno de los objetos tendrá las siguientes propiedades: nombre, posición, plantilla
	- Crea una función que se llame addJugador y admita por parámetros nombre, posición, valor, equipo. La función agregará un objeto de tipo jugador a la propiedad jugadores del equipo seleccionado
	- Crea una variable llamada métodos, la cual tiene las siguientes propiedades - funciones (todas realizadas desde función de flecha):
		- listarEquipo: obtiene por parámetro un equipo y muestra sus datos
		- listarPlantilla: obtiene por parámetro un equipo y muestra los datos de todos sus jugadores 
	- Utiliza las funciones creadas en los puntos anteriores
3. Coge el siguiente link (https://www.thesportsdb.com/api/v1/json/2/eventsseason.php?id=4328&s=2019-2020
) y guarda todo el contenido del json en una variable llamada temporada1920 y realiza las siguientes acciones:
	- Crea una función que admita por parámetros el nombre de un equipo y muestre todos los partidos de la temporada de dicho equipo con el siguiente formato: Equipo1 X - Equipo2 X
	- Crea una función que admita por parámetros el nombre del equipo y muestre las alineaciones utilizadas en cada uno de los partidos con el siguiente formato: 
		- Partido 1 Equipo1 vs Equipo2 
		


4. Modificar el ejercicio anterior para que todos los datos sean cargados desde el link de classroom directamente, es decir ejecutando una función fetch
5. Modifica el ejercicio anterior para que:
	- Se cree un objeto de tipo partido con los siguientes datos
		- EquipoLocal, EquipoVisitante, GolesLocales, GolesVisitante, AlineacionLocal, AlineacionVisitante
		- Un método mostrarDatos con la estructura indicada en el ejercicio 3
	- Cada vez que se hace una lectura en la promesa de la función fetch se cree un objeto del tipo indicado anteriormente y se guarde en un array llamado partidos
	- Muestra el contenido de todos los equipos guardados en el array partidos, ejecutando el método mostrarDatos creado