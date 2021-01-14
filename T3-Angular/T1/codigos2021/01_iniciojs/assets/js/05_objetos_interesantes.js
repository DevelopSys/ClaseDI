// date --> fecha
let fecha = new Date();
console.log(fecha);
console.log(
  `el dia ${fecha.getDate()} el mes ${
    fecha.getMonth() + 1
  } el año ${fecha.getFullYear()}`
);

//fecha.setMonth(1);
console.log(fecha);

console.log(fecha.toUTCString());
console.log(fecha.toISOString());

let fechaFutura = new Date(2022, 1, 15);
console.log(fechaFutura);

//alert(`La fecha ${fecha} `);

let palabra = prompt("Por favor introduce la palabra que quieres evaluar");
//console.log(palabra);
//console.log(palabra.toLowerCase());
//console.log(palabra.toLocaleLowerCase());
//console.log(palabra.length);
//console.log(palabra.charAt(1));
//console.log(palabra.lastIndexOf("a"));
//palabra = palabra.trim();
//console.log(palabra);
//palabra = palabra.replaceAll(" ", "");
//console.log(palabra);
//console.log(palabra.split(""));
