/* // variables
// var-ambito general let-ambito de bloque const->final
// let nombre: Tipo = valor
let nombre: string = "Borja";
let edad: number = 40;
let acierto = false;
let cosa: any = true;
const DNI = "123123";
console.log(`Mi nombre es ${nombre}`);
 */

function mostrarDatos(tarea: string) {
  console.log(tarea);
}

function saludo(nombre: string, edad?: number): string {
  return `Hola ${nombre} tu edad es de ${edad}`;
}

function saludoDefecto(nombre: string, edad: number = 0): string {
  return `Hola ${nombre} tu edad es de ${edad}`;
}

function saludoMultiple(nombre: string, apellidos: string[]) {
  console.log(`Hola ${nombre} tus apellidos son ${apellidos}`);
}

function saludoMultiple2(nombre: string, ...apellidos: string[]) {
  console.log(`Hola ${nombre}`);
  console.log("Tus apellidos son");

  apellidos.forEach((item, index, array) => {
    console.log(item);
  });
}

/* console.log(saludo("Borja", 40));
console.log(saludo("Borja"));
console.log(saludoDefecto("Borja"));
console.log(saludoDefecto("Borja", 30)); */

// saludoMultiple("Borja", ["Martin", "Herrera", "Apellido"]);
saludoMultiple2("Borja", "Martin", "Herrera", "Apellido3", "Apellido4");
//mostrarDatos("Tarea para mostrar los datos");
