class Carta {
  imagen;
  valor;
  palo;

  constructor(representacion) {
    this.representacion = representacion;
    if (isNaN(carta.substring(0, carta.length - 1))) {
      this.valor = 10;
    } else {
      this.valor = parseInt(carta.substring(0, carta.length - 1));
    }
    this.imagen = `${representacion}.png`;
    this.palo = carta.substring(carta.length - 1);
  }
}
