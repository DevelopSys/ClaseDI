export class Jugador {
  nombre: string;
  equipo: string;
  posicion: string;
  imagen: string;

  constructor(name, club, position, img) {
    this.equipo = club;
    this.nombre = name;
    this.posicion = position;
    this.imagen = img;
  }

  mostrarDatos() {
    console.log(
      `Los datos del jugador son ${this.nombre} ${this.equipo} ${this.posicion}`
    );
  }

  public get getNombre(): string {
    return this.nombre;
  }
  public get getClub(): string {
    return this.equipo;
  }
  public get getPosicion(): string {
    return this.posicion;
  }
  public get getImagen(): string {
    return this.imagen;
  }
}
