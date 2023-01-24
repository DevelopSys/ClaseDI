class equipo {
  nombre;
  plantilla;
  presupuesto;

  constructor(nombre, presupuesto) {
    this.nombre = nombre;
    this.presupuesto = presupuesto;
    this.plantilla = [];
  }

  addJugador(jugador) {
    if (this.presupuesto > jugador.valor) {
      this.plantilla.push(jugador);
      this.presupuesto -= jugador.valor;
    } else {
      alert(
        `${jugador.nombre} no se puede inscribir porque el ${this.nombre} no tiene saldo`
      );
    }
  }

  listaPlantilla() {
    this.plantilla.forEach((item) => {
      item.mostrarDatos();
    });
  }

  listarPosicion(posicion) {
    this.plantilla.forEach((element) => {
      element.posicion == posicion && element.mostrarDatos();
    });
  }
}
