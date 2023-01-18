/* let fecha = new Date();
let palabra = new String("ejemplo");
let cosas = [];
 */
class Persona {
  nombre;
  apellido;
  correo;
  edad;

  constructor(nombre, apellido, correo, edad) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.edad = edad;
  }

  // function nombre(){}
  mostrarDatos() {
    console.log(`Nombre: ${this.nombre}`);
    console.log(`Apellido: ${this.apellido}`);
    console.log(`Edad: ${this.edad}`);
    console.log(`Correo: ${this.correo}`);
  }

  get getNombre() {
    return this.nombre;
  }

  get getApellido() {
    return this.apellido;
  }

  set setApellido(apellido) {
    this.apellido = apellido;
  }
}

class Trabajador extends Persona {
  salario;
  pagas;

  constructor(nombre, apellido, correo, edad, salario, pagas) {
    super(nombre, apellido, correo, edad);
    this.salario = salario;
    this.pagas = pagas;
  }

  mostrarDatos() {
    super.mostrarDatos();
    console.log(`Salario: ${this.salario}`);
    console.log(`Pagas: ${this.pagas}`);
  }

  calcularNetoMes(retencion = 0.02) {
    let brutoMes = this.salario / this.pagas;
    let netoMes = brutoMes - brutoMes * retencion;
    console.log(netoMes);
  }
}

let personaUno = new Persona("borja", "martin", "correo@correo.es", 23);
let trabajadorUno = new Trabajador(
  "trabajador",
  "apellido",
  "correo",
  29,
  40000,
  14
);
trabajadorUno.mostrarDatos();
trabajadorUno.calcularNetoMes(0.2);
