// tipado de variables
let nombre: string = "Borja";
let numero: number = 6;
let acierto: boolean = false;
let arrayDatos: string[] = ["asd", "asd", "asd"];
let arrayCosas: any[] = ["add", false, 3, "s"];
let arrayNumeros: number[] = [1, 2, 3, 4, 5];
let variableFuncion = () => {
  console.log("funcion ejecutada");
};

function funcionParametros(nombre: string, edad: number) {
  console.log(`${nombre} ${edad}`);
}

function funcionRetorno(
  opUno: number,
  opDos: number,
  operacion: string
): number {
  let resultado: number = 0;

  switch (operacion) {
    case "suma":
      resultado = opUno + opDos;
      break;
    case "resta":
      resultado = opUno - opDos;
      break;
    case "multi":
      resultado = opUno * opDos;
      break;
    case "div":
      resultado = opUno / opDos;
      break;
  }

  return resultado;
}

function funcionParamentrosMultiples(
  parametroObligatorio: boolean,
  ...paramMultiOpta: string[]
) {
  console.log(`Funcion ejecutada`);
  // si hay parametros multiples los imprime por consola: los parametros multiples son--------
  // si no hay parametros multiples imprieme: no hay multiples

  console.log(paramMultiOpta.length);
  if (paramMultiOpta.length > 0) {
    console.log("Hay parametros multiples");

    paramMultiOpta.forEach((element) => {
      console.log(element);
    });
  } else {
    console.log("No hay parametros multiples");
  }
}

function funcionParamentrosMultiplesTodos(
  paramUno: boolean,
  ...paramOptaMult: any[]
) {}

function funcionOptativos(nombre: string, edad: number, altura?: number) {
  // altura != undefined

  if (altura) {
    console.log(`${nombre} ${edad} ${altura}`);
  } else {
    console.log(`${nombre} ${edad}`);
  }
}

function funcionParametosDefecto(
  nombre: string,
  apellido: string,
  edad: number = 18
) {
  console.log(`${nombre} ${apellido} ${edad}`);
}

funcionParametosDefecto("Borja", "Martin", 36);
//funcionOptativos("Borja", 35, 170);
//console.log(`${nombre} ${numero}`);
//variableFuncion();
//funcionParametros("Borja", 23);
//funcionParametros(23, "Borja");
//funcionParametros();
console.log(
  `La suma de dos parametros ${funcionRetorno(4, 2, "suma")} y ${funcionRetorno(
    4,
    2,
    "multi"
  )} es ${funcionRetorno(4, 2, "suma") + funcionRetorno(4, 2, "multi")}`
);

/*funcionParamentrosMultiples(
  false,
  "kjghf",
  "asdasd",
  "asdasdasdasd",
  "wqeqweqwe",
  "tryrty"
);*/
//funcionParamentrosMultiples(false);

// condicion ? loquepasasiestrue : loqueasasiesfalse

//funcionParamentrosMultiples(false, 1, 2, 3, 4, 5, 6, 7);

interface alumno {
  nombre: string;
  apellido: string;
  edad: number;
  hobbies: [];
  caracteristicas: {};
  mostarDatos();
}

let alumnoUno = {
  nombre: "Borja",
  apellido: "Martin",
  edad: 30,
  hobbies: [],
  mostrarDatos: () => {},
};
