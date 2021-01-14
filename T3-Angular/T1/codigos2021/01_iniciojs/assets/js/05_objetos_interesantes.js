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

//let palabra = prompt("Por favor introduce la palabra que quieres evaluar");
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
//if (palabra == "hola") {
//alert("has introducido algo correcto");
//  }
// Mostrar por pantalla el resultado de la expresión 5*5.
// Mostrar por pantalla el resultado de dos operandos pedidos cada uno por prompt.
/*let operandoUno = 5;
let operandoDos = 5;
alert(
  `El resultado de multiplicar ${operandoUno} y ${operandoDos} es ${
    operandoUno * operandoDos
  }`
);*/

/*let operacion = prompt("Que operacion quieres realizar");
if (operacion) {
  let operandoUno = parseInt(prompt("introduce el operando uno"));
  let operandoDos = parseInt(prompt("introduce el operando dos"));

  if (isNaN(operandoUno) || isNaN(operandoDos)) {
    alert("Alguno de los dos no es numero");
  } else {
    let resultado;
    switch (operacion) {
      case "suma":
        resultado = operandoUno + operandoDos;
        break;
      case "resta":
        resultado = operandoUno - operandoDos;
        break;
      case "multiplicacion":
        resultado = operandoUno * operandoDos;
        break;
      case "division":
        resultado = operandoUno / operandoDos;
        break;
      default:
        alert("operacion no reconocida");
        break;
    }
    alert(`El resultado de la ${operacion} es ${resultado}`);
  }
} else {
  alert("Por favor introduce algo");
}*/

/*
Pedir al usuario un frase y una letra en prompts diferentes. ("Borja es el profesor de DI" a)
Una vez metido esto saltará una alerta indicando si el nombre contiene la letra. (se contiene y hay 1 a y son 6 palabras y 21 letras) (no se contiene)
En caso de ser positivo también dirá el número de letras que tiene frase, el número de palabras que tiene la frase
En caso negativo indicará que no está contenida
*/

let frase = prompt("Por favor introduce una frase");
let letra = prompt("Por favor introduce una letra a buscar");
let contador = 0;
frase.split("").forEach((letraItem) => {
  if (letra.toLowerCase() == letraItem.toLowerCase()) {
    contador++;
  }
});
if (contador > 0) {
  let numeroPalabras = frase.split(" ").length;
  let numeroLetras = frase.replaceAll(" ", "").length;

  alert(
    `la letra está contenida \nHay ${contador} ${letra.toLowerCase()}-s\nHay ${numeroPalabras} palabras\nHay ${numeroLetras} letras`
  );
} else {
  alert("la letra no está contenida");
}
