export class Ingrediente {
  constructor(private nombre: string, private precio: number) {}

  get getNombre() {
    return this.nombre;
  }

  get getPrecio() {
    return this.precio;
  }
}

export class Pizza {
  constructor(
    private nombre: string,
    private precio: number,
    private ingredientes: Ingrediente[],
    private imagen: string
  ) {}

  get getIngredientes() {
    return this.ingredientes;
  }
}

export class Pedido {
  private lista: Ingrediente[] = [];
  private precio: number = 0;

  constructor(private nombre: string) {}

  addIngrediente(ingrediente: Ingrediente) {
    this.lista.push(ingrediente);
  }

  calcularPrecio() {
    this.lista.forEach((item) => {
      this.precio += item.getPrecio;
    });
  }
}
