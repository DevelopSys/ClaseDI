class tarea {
  // atributos
  nombre;
  fecha;
  prioridad;
  // constructores -> 1
  constructor(nombre, fecha, prioridad) {
    this.nombre = nombre;
    this.fecha = fecha;
    this.prioridad = prioridad;
  }

  // metodos
  mostrarDatos() {
    console.log(`El nombre de la tarea es ${this.nombre}`);
    console.log(`La fecha de la tarea es ${this.fecha}`);
    console.log(`La prioridad de la tarea es ${this.prioridad}`);
  }
  // getter - setter
  get getNombre() {
    return this.nombre;
  }

  set setNombre(nombre) {
    this.nombre = nombre;
  }
}
