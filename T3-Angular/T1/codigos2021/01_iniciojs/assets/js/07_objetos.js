const objeto = {
  palabra: "valor",
  numero: 3,
  acierto: false,
  array: ["Nombre1", "Nombre2", "asdasd", "hgfjf", "utyuiyu", "sdghgretert"],
  objeto: { propUno: "p1", propDos: 2 },
};

/*objeto.palabra = "Nuevo Valor";
console.log(objeto.palabra);
objeto.array.forEach((element) => {
  console.log(element);
});

console.log(objeto.objeto.propDos);*/

objeto.nuevaCosa = "valor nuevo";

console.log(objeto);

/*

(hobbies) Crear una aplicación web que tenga lo siguientes:
Objeto llamado obj1 con la siguiente estructura {nombre: "Valor correcto", apellido: "Apellido correcto", edad: 23, hobbies: ["Futbol","Series", "Videojuegos","Cine"]}
Objeto llamado obj2 con la siguiente estructura {nombre: "Valor1", apellido: "Apellido", edad: 32, hobbies: ["Lectura", "Televisión"]}
Objeto llamado obj2 con la siguiente estructura {nombre: "Valor2", apellido: "Apellido", edad: 32, hobbies: ["Lectura", "Televisión"]}
Objeto llamado obj2 con la siguiente estructura {nombre: "Valor3", apellido: "Apellido", edad: 32, hobbies: ["Lectura", "Televisión"]}
Objeto llamado obj2 con la siguiente estructura 
{nombre: "Valor correcto", apellido: "Apellido", edad: 32, hobbies: ["Lectura", "Televisión"]}
Crear un array llamado usuarios, donde se guardan todos los objetos en el array
Saca por consola todos aquellos hobbies del objeto cuyo nombre es Valor correcto
*/

let usuarioUno = {
  nombre: "Valor correcto",
  apellido: "Apellido correcto",
  edad: 23,
  hobbies: ["Futbol", "Series", "Videojuegos", "Cine"],
};
let usuarioDos = {
  nombre: "Valor1",
  apellido: "Apellido",
  edad: 32,
  hobbies: ["Lectura", "Televisión"],
};
let usuarioTres = {
  nombre: "Valor2",
  apellido: "Apellido",
  edad: 32,
  hobbies: ["Lectura", "Televisión"],
};
let usuarioCuatro = {
  nombre: "Valor3",
  apellido: "Apellido",
  edad: 32,
  hobbies: ["Lectura", "Televisión"],
};
let usuarioCinco = {
  nombre: "Valor4",
  apellido: "Apellido",
  edad: 32,
  hobbies: ["Lectura", "Televisión"],
};
let usuarioSeis = {
  nombre: "Valor correcto",
  apellido: "Apellido correcto 2",
  edad: 45,
  hobbies: ["Lectura", "Televisión", "Teatro", "Baile"],
};

let arrayUsuarios = [
  usuarioUno,
  usuarioDos,
  usuarioTres,
  usuarioCinco,
  usuarioCuatro,
  usuarioSeis,
];

arrayUsuarios.forEach((element) => {
  if (element.nombre == "Valor correcto") {
    console.log(`Los hobbies del usuario ${element.nombre} son:`);
    element.hobbies.forEach((element) => {
      console.log(element);
    });
  }
});
arrayUsuarios.forEach(({ nombre, hobbies }) => {
  if (nombre == "Valor correcto") {
    console.log(`Los hobbies del usuario ${nombre} son:`);
    hobbies.forEach((element) => {
      console.log(element);
    });
  }
});

// Crea tres arrays de jugadores (jugadoresMadrid, jugadoresBarsa, jugadoresAtleti). Cada jugador tiene las siguientes propiedades; nombre, posicion, valor.

let jugadoresMadrid = [
  { nombre: "Hazard", posicion: "Delantero", valor: "10" },
  { nombre: "Vini", posicion: "Delantero", valor: "100" },
  { nombre: "Ramon", posicion: "Defensa", valor: "10" },
];

let equipoMadrid = {
  nombre: "Real MAdrid",
  estadio: "Bernabeu",
  plantilla: jugadoresMadrid,
};

// Crea tres objetos llamados: Barsa, Madrid, Atleti. Cada uno de los objetos tendrá las siguientes propiedades: nombre, estadio, plantilla
