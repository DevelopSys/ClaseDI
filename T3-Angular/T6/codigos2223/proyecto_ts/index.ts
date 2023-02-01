class alumno {
  constructor(
    private nombre: String,
    private apellido: String,
    private correo: String
  ) {}

  mostrarDatos() {}

  public set value(v: string) {
    this.nombre = v;
  }
}

// interfaz -> constantes / metodos no definidos (firma) --> creacion de objetos

interface alumnoInterfaz {
  nombre: String;
  apellido: String;
  correo: String;
  telefono: Number;
}

let alumno1 = new alumno("Borja", "Martin", "correo@correo.com");
let alumno2: alumnoInterfaz = {
  nombre: "Ejemplo",
  apellido: "Ejemplo",
  correo: "asdadasd",
  telefono: 123123,
};

alumno2.nombre;

// any --> Object
//function funcionNormal(param1: Number, param2: Number): {};
function optativo(p1: String, p2: String, p3?: Number) {
  console.log(p1);
  console.log(p2);
  if (p3) {
    console.log(p3);
  }
}

function defecto(p1: String, p2: String, p3: Number = 2) {
  console.log(p1);
  console.log(p2);
  console.log(p3);
}

function multiples(p1: String, p2: String, p3: String, ...p4: any[]) {
  console.log(p1);
  console.log(p2);
  console.log(p3);
  console.log(p4);
}

// 8
// 4
// 9
multiples("uno", "dos", "tres");
