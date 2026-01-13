console.log("Esto se lanza desde un fichero js");
// tipo let var const - nombre - valor
let nombre = "Borja"; // string
let edad = 41; // number - int / float
let altura = 1.71; // number - int / float
let asignaturas = []; // object - array
let experiencia = true; // boolean
let fechaNacimiento = new Date(); // object
let direccion; // undefined
let equipo = null; // object - null
// NaN -> Not a Number
// Mi nombre es Borja, tengo 41 años y mido 1.71
console.log("Mi nombre es " + nombre + " y tengo " + edad + " edad");
console.log(`Mi nombre es ${nombre} y tengo ${edad}, y mido ${altura} cm`);
console.log(`Mi nombre es ${nombre}`);

// alert(`Este es mi primer programa con JS, por cierto me llamo ${nombre}`); -> void
/* if (confirm("Estas seguro que quieres continuar")) { -> bool
  alert("Opcion seleccionada para continuar ");
} else {
  alert("Has seleccionado no continuar ");
} */
let nombreInput = prompt("Introduce tu nombre");
if (nombreInput != null && nombreInput.length > 0) {
  let respuesta = confirm(
    `Perfecto ${nombreInput}, ¿estas seguro que quieres continuar?`
  );
  if (respuesta) {
    alert("Has contestado que si");
  } else {
    alert("Has contestado que no");
  }
} else {
  alert("No has seleccionado nada");
}

const dni = "1234A";
if (true) {
  console.log(nombre);
  var apellido = null;
}
console.log("La edad es " + apellido);
console.log("El DNI es  " + dni);
