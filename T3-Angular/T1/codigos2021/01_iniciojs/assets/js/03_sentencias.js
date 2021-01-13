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

numeroUno = 5;
while (numeroUno > 0) {
  console.log(`${numeroUno}`);
  numeroUno--;
}
numeroUno = 5;
do {
  console.log(`${numeroUno}`);
  numeroUno--;
} while (numeroUno > 0);

/*for(let inicio; finally; incremento){

}*/
let numeroFor = 5;
for (let index = 0; index < numeroFor; index++) {
  //const element = array[index];
  console.log(`Entrada en el for: ${index}`);
}

let arrayEquipo = ["Barcelona", "Madrid", "Atleti", "Sevilla", "Betis"];
console.log("Ejecucion del for");
for (let index = 0; index < arrayEquipo.length; index++) {
  console.log(`Equipo: ${arrayEquipo[index]}`);
}

console.log("Ejecucion del foreach");
/*
foreach(String item : arrayEquipos){

}
*/
// funcion flecha (paramentros)=>{}
arrayEquipo.forEach((element, index) => {
  console.log(`Equipo ${index}: ${element}`);
  //arrayEquipo[index] = "asdasdasd";
});

console.log("Ejecucion del for of");
for (const equipo of arrayEquipo) {
  console.log(`Equipo: ${equipo}`);
}

console.log("Ejecucion del for in");
for (const key in arrayEquipo) {
  console.log(key);
}
