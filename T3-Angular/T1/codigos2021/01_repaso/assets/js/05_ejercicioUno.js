let obj1 = {
  nombre: "Valor correcto",
  apellido: "Apellido correcto",
  edad: 23,
  hobbies: ["Futbol", "Series", "Videojuegos", "Cine"],
};

let obj2 = {
  nombre: "Valor correcto",
  apellido: "Apellido",
  edad: 32,
  hobbies: ["Lectura", "Televisión"],
};

let usuarios = [obj1, obj2];

usuarios.forEach((element) => {
  if (element.nombre == "Valor correcto") {
    //console.log("elemento encontrado");
    element.hobbies.forEach((elementHobbie) => {
      console.log(elementHobbie);
    });

    console.log("Impresion realizada");
  }
});
