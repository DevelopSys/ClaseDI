export class Usuario {
  constructor(
    private nombre: string,
    private apellido: string,
    private correo: string,
    private profesion: string
  ) {}

  get getNombre() {
    return this.nombre;
  }

  set setNombre(dato: string) {
    this.nombre = dato;
  }

  /* tantos metodos como quiera */
}
