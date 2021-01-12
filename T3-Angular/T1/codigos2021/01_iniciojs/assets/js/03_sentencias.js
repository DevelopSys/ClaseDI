console.log("sentencias de control");
let numeroUno = 9;
// if
if (numeroUno >= 0) {
  console.log("el número es positivo");
} else if (numeroUno > -5 && numeroUno < -1) {
  console.log("El numero no es positivo pero no es muy bajo ");
} else {
  console.log("El número es muy bajo");
}

// if ternario
// condicion? si_es_positivo : si_es_negativo
numeroUno > 0
  ? console.log("numero mayor que 0")
  : console.log("numero menor o igual a 0");

numeroUno > 20 && console.log("numero mayor que 20");

let opcion = 6;
switch (opcion) {
  case 1:
    console.log("caso 1");
    break;
  case 2:
    console.log("caso 2");
    break;
  case 3:
    console.log("caso 3");
    break;
  default:
    console.log("no vale nada de lo anterior");
    break;
}
