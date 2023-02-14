class alumno {
  constructor(private nombre, private apellido, private dni) {}
  mostrarDatos() {
    console.log(`Nombre: ${this.nombre}`);
    console.log(`Apellido: ${this.apellido}`);
    console.log(`DNI: ${this.dni}`);
  }

  get getNombre(): string {
    return this.nombre;
  }
}

interface interfazAlumno {
  nombre: string;
  apellido: string;
  dni: string;
}

let alumnoObjeto: alumno = new alumno("Borja", "Martin", "123123A");
let alumnoIntefaz: interfazAlumno = {
  nombre: "Borja",
  apellido: "Martin",
  dni: "123123A",
};

let alumnos: alumno[] = [];
alumnos.push(alumnoObjeto);

//alumnoObjeto.mostrarDatos();
//console.log(alumnoObjeto.getNombre);

let nombre: string = "asd";
let edad;
let experiencia: boolean;
let asignaturas: any[];

console.log(`El valor del nombre es: ${nombre}`);

function sumar(param1: number, param2: number) {
  console.log(`La suma de ${param1} y ${param2} es ${param1 + param1}`);
}

function parametrosOptativos(
  param1: string,
  param2: string,
  param3: number = 0
) {
  console.log(`los paramentros son ${param1}  ${param2}  ${param3}`);
}

function funcionParamentrosMulti(
  param1: string,
  param2: number,
  ...param: any[]
) {
  console.log(`los paramentros son ${param1}  ${param2}`);
  param.length > 0 &&
    param.forEach((element) => {
      console.log(element);
    });
}

//sumar(3, 4);
//parametrosOptativos("uno", "dos");
//parametrosOptativos("uno", "dos", 8);
funcionParamentrosMulti("uno", 2);
funcionParamentrosMulti(
  "uno",
  2,
  4,
  5,
  6,
  7,
  8,
  9,
  234,
  234,
  234,
  2,
  false,
  true,
  "hola"
);
