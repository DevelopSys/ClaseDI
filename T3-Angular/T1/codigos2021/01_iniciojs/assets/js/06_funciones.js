function primeraFuncion() {
  console.log("Ejecución de la primera función");
}

let funcionAnonima = function () {
  console.log("Esto es una ejecución desde función anónima");
};

let funcionFlecha = () => {
  console.log("Ejecución desde función de flecha");
};

function funcionParametros(parametroUno, parametroDos, parametroTres) {
  console.log(`${parametroUno} ${parametroDos} ${parametroTres}`);
}

function funcionParamentrosArguments() {
  console.log("La función se ha ejecutado");
  if (arguments.length > 0) {
    for (let index = 0; index < arguments.length; index++) {
      const element = arguments[index];
      console.log(element);
    }
  }
}

function funcionPorDefecto(parametroUno, parametroDos = 0) {
  console.log(`La suma de las dos cosas es ${parametroUno + parametroDos} `);
}

function funcionRetorno(parametroUno = 10, parametroDos = 0) {
  let resultado = parametroUno + parametroDos;
  return resultado;
}

let funcionFlechaParam = (param1, param2) => {
  return 6;
};

primeraFuncion();
funcionAnonima();
funcionParametros(1, "Hola", false);
funcionParametros(1, "Hola", false, 34, 34, 123, 123, false);
funcionParamentrosArguments("parametro1", "parametro2", 3, false);
funcionPorDefecto(1, 7);
console.log(funcionRetorno(15, 9));
//funcionFlechaParam(2, 3);
console.log(funcionFlechaParam(123, 123));
