class Coche {
  marca;
  modelo;
  matricula;
  cv;

  constructor(marca, modelo, matricula, cv) {
    this.marca = marca;
    this.modelo = modelo;
    this.matricula = matricula;
    this.cv = cv;
  }

  mostrarDatos() {
    console.log(
      `Marca: ${this.marca}\nModelo: ${this.modelo}\nMatricula: ${this.matricula}\nCV: ${this.cv}`
    );
  }

  set setMarca(marca) {
    this.marca = marca;
  }

  get getMarca() {
    return this.marca;
  }
}

/*let focus = new Coche("Ford", "Focus", "1234A", 100);
focus.mostrarDatos();
focus.setMarca = "FordCambiado";
focus.mostrarDatos();
console.log(focus.getMarca);*/
