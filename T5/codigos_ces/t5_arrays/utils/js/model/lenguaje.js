class Lenguaje {
  nombre;
  version;
  tecnologia;
  usos;
  dificultar;
  novedoso;

  constructor(nombre, version, tecnologia, usos, dificultad, novedoso) {
    this.nombre = nombre;
    this.version = version;
    this.tecnologia = tecnologia;
    this.usos = usos;
    this.dificultar = dificultad;
    this.novedoso = novedoso;
  }

  mostrarDatos() {
    console.log(`Nombre: ${this.nombre}`);
    console.log(`Version: ${this.version}`);
    console.log(`Tecnologia: ${this.tecnologia}`);
    console.log(`Dificultad: ${this.dificultar}`);
    console.log(`Novedoso: ${this.novedoso}`);
    console.log(`Usos: `);
    this.usos.forEach((element) => {
      console.log(`\t ${element}`);
    });
  }

  getVersion() {
    return this.version;
  }

  get getNombre() {
    return this.nombre;
  }

  set setNombre(nombre) {
    this.nombre = nombre;
  }
}
