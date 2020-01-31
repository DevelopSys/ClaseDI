class Alumno {
  private nombre: string;
  private apellido: string;
  private edad: number;

  constructor(nombre: string, apellido: string, edad: number) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
  }

  getNombre(): string {
    return this.nombre;
  }

  getApellido(): string {
    return this.apellido;
  }

  getEdad(): number {
    return this.edad;
  }

}

let miAlumno:Alumno = new Alumno('Borja','Martin',123);
console.log(miAlumno.getApellido());
