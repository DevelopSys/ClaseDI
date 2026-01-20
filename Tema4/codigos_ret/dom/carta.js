class Carta {
  // atributos
  imagen;
  valor;
  representacion;
  // constructores
  constructor(representacion) {
    this.imagen = "./images/" + representacion + ".png";
    // 1C
    // 10T
    this.valor = representacion.substring(0, representacion.length - 1);
    this.representacion = representacion;
  }
  // metodos
  mostrarDatos() {
    console.log(this.imagen);
    console.log(this.valor);
    console.log(this.representacion);
  }

  setValor(valor) {
    this.valor = valor;
  }

  getValor() {
    return this.valor;
  }
}
