// public void nombre(parametros){
//  ejecuciones
//}

function funcionInicial() {
  console.log("Funcion inicial del repaso de JS");
}

function funcionParametros(parametro1, parametro2) {
  /*console.log(parametro1);
  console.log(parametro2);*/
  /*console.log(`La suma de los dos parámetos es ${parametro1 + parametro2}`);
  if (arguments[2]) {
    console.log(`Tengo parémtro adicional que es ${arguments[2]}`);
  }*/
  /*for (let index = 0; index < arguments.length; index++) {
    const element = arguments[index];
    console.log(element);
  }*/

  /*console.log(`paramentro1 ${parametro1}`);
  console.log(`paramentro2 ${parametro2}`);
  console.log(`parametro adicional ${arguments[3]}`);
  console.log(`parametro paramentro1 desde arguments ${arguments[0]}`);*/

  if (arguments[1] === 23) {
    console.log(arguments[1]);
  }
}

function funcionParametrosDefecto(parametro1, parametro2) {
  if (typeof parametro2 == "undefined") {
    parametro2 = "por defecto";
  }
  console.log(`${parametro1}`);
  console.log(`${parametro2}`);
}

function funcionConRetorno(parametro1 = 0, perametro2 = 0) {
  return parametro1 + perametro2;
}

let variableFuncion = function (p1, p2, p3) {
  console.log(`${p1}`);
  console.log(`${p2}`);
  console.log(`${p3}`);
};

let variableFuncionFlecha = () => console.log("llamada a la funcion de flecha");
let variableFuncionFlechaAdicional = (p1, p2) => {
  console.log(`${p1}`);
  console.log(`${p2}`);
};
let variableFuncionFlechaRetorno = (p1, p2) => p1 + p2;
let variableFuncionFlechaRetornoAdicional = (p1, p2) => {
  return p1 + p2;
};

function funcionConCallback(param1, param2, param3) {
  console.log(
    `El resultado de sumar ${param1} y ${param2} es ${param3(param1, param2)}`
  );
}

function funcionCallbackRetorno(param1, param2) {
  return (param1, param2) => {
    console.log(`la suma de los dos parametros es ${param1 + param2}`);
  };
}

//funcionInicial();
//funcionParametros();
//funcionParametros(1, 4);
//funcionParametros(1, "asdasdazsdasdas");
//funcionParametros(1, "qew", 2);
//funcionParametros(1, 23, 45, false, true, 5.6);
//funcionParametrosDefecto("hola", "ASDASDASD");
//let suma = funcionConRetorno(4, 7);
//console.log(suma);
//variableFuncion(1, 2, 3);
//variableFuncionFlecha();
//variableFuncionFlechaAdicional(3, "asd");
//let suma = variableFuncionFlechaRetorno(2, 6);
//console.log(suma);
//let suma = variableFuncionFlechaRetornoAdicional(4, 7);
//console.log(suma);

funcionConCallback(1, 5, (param1, param2) => {
  let suma = param1 + param2;
  return suma;
});
