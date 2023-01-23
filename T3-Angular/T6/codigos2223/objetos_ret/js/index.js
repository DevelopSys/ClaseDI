// guardar en una variable llamada profesores [{[{}{}{}]}{}{}{}{}]
// todos los profesores de DAM (nombre, apellido, asignauras (nombre, ciclo, curso, horas))

let profesores = [
  {
    nombre: "Borja",
    apellido: "Martin",
    edad: 18,
    correo: "bmartinh@gmail.om",
    asignaturas: [
      {
        nombre: "Desarrollo de interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Programacion multimedia",
        horas: 6,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Alberto",
    apellido: "Fernandez",
    edad: 18,
    correo: "alberto.fernandez@gmail.om",
    asignaturas: [
      {
        nombre: "Acceso a datos",
        horas: 5,
        siglas: "AD",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Ferando",
    apellido: "Sanchez",
    edad: 24,
    correo: "fernando@gmail.om",
    asignaturas: [
      {
        nombre: "Programacion",
        horas: 8,
        siglas: "PRO",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Base datos",
        horas: 6,
        siglas: "BD",
        ciclo: "DAM",
        curso: 1,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Carlos",
    apellido: "Sanchez",
    edad: 28,
    correo: "carlos@gmail.om",
    asignaturas: [
      {
        nombre: "Entornos de Desarrollo",
        horas: 3,
        siglas: "ED",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Sistemas de Gestión empresarial",
        horas: 3,
        siglas: "SGE",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Manuel",
    apellido: "PErez",
    edad: 28,
    correo: "manuel@gmail.om",
    asignaturas: [
      {
        nombre: "Empresa e iniciativa emprendedora",
        horas: 3,
        siglas: "EIE",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
];

// CREAR UNA FUNCION PARA A BORJA DARLE UNA ASIGNATURA QUE {}

function agrerAsignatura(asignatura) {
  profesores[0].asignaturas.push(asignatura);
}

agrerAsignatura({
  nombre: "Asignatura nueva",
  horas: 5,
  siglas: "NUE",
  ciclo: "DAM",
  curso: 1,
});

profesores.forEach((item) => {
  item.asignaturas.some((i) => i.curso == 1) && item.mostrarDatos();
});
//console.log(profesores);
