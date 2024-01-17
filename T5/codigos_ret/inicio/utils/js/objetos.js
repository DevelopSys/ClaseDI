let nombre = "BlackJack";

class Carta {
  representacion;
  valor;
  imagen;

  // public Carta(){}
  constructor(representacion) {
    this.representacion = representacion;
    this.valor = Number(representacion.substring(0, representacion.length - 1));
    this.imagen = `../images/${representacion}.png`;
  }

  get getValor() {
    return valor;
  }

  set setValor(valor) {
    this.valor = valor;
  }
}

class Jugador {
  nombre;
  puntos;

  constructor(nombre) {
    this.nombre = nombre;
    this.puntos = 0;
  }

  anadirPuntuacion(puntos) {
    this.puntos += puntos;
  }
}
