// alert : feedback -> OK
// prompt : introducir datos --> input
// confirm : yes/no --> ¿?

let nombre = "Borja";
//alert(`Hola ${nombre}`);
let confirmacion = confirm("Estas seguro que quieres continuar");
if (confirmacion) {
  nombre = prompt("Por favor introduce tu nombre");
  if (!nombre) {
    alert("No tienes nombre");
  } else {
    alert(`Hola ${nombre} bienvenido a la aplicacion`);
  }
} else {
  alert(`Hasta luego`);
}
