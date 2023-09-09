- [Angular y GitHub](#angular-y-github)
- [Estructura de un proyecto](#estructura-de-un-proyecto)
- [Depurar una aplicación de Angular](#depurar-una-aplicación-de-angular)
- [Principales elementos](#principales-elementos)
  - [Módulos](#módulos)
  - [Componentes](#componentes)
  - [Pipes](#pipes)
  - [Servicios](#servicios)
- [Creación y manejo de componentes](#creación-y-manejo-de-componentes)
- [Ciclo de vida de un componente (Hooks)](#ciclo-de-vida-de-un-componente-hooks)
- [Manejo clases Angular](#manejo-clases-angular)
- [Bootstrap](#bootstrap)
  - [Implementación online](#implementación-online)
  - [Implementación offline](#implementación-offline)
- [Plantillas y Data-binding](#plantillas-y-data-binding)
  - [One Way binding](#one-way-binding)
  - [Two Way binding](#two-way-binding)
- [Directivas](#directivas)
  - [Directivas de componente](#directivas-de-componente)
  - [Directivas de atributo](#directivas-de-atributo)
- [Pipes](#pipes-1)
- [Personalización: Directivas y Pipes](#personalización-directivas-y-pipes)
  - [Pipes personalizados](#pipes-personalizados)


#### [Volver al índice](#tema2)

Como se ha comentado antes, las instalaciones necesarias para manejar ts eran:

- NodeJs (con el gestor de paquetes npm)
- TypeScrip
- IDE

Dentro de todos los IDEs que están disponibles, uno de los más amigables para el trabajo con TypeScript es VisualStudioCode. Su instalación es muy sencilla ya que no requiere de configuraciones adicionales. Una vez el IDE está instalado si es recomendable instalar una serie de plugins que facilitan el trabajo. Para ello hay que pulsar en el icono de las extensiones (último de la fila que se muestra en la parte izquierda) y seleccionar los siguientes:

- Angular 2 TypeScript Emmet
- Angular Language Service
- Angular Snippets (Version 8)
- Angular v5 Snippets
- angular2-inline
- Bootstrap 4, Font awesome 4, Font Awesome 5 Free & Pro snippets
- HTML CSS Support
- JavaScript (ES6) code snippets
- JS-CSS-HTML Formatter
- jshint
- Material Icon Theme
- Prettier - Code formatter
- Terminal
- TSLint
- TypeScript Hero
- TypeScript Importer

La gran mayoría de las extensiones se encargan mostrar los snippets (atajos de nomenglatura), formateo de código, organización de importaciones - exportaciones , etc...

Además de las herramientas mencionadas, también se debe instalar Angular-cli mediante el comando
````
npm install -g @angular/cli
````

Este comando instalará una herramienta que posibilita entre otras cosas:

- Generar la estructura completa de un proyecto angular (scaffolding).
- Generar nuevos módulos, componentes y servicios a un proyecto angular.
- Arrancar un servidor de desarrollo que automáticamente recompila la aplicación y refresca el browser cuando guardamos los cambios que realizamos en el código.
- Revisa la corrección del código que escribimos (lint)
- Lanza los test
- Construye la aplicación lista para su distribución en producción.

Los comandos que se utilizan para gestionar un proyecto Angular son

````
// crea un nuevo proyecto llamado miApp
ng new miApp
// compila el proyecto situado en la ruta desde donde se ejecuta el comando
ng serve --open
// idéntico al anterior con la personalización del host que lanza el proyecto
ng serve --host 0.0.0.0 --port 4201
````


El proceso de creación de un proyecto Angular es algo lento, dependiendo de la velocidad de conexión y potencia de la máquina dónde se ejecute. 

- Mediante terminal situarse en el directorio donde se quiere crear el proyecto
- Ejecutar el siguiente comando

````
ng new NombreProyecto. 
````

Esto empezará a crear el proyecto, descargando todas las dependencias necesarias. Es posible que se pregunte durante la creación si se quiere añadir el routing de Angular durante la instalación y si se quiere utilizar algún estándar para la gestión de estilos. Esto ayudará bastante a la hora de gestionar el tema de la navegación. 

# Angular y GitHub

Hoy en día en el mundo del desarrollo el trabajo en equipo es un pilar básico para cualquier proyecto. Por eso trabajar con un control de versiones es básico. Para ello manejar un proyecto GitHub y Angular es básico. 

En el paso anterior se ha explicado cómo crear un proyecto local de Angular. Lo primero más importante a tener en cuenta en cuanto a control de versiones, es que en la creación del mismo ya va incluido un repositorio git (local). Otra cosa que hay que tener en cuenta es que de querer clonar un repositorio Angular ubicado en un gestor de control de versiones, ademas de clonar el repositorio se deben instalar todos los módulos necesarios. Para ello se ejecutan los siguientes comando:

````
// clonar el repositorio
git clone url_código
// instalar las dependencias necesarios
npm install
````

En el caso de tener el proyecto local creado, para poder versionarlo en GitHub hay que seguir los siguientes pasos:

1. Asociar el proyecto de Angular con un proyecto de GitHub creado

````
git remote add origin URL_proyecto_git
````

2. Abrir la vista de comandos. View -- Command Pallete. Seleccionar la opción Push to.. Esto pedirá que se seleccione un repositorio donde se subirán todos los archivos
3. Desde View -- Command Pallete seleccionar la opción Commit All
4. Desde View -- Command Pallete seleccionar la opción Push All

De esta forma el proyecto queda vinculado al repositorio de GitHub. Si se produce algún cambio lo primero que se debería hacer es un Full

1. Desde View -- Command Pallete seleccionar la opción Pull

# Estructura de un proyecto

Los ficheros más importantes dentro de la estructura base del proyecto son:

- e2e/: end-to-end tests
- node_modules/: módulos de terceros listados en package.json.
- src/: Directorio donde reside la aplicación
- .editorconfig: Configuración para el editor (para intentar que todo el equipo de desarrollo utilice la misma configuración). (http://editorconfig.org)
- .gitignore: archivos a ignorar por Git
- angular.json: Fichero de configuración de angular.
- package.json: Lista de paquetes de terceros que usa el proyecto.
- README.md: Pre-relleno con información sobre comandos de angular.
- tsconfig.json: Configuración para TypeScript para el IDE
- tslint.json: Configuración para TSLint

Dentro de la carpeta src los ficheros más importantes son:

- app/app.component.{ts,html,css,spec.ts}: El componente raíz de la aplicación (archivo typescript, archivo html, archivo css y archivo spec.ts para test).
- app/app.module.ts: Define el módulo AppModule, (el módulo raíz) que le dice a angular cómo ensamblar la aplicación.
- assets/: Directorio para los assets (se copiará tal cual al construir la aplicación).
- environments/: Este directorio contiene un archivo por cada entorno. En él se encuentra la configuración de algunas variables que se utilizan en la aplicación. Por ejemplo, quizás utilices una API REST diferente durante el desarrollo que la que utilizarás en producción, diferentes tokens de analytics, servicios mock... Angular cli elige el fichero adecuado en cada caso.
- browserslist: Fichero de configuración para indicar a las distintas herramientas los target browsers.
- favicon.ico: El icono favicon.
- index.html: El html principal.
- karma.conf.js: Configuración de Karma (para tests unitarios)
- main.ts: El punto de entrada principal de la aplicación.
- polyfills.ts: Cada navegador tiene diferente grado de soporte de los estándares web. Polyfills es una librería javascipt que normaliza esas diferencias. Browser Support Guide.
- styles.css: Estilos css globales de la aplicación.
- test.ts: Punto de entrada principal a los tests unitarios.
- tsconfig.app.json: Configuración del compilador TypeScript para la aplicación angular.
- tsconfig.spec.json: Configuración del compilador TypeScript para los tests unitarios(tsconfig.spec.json).
- tslint.json: Configuración para el TSLint y Codelyzer, utilizados al ejecutar el comando ng lint.

En el caso de haber iniciado el proyecto con el gestor de rutas de Angular también estará presente el archivo app-routing.module.ts que tiene un decorador y un array de rutas (será explicado más adelante). Si se ha dicho que no a la generación de este módulo, se puede hacer manualmente o mediante el comando
````
ng g m app-routing --routing
````

# Depurar una aplicación de Angular 

Para depurar una aplicación de Angular se utiliza el comando ng serve o el comando npm start. Ambos comandos hacen lo mismo ya que uno arranca al otro. Una vez introducido esto en el directorio del proyecto se compila todo el código y se monta la aplicación web en la dirección https://localhost:4200. 

Para poder depurar una aplicación Angular existen dos posibilidades: 
- La primera es trabajar con la consola integrada en el IDE donde se pueden ver los errores de compilación 
- Se segunda es trabajar con la consola integrada en la mayoría de navegadores. Se recomienda utilizar la consola de Chrome ya que además de la consola integra una serie de características muy útiles a la hora del desarrollo

Antes de empezar a codificar y practicas con angular, es importantes entender cual es el orden de arranque y los elementos que se consultan.

1. El primer paso que se realiza en la compilación de una aplicación Angular es la consulta del fichero index.html cuyo contenido es el siguiente: 

````
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Primerospasos</title>
  <base href="/">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>
</body>
</html>

````

No sorprende que sea una web, ya que angular básicamente es una página web mejorada con diferenciación entre en fontend y el backend

2. Como se puede ver en este fichero, lo que se representa es una etiqueta llamada  `<app-root>` la cual es capaz de entender ya que está declarada en el archivo main.ts:

````
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
````

Este archivo main ts indica que el modulo principal es el AppModule, pudiendo verlo en el archivo appmodule.ts

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

Este archivo es uno de los principales, ya que indica cuales son los elementos que están contenidos en cada módulo. Digamos que es una parte de la aplicación (inicialmente la única) que contiene todos los elementos que forman parte de ella. Se puede observar que el componente principal (bootstrap) es el AppComponent que está declarado al mismo tiempo como componente. 

3. El siguiente paso es comprobar lo que indica el componente. Esto está definido el en archivo app.component (se puede ver en la importación del fichero anterior). 

````
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'primerospasos';
}

````


En este archivo se indica que se trata de un componente que tiene un selector llamado app-root (lo que se utiliza como etiqueta para que sea mostrado), una template url (el archivo html de la vista) y un styleUrls (el archivo css del componente)

4. El último paso es la lectura de los componentes html y css para que se pueda representar la parte gráfica (html y css) y asociar a la parte lógica (ts)

Cuando una aplicación consta de varios componentes, servicios, y módulos estos deben ser declarados dentro del fichero que representa el módulo. En este caso cuando se crea una aplicación de 0 el módulo existente es el app.module.ts, pudiendo crear tantos módulos como sean necesarios

# Principales elementos

Los principales elementos de los que consta una aplicación de Angular principalmente son los: componentes, módulos, pipas y servicios. 


## Módulos

Un módulo se puede definir como un aglutinado de componentes. Si estamos trabajando con aplicaciones pequeñas, solamente existirá el módulo raíz. En aplicaciones grandes, es recomendable separar la misma en diferentes módulos según funcionalidades, flujo de trabajo, o alguna otra característica.

En código un módulo es una clase NgModule con un decorador @NgModule. Por defecto está creado un módulo llamado app.module.ts que tiene el siguiente contenido:
````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

Este es el módulo principal de carga de la aplicación.

Cada uno de los elementos declarados dentro del decorador NgModule son:

- declarations: Las view classes que pertenecen a este módulo. Angular tiene 3 tipos de view classes: componentes, directivas, y pipes.
- exports: El subconjunto de declarations que deben ser visibles y utilizables en las plantillas de componente (component templates) de otros módulos que lo importen.
- imports: Lista de módulos importados. Tendremos acceso a los elementos incluidos en el exports del módulo importado.
- providers: Creadores de servicios (services) con los que este módulo contribuye en la colección global de servicios. Son accesibles en cualquier parte de la aplicación
- bootstrap: La vista de aplicación principal (el componente raíz) que alberga al resto de vistas. Solamente el módulo raíz utilizará la propiedad bootstrap. Por defecto se puede ver que la vista que actúa como principal es el AppComponent

Si se quiere crear un módulo se utiliza el comando 
````
ng g m modulo-ejemplo
````

## Componentes

Se trata del componente más importante y representa la mayor parte del trabajo en angular. Gráficamente se pueden asociar a páginas o partes de una página. Uno de sus principales beneficios es la reutilización ya que en un momento determinado en una SPA desarrollada por Angular se podría estar mostrando al mismo tiempo un componente que se encarga de mostrar un menú con las rutas, otras componente con un listado de elementos que están disponibles dentro de la aplicación, etc....  Esto garantiza tanto la reutilización de código cómo el mantenimiento de la aplicación de una forma mucho más sencilla.

Para poder crear un componente se ejecuta el siguiente comando

````
ng g c nombre-componente
````

Esto generará un componente, el cual está formado por:
- Una clase typescript que tiene el decorador @Component, donde se definen:
- selector: elemento que será nombrado en el html donde sea utilizado
- templateUrl: elemento html que representa la parte gráfica del elemento. 
- styleUrls: elemento css que representa la parte de estios del elemento. Del mismo modo que en la templateUrl, se puede utilizar los caracteres para definirlo en el propio archivo
- providers: array de proveedores de inyección de dependecias (dependency injection providers) para servicios que este componente necesite. Es una de las maneras de informar a Angular que él constructor de este componente necesita una instancia de un servicio concreto. También se pueden indicar en los constructores cómo se verá más adelante.

**Lo suyo es crear todos los componentes bajo una misma estructura. Para ello se puede crear una carpeta dentro de app que se llame components**

Una vez creado aparecerá dentro de la ruta indicada donde cada uno de los archivos tendrá la siguiente funcionalidad

- componente-ejemplo.component.ts

Se trata del más importante, ya que se encarga de la lógica del componente y de linkar el resto de elementos. Su contenido inicial es:

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-ejemplo',
  templateUrl: './componente-ejemplo.component.html',
  styleUrls: ['./componente-ejemplo.component.css']
})
export class ComponenteEjemploComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
````

Dentro del decorador @Component (que indica que se trata de un componente) se encuentra:
- selector: nombre que será utilizado cuando el componente quiera ser mostrado en otro componente, como por ejemplo el inicial
- templateUrl: link del archivo que representa la parte gráfica del componente. En este caso el archivo.css 
- styleUrls: link del archivo que representa los estilos que se aplicarán al componente. En este caso es el archivo .css

En la mayoría de los casos la definición tanto del templateUrl como del styleUrl van a ser punteros a archivos, pero también existe la posibilidad de indicar directamente el código bien html o css en el propio decorador. Tan solo deberían ser utilizados para casos donde los elementos son muy pequeños. En ese caso tendría el siguiente aspecto:
````
@Component({
  selector: 'app-componente-ejemplo',
  template: `
    <h1>Ejemplo</h1>
  `,
  styles: ['h1 { font-weight: normal; }','h2 { color: red; }']
})
````


- componente-ejemplo.component.html

Se trata de código html al uso, donde se indican cada uno de los elementos que serán mostrados en el componente. Como se verá más adelante se puede comunicar la parte gráfica con la parte lógica.

````
<p>componente-ejemplo works!</p>
````

Para facilitar el desarrollo y realizar un despliegue más rápido, se utilizarán las librerías de bootstrap para facilitar todo el aspecto gráfico

- componente-ejemplo.component.css

Se trata de código css al uso, donde se indican cada uno de los estilos que tendrán los elementos. Inicialmente el archivo está vacío 
- componente-ejemplo.component.spec.ts

Archivo donde se indican todas las pruebas de componente que se realizarán. 

````
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteEjemploComponent } from './componente-ejemplo.component';

describe('ComponenteEjemploComponent', () => {
  let component: ComponenteEjemploComponent;
  let fixture: ComponentFixture<ComponenteEjemploComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponenteEjemploComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteEjemploComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

````

Al mismo tiempo se deben actualizar dos elementos (solo si se quieren manejar rutas):
1. **El fichero app-routing.module.ts** encargado de gestionar las rutas de la aplicación (se explicará más adelante), donde se ha incluido en el array de Route la siguiente línea.
````
const routes: Routes = [
  {path: 'componente_ejemplo', component: ComponenteEjemploComponent}
];
````

En esta constante se indica todas las rutas que son gestionadas desde el módulo de rutas. En el objeto se indican el path (que será el nombre utilizado cuando se quiera llamar al elemento en una redirección) y el component (que apuntará al componente que está asociado a ese nombre). Del mismo modo en el modulo de rutas se importará el componente con la siguiente línea

````
import { ComponenteEjemploComponent } from './componentes/componente-ejemplo/componente-ejemplo.component';
````


2. **El fichero module.ts** encargado de indicar cuales son los elementos que se pueden utilizar (entre otras cosas ya que se explicará más adelante). En él se habrá incorporado de forma automática el componente en la parte de declaraciones

````
declarations: [
    AppComponent,
    ComponenteEjemploComponent,
  ]
````

Del mismo modo que en el caso anterior se habrá importado el componente con la siguiente linea
````
import { ComponenteEjemploComponent } from './componentes/componente-ejemplo/componente-ejemplo.component';
````

Una vez hecho todo esto el componente está creado y listo para utilizarse. Es importante tener en cuenta que si no está declarado en el fichero module.ts no podrá ser utilizado aunque el resto de elementos están bien configurados. Para poder utilizarlo (que sea visible en la pantalla) se realizarán los siguientes pasos:

1. Abrir el archivo index.html
````
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>ProyectoBaseRouting</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>
</body>
</html>

````

Se indica que el ````<app-root>```` es el elemento que se está mostrado. Si se abre el archivo app.component.ts se puede ver que este componente tiene como selector app-root
````
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proyectoBaseRouting';
}
````


2. Abrir el fichero que indica el index que actúa como root, que es el indicado en el punto anterior (app.component.ts)

````
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
  <h1>
    Welcome to {{ title }}!
  </h1>
  <img width="300" alt="Angular Logo" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==">
</div>
<h2>Here are some links to help you start: </h2>
<ul>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://angular.io/tutorial">Tour of Heroes</a></h2>
  </li>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://angular.io/cli">CLI Documentation</a></h2>
  </li>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://blog.angular.io/">Angular blog</a></h2>
  </li>
</ul>

<router-outlet></router-outlet>

````

Ya se tratarán cada uno de los elementos de este archivo, pero de forma general es el contenido que se mostrará en el index.

3. Introducir el el una etiqueta con el selector configurado en el archivo componente-ejemplo.component.ts. Para ello se modifica el archivo abierto en el punto anterior y se indica el selector 
````
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
    <h1>
        Welcome to {{ title }}!. Esto es parte del componente app.component
    </h1>
</div>
<app-componente-ejemplo style="text-align:center"></app-componente-ejemplo>
````

El selector ````app-componente-ejemplo```` se puede ver en el archivo componente-ejemplo.component.ts

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-ejemplo',
  templateUrl: './componente-ejemplo.component.html',
  styleUrls: ['./componente-ejemplo.component.css']
})
export class ComponenteEjemploComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
````

4. En el caso de querer utilizar un componente generado, simplemente se deberá utilizar la etiqueta (selector) que se le ha asignado en la parte del código html donde se quiera mostar

## Pipes

Los pipes son elementos que permiten la modificación de los datos que se quieren representar en la plantilla HTML. Existen algunos pipes creados:

- uppercase y lowercase: transforma un texto en mayusculas o minúsculas
- Slice: permite cortar una parte de texto y representarla
- Decimal: permite representar un número en formato decimal
- Percent: permite representar un número en formato porcentaje
- Currency: permite representar un número en formato moneda
- Json: permite representar un texto en formato json
- Async: permite asignar un proceso asíncrono a la petición que se aplica
- Date: permite representar una fecha con un formato concreto

Todos estos pipes son propios de Angular y se utilizan en las plantillas html con el carácter | precedido del elemento que se quiere transformar. Por ejemplo, si en la parte lógica existe:

````
// en la parte .ts
let texto = "esto es en minúsculas"

// en la parte .html
<p>
En este párrafo existe una transformación por pipe: {{texto | uppercase}}
</p>

// la salida sería --> En este párrafo existe una transformación por pipe: ESTO ES EN MINÚSCULAS
````

**Lo suyo es crear todos los pipes bajo una misma estructura. Para ello se puede crear una carpeta dentro de app que se llame pipes**

Al igual que existen pipes creados, nosotros podemos definir nuestros propios pipes:

````
ng g p src/app/pipe/personalizado
````

Esto genera una clase nueva que permite declarar el comportamiento del elemento al que se le aplica el pie personalizado

````
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'personalizado'
})
export class PersonalizadoPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
````

Se puede ver como en el decorador @pipe se indica cual es el nombre que tendrá que ser utilizado para aplicar la transformación. EN el método transform se indican los elementos que se aplicarán. Por ejemplo si se quiere aplicar una transformación donde el elemento que es pasado tiene menos de 5 letras sería lo siguiente

````
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'personalizado'
})
export class PersonalizadoPipe implements PipeTransform {

  transform(elemento: string): unknown {

    if (elemento.length > 5){
      return 'tiene más de 5 letras';
    } else if (elemento.length === 0){
      return 'el elemento no tiene letras';
    } else {
      return 'tiene entre 1 y 4 letras';
    }

  }

}

````

Y en la parte de html se aplicaría de la siguiente forma:

````
<span>{{ title | personalizado }}: esto es un pipe personalizado</span>

````

En los siguientes temas se explicará el uso de todos los pipes así como sus posibles configuraciones

## Servicios

Los servicios son elementos que permiten la provisión de datos en la aplicación. Por regla general los servicios se conectan remotamente con APIs o servicios web para traer y rellenar de datos a la aplicación. Existen servicios propios y servicios personalizados, donde se puede personalizar el comportamiento del mismo.

**Lo suyo es crear todos los services bajo una misma estructura. Para ello se puede crear una carpeta dentro de app que se llame services**

````
ng g s src/app/services/personalizado
````

Esto crea el archivo con el decorador @Injectable que indica que la clase es un servicio

````
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PersonalizadoService {

  constructor() { }
}
````

Los siguientes pasos serán la configuración del servicio y su utilización en alguno de los componentes

# Creación y manejo de componentes

Como se ha dicho un componente es una parte de la aplicación que puede ser o no ser reutilizada. Por ejemplo podemos decir que la parte del menú de navegación, un footer, un formulario, un login, etc... son componentes de una aplicación y estos pueden ser reutilizados si es necesario.  Antes de empezar a implementar la aplicación, es importante tener en cuenta como se va ver nuestra aplicación y cuales serán los elementos que la componen ya que de esta forma la creación y gestión de componentes será mucho más sencilla

Por defecto, nada más crear la aplicación se crea un componente por defecto cuyo nombre es app.component que consta de 3 o 4 archivos:

- app.component.html: representa la parte gráfica del componente. Se trata de HTML "enriquecido" donde se codificará toda la parte gráfica sobre la cual se mostrarán elementos que estarán definidos en la parte lógica (.ts)
- app.component.ts: representa la parte lógica del componente. En realidad este fichero es el propio componente, ya que en el es donde se asocian todos los elementos entre sí. 
- app.component.css: representa las reglas del estilo que se aplicarán al componente en cuestión: 
- app.component.spec: representa las normas o pruebas que se realizarán para testar la funcionalidad del componente. 

Si se ven fichero a fichero se comprueba lo siguiente 

````
// app.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Uno';
}

````

Las importaciones indican todos los módulos, servicios o elementos que este componente podrá utilizar. El decorador @Component  indica que esta clase representa un componente en Angular, cuyos elementos html y css son los ficheros indicados y el selector es app-root. Este selector es el elemento que permitirá su utilización dentro de otros componentes (en la parte html). Por último en la clase se indica el funcionamiento de componente declarando todos los elementos que funcionarán y se relacionarán tanto con la parte gráfica como con otros elementos

Para poder tener tener todo bien organizado se estructura de forma modular, creando una carpeta con el nombre components y dentro de esta otra con el nombre shared donde se ubicarán los componentes que son reutilizados:

````
src
--app
----components
------shared
````

1. Dentro de la carpeta componentes se creará un componente que representará la parte central de la aplicación. Para ello se ejecuta el comando : 

````
ng g c src/app/components/home
````

La ejecución de este comando creará los ficheros mencionados al principio

````
CREATE src/app/src/app/components/home/home.component.css (0 bytes)
CREATE src/app/src/app/components/home/home.component.html (19 bytes)
CREATE src/app/src/app/components/home/home.component.spec.ts (614 bytes)
CREATE src/app/src/app/components/home/home.component.ts (267 bytes)
````

Adicionalmente, cuando creamos un componentes la aplicación debe reconocerlo como tal para que este pueda ser utilizado. Por ello en el archivo app.module se debe declarar el componente generado dentro de la parte de declaraciones

````
// app.module
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './src/app/components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

Así se podrá utilizar el HomeComponent en cualquier parte. Dentro de este fichero podemos encontrar la siguiente información: 

- declarations: donde se definirán los componentes, pipes y/o directivas que formarán parte del módulo
- imports: donde aparecerán los módulos externos o propios que utilizaran todos los elementos del propio módulo
- providers: donde aparecerán los servicios que proveerán de datos a la aplicación
- bootstrap: donde aparece el componente o módulo que se cargará de inicio.

2. Para comprobar que todo ha funcionado correctamente se modifica el contenido del fichero home.component.html y se pone un simple párrafo 

````
<h1>Primer componente Angular</h1>
<p>Este es el primer componente creado con angular creado desde la linea de comandos</p>
````

Y se comprueba cual es el selector que se debe utilizar para que el componente creado sea mostrado: 

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
````

El selector que se tendrá que utilizar es app-home.

3. En aquellas partes donde se quiere mostrar el componente se declarará como etiqueta, utilizando el selector app-home.

Para ello en el archivo app.component.html se incluirá la etiqueta

````
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <app-home></app-home>
</body>

</html>
````

Es importante ver que el componente cuyo selector es app-home puede ser reutilizado, de forma que si es llamado un par de veces, gráficamente será mostrado en dos ocasiones

````
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <app-home></app-home>
    <app-home></app-home>
</body>

</html>
````

Es de suponer que una aplicación Angular consta de n componentes, donde cada uno representa una parte de la aplicación y estos pueden ser mostrados de forma independiente o sobre la misma base. Esto sirve como principio de reutilización, es decir que un componente pude albergar varios componentes al mismo tiempo, de forma que estos puedan ser llamados en otro sitio si es necesario. A la hora de mantener código también se hace muy cómodo ya que tan solo se debe mantener el archivo del módulo que se quiere modificar. Como ejemplo se utilizará una aplicación que muestra hobbies, donde la aplicación consta de:

- app.component: componente principal de la aplicación, donde se muestra un texto explicativo de la aplicación
- futbolistas.component: componente incluido en app.componente donde muestra uno de los hobbies
- videojuegos.component: componente incluido en app.componente donde muestra otro de los hobbies.

En este caso tan solo se tocará la parte gráfica, ya que de momento la lógica se explicará en el siguiente tema

**app.component**

Se trata del componente que junta todos los componentes. En este caso se realiza una maquetación por columnas, donde en cada una de ellas aparece un componente diferente

````
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
</head>

<body>
    <div class="container">
        <h1>Alguno de los hobbies son: (ejemplo de componentes múltiples)</h1>

        <div class="row" style="margin-top: 50px; ">
            <div class="col">
                <app-futbolistas></app-futbolistas>
            </div>
            <div class="col"">
                <app-videojuegos></app-videojuegos>
            </div>
        </div>
    </div>
</body>

</html>
````

De forma individual, en cada uno de los componentes se configura su vista

**futbolistas.component**

````
<div>
    <h2 style="text-align: center">Fútbol</h2>
</div>

<ul class="m-2">
    <li>
        <h3>
            <img src="../../../assets/images/iniesta.jpg" alt="Andres iniesta" class="img-thumbnail img-fluid imagen" /> Andres Iniesta
        </h3>
    </li>
    <li>
        <h3>
            <img src="../../../assets/images/cantona.jpg" alt="eric cantona" class="img-thumbnail img-fluid imagen" /> Eric Cantona
        </h3>
    </li>

    <li>
        <h3>
            <img src="../../../assets/images/zidane.jpg" alt="zinedine zidane" class="img-thumbnail img-fluid imagen" /> Zinedine Zidane
        </h3>
    </li>

    <li>
        <h3>
            <img src="../../../assets/images/ronaldinho.jpg" alt="ronaldinho gaucho" class="img-thumbnail img-fluid imagen" /> Ronaldinho Gaucho
        </h3>
    </li>
</ul>

<div>

</div>
````


**videojuegos.component**

````
<div>
    <div>
        <h2 style=" text-align: center ">Videojuegos</h2>
    </div>

    <ul class="m-2 ">
        <li>
            <h3>
                <img src="../../../assets/images/final.png " alt="final fantasy " class="img-thumbnail img-fluid imagenxl " /> Final Fantasy X
            </h3>
        </li>
        <li>
            <h3>
                <img src="../../../assets/images/thelast.png " alt="the last of us " class="img-thumbnail img-fluid imagenxl " /> The Last of Us
            </h3>
        </li>

        <li>
            <h3>
                <img src="../../../assets/images/vice.jpg " alt="Gran Thef Auto " class="img-thumbnail img-fluid imagenxl " /> Gran Thef Auto: Vice City
            </h3>
        </li>

        <li>
            <h3>
                <img src="../../../assets/images/god.png " alt="god of war " class="img-thumbnail img-fluid imagenxl " /> The God of War
            </h3>
        </li>
    </ul>
</div>
````

Ademas de la creación y codificación de cada uno de los componentes, también hay que tener en cuenta que si cada uno de ellos pertenece al mismo módulo todos deben estar declarados en el archivo que tiene todos los elementos:

**app.module**

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolistasComponent } from './components/futbolistas/futbolistas.component';
import { VideojuegosComponent } from './components/videojuegos/videojuegos.component';


@NgModule({
  declarations: [
    AppComponent, FutbolistasComponent, VideojuegosComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

# Ciclo de vida de un componente (Hooks)

Al igual que pasa en aplicaciones que manejan diferentes componentes, Angular cuenta con una serie de eventos (interfaces) que permiten manejar el comportamiento a lo largo de la estancia de un componente en la aplicación. Hay que tener en cuenta que todo componente puede ser creado, ser mantenido y ser eliminado de la aplicación y depende del estado de componente se ejecutará un evento u otro. Otra cosa que es importante tener en cuenta es que el constructor es totalmente independiente del estado en el que se encuentre el componente, ya que es el primer método que se ejecuta siempre cuando el componente es agregado en la parte gráfica de la aplicación. 

Para poder utilizar los estados o hooks es necesaria la implementación de su interfaz asociada, lo que lleva a la escritura del método del evento

Los principales hooks de los componentes angular son:

- OnInit: ejecutado nada mas cargar un componente, tras la ejecución del constructor. Se puede utilizar para inicializar algunas variables tras ser recibidas por el constructor (por ejemplo por parámetros)
- DoCheck: ejecutado cuando hay algún cambio en el componente o en la aplicación de angular, bien sea un cambio de propiedad, agregar un nodo, etc...
- OnDestroy: ejecutado cuando el componente deja de estar mostrado en la aplicación.

Para este ejemplo se crea un componente llamado ciclo-vida (angular lo interpretada como ciclo-vida) y se importa en el fichero del módulo

````
ng g c components/cicloVida
````

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolistasComponent } from './components/futbolistas/futbolistas.component';
import { VideojuegosComponent } from './components/videojuegos/videojuegos.component';
import { CicloVidaComponent } from './components/ciclo-vida/ciclo-vida.component';


@NgModule({
  declarations: [
    AppComponent, FutbolistasComponent, VideojuegosComponent, CicloVidaComponent, CicloVidasComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

En siguiente paso es codificar la parte lódiga, para ello se implementan los hooks vistos:

````
import { Component, OnInit, DoCheck, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-ciclo-vida',
  templateUrl: './ciclo-vida.component.html',
  styleUrls: ['./ciclo-vida.component.css']
})
export class CicloVidaComponent implements OnInit, DoCheck, OnDestroy {

  constructor() {
    console.log('ejecutado constructor ciclo vida');
   }
  ngOnDestroy(): void {
    console.log('On Destroy ejecutado');
    
  }
  ngDoCheck(): void {
    console.log('Algo ha cambiado en la aplicación');
  }

  ngOnInit(): void {

    console.log('onInit ciclo de vida iniciado');

  }

}
````

Nada más ejecutar la aplicación se puede ver que la salida por consola será la siguiente:

````
ejecutado constructor ciclo vida
onInit iniciado
````

Se ejecuta el constructor en primera instancia y después el hook OnInit ya que el constructor ha terminado de cargarse

Para comprobar el funcionamiento de los otros dos hooks se van a crear dos botones: uno que cambie una propiedad (creado en el propio componente y otro en el app.component que quite la visibilidad del componente ciclo-vida

1. El primer botón es muy sencillo ya que tan solo ejecuta un método que cambia el contenido de una propiedad en el componente ciclo-vida

````
<button class="btn btn-primary" (click)='cambiarPropiedad()'>Cambiar alguna propiedad</button>
````

Este botón tiene un método asociado mediante un evento click, por lo que es necesario declarar el método en la parte .ts

````
import { Component, OnInit, DoCheck, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-ciclo-vida',
  templateUrl: './ciclo-vida.component.html',
  styleUrls: ['./ciclo-vida.component.css']
})
export class CicloVidaComponent implements OnInit, DoCheck, OnDestroy {

titulo = 'Ejemplos de los hooks de un componente';

  constructor() {
    console.log('ejecutado constructor ciclo vida');
   }
  ngOnDestroy(): void {
    console.log('On Destroy ejecutado');
    
  }
  ngDoCheck(): void {
    console.log('Algo ha cambiado en la aplicación');
  }

  ngOnInit(): void {

    console.log('onInit ciclo vida');

  }

  cambiarPropiedad(){
    this.titulo.concat(' cambio');
  }

}
````

El método cambiar propiedad tan solo añade la palabra cambio a la variable título cuando el botón sea pulsado. En este caso la salida por consola tras la pulsación del botón será la siguiente

````
// al ejecutarse la aplicación
ejecutado constructor ciclo vida
onInit iniciado

// al pulsarse el botón
Algo ha cambiado en la aplicación
````

En este caso se produce el cambio en el propio componente, pero si fuese en cualquier componente se ejecutaría de la misma forma.

2. Para el segundo caso se crea un botón en app.component y se asocia a un método igual que se ha hecho en el punto anterior

````
<div>
	<button class="btn btn-primary" (click)='mostrarComponente()'>Mostrar el componente</button>

</div>

<app-ciclo-vida *ngIf="visibilidad"></app-ciclo-vida>
````

Ademas de añadirle el botón con su correspondiente método, a la etiqueta app-ciclo-vida se a puesto una directiva gIf (se explicará en el siguiente tema). En la parte lógica se crea una variable llamada visibilidad, cuyo contenido cambia al pulsar el botón (en la ejecución del método)

````
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Uno';
  visibilidad = true;

  mostrarComponente(){
    this.visibilidad = !this.visibilidad;
  }

}
````

En este caso, nada la salida por consola sería la siguiente:

````
// al ejecutarse la aplicación
ejecutado constructor ciclo vida
onInit iniciado
// al pulsar el botón que oculta el componente
On Destroy ejecutado
// al volver a pulsar el botón que muestra el componente
ejecutado constructor ciclo vida
onInit ciclo vida
Algo ha cambiado en la aplicación
````

Se puede ver que al dejar de mostrar el componente se ejecuta el OnDestroy y al volver a mostrarlo se ejecuta el ciclo completo, desde el constructor al OnInit.

Estos son los principales, pero no los únicos hooks que existen. Todos son:

- OnChanges: primer hooks ejecutado tras el constructor. Se ejecuta cuando se detecta un cambio en alguno de los inputs del propios componente, sin tener en cuenta el resto de la aplicación
- AfterContentInit: se ejecuta al realiza cualquier muestra de contenido dentro de las vistas de componentes y justo después de ngDoCheck
- AfterContentChecked: se ejecuta cada vez que el contenido del componente ha sido verificado
- AfterViewInit: se ejecuta cuando la vista del componente se ha ejecutado por completo y el componente está totalmente disponible
- AfterViewChecked: ejecutado cada vez que la vista del componente ha verificado algún cambio. 

El orden del ciclo de ejecución completa es la siguiente:

![hooks angular](./images/hooks.png)

# Manejo clases Angular

Como ya se vio en el primer tema de TypeScript, se pueden crear tantas clases como sean necesarias para manejar objetos con métodos y atributos (la forma de crear un objeto puede ser mediante constructor o mediante notación JSON). 

En este ejemplo se creará una clase llamada futbolista con los atributos nombre, club, posición e imagen

````
class Jugador {
    
    nombre: string;
    equipo: string;
    posicion: string;
    imagen: string;
    mostrarDatos()

}
````

Otra posibilidad sería la de declarar las variables publicas dentro del constructor sin necesidad de declararlas como variable de clase, ya que así se definen automáticamente como variable de clase

````
class Jugador {
    
   
    constructor(public name: string,public club: string,public position: string,public img: string) {
           }
    mostrarDatos(){
        console.log(`Los datos del jugador son ${this.nombre} ${this.equipo} ${this.posicion}`);
    }

}
````

En este caso la creación del objeto se hará mediante constructor, por lo que se crea una clase que contiene la palabra export para que pueda ser utilizada desde cualquier clase diferente a esta (previa importación). Otra de las posibilidades habría sido la de declarar el objeto como una interfaz para así poder crearlo como una notación JSON:

````
export interface JugadorInterfaz {
  nombre: string;
  equipo: string;
  posicion: string;
  imagen: string;
  mostrarDatos();
}

````


En el componente de nueva creación clases.component se creará un futbolista utilizando como modelo la clase creada

````
import { Component, OnInit } from '@angular/core';
import { Jugador } from '../../utils/jugador';

@Component({
  selector: 'app-clases',
  templateUrl: './clases.component.html',
  styleUrls: ['./clases.component.css']
})
export class ClasesComponent implements OnInit {


  unJugador;

  constructor() { }

  ngOnInit(): void {
    this.unJugador = new Jugador('Andres Iniesta','Visel Kobe','MID','src/assets/images/iniesta.jpg');
    console.log(this.unJugador.mostrarDatos());
  }

}
````
En este caso en el momento de construir el componente se crea un objeto de tipo Jugador. Para poder utilizar esta clase se debe importar

````
import { Jugador } from '../../utils/jugador';
````

Más adelante se podrán utilizar todas las características del objeto para poder por ejemplo representarlas en la parte gráfica, añadirlo a un array, etc...

En el caso de haber declarado al jugador como interfaz, para poder crearlo en el componente sería de la siguiente forma:

````
import { Component, OnInit } from '@angular/core';
import { JugadorInterfaz } from '../../utils/jugador-interfaz';

@Component({
  selector: 'app-clases',
  templateUrl: './clases.component.html',
  styleUrls: ['./clases.component.css'],
})
export class ClasesComponent implements OnInit {
  unJugadorInterfaz: JugadorInterfaz;

  constructor() {}

  ngOnInit(): void {
    this.unJugadorInterfaz = {
      nombre: 'Eric Cantona',
      equipo: 'Manchester United',
      posicion: 'DEL',
      imagen: 'src/assets/images/cantona.jpg',
      mostrarDatos: () => {
        console.log('mostrar los datos');
      }
    };
  }
}

````

# Bootstrap

Bootstrap es un framework CSS que agrega multitud de estilos a una aplicacion web. Gracias a esta cantidad de estilos, desarrollar interfaces gráficas atractivas es bastante sencillo. Existen dos posibilidades de implementación: 
- Implementación online: se trata de una implementación donde todos los estilos estarán disponibles en la aplicación gracias a un link del framework. De forma generalizada esta es la forma de trabajar
- Implementación offline: en algunos casos no es conveniente tener una dependencia de internet (escenarios de pruebas por ejemplo), por lo que es necesario que todos los elementos están disponibles en modo sin conexión.

## Implementación online

Para poder hacer una implementación online, tan solo hay que abrir la parte de la <a href="https://getbootstrap.com/docs/4.3/getting-started/download/" target="_blank">documentación oficial</a> donde se referencia el link que debe agregarse al proyecto.

Los links que se deben agregar al proyecto son los siguientes:
````
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
````

Como muchos de los elementos de bootstrap utilizan js y librerías parecidas, también es necesario poner los links referentes a estas librerías

````
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
````

Este link debe ir situado en en archivo índex.html, dentro de la etiqueta ````<head>````

````
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>ProyectoBootstrap</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
  <app-root></app-root>
</body>
</html>

````

De esta forma dentro del proyecto se podrá utiliza cualquier estilo creado en bootstrap. Para comprobar que todo ha funcionado tan solo tendríamos que aplicar alguno de los estilos o clases a un componente
````
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
    <h1>
        Welcome to {{ title }}!
    </h1>
</div>
<h2>Here are some links to help you start: </h2>
<p class="container-fluid"></p>
````


## Implementación offline

Para poder hacer una implementación offline hay que seguir los siguientes pasos:
1. Descargar el zip con la version de <a href="https://getbootstrap.com/docs/4.3/getting-started/download/" target="_blank">bootstrap</a>
2. Crear una carpeta llamada styles dentro del proyecto src
3. Copiar el contenido de los ficheros descargados. Los que realmente interesan son los que aparecen en la imagen

![bootstrap](./images/boots.png)

4. En el archivo de angular.json hay que indicar que los estilos son manejados desde los ficheros que se han creado
````
"styles": [
  "styles/bootstrap-3.3.7-dist/css/bootstrap.min.css",
  "styles.scss"
],
"scripts": [
  "styles/bootstrap-3.3.7-dist/js/jquery.min.js",
  "styles/bootstrap-3.3.7-dist/js/bootstrap.min.js"
]
````

Con estos pasos es suficiente para agregar bootstrap en local

Existe otra posibilidad que es hacer la instalación mediante el gestor de paquetes npm mediante el comando:
````
npm install bootstrap
````

En este caso, y para referenciar que los estilos serán manejados por el módulo de bootstrap descargado, el archivo angular.json tendrá este aspecto:
````
"styles": [
  "src/styles.css",
  "node_modules/bootstrap/dist/css/bootstrap.min.css"
],
"scripts": [
  "node_modules/jquery/dist/jquery.min.js",
  "node_modules/bootstrap/dist/js/bootstrap.min.js"
]
````


En la documentación oficial se pueden buscar todas las posibilidades. Uno de los estilos de maquetación= más utilizados es el de columnas o grid, donde  se divide cada fila en 12 columnas. El usuario indica cual es la forma en la que quiere que se dividan las columnas pudiendo indicar el número de columnas que quiere que ocupe el elemento

En el caso de querer que las columnas ocupen lo mismo se utiliza la clase col, y en el caso de querer que ocupe una medida concreta se utiliza col-1 (o el número que se quiere utilizar)

````
<div class="container">
    <div class="row">
        <div class="col">
            <h1>Columna 1</h1>
            <div>
                <p>Esta es la primera columna aplicando tan solo la clase col </p>
            </div>
        </div>
        <div class="col">
            <h1>Columna 2</h1>
            <p>Esta es la segunda columna aplicando tan solo la clase col </p>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <h1>Columna 1</h1>
            <p>Esta es la segunda columna aplicando tan solo la clase col </p>

        </div>
        <div class="col-6 ">
            <h1>Columna 2</h1>
            <p>Esta es la segunda columna aplicando tan solo la clase col-6 </p>

        </div>
        <div class="col">
            <h1>Columna 3</h1>
            <p>Esta es la tercera columna aplicando tan solo la clase col </p>

        </div>
    </div>
</div>
````

En este caso las columnas de la primera fila se reparten por igual, mientras que las columnas de la segunda fila ocupan 3, 6 y 3 respectivamente

Existe la posibilidad de querer personalizar un poco la UI dependiendo de cuánto ocupe la pantalla ya que no es lo mismo una pantalla grande que una pequeña. Para esta distinción de tamaños se utilizan las siguientes medidas:

- Pantallas grandes (LG) > 1200 pixels
- Pantlallas medias (MD) > 992 pixels
- Pantallas tipo tablet (SM) > 768 pixels

Con estas medidas se puede indicar cuantas unidades ocupa cada columna dependiendo del tamaño de la pantalla de la siguiente forma

````
<div class="row">
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 1</h1>
        </div>
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 2</h1>
        </div>
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 3</h1>
        </div>
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 4</h1>
        </div>
    </div>
````

En este ejemplo para pantallas lg se situarán 4 columnas (4*3 = 12), para pantallas md  3 columnas (3*4 = 12) y para pantallas sm 2 columnas (2*6=12)


# Plantillas y Data-binding

Como ya se ha comentado, los componentes de Angular son los elementos principales de la aplicación. Estos constan de dos partes que son las que realizan casi todo el trabajo: parte gráfica y parte lógica. Lo normal es que los datos de una parte sean utilizados en la otra y viceversa. Esto es lo que se conoce como DataBinding y existen dos grandes tipos:

- One Way binding: Cuando se produce una comunicación entre el componente y el DOM de la página. Esta comunicación puede ser desde la parte gráfica a la parte lógica o viceversa:
	- Comunicación ts --> html

		- Obtener el contenido de un dato que se encuentra en la parte lógica y se quiere representar en la parte gráfica: Interpolation binding  ````{{data}}````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a una propiedad HTML de la parte gráfica: Property binding ````[property]=”data”````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a un atributo HTML: Attribute Binding: ````[attribute]=”data”````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a una clase HTML: Class Binding ````[class]=”data”````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a un atributo HTML: Style Binding ````[style]=”data”````

	- Comunicación html --> ts
		- Actuar ante un evento producido por un usuario en un elemento de la parte gráfica, asociando a una función declarada en la parte lógica: Event binding ````(click)="elementoPulsado()"````
- Two Way binding: Cuando se produce una comunicación entre el componente y el DOM de la página al mismo tiempo. Muy utilizado en el caso de los formularios.````[(ngModel)]="data"````


## One Way binding
Dentro de este tipo de binding lo más importante es ser capaz de diferenciar un atributo de una propiedad. Para ello es recomendable leer el siguiente <a href = "https://angular.io/guide/template-syntax#html-attribute-vs-dom-property" target="_blank">link</a>

**Interpolation binding**
****
Se produce cuando se quiere usar el contenido de un dato desde la parte ts hasta la parte html para por ejemplo representarlo en pantalla.

1. Crear dos variables en la parte lógica que son las que se quieren representar en la parte gráfica
````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  nombre: string = 'Mi nombre';
  apellido: string = 'Mi apellido';

  constructor() {}

  ngOnInit() {}
}
````

En este caso se han declarado dos variables a las que se les ha asignado un valor cualquiera

2. En la parte gráfica utilizar la variable declarada entre {{}} para poder utiliza su contenido
````
<p>{{nombre}}<br/> {{apellido}}</p>
````

De esta forma en el párrafo se renderizará el contenido de las variables nombre y apellido.

Del mismo modo que se pueden interpolar String, también se pueden interpolar la ejecución de funciones declaradas en el archivo ts o incluso la ejecución de sentencias js

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  numero1: number = 1;
  numero2: number = 2;

  constructor() {}

  suma(num1: number, num2: number ): number {
    return num1 + num2;
  }

  ngOnInit() {}
}
````
````
<p>El resultado de la suma de {{numero1}} y {{numero2}} es {{numero1+numero2}}</p>
<p>El resultado de la suma de {{numero1}} y {{numero2}} es {{suma(numero1,numero2)}}</p>

````

**Property binding, Attribute Binding, Class Binding, Style Binding**
****
Es utilizada para asociar un valor declarado en el archivo ts con un elemento de un componente HTML. 

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  activado: boolean = true;

  constructor() {}

  ngOnInit() {}
}

````
````
<p>
    <input type="text" [disabled]="activado">
</p>
````

En este caso la propiedad disabled del elemento input está asociada al valor de la variable activado declarada en la parte lógica

El resto de bindings se realiza exactamente de la misma forma

````
// Class Binding
<p [class]="clase">
    Ejemplo 
</p>
// Style Binding
<p [style.font-size.px]="50" [style.background]="color"></p>

````


**Event Binding**
****
Se utiliza cuando se asocia el evento producido por un elemento de la interfaz con la ejecución de una función declarada en la parte lógica
1. Declarar una función que realice una tarea deseada
````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  activado: boolean = true;
 
  modificarInput(){
    this.activado = !this.activado;
  }
}
````

2. Asociar un evento determinado a un elemento html, encapsulado mediante ()
````
<button type="button" class="btn btn-primary" (click)=''>Activar / Desactivar</button>


````

3. Igualar a dicho evento la función declarada en el punto 1
````
<button type="button" class="btn btn-primary" (click)='modificarInput()'>Activar / Desactivar</button>

````

Del mismo modo que pasa en los bindings anteriores, a un evento también se le puede asignar un código js

3. Igualar a dicho evento la función declarada en el punto 1
````
<button type="button" class="btn btn-primary" (click)='activado = !activado'>Activar / Desactivar</button>

````

## Two Way binding

Sobre todo es utilizada en formularios y se produce cuando hay una comunicación bidireccional entre el elemento ts y el elemento html, es decir que sus componentes realizan comunicación en ambos sentidos. Para ello se utilizan los caracteres [()] y solo es efectiva si está activo el módulo de formularios, por lo que el primer paso es incluirlo dentro del fichero app.module

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DirectivasComponent } from './components/directivas/directivas.component';


@NgModule({
  declarations: [
	DirectivasComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````


````
<input type="text" [(ngModel)]="nombre">
````

[()] es una "abreviatura" del siguiente código:

````
<input [ngModel]="nombre" (ngModel)="nombre=$event.target.value"/>
````

ó

````
<input [value]="nombre" (click)="nombre=$event.target.value"/>

````

De esta forma el valor de la variable nombre declarada en la parta .ts se actualizará automáticamente, sin necesidad de que se produzca un evento de enviado, reservado para el envío de los datos (no la captura) y la acción propia de enviado.

# Directivas

Las directivas en Angular son aquellos elementos que permiten modificar el DOM de la página de forma dinámica. Un ejemplo sería mostrar un conjunto de datos dentro de una página web donde no se sabe exactamente cuántos elementos se deben mostrar, por lo que no se puede saber cuantos divs hay que hacer. Existen 3 tipos de directivas:

- Directivas de componente: son aquellas que permiten agregar un componente al DOM de la página. Como se explicó cuando se hablo de componentes, si se quiere agregar un componente a la parte gráfica de otro componente se debe utilizar el selector. El uso de este selector sería la propia directiva de componente.
````
<div>
    <app-componente-directivas></app--componente-directiva>
</div>
````

- Directivas estructurales: son aquellas que modifican la estructura del DOM, agregando o quitando elementos según diferentes elementos. Estas directivas estructurales son:
	- ngIf
	- ngFor
	- ngSwitch
	- ng-Container
- Directivas de atributo: son aquellas que modifican los atributos de elementos del DOM, cambiando el aspecto o comportamiento del elemento. Estas directivas de atributo son:
	- NgClass
	- NgStyle
	- NgModel
	- NgForm

## Directivas de componente
Antes de ver cada una de ellas, es importante saber que tan solo se puede aplicar una directiva estructural por componente

**ngIf**
****
Su uso es muy parecido al estamento if de programación orientada a objetos, pero aplicado a componentes HTML. Para su uso de declara la directiva dentro de la etiqueta de la que se quiere mostrar u ocultar su contenido, igualando a una función o variable que tenga un valor boolean. En el caso de ser verdadero la etiqueta será mostrada, en caso contrario la etiqueta no se mostrará. Para poder utilizarla tan solo hay que incluir la directiva ````*ngIf```` al elemento que le afectará. Su estructura es la siguiente
````
*ngIf= 'valor'
````
Donde valor es una variable boolean

1. En la parte gráfica, incluir en el elemento que se quiere mostrar u ocultar la directiva NgIf
````
<p *ngIf="">Elemento del DOM que aparece y desaparece</p>
````

2. Declarar en la parte lógica una variable boolean
````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-direcivas-estructurales',
  templateUrl: './direcivas-estructurales.component.html',
  styleUrls: ['./direcivas-estructurales.component.css']
})
export class DirecivasEstructuralesComponent implements OnInit {

  elementoNgIf: boolean = true;

  constructor() { }

  ngOnInit() {
  }

}
````
3. Asociar la variable declarada en el punto anterior con la directiva NgIf del punto 1
````
<p *ngIf="elementoNgIf">Elemento del DOM que aparece y desaparece</p>

````
4. Decidir la lógica por la que la variable del punto dos cambia de valor. En este ejemplo se realiza mediante la pulsación de un botón
````
<p>
El siguiente texto aparecerá y desaparacerá dependiendo de la pulsación del siguiente botón<br />
<button type="button" class="btn btn-primary" (click)="elementoNgIf = !elementoNgIf">Pulsar</button>
</p>
<p *ngIf="elementoNgIf">Elemento del DOM que aparece y desaparece</p>
````

En el ejemplo se realiza el mostrado / ocultación del p donde está presente la directiva mediante la ejecución del evento igualado a código js

````
(click)="elementoNgIf = !elementoNgIf"
````

Pero se podría hacer igualándolo a una función que altere el valor de la variable
````
<button type="button" class="btn btn-primary" (click)="mostrarOcultar()">Pulsar</button>
````

````
export class DirecivasEstructuralesComponent implements OnInit {

  elementoNgIf: boolean = true;

  constructor() { }

  ngOnInit() {
  }

  mostraOcultar(){
  	this.elementoNgif != this.elementoIf; 
  }

}
````

Del mismo modo se podría hacer directamente sobre un div completo para que afecte a todos los elementos que están dentro 

**ngFor**
****
Esta directiva que permite realizar repeticiones sobre un código HTML tomando como valores de la iteración los pertenecientes a una colección de datos. Su funcionamiento es muy parecido a un bucle foreach y su estructura es la siguiente
````
*ngFor= 'let indice of colección'
````

Donde:
- let: es el elemento que se está recorriendo en cada iteración
- colección: es la variable array declarada en la parte lógica que se quiere recorrer 

Aquella etiqueta donde está aplicada la directiva repetirá tantas veces como elemento tenga el contenido de la etiqueta. Lo normal es querer utilizar cada uno de los elementos de la iteración, por lo que se utilizará la interpolación de contenido con el elemento item
````
{{item}}
````

1. En la parte gráfica, incluir en el elemento que se quiere repetir su contenido la directiva NgFor. En la mayoría de los casos suele ser listas
````
<ul *ngFor="let item of ">
</ul>
````
2. Declarar en la parte lógica una variable array con los elementos que se quieren representar
````
export class DirecivasEstructuralesComponent implements OnInit {

  elementosLista: string[] = ['Elemento1', 'Elemento2', 'Elemento3'];

  constructor() { }

  ngOnInit() {
  }

}
````
3. Asociar la variable declarada en el punto anterior con la directiva NgFor del punto 1
````
<ul *ngFor="let item of elementosLista">
</ul>
````
4. Incluir la etiqueta que se repetirá tantas veces como elementos tenga la lista. Si se quiere utilizar los elementos que se iteran, utilizarlos mediante interpolación
````
<ul *ngFor="let item of elementosLista">
	<li>{{item}}</li>
</ul>
````

En este caso aparecerá una lista con 3 strings (aquellos que representa la lista). En el caso de ser elementos más complejos, se utilizará el acceso a sus propiedades mediante el caracter .

1. Declarar en la parte lógica un array de elementos complejos
````
elementosLista2: any[] = [
    { nombre: "Elemento1", posicion: 1 },
    { nombre: "Elemento2", posicion: 2 },
    { nombre: "Elemento3", posicion: 3 }

];
````

2. Utilizar el acceso a sus propiedades

````
<ul *ngFor="let item of elementosLista2">
	<li>{{item.posicion}} {{item.nombre}} </li>
</ul>
````

Si se sigue un patrón de MVC donde se declara un objeto en una clase externa (bien sea mediante interfaz o clase), se realizaría de la misma forma

````
export class Coche {
    private marca: string;
    private modelo: string;
    private cv: number;

    constructor(marca: string, modelo: string, cv: number) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
    }

    get marcaProp() {
        return this.marca;
    }

    get modelProp() {
        return this.modelo;
    }

    get cvProp() {
        return this.cv;
    }
}

````

Importante la palabra reservada export para que la clase pueda ser utilizada en otro archivo ts
````
import { Component, OnInit } from "@angular/core";
import { Coche } from "../../utils/coche";

@Component({
  selector: "app-direcivas-estructurales",
  templateUrl: "./direcivas-estructurales.component.html",
  styleUrls: ["./direcivas-estructurales.component.css"]
})
export class DirecivasEstructuralesComponent implements OnInit {

  elementosObjeto: Coche[] = [
    new Coche("Ford", "Mustang", 500),
    new Coche("Volwagen", "Arteon", 270),
    new Coche("Mercedes", "GLC", 350)
  ];

  constructor() {}

  ngOnInit() {}
}

````

````
<ul *ngFor="let item of elementosObjeto">
	<li>{{item.marcaProp}} {{item.modelProp}} {{item.cvProp}} </li>
</ul>
````

Además de poder utilizar los elementos que forman el array indicado en la directiva nfFor, también se pueden utilizar una serie de variables incluidas en la directiva como son:

- index: number: El índice del elemento actual.
- first: boolean: True cuando el item actual es el primero.
- last: boolean: True cuando el item actual es el último.
- even: boolean: True cuando el índice del item actual es par.
- odd: boolean: True cuando el índice del item actual es impar.

Algunos ejemplos de uso

````
<ul *ngFor="let item of elementosObjeto ; let i = index">
	<li>{{i+1}} {{item.marcaProp}} {{item.modelProp}} {{item.cvProp}} </li>
</ul>
````

````
<ul *ngFor="let item of elementosObjeto; let i = index; let p = odd">
                <li>
                    <p *ngIf="p">Elemento par</p>
                    <p *ngIf="!p">Elemento impar</p>
                    {{ i + 1 }} {{ item.marcaProp }} {{ item.modelProp }} {{ item.cvProp }}
                </li>
</ul>
````

**ngSwitch**
****
Esta directiva es exactamente igual que un estamento switch de programación, donde el resultante de una expresión definirá cual es el elemento del DOM (el tag) que se mostrará. Para ello se utilizan los atributos ````[ngSwitch]```` igualado a una variable definida en código (la cual será la que cambie su valor) y los atributos *ngSwitchCase igualados a los posibles valores que puede tomar la variable. Cuando la variable tome el valor de uno de los *ngSwitchCase se mostrará el tag asignado. También se puede incluir un tag con el atributo *ngDefaultSwitch para que se muestre siempre y cuando el valor de la variable no está contemplado en ninguno de los casos. Su sintaxis es la siguiente:
````
<div [ngSwitch]="variable">
    <div *ngSwitchCase="'elemento1'" ></div>
    <div *ngSwitchCase="'elemento2'"></div>
    <div *ngSwitchCase="'elemeneto3'"></div>
	<div *ngSwitchDefault></div>

</div>  
````

Para utilizarlo:

1. Declarar la directiva ngSwitch en la etiqueta donde se mostrarán los elementos dependiendo de un elemento
````
<div [ngSwitch]="">
</div>
````

2. Declarar una variable en la parte lógica. Esta variable será la que cambie según algún evento y hará modificar el DOM
````
export class DirecivasEstructuralesComponent implements OnInit {
  seleccionado: string;
}
````

3. Igualar la variable a la directiva ngSwitch, configurando los casos posibles
````
<div [ngSwitch]="seleccionado">
	<div *ngSwitchCase="'Op1'">Seleccionado caso 1</div>
	<div *ngSwitchCase="'Op2'">Seleccionado caso 2</div>
	<div *ngSwitchDefault>Seleccionado caso desconocido</div>
</div>
````
Es importante que los casos van entra los caracteres " y ' de modo que lo tome como un literal y no como una variable

````
// variable de la parte lógica cuyo nombre es Op1
<div *ngSwitchCase="Op1">Seleccionado caso 1</div>
// literal Op2
<div *ngSwitchCase="'Op2'">Seleccionado caso 2</div>
````

4. (**para este ejemplo**) Crear tantos radios como opciones haya y meterlos dentro de un grupo
````
<div class="input-group-text">
        <label style="padding-right: 10px">
          <input
            type="radio"
            name="grupo"
            value="Op1"
          />
          Opción 1
        </label>
        <label>
          <input
            type="radio"
            name="grupo"
            value="Op2"
          />
          Opción 2
        </label>
</div>
````
Esto se puede realizar muy fácilmente con la directiva NgFor explicada

5. Crear una función que evalúenlos el elemento pulsado. Esto se realiza mediante un evento, por lo que el parámetro de entrada es un objeto de tipo any
````
grupoSeleccionado(event: any) {
    this.seleccionado = event.target.value;
    console.log(this.seleccionado);
}
````

6. En cada uno de los radios hacer un EventBinding igualándolo al método creado para manejar el camino de selección 
````
      <div class="input-group-text">
        <label style="padding-right: 10px">
          <input
            type="radio"
            name="grupo"
            (change)="grupoSeleccionado($event)"
            value="Op1"
          />
          Opción 1
        </label>
        <label>
          <input
            type="radio"
            name="grupo"
            (change)="grupoSeleccionado($event)"
            value="Op2"
          />
          Opción 2
        </label>
      </div>

      <div [ngSwitch]="seleccionado">
        <div *ngSwitchCase="'Op1'">Seleccionado caso 1</div>
        <div *ngSwitchCase="'Op2'">Seleccionado caso 2</div>
        <div *ngSwitchDefault>Seleccionado caso desconocido</div>
      </div>
````

Para poder pasar como parámetro el evento realizado hay que poner el caracter $event 

## Directivas de atributo

Son aquellas que permiten modificar el DOM de la página pero no mostrando u ocultando elementos, sino que modificando propiedades de los elementos donde son configuradas. A diferencia de las anteriores, se pueden aplicar varias directivas de atributo al mismo componente

**ncClass**
****

Modifica de forma dinámica la clase css que se le asignará al elemento en donde es aplicada. Para ello se cuenta con una serie de clases css que son las que se puede aplicar, donde más de una puede aplicarse. La sintaxis es la siguiente:

````
<div [ngClass]="estilos">
````

Donde estilos es un array de objetos par clave - valor donde la clave es el nombre de la clase y el valor una expresión boolean que dice si se aplica o no el estilo. Se puede declarar tanto literal en el HTML o asociarlo a una variable de la parte lógica

Para utilizarlo. 

1. Declarar las clases css que podrán ser aplicadas al elemento (dentro del ámbito del componente)
````
.letraUno {
    font-size: 10px;
    font-style: italic;
    font-weight: bold;
}

.letraDos {
    font-size: 20px;
    font-style: normal;
    font-weight: bolder;
}

.letraTres {
    font-size: 30px;
    font-style: oblique;
    font-weight: initial;
}
````

2. Asignar la directiva ngClass al elemento que se quiere aplicar la o las clases
````
<div [ngClass]="">
</div>

````

3. Declarar en la parte lógica un array par clave valor con las clases. Asignar un valor a cada clase
````
export class DirecivasEstructuralesComponent implements OnInit {

  estilos = {letraUno: false, letraDos: false, letraTres: true};
}
````

3. Asociar el array declarado a la directiva ngClass

````
<div [ngClass]="estilos">
</div>
````

Del mismo modo se podría haber declarado de forma literal en el HTML

````
<div [ngClass]="{letraUno: true, letraDos: false, letraTres: false}">
</div>
````

**Realizar el cambio de estilo de forma dinámica con tres checkbox.**

**ngStyle***
****

Tiene un funcionamiento muy similar a la directiva anterior, con la única diferencia que no modifica el valor de una clase css asignándole una nueva completa, sino que modifica algunas atributo del estilo. Su sintaxis es muy parecida a la directiva anterior

````
<div [ngClass]="estilos">
````

Donde estilos es un array de objetos par clave - valor donde la clave es el nombre de la propiedad del estilo y el valor una expresión que devuelve el valor a aplicar al estilo. Se puede declarar tanto literal en el HTML o asociarlo a una variable de la parte lógica

En este caso el valor no puede ser boolean ya que no tendría ningún sentido aplicar por ejemplo Font-Sise = true, sino que sería Font-Sise = 20. Para ello se utilizan las expresiones directas o condicionales 

En las directas se utiliza la siguiente sintaxis:
````
'Font-size' : '12px'
````


En las condicionales se utiliza siguiente sintaxis:

````
(expresion1)? expresion2 : expresion3
````

Donde si “expresion1” es verdadera, se devuelve el valor de “expresion2”; y si es falsa, se
devuelve el valor de “expresion3”. Un ejemplo sería 

````
this.grande ? '50px' : '12px'
````
En este caso, dependiendo del valor de la variable grande la salida será:
- si es verdadera, la salida será 50px
- si es falsa, la salida será 12px

Lo normal es que la salida se asigne a una propiedad de estilo, para ello la variable de la que depende la salida se le asigna el valor de esta forma:

````
'font-size': this.grande ? '50px' : '12px';

````

Un ejemplo sería:
````
'font-size': '12px', 'background-color' : 'green'};

````

En el caso de querer hacerlo dinámico, lo mejor es declarar un método que devuelva el array de estilos con todas sus posibilidades. La directiva ngStyle se asociará al método

Para poder utilizarlo:

2. Asignar la directiva ngStyle al elemento que se quiere aplicar los diferentes estilos
````
<div [ngStyle]="">
</div>

````

3. Declarar en la parte lógica un array par clave valor con los estilos que se pueden aplicar. Asignar un valor de estilo a cada posible salida
````
export class DirecivasEstructuralesComponent implements OnInit {

grande:boolean = false;
color:boolean = false;

estilosDinamicos = {'font-size': this.grande ? '50px' : '12px', 'background-color' : this.color ? 'green' : 'none'};

  estilos = {letraUno: false, letraDos: false, letraTres: true};
  constructor() {}

  ngOnInit() {}

}

````

3. Asociar el array declarado a la directiva ngClass

````
<div [ngStyle]="estilosDinamicos">
</div>
````

En el caso de querer aplicar los estilos directos, se podría hacer definido la variable con los valores directos 
````
estilosDinamicos = {'font-size': '50px' , 'background-color' : 'green'};

````
Ó en el HTML diretamente

````
<div [ngStyle]="{'font-size': '50px' , 'background-color' : 'green'}">
</div>
````

**Existen otros tipos de directivas que se irán explicando a lo largo de los siguientes temas ya que se mezclan con otros elementos como por ejemplo los formularios**

# Pipes

Los pipes actúan como funciones de transformación de datos, es decir que toman una entrada cualquiera y la transforman para que esta sea mostrada de forma diferente. Para poder utilizarlos el caracter | debe seguir a la información que se quiere transformar. Los tipos de pipes que existen son:

- UpperCasePipe
- TitleCasePipe
- SlicePipe
- DecimalPipe
- PercentPipe
- CurrecyPipe
- AsyncPipe
- DatePipe
- JsonPipe

Cada uno de ellos realiza las siguientes funciones pero su sintaxis es igual:
````
{{variable | pipe:param1:param2}}
````

Dependiendo del tiempo de pipe los parámetros que se pueden poner son diferentes pero su uso es el mismo:

1. Se crea una variable en la parte lógica de tipo string y se iguala a un valor
2. En la parte gráfica, se llama al contenido de la variable a la cual se le aplica el pipe

Para los ejemplos mostrados en cada uno de los siguientes pipes se definen en la parte lógica las siguientes variables:
````
  palabraMinuscula: string = 'PASAR A MINUSCULAR';
  palabraMayuscula: string = 'pasar a mayuscula';
  palabraCapitalizar: string = 'las primeras letras a mayuscula';
  palabraCortar: string = 'Ejemplo de corte';
  fecha: Date = new Date(2019, 9);
  numeroDecimal: number = 12.12312;
  numeroPorcentaje: number = 44.390;
  numeroMoneda: number = 2.500;
````


- UpperCasePipe | LowerCasePipe

Utilizado para transformar un texto en mayúsculas / minúsculas respectivamene. Para ello:
````
        <tr>
            <td>Valor normal: {{ palabraMinuscula }}</td>
            <td>Valor con pipe: {{ palabraMinuscula | lowercase }}</td>
        </tr>
        <tr>
            <td>Valor normal: {{ palabraMayuscula }}</td>
            <td>Valor con pipe: {{ palabraMayuscula | uppercase }}</td>
        </tr>
````

- TitleCasePipe

Muy similar a los anteriores, con la diferencia que capitaliza la primera letra de cada palabra

````
        <tr>
            <td>Valor normal: {{ palabraCapitalizar }}</td>
            <td>Valor con pipe: {{ palabraCapitalizar | titlecase }}</td>
        </tr>
````

- SlicePipe

Utilizado para poder cortar partes de un elemento según se indiquen en los parámetros del pipe. Su sintaxis es la siguiente

````
// suponer una variable var = 'Ejemplo de variable';
// {{var | slice: posicionInicio:posicionFin}}
{{var | SlicePipe:0:6}} // Ejemplo
````

````
            <td>Valor normal: {{ palabraCortar }}</td>
            <td>Valor con pipe: {{ palabraCortar | slice: 0:7 }}</td>
````

- DecimalPipe

Utilizado para mostrar números en un formato específico. Se utiliza con variables formato number. Los argumentos que admite son:
````
{{ var | number: ’ minimoDeEnteros . minimDeDecimales -maximoDeDecimales ’ }}
````

````
        <tr>
            <td>Valor normal: {{ numeroDecimal }}</td>
            <td>Valor con pipe: {{ numeroDecimal | number: "2.4" }}</td>
        </tr>
````

- PercentPipe

Muy similar al anterior, con la diferencia que convierte un numero dado en su correspondiente decimal. Los argumentos que admite son:

````
{{ var | number: ’ minimoDeEnteros . minimDeDecimales -maximoDeDecimales ’ }}
````

````
        <tr>
            <td>Valor normal: {{ numeroPorcentaje }}</td>
            <td>Valor con pipe: {{ numeroPorcentaje | percent: "1.4" }}</td>
        </tr>
````


- CurrencyPipe

Utilizado para mostrar un valor en formato moneda. Los argumentos que admite son:
````
{{ var | currency: ‘codigoISO’ : valorBooleanoParaMostrarSimboloOCodigoIso: ’ minimoDeEnteros . minimDeDecimales -maximoDeDecimales ’ }}
````

````
        <tr>
            <td>Valor normal: {{ numeroMoneda }}</td>
            <td>Valor con pipe: {{ numeroMoneda | currency: "EUR":true:"1.3" }}</td>
        </tr>
````


Los códigos ISO de las monedas locales se pueden consultar en el siguiente <a href="https://es.iban.com/currency-codes" target="_blank">link</a>

- DatePipe

Transforma un dato en el formato fecha que se le indique. Para ello, los argumentos que admite son:

````
{{ value_expression | date [ : format [ : timezone [ : locale ] ] ] }}
````
````
        <tr>
            <td>Valor normal: {{ fecha }}</td>
            <td>Valor con pipe: {{ fecha | date: "short" }}</td>
            <td>Valor con pipe: {{ fecha | date: "yyyy/dd/MM" }}</td>
        </tr>
````


Los formatos de fecha que podemos pasarle a estas pipes son:

````
DatePipe:‘short’ // 6/15/19, 9:03 AM
DatePipe:‘medium’ // Jun 15, 2019, 9:03:01 AM
DatePipe:‘long’ // June 15, 2019 at 9:03:01 AM GMT+1
DatePipe:‘full’ // Monday, June 15, 2019 at 9:03:01 AM GMT+01:00
DatePipe:‘shortDate’ // 6/15/19
DatePipe:‘mediumDate’ // Jun 15, 2019
DatePipe:‘longDate’ // June 15, 2019
DatePipe:‘fullDate’ // Monday, June 15, 2019
DatePipe:‘shortTime’// 9:03 AM
DatePipe:‘mediumTime’// 9:03:01 AM
DatePipe:‘longTime’ // 9:03:01 AM GMT+1
DatePipe:‘fullTime’ // 9:03:01 AM GMT+01:00
````

Del mismo modo también se puede indicar el formato propio


````
{{myVar | date: 'M/d/yy'}}
````

Se pueden consultar todos los valores de formato específico en el siguiente <a href="https://angular.io/api/common/DatePipe" target="blank">link</a>

- JsonPipe

Permite mostrar de forma "legible" on objeto de tipo son

- AsyncPipe

Permite mostrar datos que provienen de Observables o promesas 

# Personalización: Directivas y Pipes


Al igual que existen tanto directivas como pipes ya creados en Angular, un usuario puede crear sus propios elementos ya que en muchas ocasiones es necesario personalizar al máximos las tareas que se realizan. 

## Pipes personalizados

Para poder generar un pie se debe poner el comando 

````
````

Esto genera el pipe personalizado

````
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipePerso'
})
export class PipePersoPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
````

Esto genera una clase que implementa PipTrasform donde se crea un método transform que es el ejecutado cuando el pie es llamado. Entre los valores que tiene el método (value), se encuentra el elemento que podrá obtener el pie en entrada. Para el ejemplo se utilizará una lista de cartas con una imagen y un texto. En el caso de no encontrar la imagen se cargará una por defecto mediante un pipe. Para ello los pasos son los siguientes

1. Se crea el componente PipesPersonalizados y se crea un array de objetos donde cada uno de ellos tiene nombre e imagen. Para esto también es necesario crear la plantilla de un objeto de tipo Ciudad de modo que se más sencillo el manejo de objetos.

````
export interface Ciudad{
    nombre: string;
    imagen: string;
}
````


````
import { Component, OnInit } from '@angular/core';
import { Ciudad } from '../../utils/Ciudad';

@Component({
  selector: 'app-pipes-perso',
  templateUrl: './pipes-perso.component.html',
  styleUrls: ['./pipes-perso.component.css'],
})
export class PipesPersoComponent implements OnInit {
  ciudades: Ciudad[];

  constructor() {}

  ngOnInit(): void {
    this.ciudades = [
      {
        nombre: 'NEW YORK',
        imagen: 'assets/images/new_york.jpg',
      },
      {
        nombre: 'SAN FRANCISCO',
        imagen: 'assets/images/san_francisco.jpg',
      },
      {
        nombre: 'MADRID',
        imagen: 'assets/images/madrid.jpg',
      },
      { nombre: 'BARCELONA', imagen: '' },
      { nombre: 'BARCELONA', imagen: '' }
    ];
  }
}

````


2. En la parte html se cargan una serie de cartas donde aparece la imagen y el nombre utilizando la directiva ngFor.

````
<div class="card-group">
    <div class="card" *ngFor="let item of ciudades">
      <img class="card-img-top" [src]="item.imagen | pipePerso" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">{{item.nombre}}</h5>
        <p class="card-text"></p>
      </div>
      <div class="card-footer">
        <small class="text-muted">Last updated 3 mins ago</small>
      </div>
    </div>
</div>
````

En la parte de la etiqueta img, se aplica el pipe personalizado dentro del atributo src (pasado como binding de atributo). En el pipe creado se codificará de la siguiente forma

````
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipePerso',
})
export class PipePersoPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    if (!value) {
      return 'assets/images/ciudad.jpg';
    } else {
      return value;
    }
  }
}
````

Donde en método transform recibe como parámetros el objeto value, que en este caso es el elemento item.imagen. Se hace una comprobación y en el caso de no haber pasado nada se retorna una imagen por defecto. En el caso de haber pasado algo por parámetros se retorna el mismo objeto.
