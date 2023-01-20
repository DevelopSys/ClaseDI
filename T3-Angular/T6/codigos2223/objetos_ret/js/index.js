let persona = {
  nombre: "Borja",
  apellido: "Martin",
  edad: 18,
  correo: "bmartinh@gmail.om",
  asignaturas: [
    {
      nombre: "Desarrollo de interfaces",
      horas: 6,
      siglas: "DI",
      ciclo: "DAM2",
    },
    {
      nombre: "Programacion multimedia",
      horas: 6,
      siglas: "PMDM",
      ciclo: "DAM2",
    },
  ],
  mostrarDatos: function (cosa) {
    console.log(this.nombre);
    console.log(this.apellido);
    console.log(this.edad);
  },
};

persona.mostrarDatos(asdasd);
