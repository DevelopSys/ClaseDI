<a name="tema1"></a>
- [¿Qué es Angular?](#qué-es-angular)
- [¿Qué es TypeScript?](#qué-es-typescript)
- [Instalaciones necesarias](#instalaciones-necesarias)
  - [Base TypeScript](#base-typescript)
    - [Declaración de variables](#declaración-de-variables)
    - [Tipos de datos\*\*](#tipos-de-datos)
    - [Bloques](#bloques)
    - [Funciones](#funciones)
    - [Clases](#clases)
    - [Interfaces](#interfaces)
    - [Promesas](#promesas)


# ¿Qué es Angular?

Angular es un framework de desarrollo para JavaScript creado por Google. La finalidad de Angular es facilitarnos el desarrollo de aplicaciones web SPA (Simple Page Application) y además darnos herramientas para trabajar con los elementos de una web de una manera más sencilla y optima.

El concepto de SPA integra multitud de componentes en una sola página, facilitando así la carga para el navegador mejorando en grn medidatanto la velocidad como el rendimiento. Esto quiere decir que no necesita de una recarga del navegador cada vez que se cambie de componente dentro de la página. Una de las muchas cosas buenas que tienen Ángular, es que a diferencia de aplicaciones web realizadas con JavaScript, el código es muy sencillo de escribir y mantener. Al mismo tiempo, Ángular está desarrollado y mantenido por Google por lo que lleva consigo una gran comunidad de desarrollo por detras

Las principales características de Angular son:

- Basado en HTML + JavaScript
- SPA (Single Page Application)
- Sigue el patrón MVC 
- Orientado a la creación de apps móviles.
- Se puede programar con ECMAScript 5 de toda la vida, ES6, TypeScript o incluso Dart (de Google).
- Integrado con npm y node.

Las versiones de Angular son:

- Angular JS (v1)
- Angular 2, 4, 5, 6, 7, 8,9,10

El paso de la versión 1 a la versión 2 sufrió un gran cambio, donde se incorporó el soporte al lenguaje de programación TypeScript (antes tan solo soportaba JavaScript). La versión tres no llegó nunca a ver la luz ya que en el cambio de la versión 2 a la siguiente, muchos de los componentes internos del framework estaban es su versión 3.x. Para evitar problemas el equipo de Angular decidió saltar a la versión 4, unificando asó la versión de todos sus componentes

Como se verá, el desarrollo en Angular está basado en el desarrollo de componentes, los cuales tienen una parte gráfica escrita en HTML y una parte lógica escrita en TypeScript (en nuestro caso). Al mismo tiempo se pueden desarrollar clases, interfaces, servicios, json, etc... que sirvan como elementos de interaccion con los diferentes componentes desarrollados.



# ¿Qué es TypeScript?

Se trata de un lenguaje de programación orientado a objetos fuertemente tipado desarrollado y mantendido por Microsoft que se traduce a JavaScript de forma automática por parte del compilados. Lo bueno que tiene TypeScript es que además de incluir características que no posee JavaScript (por lo que es un superconjuntto de js), escribir código es muhco más sencillo y el compilador se encarga de traducir todo el código js de forma automática. Esta traducción se conoce como transpilación. 

Como se puede ver en la siguiente imagen, ts engloba todas las características del estandar que soporta JavaScript, añadiendo funcionalidades de POO 

!(typescript)[./images/ts.png]

La razón de incorporar el soporte para ts en Angular surge de la mejora en el rendimiento y productividad comparado con js

# Instalaciones necesarias

Para poder trabajar con TypeScript el único requisito es tener instalado <a href="https://nodejs.org/es/download/" target="_blank">nodejs</a> y su gestor de paquetes npm. Este último viene incluido en las versiones de nodejs. Una vez está instalado se ejecuta el siguiente comando para instalar <a href="https://www.typescriptlang.org" target="_blank">TypeScript</a>
````
npm install -g typescript
````
Para comprobar que todo ha funcionado se ejecutan los siguientes comandos
````
// comprobar la version de node
node --version
// comprobar versión de ts
tsc --version
````
Para pode trabajar con Angular, además de node y el gestor de paquetes npm, hay que instalar el Angular cli<a href="https://github.com/angular/angular-cli" target="_blank"></a>. Para ello hay que ejecutar el siguiente comando 
````
npm install -g @angular/cli
````
**hay que tener en cuenta que todos los comandos que lleven -g quiere decir que se deben instalar o bien con sudo (linux mac) o bien con cmd abierto como administrador**

Por último para poder empezar a trabajar es necesario instalar un editor de código. Por su facilidad de uso y por su integracion con ts es recomendable utilizar <a href="https://code.visualstudio.com" target="_blank">Visual Studio Code</a>Visual Studio Code, aunque existen multitud de posibilidades

[Volver al índice](#tema1)

## Base TypeScript

**Hola Mundo**

Se crea un archivo hola con extensión .ts con el siguiente código y se guarda

````
console.log("Hola Mundo");
````

Una vez guardado si se abre con un navegador, aparece en la pantalla el mensaje. Lo que debería de pasar es que se muestra dentro de la consola de desarrollador (se recomienda chrome). Para que esto surta efecto hay que compilar el archivo ejecutando el siguiente código
````
tsc hola.ts
````
En el momento de ejecución se genera de forma automática el correspondiente archivo js por el proceso de transpilación

````
// Archivo ts
console.log("Hola Mundo");
````

````
// Archivo js
console.log("Hola Mundo");
````

En algunos de los casos el contenido del archivo va a ser el mismo, pero si el archivo ts incluye características nuevas, estas serán traducidas y generados códigos diferentes

Este proceso de compilación es poco productivo, ya que hay que estar ejecutando el comando tsc cada vez que queramos realizar el proceso. Existe la posibilidad de agregar un visor al archivo o al proyecto para que todo este proceso se realice de forma automática y en el momento de encontrarse con un error avisar del mismo. Para ello hay que ejecutar el comando:

````
tsc *.ts --out hola.js --watch
````

Para poder crear un proyecto de tipo ts se ejecutan los siguientes comandos:
````
mkdir proyectots
cd proyectots
npm init
````

Se creará un archivo package.json que indicará los datos introducidos a la hora de crear el proyecto. Del mismo modo es necesario indicar en un archivo json algunas estructuras que debe cumplir el proyecto. Para ello se crea un archivo llamado tsconfig.json con el siguiente contenido:
````
{
  "compilerOptions": {
    /* Basic Options */
    // "incremental": true,                   /* Enable incremental compilation */
    "target": "es6",                          /* Specify ECMAScript target version: 'ES3' (default), 'ES5', 'ES2015', 'ES2016', 'ES2017', 'ES2018', 'ES2019' or 'ESNEXT'. */
    "module": "commonjs",                     /* Specify module code generation: 'none', 'commonjs', 'amd', 'system', 'umd', 'es2015', or 'ESNext'. */
    // "lib": [],                             /* Specify library files to be included in the compilation. */
    // "allowJs": true,                       /* Allow javascript files to be compiled. */
    // "checkJs": true,                       /* Report errors in .js files. */
    // "jsx": "preserve",                     /* Specify JSX code generation: 'preserve', 'react-native', or 'react'. */
    // "declaration": true,                   /* Generates corresponding '.d.ts' file. */
    // "declarationMap": true,                /* Generates a sourcemap for each corresponding '.d.ts' file. */
    // "sourceMap": true,                     /* Generates corresponding '.map' file. */
    // "outFile": "./",                       /* Concatenate and emit output to single file. */
    // "outDir": "./",                        /* Redirect output structure to the directory. */
    // "rootDir": "./",                       /* Specify the root directory of input files. Use to control the output directory structure with --outDir. */
    // "composite": true,                     /* Enable project compilation */
    // "tsBuildInfoFile": "./",               /* Specify file to store incremental compilation information */
    // "removeComments": true,                /* Do not emit comments to output. */
    // "noEmit": true,                        /* Do not emit outputs. */
    // "importHelpers": true,                 /* Import emit helpers from 'tslib'. */
    // "downlevelIteration": true,            /* Provide full support for iterables in 'for-of', spread, and destructuring when targeting 'ES5' or 'ES3'. */
    // "isolatedModules": true,               /* Transpile each file as a separate module (similar to 'ts.transpileModule'). */

    /* Strict Type-Checking Options */
    "strict": true,                           /* Enable all strict type-checking options. */
    // "noImplicitAny": true,                 /* Raise error on expressions and declarations with an implied 'any' type. */
    // "strictNullChecks": true,              /* Enable strict null checks. */
    // "strictFunctionTypes": true,           /* Enable strict checking of function types. */
    // "strictBindCallApply": true,           /* Enable strict 'bind', 'call', and 'apply' methods on functions. */
    // "strictPropertyInitialization": true,  /* Enable strict checking of property initialization in classes. */
    // "noImplicitThis": true,                /* Raise error on 'this' expressions with an implied 'any' type. */
    // "alwaysStrict": true,                  /* Parse in strict mode and emit "use strict" for each source file. */

    /* Additional Checks */
    // "noUnusedLocals": true,                /* Report errors on unused locals. */
    // "noUnusedParameters": true,            /* Report errors on unused parameters. */
    // "noImplicitReturns": true,             /* Report error when not all code paths in function return a value. */
    // "noFallthroughCasesInSwitch": true,    /* Report errors for fallthrough cases in switch statement. */

    /* Module Resolution Options */
    // "moduleResolution": "node",            /* Specify module resolution strategy: 'node' (Node.js) or 'classic' (TypeScript pre-1.6). */
    // "baseUrl": "./",                       /* Base directory to resolve non-absolute module names. */
    // "paths": {},                           /* A series of entries which re-map imports to lookup locations relative to the 'baseUrl'. */
    // "rootDirs": [],                        /* List of root folders whose combined content represents the structure of the project at runtime. */
    // "typeRoots": [],                       /* List of folders to include type definitions from. */
    // "types": [],                           /* Type declaration files to be included in compilation. */
    // "allowSyntheticDefaultImports": true,  /* Allow default imports from modules with no default export. This does not affect code emit, just typechecking. */
    "esModuleInterop": true                   /* Enables emit interoperability between CommonJS and ES Modules via creation of namespace objects for all imports. Implies 'allowSyntheticDefaultImports'. */
    // "preserveSymlinks": true,              /* Do not resolve the real path of symlinks. */
    // "allowUmdGlobalAccess": true,          /* Allow accessing UMD globals from modules. */

    /* Source Map Options */
    // "sourceRoot": "",                      /* Specify the location where debugger should locate TypeScript files instead of source locations. */
    // "mapRoot": "",                         /* Specify the location where debugger should locate map files instead of generated locations. */
    // "inlineSourceMap": true,               /* Emit a single file with source maps instead of having a separate file. */
    // "inlineSources": true,                 /* Emit the source alongside the sourcemaps within a single file; requires '--inlineSourceMap' or '--sourceMap' to be set. */

    /* Experimental Options */
    // "experimentalDecorators": true,        /* Enables experimental support for ES7 decorators. */
    // "emitDecoratorMetadata": true,         /* Enables experimental support for emitting type metadata for decorators. */
  }
}
````

Actividad: Crear un proyecto que tenga un archivo donde aparezca por consola tu nombre y tenga un visor para la compilación continua 

El siguiente punto sería crear el archivo HTML al cual se asociará el archivo js correspondiente (que ha sido traducido desde el ts). Para ello se crea un HTML con el siguiente código:

````
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <script src="hola.js"></script>
</head>

<body>
    <h1>Ejemplo inicial de TypeScript</h1>
</body>
````

En este caso si se abre el archivo index.hmtl en chrome, aparecerá dentro de las herramientas de desarrollador el mensaje por consola que se indicó

### Declaración de variables

Para poder declarar una variable se utilizan las palabras reservadas let, var y cons. 

Cada una de ellas depende del ámbito de uso:
````
for (var i = 0; i < 10; i++) {
}
console.log(i) // 10

for (let j = 0; j < 10; j++) {
}

console.log(j) // j is not defined
````


La estructura es la siguiente
````

// let nombre_variable:tipo=valor
````

Al igual que en otros lenguajes de programación fuertemente tipados, existen diferentes tipos de datos. Se puede indicar que una variable es de cualquier tipo, tipo any para cualquiera. También puede ser un objeto, escrito en formato json con el 
````
let letras:string = "Hola";
let numeros:number = 123;
let bool:boolean= true;
let cualquiera:any = 12;
let objeto = {nombre:"Nombre",apellido:"Apellido",edad:20};*/
````

Para un formateo se utiliza el carácter  comilla y ${} para englobar a la variable. Puede englobar también código ts, por lo que puede ser llamada una función
````
let nombre:string = "Borja";
let apellido:string = "Borja";
let edad: number= 20;
let fecha:Date = new Date();
let patron = `Hola ${nombre} ${apellido} tienes ${edad} años`;
let patron2 = `Hola ${mostrarNombre(nombre)} ${apellido} tienes ${edad} años`;
````


### Tipos de datos**

````
// boolean
let a: boolean = true;
let b: boolean = false;
// números
let a: number = 10;
let b: number = 14.6;
// string
let a: string = "";
let b: string = "a";
let c: string = "ejemplo";
// cualquier
let cualquiera: any = "ejemplo"
// arrays
let a: number[] = [1, 2, 3, 4];
let b: string[] = ["a", "b", "c"];
let c: Array<number> = [1, 2, 3, 4];
let d: Array<string> = ["a", b, "c"];
let e: [number, string] = [1,"a"]
// enum
enum Animals {obj1, obj2, obj3, obj4, obj5}


````

### Bloques

- If
````
if (true) 
{
    console.log('This will always executed.');
}

if (false) {
    console.log('This will never executed.');
}    
````

- If ternario

- Switch
````
switch(expression) { 
   case op1: { 
      //statements; 
      break; 
   } 
   case op2: { 
      //sentencias; 
      break; 
   } 
   default: { 
      //sentencias; 
      break; 
   } 
} 
````

- While
````
while (condition expression) {
    // sentencias
}

let pos = 4
while(pos!=0){
    console.log(`Ejecución ${pos}`)
    pos--;
}
````

- Do while
````
do {
// sentencias
}
while (condition expression);

let lenguajes = ["Java", "JavaScript", "Powershell"];
let i=0;

do{
    console.log(lenguajes[i]);
    i++;
}while(lenguajes.length!=i)

````

- For
````
for (first expression; second expression; third expression ) {
    // sentencias
}


let lenguajes = ["Java", "JavaScript", "Powershell"];
for (let i =0;i<lenguajes.length;i++){
    console.log(lenguajes[i]);
}
````

- Foreach 
````
let elementos = [10, 20, 30];
for (let value of elementos) {
      console.log(value);
}

let lenguajes = ["Java", "JavaScript", "Powershell"];

for (let value of lenguajes) {
      console.log(value);
}
````


### Funciones

Las funciones en TypeScript definen ejecución de instrucciones con la posibilidad de pasar parámetros. Para poder crear una función, la estructura es la siguiente:

````
function nombre(parametro:tipo, parametro:tipo): retorno
````


Un ejemplo sería el siguiente: 
````
function mostrarNombre(nombre:string): string{
    return nombre;
}

console.log(mostrarNombre('MiNombre'));
````

Como se ha visto, en una función se pueden incluir parámetros indicando el tipo del mismo.  Normalmente los parámetros que se indican en la función son obligatorios y del tipo indicado, es decir cuando la función es llamada se debe incluir en la llamada. Pero existen algunas opciones:

- Se puede indicar que hay algunos parámetros que pueden no incluirse y si tienen algún valor por defecto. Para indicar que un parámetro es optativo se incluye el carácter ?

````
function parametrosOptativos(parm1: string, param2: string, param3:string){
}

function desarrollo(cliente: string, nombre: string, cantidad?: number){
    let patron: string;
    if (cantidad){
        patron = `Proyecto para ${cliente}, cuyo nombre es ${nombre} y con un coste de ${cantidad}`
    }
    else{
        patron = `Proyecto para ${cliente}, cuyo nombre es ${nombre}`;
    }

    console.log(patron);
}

desarrollo('Cliente','Proyecto');
desarrollo('Cliente','Proyecto',4);
````
Hay que tener en cuenta que los parámetros optativos deben de indicarse en las últimas posiciones
 - Se puede indicar que existe un número indeterminado de parámetros. Para ello se utiliza el carácter ...[]
````
function parametrosMultiples(parm1: string, param2: string, ...param3:string[]){
}

function parametrosMultiples (cliente: string, ...nombres:string[]){
    let patron: string = `Proyecto para ${cliente}, cuyo nombre es ${nombres}`
    console.log(patron);
}

parametrosMultiples('Cliente', 'Proyecto1','Proyecto2');
````
- Se puede indicar que un parámetro tiene un valor por defecto en el caso de que no sea indicado en la llamada de la función. Para ello se iguala el parámetro al que se asigna un valor por defecto con el carácter =
````
function parametrosDefecto(param1:tipo, param2:tipo=valor):{
}

function parametrosDefecto(cliente:string, nombre:string="Proyecto cualquiera"):string{
    let patron: string = `Proyecto para ${cliente} con el nombre ${nombre}`;
    return patron;
}

console.log(parametrosDefecto("Cliente"));
console.log(parametrosDefecto("Cliente",'NombreProyecto'));
````

Además de crear las funciones como se ha indicado, también existen las llamadas funciones de flecha. Se identifican con los caracteres =>, que hace de separador entre los argumentos y lo que devuelve. Tienen algunas características:

- retorno implícito si sólo tienen 1 expresión (no hace falta el return ni las llaves)
- no hacen falta los paréntesis en los parámetros si sólo tienen 1 (si no, () => 1 o (a,b)=>a+b )


La sintaxis de este tipo de funciones es el siguiente:
````
let var = (param1:tipo, param2:tipo) => {instrucciones}

let sumaNormal = function(op1: number, op2: number) {
  return op1 + op2;
};

let sumaFlecha = (op1: number, op2: number) => op1 + op2;

console.log(sumaFlecha(1, 5));
console.log(sumaNormal(1, 5));
````

Estas funciones de flecha, utiliza la palabra reservada this para llamar a los parámetros de dentro de la variable asignada

````
let lenguaje = "JavaScript";

let ejemplo1 = {
    lenguaje: "TypeScript",
    destino() {
      let nombre = this.lenguaje;
      console.log(nombre);
    }
  };

console.log(ejemplo1.destino());
````
En este caso la salida sería TypeScript


### Clases
Como en todo lenguaje de POO, las clases representan los moldes que se utilizan para implementar objetos. Una clase está creada por atributos y métodos, de los cuales debe haber como mínimo un constructor que será el utilizado para implementar objetos

````
class EjemploInicial{

    variable: string | undefined;
    constructor(){
    }

    metodoUno(){
    }
}
````

````
export class ClaseUno {

    nombre:string;
    apellido:string;
    telefono:number;

    constructor(nombre:string, apellido:string, telefono:number){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    imprimirDatos(){
        console.log(`${this.nombre} ${this.apellido} ${this.telefono} `)
    }

}

````
Las palabras reservadas para cada uno de los elementos son:

- Herencia ( extends )
- Constructores ( constructor() {} )
- Métodos de instancia ( metodo() {} )
- Métodos estáticos ( static metodo() {} )
- Overrides de métodos a hijos ( super.metodo() )
- Llamadas a constructores padre ( super() )

Existen unos métodos especiales que devuelven el valor de las propiedades (ya que deberían ser privadas) y se conocen como getter y setter. Para poder crearlos no necesitan el tipo de retorno y van acompañados de la palabra get y set

````
class Clase {

    _propiedad;

    get propiedad() {
      return this._atributo;
    }

    set propiedad(value) {
      this.propiedad = value;
    }
}

let objeto = new Clase();
objeto.propiedad = 27;
console.log(myObject.atributo);
````

### Interfaces

Las interfaces sirven como un nexo de unión de objetos, de forma que sea más sencillo utilizarlos en funciones. Cada lenguaje de programación utiliza las interfaces para un cometido diferente. Como en otros lenguajes de programación, las interfaces sirven para paliar la falta de herencia múltiple, utilizando la palabra reservada implements, la cual hará que todos los métodos  (con obligación de escribirse) y objetos pasen a la clase.

````
interface trabajador{
    id: number;
    nombre: string;
    antiguedad: boolean;
    tipo: string;

    calcularSueldo():number;

}

````

````
export class trabajadorAutonomo implements trabajador {
  id: number;
  nombre: string;
  antiguedad: boolean;
  tipo: string;

  constructor(id: number, nombre: string, antiguedad: boolean, tipo: string) {
    this.id = id;
    this.nombre = nombre;
    this.antiguedad = antiguedad;
    this.tipo = tipo;
  }

  calcularSueldo(): number {
    let sueldo: number;

    if (this.tipo == "autónomo") {
      sueldo = 100;
    } else {
      sueldo = 10;
    }

    return sueldo;
  }
}

````

````
import { trabajadorAutonomo } from "./trabajadorAutonomo";
let trabajabadorA:trabajadorAutonomo = new trabajadorAutonomo(1,"Trabajador1",false,"autónomo");
let trabajabadorB:trabajadorAutonomo = new trabajadorAutonomo(2,"Trabajador2",false,"asalariado");
console.log(trabajabadorB.calcularSueldo());
console.log(trabajabadorA.calcularSueldo());
````

Además en TypeScript se pueden utilizar las interfaces para definir propiedades de un objeto. Para declarar una interfaz se utiliza la palabra reservada interface seguida del nombre y los elementos que la forman

````
interface nombreInterfaz {
  prop: tipo;
  prop: tipo;

  metodo(): retorno;
}

interface trabajador{
  id:number,
  nombre:string,
  antiguedad:boolean
}
````

Para poder definir un "objeto" mediante una interfaz se utiliza un patrón json donde se indica {nombrePropiedad: valor}:
````
let trabajador = {id:1,nombre:"TrabajadorNombre",antiguedad:false};
````

Una vez se tiene el objeto definido se puede utiliza como parámetro en una función, llamando a todas las propiedades que tiene en su interior

````
function mostrarDatos(dato: trabajador){
    let patron: string = `El id del trabajador es ${dato.id}, el nombre es ${dato.nombre} y su expediencia es ${dato.antiguedad}`
    console.log(patron);
}

let trabajador = {id:1,nombre:"TrabajadorNombre",antiguedad:false};
mostrarDatos(trabajador);
````

### Promesas

Las promesas son ejecuciones que obtienen una respuesta mediante los métodos resolve y reject. Una vez declarada la promesa, dentro se pone lo que se quiere ejecutar de forma asíncrona y el  método que se ejecutará después. Es importante tener en cuenta que solo funciona para una compilación ES6 adelante

La estructura de la promesa es:

````
let promesa = new Promise(function(resolve, reject) {
  setTimeout(() => {
    console.log("Tarea ejecutandose");
    //resolve();
    reject();
  }, 1000);
});

promesa.then(
  () => console.log("correctro"),
  () => console.log("Tarea erronea")
);
````
