/*let objetoInicial = {
  prop1: "valor",
  prop2: 123,
  prop3: false,
  prop4: ["uno", "dos", "tres"],
  prop5: { p1: "asd", p2: "dasdasdasdasd" },
};*/

class Jugador {
  nombre;
  apellido;
  posicion;

  constructor(nombre, apellido, posicion) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.posicion = posicion;
  }

  mostrarDatos() {
    console.log(`Nombre: ${this.nombre}
    Apellido: ${this.apellido}
    Posicion: ${this.posicion}
    `);
  }

  set setPosicion(posicion) {
    this.posicion = posicion;
  }

  get getPosicion() {
    return this.posicion;
  }
}

let jugadorUno = new Jugador("Messi", "Messi", "Delantero");
jugadorUno.setPosicion = "Medio";
jugadorUno.mostrarDatos();
console.log(`La posicion del jugador el ${jugadorUno.getPosicion}`);
