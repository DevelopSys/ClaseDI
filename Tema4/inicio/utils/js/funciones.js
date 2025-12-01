// nominales - flecha
// nominales -> function (parametros){}
function realizarCalculo(op1, op2) {
  console.log(`La suma de los dos parametros es ${op1 + op2}`);
}
function realizarCalculoRetorno(op1, op2) {
  return op1 + op2;
}

function realizarCalculoDefecto(op1, op2 = 7) {
  return op1 + op2;
}

function realizarCalculoFantasma(op1) {
  console.log("Calculo fantasma");
  console.log(op1 + " es parametro requerido");
  // arguments -> argumentos fantasma que son pasados adicionamente..[]
  console.log(`El numero de argumentos fantasma es de ${arguments.length}`);
  // hagais la suma de todos los argumentos que me pasan por parametros, indicando
  // cuantos son pasados y cuantos son fantasma
  // hay 4 arguemtnos, 3 fantasmas
  // la suma de todos es 10
  let suma = 0;
  arguments.forEach((element, index, data) => {
    suma += element;
  });
}

realizarCalculoFantasma(1, 2, 3, 4);
// console.log(`La suma con retorno y default es ${realizarCalculoDefecto()}`);
/* console.log(
  `el resultado de la operacion con retorno es: ${realizarCalculoRetorno(
    4,
    5
  )}`
); */
