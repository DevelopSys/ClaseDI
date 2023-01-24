class jugador {
  nombre;
  posicion;
  valor;
  constructor(nombre, posicion, valor) {
    this.nombre = nombre;
    this.posicion = posicion;
    this.valor = valor;
  }

  mostrarDatos() {
    console.log(`Nombre: ${this.nombre}`);
    console.log(`Posicion: ${this.posicion}`);
    console.log(`Valor: ${this.valor}`);
  }
}
