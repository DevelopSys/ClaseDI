let ejemploObjeto = new ClaseEjemplo("p1", "p2", ["p3"]);
ejemploObjeto.mostrarDatos();

// una clase que represente una nota
/* una nota tiene un titulo,
 tiene una fecha, 
 tiene una descripcion,
tiene un completada ?, 
conjunto de tareas
  
  set y get
  agregar una tarea dentro de la nota
  muestre todas las tareas pendientes de la nota
muestre todas las tareas completas de la nota
  
  */

// nota: realizar practica de di
// titulo: practica di
// fecha: 22/12/2022 --> DATE
// completada: false
// descripcion: realizacion de una clase js para hacer una app de notas
// tareas: [ ("hacer una clase",boolean), ("hacer unos metodos",boolean)]

class Tarea {
  titulo;
  completa;
  constructor(titulo) {
    this.titulo = titulo;
    this.completa = false;
  }

  set setCompleta(completa) {
    this.completa = completa;
  }
}

class Nota {
  titulo;
  descripcion;
  tareas;
  fecha;
  completa;

  constructor(titulo, descripcion, fecha) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.fecha = fecha;
    this.tareas = [];
    this.completa = false;
  }

  agregarTarea(tarea) {
    // [t1,t2,t3,t4] --> [t1,t4]
    // la lista de tareas que tienen el titulo igual que la tarea que intento agregar
    /*this.tareas.filter((item) => item.titulo == tarea.titulo).length > 0
      ? console.log("No se puede añadir, ya existe")
      : this.tareas.push(tarea);*/

    this.tareas.some((item) => item.titulo == tarea.titulo)
      ? console.log("No se puede añadir, ya existe")
      : this.tareas.push(tarea);

    /*
    if (this.tareas.some((item) => item.titulo == tarea.titulo)) {
      console.log("No se puede añadir, ya existe");
    } else {
      this.tareas.push(tarea);
    }
    */

    // cuando no exista (el titulo) dentro de la lista
  }

  completarNota() {
    // cuando todas las tareas están completas
    /* let completas = 0;
    this.tareas.forEach((item) => {
      if (item.completa) {
        completas++;
      }
    });
    if (completas == this.tareas.length) {
      this.completa = true;
    } */
    /* if (this.tareas.filter(item => { return item.completa }).length == this.tareas.length) {
      this.completa = true
    } */

    this.tareas.some((item) => !item.completa)
      ? console.log("No se pude completar")
      : (this.completa = true);
  }

  completarTarea(titulo) {
    // buscar la tarea que cumple la condicion
    // foreach - for
    /*this.tareas.forEach((item) => {
      if (item.titulo == titulo) {
        item.completa = true;
      }
    });*/
    this.tareas.find((item) => item.titulo == titulo).completa = true;
    completarNota();
  }

  tareasPendientes() {
    this.tareas.forEach((item) => {
      if (!item.completa) {
        console.log(item.titulo);
      }
    });
  }

  tareasCompletas() {
    this.tareas
      .filter((item) => {
        return item.completa;
      })
      .forEach((item) => {
        console.log(item.titulo);
      });
  }

  listarTareas() {
    this.tareas.forEach((item) => {
      console.log(item.titulo);
      console.log(item.completa);
    });
  }

  get getTitulo() {
    return this.titulo;
  }
  get getDescripcion() {
    return this.descripcion;
  }
  get getFecha() {
    return this.fecha;
  }
  get getTareas() {
    return this.tareas;
  }
  get getCompleta() {
    return this.completa;
  }

  set setDescripcion(descripcion) {
    this.descripcion = descripcion;
  }
}

let notaUno = new Nota(
  "Nota ejemplo",
  "Esta nota es un ejemplo para hacer el ejercicio",
  new Date()
);

// completa = false
// tareas = []

notaUno.agregarTarea(new Tarea("Tarea 1"));
notaUno.agregarTarea(new Tarea("Tarea 2"));
notaUno.agregarTarea(new Tarea("Tarea 3"));
notaUno.agregarTarea(new Tarea("Tarea 4"));

notaUno.completarTarea("Tarea 1");

//notaUno.completarTarea("Tarea 3");

// poner la restriccion para que no puedan existir tareas con el mismo nombre
// crear un método en la nota para poder completar la tarea que le pase por
// parametros

// marcarCompleta() --> marcara como completa una nota si todas las tareas
// estan completas

notaUno.listarTareas();
//notaUno.tareasCompletas();
