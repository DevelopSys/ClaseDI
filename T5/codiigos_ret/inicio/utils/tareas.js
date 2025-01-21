class Tarea {
  constructor(titulo, prioridad, completada) {
    this.titulo = titulo;
    this.prioridad = prioridad;
    this.completada = completada;
  }

  mostrarDatos() {
    console.log(`Titulo: ${this.titulo}`);
    console.log(`Prioriordad: ${this.prioridad}`);
    console.log(`Completada: ${this.completada}`);
  }

  get getPrioridad() {
    return this.prioridad;
  }
  set setPrioridad(val) {
    this.prioridad = val;
  }
}

// extends implements
class TareaOcio extends Tarea {
  constructor(titulo, prioridad, completada, lugar) {
    super(titulo, prioridad, completada);
    this.lugar = lugar;
  }

  mostrarDatos() {
    super.mostrarDatos();
    console.log(`Lugar: ${this.lugar}`);
  }

  get getLugar() {
    return this.lugar;
  }

  set setLugar(lugar) {
    this.lugar = lugar;
  }
}

class TareaTrabajo extends Tarea {
  constructor(titulo, prioridad, completada, presupuesto) {
    super(titulo, prioridad, completada);
    this.presupuesto = presupuesto;
    console.log("Argumentos invisibles");
    console.log(arguments);
  }

  get getPresupuesto() {
    return this.presupuesto;
  }

  set setPresupuesto(val) {
    this.presupuesto = val;
  }

  mostrarDatos() {
    super.mostrarDatos();
    console.log(`Presupuesto ${this.presupuesto}`);
  }
}
