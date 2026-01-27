export class usuario {
  // attri
  // const
  hobbies: string[];
  constructor(
    private nombre: string,
    private apellido: string,
    private edad: number,
  ) {
    this.hobbies = [];
  }
  // metodos -> para poder agregar un hobbie
  agregarHobbie(item: string) {
    this.hobbies.push(item);
  }

  getNombre(): string {
    return this.nombre;
  }
}
