let alumnos = [

  new alumno("nombre","apellido",12,"sexo"),
  { nombre: "Borja", apellido: "Martin", edad: 20, sexo: "masculino" },
  { nombre: "Luis", apellido: "Martin", edad: 23, sexo: "masculino" },
  { nombre: "Marta", apellido: "Martin", edad: 43, sexo: "femenino" },
  { nombre: "Celia", apellido: "Martin", edad: 19, sexo: "femenino" },
  { nombre: "Pedro", apellido: "Martin", edad: 32, sexo: "masculino" },
  { nombre: "Jose", apellido: "Martin", edad: 62, sexo: "masculino" },
  { nombre: "Rebeca", apellido: "Martin", edad: 23, sexo: "femenino" }
];

alumnos.push({
  nombre: "Julia",
  apellido: "Martin",
  edad: 23,
  sexo: "femenino",
  nacionalidad: "Española",
});

console.log("Todos los alumnos");
console.log(alumnos);

alumnos[0].mostrarDatos();
alumnos[0].setNombre = "Nuevo";
alumnos[0].getNombre;

let alumnosFiltrados = [];

// solo esten los alumnos que son masculinos

/*alumnos.forEach(element => {
    if (element.sexo == "femenino"){
        alumnosFiltrados.push(element)
    }
});*/

function filtrarDatos(sexo) {
  alumnosFiltrados = alumnos.filter((element) => {
    return element.sexo == sexo;
  });
  console.log(alumnosFiltrados);
}

console.log("Los alumnos masculinos son");
filtrarDatos("masculino");

console.log("Los alumnos femeninos son");
filtrarDatos("femenino");
