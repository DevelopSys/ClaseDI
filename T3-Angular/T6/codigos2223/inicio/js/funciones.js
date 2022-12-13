function ejemploFuncion() {
  console.log("Ejecucion de una funcion normal");
}

function funcionConParametros(paramentroUno, parametroDos) {
  console.log(`${paramentroUno} ${parametroDos}`);
}

function funcionArgumentosInvisibles() {
  console.log(arguments);
}

function funcionConRetorno(numeroUno, numeroDos) {
  return numeroUno + numeroDos;
}

function funcionSuma(p1, p2) {
  console.log(`La suma es ${p1 + p2}`);
}

function funcionMulti(p1, p2) {
  console.log(`La multi es ${p1 * p2}`);
}
function funcionDiv(p1, p2) {
  console.log(`La div es ${p1 / p2}`);
}

function funcionRetornoFuncion(param1, param2) {
  return funcionSuma(param1, param2);
}

function funcionParametrosFuncion(para1, para2, para3) {
  if (arguments.length == 4) {
    console.log(
      `Aqui utilizo el parametro adicional como quiera ${arguments[3]}`
    );
  }
  para1(para2, para3);
}

let variableAnonima = function (para1, para2) {
  console.log(`Paramentos pasados ${arguments.length}`);
  console.log(`${para1}`);
  console.log(`${para2}`);
};

function funcionConAnonima(para1, para2, para3) {
  para1(para2, para3);
}

// ejemploFuncion();
// funcionConParametros("Hola", false);
// funcionConParametros(["uno", "dos", "tres"], new Date());
// funcionConParametros("Uno parametro");
//funcionConParametros("uno", "dos","tres");
//funcionArgumentosInvisibles("uno", "dos", "tres", "cuatro");
//console.log(funcionConRetorno(4, 7));
//funcionRetornoFuncion(1, 4);
// funcionParametrosFuncion(funcionSuma, 5, 10);
//funcionParametrosFuncion(funcionMulti, 5, 10);
//funcionParametrosFuncion(funcionDiv, 5, 10, 18);
//variableAnonima(1, 2, "asasads");

funcionConAnonima(
  function (p1, p2) {
    console.log(`${p1 + p2}`);
  },
  5,
  10
);
//nombre de la funcion

let funcionLambda = (p1, p2, p3, p4) => console.log(`${arguments.length}`);

//funcionConAnonima((p1, p2) => console.log(`${p1 * p2}`), 5, 7);

//funcionConAnonima((p1, p2) => console.log(`${p1 * p2}`), 5, 7);
//funcionLambda(1);

setTimeout(() => console.log("Ejecucion postergada"), 2000);
setInterval(() => {
  console.log("Ejecucion intervalo");
}, 5000);
